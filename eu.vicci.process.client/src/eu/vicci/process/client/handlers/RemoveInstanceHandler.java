package eu.vicci.process.client.handlers;

import ws.wamp.jawampa.Reply;

public class RemoveInstanceHandler extends AbstractClientHandler{

	@Override
	public void onNext(Reply t) {
		state = t.arguments().get(0).asText();			
	}

}