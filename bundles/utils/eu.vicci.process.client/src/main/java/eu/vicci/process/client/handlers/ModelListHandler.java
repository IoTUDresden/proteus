package eu.vicci.process.client.handlers;

import java.util.ArrayList;
import java.util.List;

import ws.wamp.jawampa.Reply;

public class ModelListHandler extends AbstractClientHandler {
	private List<String> modelList;
	
	@Override
	public void onCompleted() {
		state = "succes";
		super.onCompleted();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onNext(Reply t) {
		modelList = convertFromJson(t.arguments().get(0), ArrayList.class); 		
	}

	public List<String> getModelList() {
		return modelList;
	}
}
