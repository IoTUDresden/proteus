package eu.vicci.process.graphiti.upload;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.ui.PlatformUI;

public class DiagramSerialization {
	
	public static OutputStream getDiagramSerialized(){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
	    try {
			Diagram diagram = (Diagram) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getAdapter(Diagram.class);
			diagram.eResource().save(os, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return os;
	}
}
