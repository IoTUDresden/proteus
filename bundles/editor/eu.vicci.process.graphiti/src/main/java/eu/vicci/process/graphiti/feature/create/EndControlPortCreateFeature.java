package eu.vicci.process.graphiti.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;

import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.SofiaFactory;

public class EndControlPortCreateFeature extends EndPortCreateFeature {

    public EndControlPortCreateFeature(IFeatureProvider fp) {

        super(fp, "End Control Port", "Create an End Control Port");
    }

    @Override
    protected Port createPort() {

        return SofiaFactory.eINSTANCE.createEndControlPort();
    }
}
