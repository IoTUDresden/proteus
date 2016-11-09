package eu.vicci.process.graphiti.upload;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.ui.PlatformUI;

import eu.vicci.process.client.ProcessEngineClient;
import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.sofia.Process;

public class UploadToEngineController {
	private static IProcessEngineClient pec;

	public static boolean connect(String name, String ip, String port) {
		ProcessEngineClientBuilder builder = new ProcessEngineClientBuilder();
		builder.withIp(ip)
		.withPort(port)
		.withName(name)
		.withRealmName(ProcessEngineClient.DEFAULT_REALM)
		.withNamespace(ProcessEngineClient.DEFAULT_NAMESPACE);
		pec = builder.build();
		return pec.connect();
		
	}

	public static void upload() {
		Diagram diagram = (Diagram) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getAdapter(Diagram.class);
		EList<Shape> children = diagram.getChildren();
		Process p = (Process)Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement((PictogramElement) children.get(0));
		Process p2 = EcoreUtil.copy(p);				

		String text = getModelText(p2);		
		pec.uploadProcessDefinition(p.getId(), text, false);
		pec.deployProcess(p2);
	}
	
	private static String getModelText(Process p2){
		XMLResourceImpl resource = new XMLResourceImpl();
		XMLProcessor processor = new XMLProcessor();		
		resource.getContents().add(p2);
		
		try {
			return processor.saveToString(resource, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;		
	}

}
