package eu.vicci.process.client.handlers;

import ws.wamp.jawampa.Reply;

public class InstanceConfigurationHandler extends AbstractClientHandler {

	@Override
	public void onNext(Reply t) {
		state = t.arguments().get(0).asText();		
	}

	public String getState() {
		return state;
	}

}
