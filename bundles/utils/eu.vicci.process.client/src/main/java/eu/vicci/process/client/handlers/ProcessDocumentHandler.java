package eu.vicci.process.client.handlers;

import eu.vicci.process.engine.core.ReplyState;
import ws.wamp.jawampa.Reply;

public class ProcessDocumentHandler extends AbstractClientHandler {
	private String document = "";

	@Override
	public void onNext(Reply t) {
		document = t.arguments().get(0).asText();		
	}
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}

	public String getDocument() {
		return document;
	}
}
