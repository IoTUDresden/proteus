package eu.vicci.process.graphiti.feature;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

import eu.vicci.process.graphiti.ToolBehaviorProvider;

public class ProcessMoveShapeFeature extends DefaultMoveShapeFeature {

   public ProcessMoveShapeFeature(IFeatureProvider fp) {

      super(fp);
   }   
   
   @Override
   public boolean canMoveShape(IMoveShapeContext context) {
      // move processes only if grabbed at the topmost 20 pixels
      IDiagramTypeProvider typeProvider = getFeatureProvider().getDiagramTypeProvider();
      
      PictogramElement element = context.getPictogramElement();
      ILocation loc = ((ToolBehaviorProvider) typeProvider.getAvailableToolBehaviorProviders()[typeProvider.getCurrentToolBehaviorIndex()]).getAbsoluteLocation(element.getGraphicsAlgorithm());
      DiagramBehavior behavior = (DiagramBehavior) typeProvider.getDiagramBehavior();
      Point mouse = behavior.calculateRealMouseLocation(behavior.getMouseLocation());

      if (Math.abs(loc.getY() + context.getDeltaY() - mouse.y) > 20)
         return false;
      
     return context.getSourceContainer() != null
            && context.getSourceContainer().equals(context.getTargetContainer());
   }
}
