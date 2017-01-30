package eu.vicci.process.devices.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;

import eu.vicci.semiwa.common.messages.CallResult;
import eu.vicci.semiwa.node.tasking.server.AsynchronousTask;
import eu.vicci.semiwa.node.tasking.server.TaskingServiceStub;

public class SeMiWaListener {
	
//	private static SeMiWaListener smwl;
//	private static SeMiWaListenerThread slt;
//	
//	private SeMiWaListener() {
//		
//	}
//	
//	public static synchronized SeMiWaListener getInstance() {
//		if (smwl == null) {
//			smwl = new SeMiWaListener();
//		}
//		return smwl;
//	}
//
//	
//	public void start() {
//		slt = new SeMiWaListenerThread();
//		slt.start();
//	}
//
//	public SeMiWaListenerThread getSlt() {
//		return slt;
//	}
//
//	public void setSlt(SeMiWaListenerThread slt) {
//		SeMiWaListener.slt = slt;
//	}

	private NodeThread sensorListenerNode;
	private NodeThread rpcCallerNode;
	
	private static SeMiWaListener smwl;
	private static SeMiWaListenerThread slt;
	
	private SeMiWaListener() {
		
	}
	
	public static synchronized SeMiWaListener getInstance() {
		if (smwl == null) {
			smwl = new SeMiWaListener();
		}
		return smwl;
	}

	
	public void start() {

		InetAddress IP = null;
		
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// e1.printStackTrace();
		}
		
		HashMap<String, String> dataSheet = new HashMap<String, String>();
		
		dataSheet.put("uid", IP.getHostName().replace("-", ""));
		dataSheet.put("deviceName", "VICCIProcessEngine");
		dataSheet.put("deviceUnit", "xsd:string");
		dataSheet.put("deviceType", "Process");
		
		// Generates an example node in a background thread.
		sensorListenerNode = new NodeThread(dataSheet, null, true);
		
		// First dummy sensor end
		
		HashMap<String, String> dataSheet2 = new HashMap<String, String>();
		
		dataSheet2.put("uid", "VICCIProcessesCaller");
		dataSheet2.put("deviceName", "VICCIProcessEngine");
		dataSheet2.put("deviceUnit", "xsd:integer");
		dataSheet2.put("deviceType", "Process");
		
		// Generates an example node in a background thread.
		rpcCallerNode = new NodeThread(dataSheet2, null, false);
		
		TaskingServiceStub taskingServiceStub = new TaskingServiceStub();
		taskingServiceStub.setNode(IP.getHostName().replace("-", ""));
		taskingServiceStub.setProcedureName("AddTwoInts");

		HashMap<String, String> input = new HashMap<String, String>();
		input.put("Integer", "param1");
		input.put("Integer", "param2");

		taskingServiceStub.setInput(input);
		taskingServiceStub.setOutput("Integer");

		// this block calls the remote procedure
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("param1", "12");
		params.put("param2", "8");

		AsynchronousTask<Integer> task = new AsynchronousTask<Integer>(params,
				taskingServiceStub);

		CallResult<Integer> cResult = task.start(rpcCallerNode.getNode());
		System.out.println("RESULT: "+cResult.getResult().toString());
				
	}

	public SeMiWaListenerThread getSlt() {
		return slt;
	}

	public void setSlt(SeMiWaListenerThread slt) {
		SeMiWaListener.slt = slt;
	}

	public NodeThread getSensorListenerNode() {
		return sensorListenerNode;
	}

	public void setSensorListenerNode(NodeThread sensorListenerNode) {
		this.sensorListenerNode = sensorListenerNode;
	}

	public NodeThread getRpcCallerNode() {
		return rpcCallerNode;
	}

	public void setRpcCallerNode(NodeThread rpcCallerNode) {
		this.rpcCallerNode = rpcCallerNode;
	}
	
}
