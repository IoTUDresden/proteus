package eu.vicci.process.graphiti.execution.launch;

import org.eclipse.core.resources.IResource;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;

/**
 * Launch shortcut, for uploading a process to the engine.
 */
public class UploadToEngineLaunchShortcut extends AbstractLaunchShortcut {
	private ILaunchConfigurationType configurationType;

	@Override
	protected ILaunchConfigurationType getConfigurationType() {
		if(configurationType == null){
			ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
			configurationType = manager.getLaunchConfigurationType(UploadToEngineConfigurationType.ID);			
		}
		return configurationType;
	}

	@Override
	protected void addAttributesToConfiguration(IResource file, ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(VicciMainTab.CFG_PROJECT, file.getProject().getName());
		configuration.setAttribute(VicciMainTab.CFG_FILE, file.getProjectRelativePath().toPortableString());		
	}

}
