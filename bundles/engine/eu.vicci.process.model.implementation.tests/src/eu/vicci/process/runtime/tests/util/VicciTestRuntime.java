package eu.vicci.process.runtime.tests.util;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;

import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

//FIXME complete or delete
public class VicciTestRuntime {
	
	/**
	 * @param args
	 */
	public static void startRuntime() {		
		initializeSofiaModel();		
			
	}
		
	public static void initializeSofiaModel() {		
		// Initialize the models
	    SofiaPackage.eINSTANCE.eClass();
	    SofiaInstancePackage.eINSTANCE.eClass();
	    PictogramsPackage.eINSTANCE.eClass();
	    
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("diagram", new XMIResourceFactoryImpl());
	    m.put("sofia", new XMIResourceFactoryImpl());
	    m.put("sofiainstance", new XMIResourceFactoryImpl());	    
	}

}
