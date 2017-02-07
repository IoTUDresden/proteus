package eu.vicci.process.model.implementation.tests.util;

import java.io.File;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

/**
 * Base class for testing the process execution.
 */
public abstract class TestsBase {
	private final static String MODELS_PATH = "processes/models/";

	@BeforeClass
	public static void registerFactories() {
		SofiaPackage.eINSTANCE.eClass();
		SofiaInstancePackage.eINSTANCE.eClass();
		PictogramsPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("diagram", new XMIResourceFactoryImpl());
		m.put("sofia", new XMIResourceFactoryImpl());
		m.put("sofiainstance", new XMIResourceFactoryImpl());
	}

	@AfterClass
	public static void cleanupUploadedFiles() {
		File path = new File(MODELS_PATH);
		for (File file : path.listFiles())
			file.delete();
	}
}
