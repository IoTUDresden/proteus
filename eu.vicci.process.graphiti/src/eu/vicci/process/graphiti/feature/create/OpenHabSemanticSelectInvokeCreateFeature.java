package eu.vicci.process.graphiti.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;

import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;
import eu.vicci.process.model.sofia.impl.SofiaFactoryImpl;

public class OpenHabSemanticSelectInvokeCreateFeature extends OpenHabSemanticInvokeCreateFeatureBase {

	public OpenHabSemanticSelectInvokeCreateFeature(IFeatureProvider fp) {
		super(fp, "OpenHabSemanticSelectInvoke", "Create a OpenHabSemanticSelectInvoke", 
				new Factory());
	}
	
	private static class Factory implements OpenHabSemanticInvokeCreateFeatureFactory{
		@Override
		public OpenHabSemanticInvoke createOpenHabSemanticInvoke() {
			return SofiaFactoryImpl.eINSTANCE.createOpenHabSemanticSelectInvoke();
		}		
	}

}
