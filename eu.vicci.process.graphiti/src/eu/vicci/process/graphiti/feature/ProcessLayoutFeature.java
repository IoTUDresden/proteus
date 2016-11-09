package eu.vicci.process.graphiti.feature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.impl.AbstractLayoutFeature;

public class ProcessLayoutFeature extends AbstractLayoutFeature {

    public ProcessLayoutFeature(IFeatureProvider fp) {

        super(fp);
    }

    @Override
    public boolean canLayout(ILayoutContext context) {
        return getBusinessObjectForPictogramElement(context.getPictogramElement()) instanceof eu.vicci.process.model.sofia.Process;
    }

    @Override
    public boolean layout(ILayoutContext context) {

        return false;
    }

}
