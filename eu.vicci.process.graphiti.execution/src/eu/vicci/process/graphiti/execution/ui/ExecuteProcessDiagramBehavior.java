package eu.vicci.process.graphiti.execution.ui;

import java.util.Arrays;
import java.util.Optional;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

import eu.vicci.process.graphiti.execution.debug.model.ProcessDebugTarget;
import eu.vicci.process.graphiti.execution.debug.model.ProcessThread;
import eu.vicci.process.graphiti.feature.ProcessClickedFeature;

/**
 * Custom DiagramBehavior for executing processes
 */
public class ExecuteProcessDiagramBehavior extends DiagramBehavior {
	private String instanceId;

	public ExecuteProcessDiagramBehavior(IDiagramContainerUI diagramContainer) {
		super(diagramContainer);
	}

	@Override
	public Object executeFeature(IFeature feature, IContext context) {
		if (!(feature instanceof ProcessClickedFeature))
			return super.executeFeature(feature, context);
		onProcessClicked(((ProcessClickedFeature) feature).getProcessId());
		return null;
	}

	// FIXME: seems that the ProcessStack must be visible in the view, otherwise it is not possible to select them :(
	// u must click at least 3 times on the process. Debug View is not suitable for us :(
	private void onProcessClicked(String processId) {

		if (instanceId == null || processId == null)
			return;
		System.out.println("Clicked on process " + processId + " for instance " + instanceId);
		try {
			AbstractDebugView debugViewPart = (AbstractDebugView) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().findView("org.eclipse.debug.ui.DebugView");
			TreeViewer treeViewer = (TreeViewer) debugViewPart.getViewer();

			ILaunch launch = getLaunch(treeViewer);
			if (launch == null)
				return;

			ProcessDebugTarget target = (ProcessDebugTarget) launch.getDebugTarget();
			if (target == null)
				return;

			ProcessThread pt = getProcessThread(target, processId);
			if (pt == null)
				return;			
			
			TreePath path = new TreePath(new Object[] { launch, target, pt });	
			StructuredSelection selection = new StructuredSelection(new Object[]{ pt.getTopStackFrame() });			
			dispatchSelection(treeViewer, path, selection);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void dispatchSelection(TreeViewer viewer, TreePath path, IStructuredSelection selection){
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				viewer.expandToLevel(path, 1);
				viewer.setSelection(selection, true);
			}			
		});	
	}

	private ILaunch getLaunch(TreeViewer viewer) {
		Object input = viewer.getInput();
		if (!(input instanceof ILaunchManager))
			return null;
		ILaunchManager lm = (ILaunchManager) input;
		for (ILaunch launch : lm.getLaunches()) {
			if (checkTarget(launch.getDebugTargets()))
				return launch;
		}
		return null;
	}

	private boolean checkTarget(IDebugTarget[] targets) {
		for (IDebugTarget target : targets) {
			if(!(target instanceof ProcessDebugTarget))
				return false;
			if(((ProcessDebugTarget)target).getInstanceId().equals(instanceId))
				return true;
		}
		return false;
	}

	private ProcessThread getProcessThread(ProcessDebugTarget target, String processId) throws DebugException {
		Optional<ProcessThread> pt = Arrays.asList(target.getThreads()).stream()
				.filter(t -> processId.equals(t.getVicciProcessId())).findFirst();
		if (pt.isPresent())
			return pt.get();
		return null;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public boolean isInstanceEditor() {
		return instanceId != null;
	}

}
