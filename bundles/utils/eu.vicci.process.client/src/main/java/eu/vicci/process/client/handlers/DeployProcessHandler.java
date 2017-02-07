package eu.vicci.process.client.handlers;

import eu.vicci.process.engine.core.ReplyState;
import ws.wamp.jawampa.Reply;

public class DeployProcessHandler extends AbstractClientHandler {
	private String processId = "";
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}

	@Override
	public void onNext(Reply t) {
		processId = t.arguments().get(0).asText();		
	}

	public String getProcessId() {
		return processId;
	}
}
