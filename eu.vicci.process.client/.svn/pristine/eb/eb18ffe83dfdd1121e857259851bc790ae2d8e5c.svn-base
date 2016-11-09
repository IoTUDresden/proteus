package eu.vicci.process.client.handlers;

import ws.wamp.jawampa.Reply;

public class UploadModelHandler extends AbstractClientHandler {
	private String state = "request failed";

	@Override
	public void onNext(Reply t) {
		state = t.arguments().get(0).asText();
	}
	
	public String getState() {
		return state;
	}

}
