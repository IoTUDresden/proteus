package eu.vicci.process.client.handlers;

import java.io.IOException;
import java.io.StringReader;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.xml.sax.InputSource;

import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.sofia.Process;
import ws.wamp.jawampa.Reply;

public class ProcessInfosHandler extends AbstractClientHandler {
	private String processInfos;
	private Process process;

	@Override
	public void onNext(Reply t) {
		processInfos = t.arguments().get(0).asText();
		
		XMLResource resource = new XMLResourceImpl();
		try {
			resource.load(new InputSource(new StringReader(processInfos)), null);
		} catch (IOException e) {
		}
		
		process = (Process)resource.getContents().get(0);		
	}
	
	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}

	public String getProcessInfos() {
		return processInfos;
	}

	public Process getProcess() {
		return process;
	}
}
