package eu.vicci.process.wampserver.handlers;

import java.util.List;

import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.IProcessManager;
import ws.wamp.jawampa.Request;

/**
 * Returns a list of available process instances with additional attributes (ProcessInstanceInfo)
 * @author ronsei
 *
 */
public class ProcessInstanceListServerHandler extends AbstractRpcHandlerManageable {

	public ProcessInstanceListServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		List<IProcessInstanceInfo> instanceInfos = processManager.listProcessInstances();
		t.reply(instanceInfos);		
	}

}
