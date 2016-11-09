package eu.vicci.process.graphiti.execution.feature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;
import eu.vicci.process.graphiti.execution.ui.ExecuteProcessEditor;

/**
 * Layout Feature for the {@link ExecuteProcessEditor}
 */
public class ExecuteProcessLayoutFeature extends AbstractLayoutFeature {

	public ExecuteProcessLayoutFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canLayout(ILayoutContext context) {
		return false;
	}

	@Override
	public boolean layout(ILayoutContext context) {
		return false;
	}

}
