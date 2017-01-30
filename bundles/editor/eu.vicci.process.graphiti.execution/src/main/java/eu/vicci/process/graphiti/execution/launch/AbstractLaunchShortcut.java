package eu.vicci.process.graphiti.execution.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

/**
 * Abstract impl for a launch shortcut Code snippets taken from 
 * <a href="http://codeandme.blogspot.de/2013/11/debugger-2-launch-framework-not-only.html"> codeandme.blogspot.de</a>
 *
 */
public abstract class AbstractLaunchShortcut implements ILaunchShortcut, ILaunchShortcut2 {
	
	@Override
	public void launch(ISelection selection, String mode) {
		launch(getLaunchableResource(selection), mode);
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		launch(getLaunchableResource(editor), mode);		
	}

	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {
		return getLaunchConfgurations(getLaunchableResource(selection));
	}

	@Override
	public ILaunchConfiguration[] getLaunchConfigurations(IEditorPart editorpart) {
		return getLaunchConfgurations(getLaunchableResource(editorpart));
	}

	@Override
	public IResource getLaunchableResource(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			for (final Object element : ((IStructuredSelection) selection).toArray()) {
				if (element instanceof IFile)
					return (IResource) element;
			}
		}
		return null;
	}

	@Override
	public IResource getLaunchableResource(IEditorPart editorpart) {
		final IEditorInput input = editorpart.getEditorInput();
		if (input instanceof FileEditorInput)
			return ((FileEditorInput) input).getFile();
		return null;
	}
	
	/**
	 * Launch a resource. Try to launch using a launch configuration. Used for
	 * contextual launches
	 * 
	 * @param file
	 *            source file
	 * @param mode
	 *            launch mode
	 */
	private void launch(final IResource file, final String mode) {
		if (file instanceof IFile) {
			// try to save dirty editors
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().saveAllEditors(true);

			try {
				ILaunchConfiguration[] configurations = getLaunchConfgurations(file);
				if (configurations.length == 0) {
					// no configuration found, create new one					
					ILaunchConfigurationType type = getConfigurationType();

					ILaunchConfigurationWorkingCopy configuration = type.newInstance(null, file.getName());
					addAttributesToConfiguration(file, configuration);

					// save and return new configuration
					configuration.doSave();

					configurations = new ILaunchConfiguration[] { configuration };
				}

				// launch
				configurations[0].launch(mode, new NullProgressMonitor());

			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected abstract ILaunchConfigurationType getConfigurationType();
	
	protected abstract void addAttributesToConfiguration(final IResource file, 
			ILaunchConfigurationWorkingCopy configuration);
	
	
	/**
	 * Get all launch configurations that target a dedicated resource file.
	 * 
	 * @param resource
	 *            root file to execute
	 * @return {@link ILaunchConfiguration}s using resource
	 */
	private ILaunchConfiguration[] getLaunchConfgurations(IResource resource) {
		List<ILaunchConfiguration> configurations = new ArrayList<ILaunchConfiguration>();
		if(resource == null)
			return configurations.toArray(new ILaunchConfiguration[configurations.size()]);
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = getConfigurationType();

		// try to find existing configurations using the same file
		try {
			for (ILaunchConfiguration configuration : manager.getLaunchConfigurations(type)) {
				try {
					IFile file = LaunchUtil.getSourceFile(configuration);
					if (resource.equals(file))
						configurations.add(configuration);

				} catch (CoreException e) {
					// could not read configuration, ignore
				}
			}
		} catch (CoreException e) {
			// could not load configurations, ignore
		}

		return configurations.toArray(new ILaunchConfiguration[configurations.size()]);
	}
	
}
