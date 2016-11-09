package eu.vicci.process.wampserver.handlers;

import java.util.List;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessManager;
import ws.wamp.jawampa.Request;

/**
 * Returns a list of available (deployed) process models and additional attributes (ProcessInfo)
 * 
 * @author ronsei
 *
 */
public class ProcessListServerHandler extends AbstractRpcHandlerManageable {

	public ProcessListServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		List<IProcessInfo> processesInfos = processManager.listDeployedProcesses();
		t.reply(processesInfos);
	}

}
