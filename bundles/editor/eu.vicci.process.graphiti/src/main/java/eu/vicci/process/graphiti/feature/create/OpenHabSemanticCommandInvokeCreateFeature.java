package eu.vicci.process.graphiti.feature.create;

import org.eclipse.graphiti.features.IFeatureProvider;

import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;
import eu.vicci.process.model.sofia.impl.SofiaFactoryImpl;

public class OpenHabSemanticCommandInvokeCreateFeature extends OpenHabSemanticInvokeCreateFeatureBase {

	public OpenHabSemanticCommandInvokeCreateFeature(IFeatureProvider fp) {
		super(fp, "OpenHabSemanticCommandInvoke", "Create a OpenHabSemanticCommandInvoke", 
				new Factory());
	}
	
	private static class Factory implements OpenHabSemanticInvokeCreateFeatureFactory{
		@Override
		public OpenHabSemanticInvoke createOpenHabSemanticInvoke() {
			return SofiaFactoryImpl.eINSTANCE.createOpenHabSemanticCommandInvoke();
		}		
	}

}
