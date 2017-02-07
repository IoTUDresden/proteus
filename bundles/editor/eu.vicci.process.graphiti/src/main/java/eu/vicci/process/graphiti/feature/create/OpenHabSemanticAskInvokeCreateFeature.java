package eu.vicci.process.graphiti.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;

import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;
import eu.vicci.process.model.sofia.impl.SofiaFactoryImpl;

public class OpenHabSemanticAskInvokeCreateFeature extends OpenHabSemanticInvokeCreateFeatureBase {

	public OpenHabSemanticAskInvokeCreateFeature(IFeatureProvider fp) {
		super(fp, "OpenHabSemanticAskInvoke", "Create a OpenHabSemanticAskInvoke", 
				new Factory());
	}
	
	private static class Factory implements OpenHabSemanticInvokeCreateFeatureFactory{
		@Override
		public OpenHabSemanticInvoke createOpenHabSemanticInvoke() {
			return SofiaFactoryImpl.eINSTANCE.createOpenHabSemanticAskInvoke();
		}		
	}

}
