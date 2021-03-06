package eu.vicci.process.wampserver.handlers;

import java.util.HashMap;
import java.util.Map;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.util.ProcessStartRequest;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;
import ws.wamp.jawampa.Request;

public class StartInstanceServerHandler extends AbstractRpcHandlerManageable {

	public StartInstanceServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		ProcessStartRequest request = convertFromJson(t.arguments().get(0), ProcessStartRequest.class);
		String processInstanceId = request.getProcessInstanceId();
		String originalProcessInstanceId = request.getRunningForInstanceId();
		Map<String, IJSONTypeInstance> ports = request.getPorts();
		Map<String, DataTypeInstance> inputParameters = deserializePorts(ports);
		boolean runInLoop = request.getRunInLoop();
		String state = processManager.startProcessInstance(processInstanceId, originalProcessInstanceId, inputParameters, runInLoop);
		t.reply(state);		
	}
	
	private Map<String, DataTypeInstance> deserializePorts(Map<String, IJSONTypeInstance> ports){
		if(ports == null)
			return null;
		
		Map<String, DataTypeInstance> inputParameters = new HashMap<String, DataTypeInstance>();
		for (String portName : ports.keySet()) {
			IJSONTypeInstance json = ports.get(portName);
			DataTypeInstance dti = json.makeDataTypeInstance(SofiaInstanceFactoryImplCustom.getInstance());
			inputParameters.put(portName, dti);
		}		
		return inputParameters;		
	}
}
