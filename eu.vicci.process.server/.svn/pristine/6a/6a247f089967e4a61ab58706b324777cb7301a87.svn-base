package eu.vicci.process.wampserver.handlers;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofia.Process;
import ws.wamp.jawampa.Request;

/**
 * Returns the complete process model
 * @author ronsei
 *
 */
public class ProcessInfosServerHandler extends AbstractRpcHandlerManageable {

	public ProcessInfosServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		String processId =t.arguments().get(0).asText();
		
		String path = processManager.getUploadedProcesses().get(processId);
				
		Process model = null;
		
		// Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();
	    
	    // Get the resource
	    Resource resource = resSet.getResource(org.eclipse.emf.common.util.URI
	        .createURI(path), true);	
	        
    	model = (Process) resource.getContents().get(0);
	        
	    XMLResourceImpl resource2 = new XMLResourceImpl();
		XMLProcessor processor = new XMLProcessor();
		
		String text = "";
		
		resource2.getContents().add(model);
		
		try {
			text = processor.saveToString(resource2, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		t.reply(text);		
	}

}
