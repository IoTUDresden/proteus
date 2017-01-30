package eu.vicci.process.graphiti.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;

import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.SofiaFactory;

public class StartControlPortCreateFeature extends StartPortCreateFeature {

    public StartControlPortCreateFeature(IFeatureProvider fp) {

        super(fp, "Start Control Port", "Create a Start Control Port");
    }

    @Override
    protected Port createPort() {

        return SofiaFactory.eINSTANCE.createStartControlPort();
    }
}
