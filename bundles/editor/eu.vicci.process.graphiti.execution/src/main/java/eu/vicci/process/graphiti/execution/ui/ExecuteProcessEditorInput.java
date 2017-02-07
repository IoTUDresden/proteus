package eu.vicci.process.graphiti.execution.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;

public class ExecuteProcessEditorInput extends DiagramEditorInput {
	
	public ExecuteProcessEditorInput(URI diagramUri, String providerId) {
		super(diagramUri, providerId);
	}
	
	public ExecuteProcessEditorInput(URI diagramUri) {
		this(diagramUri, null);
	}
	
	//this prevents the multiple opening of editors while executing a process
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ExecuteProcessEditorInput))
			return false;
		URI other = ((ExecuteProcessEditorInput)obj).getUri();
		return getUri().equals(other);
	}

}
