package eu.vicci.process.graphiti.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.EscalationPort;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.SofiaFactory;

public class EscalationPortCreateFeature extends EndPortCreateFeature {

    public EscalationPortCreateFeature(IFeatureProvider fp) {

        super(fp, "Escalation Port", "Create an Escalation Port");
    }

    @Override
    protected Port createPort() {
        return SofiaFactory.eINSTANCE.createEscalationPort();
    }
    
    @Override
    public boolean canCreate(ICreateContext context) {
    	boolean hasNoEscalationPort = true;
    	if (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof ProcessStep){
    		ProcessStep target = (ProcessStep) getBusinessObjectForPictogramElement(context.getTargetContainer());
    		for(Port port : target.getPorts()){
    			if(port instanceof EscalationPort){
    				hasNoEscalationPort = false;
    			}
    		}
    	}
    	return hasNoEscalationPort && super.canCreate(context);
    }
}
