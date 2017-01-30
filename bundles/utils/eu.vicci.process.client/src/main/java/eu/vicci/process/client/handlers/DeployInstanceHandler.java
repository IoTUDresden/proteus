package eu.vicci.process.client.handlers;

import eu.vicci.process.engine.core.ReplyState;
import ws.wamp.jawampa.Reply;

public class DeployInstanceHandler extends AbstractClientHandler {
	private String instanceId = "";

	@Override
	public void onNext(Reply arg0) {		
		instanceId = arg0.arguments().get(0).asText();
	}
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}
	
	public String getInstanceId() {
		return instanceId;
	}	

}
