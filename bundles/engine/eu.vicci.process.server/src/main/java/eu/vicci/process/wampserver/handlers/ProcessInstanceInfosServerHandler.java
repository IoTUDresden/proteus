package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONProcessStepInstanceSerializer;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONProcessStepInstance;
import ws.wamp.jawampa.Request;

/**
 * Returns the complete instance
 * @author ronsei
 *
 */
public class ProcessInstanceInfosServerHandler extends AbstractRpcHandlerManageable {

	public ProcessInstanceInfosServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {		
		String processInstanceId = t.arguments().get(0).asText();				
		ProcessInstance procIns = processManager.getProcessInstanceInfos(processInstanceId);
		IJSONProcessStepInstance json = JSONProcessStepInstanceSerializer.makeJSONProcessStepInstance(procIns);		
		t.reply(json);		
	}

}
