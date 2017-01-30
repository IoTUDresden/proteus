package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.ConfigureInstanceRequest;
import ws.wamp.jawampa.Request;

public class InstanceConfigurationServerHandler extends AbstractRpcHandlerManageable {

	public InstanceConfigurationServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		
		ConfigureInstanceRequest cir = convertFromJson(t.arguments().get(0), ConfigureInstanceRequest.class);
		
		String processId = cir.getProcessId();
		String configuration = cir.getConfiguration();
		
		String state = processManager.configureProcessInstance(processId, configuration);
		
		t.reply(state);
		
	}

}
