package eu.vicci.process.client.handlers;

import java.util.List;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.util.ProcessInfo;
import ws.wamp.jawampa.Reply;

public class ProcessListHandler extends AbstractClientHandler {
	private List<IProcessInfo> processInfos;


	@SuppressWarnings("unchecked")
	@Override
	public void onNext(Reply t) {
		processInfos= (List<IProcessInfo>)convertFromJsonToCollectionType(t.arguments().get(0), 
				List.class, ProcessInfo.class);
	}
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}

	public List<IProcessInfo> getProcessInfos() {
		return processInfos;
	}
}
