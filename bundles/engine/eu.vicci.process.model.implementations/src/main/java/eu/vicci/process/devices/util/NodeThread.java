package eu.vicci.process.devices.util;

import java.util.HashMap;

import com.google.gson.Gson;

import eu.vicci.process.devices.events.SensorEvent;
import eu.vicci.process.model.cep.EsperEngine;
import eu.vicci.process.semiwa.commands.AddTwoInts;
import eu.vicci.semiwa.common.messages.Call;
import eu.vicci.semiwa.common.messages.CallResult;
import eu.vicci.semiwa.common.messages.Event;
import eu.vicci.semiwa.common.node.NodeInformation;
import eu.vicci.semiwa.connection.SeMiWaMissingInformationException;
import eu.vicci.semiwa.connection.interfaces.SeMiWaNodeCallMsgListenerInterface;
import eu.vicci.semiwa.connection.interfaces.SeMiWaNodeEventListenerInterface;
import eu.vicci.semiwa.connection.interfaces.SeMiWaNodeRegisterListenerInterface;
import eu.vicci.semiwa.node.impl.SeMiWaNodeProxy;
import eu.vicci.semiwa.node.tasking.command.interfaces.Command;

/**
 * The Class NodeThread.
 */
@SuppressWarnings({"rawtypes", "unused", "unchecked"})
public class NodeThread extends Thread implements Runnable {

	public NodeInformation getNodeInformation() {
		return nodeInformation;
	}

	/** The gson. */
	private Gson gson = new Gson();
	private boolean sensorListener;
	public int frequency = 2000;

	public int messages = 0;

	public boolean connected = false;

	private String uid;

	private NodeInformation nodeInformation;

	/**
	 * The datasheet. Contains all sensor specific properties
	 */
	private HashMap<String, String> datasheet;

	/** The node. */
	private SeMiWaNodeProxy node;

	/**
	 * Gets the node.
	 * 
	 * @return the node
	 */
	public SeMiWaNodeProxy getNode() {
		return node;
	}

	/**
	 * Instantiates a new node thread.
	 * 
	 * @param datasheet
	 *            the datasheet
	 * @param properties
	 *            the properties
	 */
	NodeThread(HashMap<String, String> datasheet,
			HashMap<String, String> properties, boolean sensorListener) {
		this.datasheet = datasheet;
		this.uid = datasheet.get("uid");
		this.init();
	}

	public void init() {

		// Generates one node.
		node = new SeMiWaNodeProxy(datasheet);

		// Combines node with connection connection to SeMiWa
		try {
			connected = node.connectToSeMiWa();
		} catch (SeMiWaMissingInformationException e1) {
			connected = false;
			e1.printStackTrace();
		} catch (Exception e) {
			connected = false;
			e.printStackTrace();
		}

		// Listener for RPC Messages.
		SeMiWaNodeCallMsgListenerInterface callMsgListenerInterface = new SeMiWaNodeCallMsgListenerInterface() {

			@Override
			public void invokeCallMsg(Call call) {

			}

			@Override
			public void receiveCallResult(CallResult callResult) {

			}

			@Override
			public <T> T receiveCallMsg(Call call) {

				System.out.println("Local receive call: " + call.getMethod()
						+ " // " + gson.toJson(call.getMsg()));

				HashMap<String, String> params = gson.fromJson(
						(String) call.getMsg(), HashMap.class);

				Command command = null;

				if (call.getMethod().equals("AddTwoInts")) {
					command = new AddTwoInts(node, params);
				}

				if (command != null) {
					return command.execute();
				}

				return null;

			}

			@Override
			public void invokeCallResult(CallResult callResult) {

				// System.out.println("Local receive callResult: "
				// + gson.toJson(callResult));

				// System.out.println(callResult.getResult().getClass());

			}

		};

		if (!sensorListener) {
			node.addCallMsgInterface(callMsgListenerInterface);	
		}

		// Get device registered and (un)registered messages from <i>all</i>
		// nodes.
		SeMiWaNodeRegisterListenerInterface regMsgInterfaceListener = new SeMiWaNodeRegisterListenerInterface() {

			@Override
			public void receiveNodeRegistered(NodeInformation node) {
				Devicifier.createDevice(node);
			}

			@Override
			public void receiveNodeUnregistered(NodeInformation node) {

				// System.out.println("Local unreg: "
				// + gson.toJson(node.getRuntimeInformation().get(
				// "deviceName")));

			}
		};

		if (sensorListener) {
			node.addRegMsgInterface(regMsgInterfaceListener);	
		}

		// Get values from <i>all</i> nodes.
		SeMiWaNodeEventListenerInterface valMsgInterfaceListener = new SeMiWaNodeEventListenerInterface() {

			@Override
			public void receiveNodeEvent(Event inevent) {
				Eventifier eventifier = new Eventifier(inevent);
				SensorEvent event = eventifier.getEvent();
				if (event!=null) {
					EsperEngine.getInstance().sendSensorEvent(event);	
				}
			}

		};

		if (sensorListener) {
			node.addValMsgInterface(valMsgInterfaceListener);	
		}
		
	}

	public boolean isSensorListener() {
		return sensorListener;
	}

	public void setSensorListener(boolean sensorListener) {
		this.sensorListener = sensorListener;
	}
}
