package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.UploadModelRequest;
import eu.vicci.process.model.util.Utility;
import ws.wamp.jawampa.Request;

public class UploadAndDeployServerHandler extends AbstractRpcHandlerManageable {

	public UploadAndDeployServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		UploadModelRequest input = convertFromJson(t.arguments().get(0), UploadModelRequest.class);		
		boolean isDiagram = input.isDiagram();		
		String processId = input.getProcessId();
		String processDoc;
		
		if (input.isCompressed()) {
			byte[] processDoczip = input.getProcessDoc();
			processDoc = Utility.decompress(processDoczip);
			
		} else {
			processDoc = input.getProcessDocXML();
		}		
										
		String id = processManager.uploadProcessDefinition(processId, processDoc, isDiagram);	
		id = processManager.deployProcess(id);		
		t.reply(id);		
	}

}
