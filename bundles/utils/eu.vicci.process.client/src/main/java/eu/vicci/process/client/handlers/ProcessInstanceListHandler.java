package eu.vicci.process.client.handlers;

import java.util.List;

import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.util.ProcessInstanceInfo;
import ws.wamp.jawampa.Reply;

public class ProcessInstanceListHandler extends AbstractClientHandler {
	private List<IProcessInstanceInfo> processInstanceList;


	@SuppressWarnings("unchecked")
	@Override
	public void onNext(Reply t) {		
		processInstanceList = convertFromJsonToCollectionType(t.arguments().get(0), List.class, 
				ProcessInstanceInfo.class);	
	}
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}


	public List<IProcessInstanceInfo> getProcessInstanceList() {
		return processInstanceList;
	}
}
