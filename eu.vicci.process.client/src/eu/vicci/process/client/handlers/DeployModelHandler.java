package eu.vicci.process.client.handlers;

import ws.wamp.jawampa.Reply;

public class DeployModelHandler extends AbstractClientHandler {
	
	@Override
	public void onNext(Reply arg0) {
		state = arg0.arguments().get(0).asText();
	}

}
