package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import ws.wamp.jawampa.Request;

public class ProcessDocumentServerHandler extends AbstractRpcHandlerManageable {

	public ProcessDocumentServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		String processId = t.arguments().get(0).asText();
		String document = processManager.getProcessDefinition(processId);
		t.reply(document);		
	}
}
