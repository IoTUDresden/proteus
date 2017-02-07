package eu.vicci.process.client.handlers;

import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.util.messages.StateChangeMessage;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import ws.wamp.jawampa.Reply;

public class RetrieveInstanceStateHandler extends AbstractClientHandler {
	private IStateChangeMessage scm;

	@Override
	public void onNext(Reply t) {
		scm = convertFromJson(t.arguments().get(0), StateChangeMessage.class);
	}

	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}
	public IStateChangeMessage getScm() {
		return scm;
	}

}
