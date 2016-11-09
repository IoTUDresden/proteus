package eu.vicci.process.client.handlers;

import eu.vicci.process.engine.core.ReplyState;
import ws.wamp.jawampa.Reply;

public class ExecuteProcessStepHandler extends AbstractClientHandler {
	private String processInstanceString;
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}

	@Override
	public void onNext(Reply t) {
		processInstanceString = t.arguments().get(0).asText();		
	}

	public String getProcessInstanceString() {
		return processInstanceString;
	}
}
