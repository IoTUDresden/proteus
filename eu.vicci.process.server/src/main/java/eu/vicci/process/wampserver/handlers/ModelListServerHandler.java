package eu.vicci.process.wampserver.handlers;

import java.util.ArrayList;
import java.util.Set;

import eu.vicci.process.engine.core.IProcessManager;
import ws.wamp.jawampa.Request;

/**
 * Returns a list of uploaded process models
 * @author ronsei
 *
 */
public class ModelListServerHandler extends AbstractRpcHandlerManageable{	

	public ModelListServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		ArrayList<String> modelList = new ArrayList<String>();
		Set<String> tempSet = processManager.getUploadedProcesses().keySet();
		
		for (String elem : tempSet)
			modelList.add(elem);
		
		t.reply(modelList);		
	}

}
