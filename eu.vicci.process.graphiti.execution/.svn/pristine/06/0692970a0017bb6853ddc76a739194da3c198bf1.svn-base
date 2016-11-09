package eu.vicci.process.graphiti.execution.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

public class LaunchUtil {
	
	private LaunchUtil() {	}
	
	/**
	 * Retrieve the source file from an {@link ILaunchConfiguration}.
	 * 
	 * @param configuration
	 *            configuration to use
	 * @return source file or <code>null</code>
	 * @throws CoreException
	 */
	public static IFile getSourceFile(final ILaunchConfiguration configuration) throws CoreException {
		String projectName = configuration.getAttribute(VicciMainTab.CFG_PROJECT, "");
		if (projectName == null || projectName.isEmpty())
			return null;		
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);	
		if (!project.exists())
			return null;
		String fileName = configuration.getAttribute(VicciMainTab.CFG_FILE, "");
		if(fileName == null || fileName.isEmpty())
			return null;
		IFile file = project.getFile(fileName);
		if (file.exists())
			return file;		
		return null;
	}

}
