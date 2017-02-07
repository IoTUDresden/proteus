package eu.vicci.process.graphiti.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.StartDataPort;

public class StartDataPortCreateFeature extends StartPortCreateFeature {

    public StartDataPortCreateFeature(IFeatureProvider fp) {

        super(fp, "Start Data Port", "Create a Start Data Port");
    }

    @Override
    protected Port createPort() {

        return SofiaFactory.eINSTANCE.createStartDataPort();
    }
    
    @Override
    public boolean canCreate(ICreateContext context) {
    	if(getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof If){
    		If iF = (If) getBusinessObjectForPictogramElement(context.getTargetContainer());
    		
    		int startDataPortCount = 0;
    		for(Port port : iF.getPorts()){
    			if(port instanceof StartDataPort){
    				startDataPortCount++;
    			}
    		}
    		if(startDataPortCount>1)
    			return false;
    	}
    	
    	return super.canCreate(context);
    }
}
