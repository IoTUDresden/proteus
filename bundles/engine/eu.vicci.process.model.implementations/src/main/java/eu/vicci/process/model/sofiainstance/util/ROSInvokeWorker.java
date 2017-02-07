package eu.vicci.process.model.sofiainstance.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import eu.vicci.process.model.sofia.ROSInvoke;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

@SuppressWarnings({"rawtypes", "unchecked"})
public class ROSInvokeWorker extends WebSocketClient {
	
	private String serviceName;
	private boolean connected=false;
	
	private String serviceCallAnswer="";
	private boolean serviceCall= false;
	private boolean answerReceived=false;
	private List<DataTypeInstance> returnedData = new LinkedList<DataTypeInstance>();

	public ROSInvokeWorker(URI serverURI) {
		super(serverURI);
	}
	
	public List<DataTypeInstance> work(ProcessStepInstance rii) {

		ROSInvoke ri = (ROSInvoke)rii.getProcessStepType();
		serviceName = ri.getServiceName();

		LinkedTreeMap<String, Object> call = new LinkedTreeMap<>();

		call.put("op", "call_service");
		call.put("service", serviceName);
		
		LinkedTreeMap<String, Object> arguments = new LinkedTreeMap<>();

		//Assuming simple types at ports
		for (PortInstance pi : rii.getPorts()) {
			if (pi instanceof StartDataPortInstance) {
				StartDataPortInstance sdpi = (StartDataPortInstance)pi;
				DataTypeInstance type = sdpi.getDataInstance();
				String name = type.getDataTypeType().getName();
				if (type instanceof StringTypeInstance) {
					StringTypeInstance data = (StringTypeInstance)type;
					String value = data.getValue();
					arguments.put(name, value);
				} else if (type instanceof IntegerTypeInstance){
					IntegerTypeInstance data = (IntegerTypeInstance)type;
					int value = data.getValue();
					arguments.put(name, value);
				} else if (type instanceof DoubleTypeInstance){
					DoubleTypeInstance data = (DoubleTypeInstance)type;
					double value = data.getValue();
					arguments.put(name, value);
				} else if (type instanceof BooleanTypeInstance){
					BooleanTypeInstance data = (BooleanTypeInstance)type;
					boolean value = data.isValue();
					arguments.put(name, value);
				}
			}
			call.put("args", arguments);
			}
		
		Gson gson = new Gson();
		
		String message = gson.toJson(call);
						
		System.out.println("Invoke message: "+message);
		
		send(message);
		
		
		while (!answerReceived) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
						
		String response = serviceCallAnswer;
		
		Gson respgson = new Gson();
		Map<String, Object> map = new HashMap<String, Object>();
		map = (Map<String,Object>)respgson.fromJson(response, map.getClass());
		
		LinkedTreeMap data = null;
		
		if(map.containsKey("values")) {
			data = (LinkedTreeMap) map.get("values");
		}
						
		// activating outgoing ports with parameters by matching port name and parameter name within JSON string
		// if necessary traverse JSON string recursively
		// TODO: JSON deserialization
		for (PortInstance porti : rii.getPorts()) {
			if (porti instanceof EndDataPortInstance) {
				DataPortInstance dpie = (DataPortInstance)porti;
				if (data!=null) {
					DataTypeInstance dti = dpie.getDataInstance();
					String key = dti.getDataTypeType().getName();
					Object value = traverse(key,data);
					if (dti instanceof StringTypeInstance) {
						StringTypeInstance sti = (StringTypeInstance)dti;
						String str = (String)value;
						sti.setValue(str);
						dpie.setDataInstance(sti);
					} else if (dti instanceof IntegerTypeInstance) {
						IntegerTypeInstance iti = (IntegerTypeInstance)dti;
						Integer integ = (Integer)value;
						iti.setValue(integ);
						dpie.setDataInstance(iti);
					} else if (dti instanceof DoubleTypeInstance) {
						DoubleTypeInstance doti = (DoubleTypeInstance)dti;
						Double doub = (Double)value;
						doti.setValue(doub);
						dpie.setDataInstance(doti);
					} else if (dti instanceof BooleanTypeInstance) {
						BooleanTypeInstance bti = (BooleanTypeInstance)dti;
						Boolean bool = (Boolean)value;
						bti.setValue(bool);
						dpie.setDataInstance(bti);;									
					}
				}
			}
		}
		
		for (PortInstance pi : rii.getPorts()) {
			if (pi instanceof EndDataPortInstance) {
				EndDataPortInstance edpi = (EndDataPortInstance)pi;
				DataTypeInstance dti = edpi.getDataInstance();
				returnedData.add(dti);
			}
		}
		
		return returnedData;
	}		


	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
		connected = false;
		
	}

	@Override
	public void onError(Exception arg0) {
		
	}

	@Override
	public void onMessage(String s) {
		if (s.contains(serviceName) && s.contains("service_response")) {
			serviceCallAnswer = s;
			answerReceived=true;
			System.out.println("Answer: "+serviceCallAnswer);
		}
		
	}

	@Override
	public void onOpen(ServerHandshake arg0) {
		connected = true;
		System.out.println("Connected");
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public String getServiceCallAnswer() {
		return serviceCallAnswer;
	}
	
	public boolean isServiceCall() {
		return serviceCall;
	}

	public void setServiceCall(boolean serviceCall) {
		this.serviceCall = serviceCall;
	}
		
	public boolean isConnected() {
		return connected;
	}

	public boolean isAnswerReceived() {
		return answerReceived;
	}

	public void setAnswerReceived(boolean answerReceived) {
		this.answerReceived = answerReceived;
	}
	
	private static Object traverse(String key, LinkedTreeMap ltm) {
		Object value = "";
		if (ltm.containsKey(key)) {
			value = ltm.get(key);
		} else {
			for (Object o : ltm.values()) {
				if (o instanceof java.util.ArrayList) {
					ArrayList al = (ArrayList)o;
					for (Object o2 : al) {
						if (o2 instanceof LinkedTreeMap) {
							LinkedTreeMap ltm3 = (LinkedTreeMap)o2;
							value = traverse(key,ltm3);
						}
					}
				} else if (o instanceof LinkedTreeMap) {
					LinkedTreeMap ltm2 = (LinkedTreeMap)o;
					value = traverse(key, ltm2);
				}
			}
		}
		return value;
	}
	
}
