package eu.vicci.process.graphiti.execution.launch;

import org.eclipse.core.resources.IResource;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;

/**
 * Launch shortcut impl for executing a process step
 */
public class ExecuteProcessLaunchShortcut extends AbstractLaunchShortcut {
	private ILaunchConfigurationType configurationType;

	@Override
	protected ILaunchConfigurationType getConfigurationType() {
		if(configurationType == null){
			ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
			configurationType = manager.getLaunchConfigurationType(ExecuteProcessConfigurationType.ID);			
		}
		return configurationType;
	}

	@Override
	protected void addAttributesToConfiguration(final IResource file, ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(VicciMainTab.CFG_PROJECT, file.getProject().getName());
		configuration.setAttribute(VicciMainTab.CFG_FILE, file.getProjectRelativePath().toPortableString());
		configuration.setAttribute(VicciMainTab.CFG_RUN_IN_LOOP, VicciMainTab.DEFAULT_RUN_IN_LOOP);		
	}

}
