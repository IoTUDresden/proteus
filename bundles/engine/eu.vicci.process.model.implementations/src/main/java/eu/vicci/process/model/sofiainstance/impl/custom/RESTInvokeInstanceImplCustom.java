package eu.vicci.process.model.sofiainstance.impl.custom;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import eu.vicci.process.model.sofia.HTTPverb;
import eu.vicci.process.model.sofia.RESTInvoke;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EndPortInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.RESTInvokeInstance;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.sofiainstance.util.RESTInvokeWorker;

public class RESTInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements RESTInvokeInstance {

	private String returnMessage = "";
	private String serverUri = "";

	/**
	 * The work to be done by the ProcessStep.<br>
	 * <br>
	 * Please fill in here all necessary business logic.
	 */
	@Override
	public void work() {
		try {

			HTTPverb httpVerb = null;

			if (this.getProcessStepType() instanceof RESTInvoke) {
				RESTInvoke ri = (RESTInvoke) this.getProcessStepType();
				serverUri = ri.getServerUri();
				httpVerb = ri.getHTTPMethod();
			}

			RESTInvokeWorker worker = new RESTInvokeWorker(serverUri);

			switch (httpVerb) {

			case DELETE:
				worker.executeXMLDeleteCall();
				break;

			case GET:
				returnMessage = worker.executeXMLGetCall();
				break;

			case POST:
				//FIXME short workaround for openhab commands
//				worker.executeXMLPostCall(startParameter.get(0).serializeToXML());
				Object string = startParameter.get(0).getValueAsObject();
				if(!(string instanceof String))
					return;
				worker.executeXMLPostCall((String)string);
				break;

			case PUT:
				worker.executeXMLPutCall(startParameter.get(0).serializeToXML());
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Activates all data end ports.
	 * 
	 * For the RestInvoke simply name the datatype instance like the <br>
	 * parametername you want to get from the rest api.
	 * 
	 * The values received are put in the given datatypes at this point.
	 * 
	 * ATTENTION: If there is no matching in the parameter name and the datatype name, the
	 * port will not activated or deactived at this point.
	 */
	// TODO deactivating non matching data endports? Else the process will never
	// complete
	public void activateDataEndPorts() {
		for (PortInstance port : ports) {
			DataTypeInstance dataInstance = null;
			if (port instanceof EndPortInstance) {
				if (port instanceof EndDataPortInstance) {
					// try to deserialize the returnMessage with a DataType.
					EndDataPortInstance pi = (EndDataPortInstance) port;
					dataInstance = pi.getDataInstance();
					deserializeAndActivatePort(pi, dataInstance);
				}
			}
		}
	}

	//TODO small hack to receive correct data from openhab rest. the default implementation causes errors
	private void deserializeAndActivatePort(EndDataPortInstance port, DataTypeInstance dataInstance) {	
		if(isCompensatingPort(port))
			return;
		
		if ((serverUri.contains("rest/items") || serverUri.contains("rest/things"))) {
			
			String typeName = port.getDataInstance().getDataTypeType().getName();
			String valueReceived = deserializeFromOpenHabJason(returnMessage, typeName);
			if(valueReceived == null){
				LOGGER.error("cant get value for port. Port is not activated: {}", typeName);
				return;
			}
			
			try {
				dataInstance.parse(valueReceived);				
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("cant parse the received value to the port datainstance. port is not activated. {}", port.getName());
				return;
			}
			
			LifeCycleManager.INSTANCE.activatePort(port, dataInstance);
		}
		else if (dataInstance.deserializeFromJSON(returnMessage)) {
			//the default case
			LifeCycleManager.INSTANCE.activatePort(port, dataInstance);
		}

	}
	
	private String deserializeFromOpenHabJason(String jsonString, String propertyName){
		JsonParser parser = new JsonParser();
		JsonObject obj = parser.parse(jsonString).getAsJsonObject();
		if(obj == null || obj.isJsonNull())
			return null;
		
		JsonElement element = obj.get(propertyName);
		if(element == null || element.isJsonNull() || !element.isJsonPrimitive())
			return null;
		
		return element.getAsString();	
	}
	
}
