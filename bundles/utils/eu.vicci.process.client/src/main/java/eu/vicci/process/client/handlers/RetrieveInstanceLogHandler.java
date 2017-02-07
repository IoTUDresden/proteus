package eu.vicci.process.client.handlers;

import java.util.List;

import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.util.messages.StateChangeMessage;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import ws.wamp.jawampa.Reply;

public class RetrieveInstanceLogHandler extends AbstractClientHandler {
	private List<IStateChangeMessage> instanceLog;

	@SuppressWarnings("unchecked")
	@Override
	public void onNext(Reply t) {
		instanceLog = convertFromJsonToCollectionType(t.arguments().get(0), 
				List.class, StateChangeMessage.class);	
		if(instanceLog == null){
			instanceLog = null;
		}
	}
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}

	public List<IStateChangeMessage> getInstanceLog() {
		return instanceLog;
	}
}
