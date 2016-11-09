package eu.vicci.process.graphiti.execution.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class UploadToEngineLaunchTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {		
		ILaunchConfigurationTab[] tabs = { new VicciMainTab(), new CommonTab() };
		setTabs(tabs);
	}

}
