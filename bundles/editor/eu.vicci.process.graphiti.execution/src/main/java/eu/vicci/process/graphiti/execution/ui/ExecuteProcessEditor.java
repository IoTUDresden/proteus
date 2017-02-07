package eu.vicci.process.graphiti.execution.ui;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.swt.widgets.Composite;

import eu.vicci.process.graphiti.ReadOnlyToolBehaviorProvider;

/**
 * 
 * Custom editor for the execution of process steps
 *
 */
public class ExecuteProcessEditor extends DiagramEditor {
	
	/**
	 * The ID of the {@link DiagramEditor} as it is registered with the
	 * org.eclipse.ui.editors extension point.
	 */
	public static final String EXECUTE_PROCESS_EDITOR_ID = "eu.vicci.process.graphiti.execution.executeProcessEditor";
	
	private ExecuteProcessDiagramBehavior customDiagramBehavior;
	
	private DisposeListener disposeListener;
	
	
	public ExecuteProcessEditor() {
		super();
	}
	
	@Override
	protected DiagramBehavior createDiagramBehavior() {
		customDiagramBehavior = new ExecuteProcessDiagramBehavior(this);
		return customDiagramBehavior;
	}
	
	@Override
	public void dispose() {
		super.dispose();
		if(disposeListener != null)
			disposeListener.onDispose();
	}
	
	public void setDisposeListener(DisposeListener disposeListener) {
		this.disposeListener = disposeListener;
	}	
	
	public void setInstanceId(String instanceId){
		customDiagramBehavior.setInstanceId(instanceId);
	}
	
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		setGridVisibility(false);
		switchToReadOnlyToolBehavior();
	}
	
	@Override
	public boolean isDirty() {
		//no changes after/while the execution should saved to the model
		return false;
	}
	
	@Override
	public boolean isSaveOnCloseNeeded() {
		//no changes after/while the execution should saved to the model
		return false;
	}
	
	@Override
	protected CustomPalettePage createPalettePage() {
		return null;
	}	
	
	/**
	 * Sets the visibility for the grid in the background. Default is false.
	 * @param isVisible
	 */
	public void setGridVisibility(boolean isVisible){
	    if (getGraphicalViewer() == null || getGraphicalViewer().getEditPartRegistry() == null)
	    	return;
	    LayerManager rootEditPart = (LayerManager) getGraphicalViewer().getEditPartRegistry().get(LayerManager.ID);
	    IFigure gridFigure = rootEditPart.getLayer(LayerConstants.GRID_LAYER);
	    gridFigure.setVisible(isVisible);
	}	
	
	//this makes the editor readonly
	private void switchToReadOnlyToolBehavior(){
		IToolBehaviorProvider[] toolProviders = getDiagramTypeProvider().getAvailableToolBehaviorProviders();
		String readOnlyName = ReadOnlyToolBehaviorProvider.class.getCanonicalName();
		for (int i = 0; i < toolProviders.length; i++) {
			if(readOnlyName.equals(toolProviders[i].getClass().getCanonicalName())){
				getDiagramTypeProvider().setCurrentToolBehaviorIndex(i);
				return;
			}			
		}		
	}
	
	public static interface DisposeListener{
		void onDispose();
	}
}
