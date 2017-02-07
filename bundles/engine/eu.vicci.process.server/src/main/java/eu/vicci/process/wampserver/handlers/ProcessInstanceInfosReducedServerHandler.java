package eu.vicci.process.wampserver.handlers;

import java.util.Map;

import eu.vicci.process.engine.core.IProcessManager;
import ws.wamp.jawampa.Request;

public class ProcessInstanceInfosReducedServerHandler extends AbstractRpcHandlerManageable {

	public ProcessInstanceInfosReducedServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		Map<String,String> processStepInstances;
		
		String processInstanceId = t.arguments().get(0).asText();
		
		processStepInstances = processManager.getProcessInstanceInfosReduced(processInstanceId);
		
		t.reply(processStepInstances);		
	}

}
