package eu.vicci.process.graphiti.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.SofiaFactory;

public class EndDataPortCreateFeature extends EndPortCreateFeature {

    public EndDataPortCreateFeature(IFeatureProvider fp) {

        super(fp, "End Data Port", "Create an End Data Port");
    }

    @Override
    protected Port createPort() {

        return SofiaFactory.eINSTANCE.createEndDataPort();
    }
    
    @Override
    public boolean canCreate(ICreateContext context) {
    	if(getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof If){
    		If iF = (If) getBusinessObjectForPictogramElement(context.getTargetContainer());
    		
    		int endDataPortCount = 0;
    		for(Port port : iF.getPorts()){
    			if(port instanceof EndDataPort){
    				endDataPortCount++;
    			}
    		}
    		
    		//Change the maximum EndDataPort-Count here
    		if(endDataPortCount>-1)
    			return false;
    	}
    	
    	return super.canCreate(context);
    }
}
