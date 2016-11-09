package eu.vicci.process.wampserver.handlers;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.xml.sax.InputSource;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.util.UploadModelRequest;
import eu.vicci.process.model.util.Utility;
import ws.wamp.jawampa.Request;

public class DeployProcessServerHandler extends AbstractRpcHandlerManageable {

	public DeployProcessServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		UploadModelRequest input = convertFromJson(t.arguments().get(0), UploadModelRequest.class);

		String processId = input.getProcessId();
		byte[] processDoczip = input.getProcessDoc();

		String processDoc = Utility.decompress(processDoczip);

		XMLResourceImpl res = new XMLResourceImpl();
		try {
			res.load(new InputSource(new StringReader(processDoc)), null);
		} catch (IOException e) {
//			e.printStackTrace();
		}
		
		Process process = (Process)res.getContents().get(0);
		
		processId = processManager.deployProcess(process);

		t.reply(processId);		
	}
}
