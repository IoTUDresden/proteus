package eu.vicci.process.client.handlers;

import java.util.Map;

import eu.vicci.process.engine.core.ReplyState;
import ws.wamp.jawampa.Reply;

public class ProcessInstanceInfosReducedHandler extends AbstractClientHandler {
	private Map<String,String> processStepInstances;

	@SuppressWarnings("unchecked")
	@Override
	public void onNext(Reply t) {
		processStepInstances = convertFromJson(t.arguments().get(0), Map.class);		
	}
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}

	public Map<String,String> getProcessStepInstances() {
		return processStepInstances;
	}
}
