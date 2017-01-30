package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.UploadModelRequest;
import eu.vicci.process.model.util.Utility;
import ws.wamp.jawampa.Request;

public class UploadModelServerHandler extends AbstractRpcHandlerManageable {

	public UploadModelServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t1) {
		UploadModelRequest input = convertFromJson(t1.arguments().get(0), UploadModelRequest.class);
		boolean isDiagram = input.isDiagram();
		boolean overrideExisting = input.isOverrideExisting();

		String processId = input.getProcessId();
		String processDoc;

		if (input.isCompressed()) {
			byte[] processDoczip = input.getProcessDoc();
			processDoc = Utility.decompress(processDoczip);

		} else {
			processDoc = input.getProcessDocXML();
		}

		String id = processManager.uploadProcessDefinition(processId, processDoc, isDiagram, overrideExisting);
		t1.reply(id);		
	}
}
