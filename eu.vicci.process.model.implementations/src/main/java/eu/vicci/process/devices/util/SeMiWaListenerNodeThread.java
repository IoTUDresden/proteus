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

@SuppressWarnings({"rawtypes", "unchecked"})
public class SeMiWaListenerNodeThread extends Thread implements Runnable {
	
	public NodeInformation getNodeInformation() {
		return nodeInformation;
	}

	/** The gson. */
	private Gson gson = new Gson();
	private boolean listener;
	public int frequency = 2000;

	public int messages = 0;

	public boolean connected = false;

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
	SeMiWaListenerNodeThread(HashMap<String, String> datasheet,
			HashMap<String, String> properties, Boolean listener) {
		this.datasheet = datasheet;
		this.listener=listener;
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
			public void invokeCallMsg(Call arg0) {
						
			}

			@Override
			public void invokeCallResult(CallResult callResult) {
						
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
			public void receiveCallResult(CallResult arg0) {
				System.out.println(("RESULT: "+arg0.getResult()));
						
			}

		};

		if (!listener) {
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
			public void receiveNodeUnregistered(NodeInformation arg0) {
				
			}
		};

		if (listener) {
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

		if (listener) {
			node.addValMsgInterface(valMsgInterfaceListener);	
		}
	}
}
