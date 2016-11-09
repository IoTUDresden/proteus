package eu.vicci.process.engine;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import eu.vicci.process.model.sofia.Process;

/**
 * Process model loader
 * @author ronsei, Reik Mueller
 *
 */

public class ProcessModelLoader {
		
	public ProcessModelLoader() {
		
	}
		
	public Process loadUri (String resourceuri) {
	    System.err.println("resURI: " + resourceuri);
		Process deployedprocess = null;
		
		// Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();
	    
	    // Get the resource
	    Resource resource = resSet.getResource(URI
	        .createURI(resourceuri), true);	
	    
	    // Get the first model element and cast it to the right type
	    
	    if (resourceuri.endsWith(".diagram")) {
	    	deployedprocess = (Process) resource.getContents().get(1);
	    	// Obtain a new resource set
			ResourceSet resSet2 = new ResourceSetImpl();
			
			// Create a resource
			resourceuri = resourceuri.replace("\\", "/");
			int temp = resourceuri.lastIndexOf('/');
			int temp2 = resourceuri.indexOf(".diagram");
			String filename = resourceuri.substring(temp,temp2);
			String path = "./processes/models/"+filename+".sofia";
			Resource resource2 = resSet2.createResource(URI
					.createURI(path));
				    
			resource2.getContents().add(deployedprocess);

			// Now save the content.
			try {
				resource2.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
			e.printStackTrace();  
			}
	    } else {
	    	deployedprocess = (Process) resource.getContents().get(0);
	    }
	 
	    return deployedprocess;
		
	}

}

