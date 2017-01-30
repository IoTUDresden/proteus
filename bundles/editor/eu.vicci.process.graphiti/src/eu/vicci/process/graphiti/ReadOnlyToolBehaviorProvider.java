package eu.vicci.process.graphiti;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureChecker;
import org.eclipse.graphiti.features.IFeatureCheckerHolder;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.ISingleClickContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;

import eu.vicci.process.graphiti.feature.ProcessClickedFeature;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;

/**
 * Readonly behavior. 
 */
public class ReadOnlyToolBehaviorProvider extends DefaultToolBehaviorProvider implements IFeatureCheckerHolder{
	private ReadOnlyFeatureChecker featureChecker;
	private SingleClickFeature singleClickFeature;
	

	public ReadOnlyToolBehaviorProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}
	
	@Override
	public ICustomFeature getSingleClickFeature(ISingleClickContext context) {
		if(singleClickFeature == null)
			singleClickFeature = new SingleClickFeature(getFeatureProvider());
		return singleClickFeature;
	}	

	@Override
	public IFeatureChecker getFeatureChecker() {
		if(featureChecker == null)
			featureChecker = new ReadOnlyFeatureChecker();
		return featureChecker;
	}
	
	private static class SingleClickFeature extends AbstractCustomFeature{

		public SingleClickFeature(IFeatureProvider fp) {
			super(fp);
		}
		
		@Override
		public boolean canExecute(ICustomContext context) {
			if(context.getPictogramElements().length != 1)
				return false;
			Object bo = getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
			if(isSupportedBusinessObject(bo))
				return true;
			return false;
		}

		@Override
		public void execute(ICustomContext context) {
			Object bo = getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
			String id = getSelectedProcessId(bo);
			if(id == null)
				return;
				
			ProcessClickedFeature clickedFeature = new ProcessClickedFeature(getFeatureProvider(), id);
			getDiagramBehavior().executeFeature(clickedFeature, context);
		}	
		
		private String getSelectedProcessId(Object bo){
			if(bo instanceof Port){
				ProcessStep step = ((Port)bo).getProcessStep();
				if(step != null) 
					return step.getId();
			}
			if(bo instanceof ProcessStep) {
				return ((ProcessStep)bo).getId();				
			}
			return null;
		}
		
		private boolean isSupportedBusinessObject(Object bo){
			return bo instanceof ProcessStep || bo instanceof Port;
		}
	}

}
