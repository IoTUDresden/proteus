package eu.vicci.process.graphiti.feature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public class ProcessClickedFeature extends AbstractCustomFeature {

	//id of the process in the model
	private String processId;
	
	
	public ProcessClickedFeature(IFeatureProvider fp, String processId) {
		super(fp);
		this.processId = processId;
	}	

	@Override
	public void execute(ICustomContext context) {
		// nothing to do here		
	}

	public String getProcessId() {
		return processId;
	}

}
