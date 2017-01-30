package eu.vicci.process.adapter.util;

import java.net.URI;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.model.sofia.Process;

/**
 * Util helps finding a process model in the current workspace.
 */
public class ModelFileUtil {
	private static final String EXTENSION_MODEL = "diagram";

	public ModelFileUtil() {
	}

	/**
	 * Search for the model file, which has the same process id as the given
	 * {@link IProcessInfo}
	 * 
	 * @param processInfo
	 * @return null if process model was not found otherwise the {@link IFile}
	 *         which is linked to the found model.
	 */
	public IFile findModelInWorkspace(IProcessInfo processInfo) {
		if (processInfo == null || processInfo.getProcessId() == null)
			throw new IllegalArgumentException("the process info or the process id cant be null");
		return findModelInWorkspace(processInfo.getProcessId());
	}

	/**
	 * Search for the model file, which has the same process id as the given one.
	 * 
	 * @param processId
	 * @return null if process model was not found otherwise the {@link IFile}
	 *         which is linked to the found model.
	 */
	public IFile findModelInWorkspace(String processId) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject project : projects) {
			IFile found = findProcessModel(project.getLocationURI(), processId);
			if (found != null)
				return found;
		}
		return null;
	}

	private IFile findProcessModel(URI pathToSearch, String processId) {
		IFile found = searchAllFiles(pathToSearch, processId);
		if (found != null)
			return found;
		return searchAllFolders(pathToSearch, processId);
	}

	private IFile searchAllFiles(URI pathToSearch, String processId) {
		IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(pathToSearch);
		for (IFile file : files) {
			Process p = getProcess(file);
			if (isWantedModel(p, processId))
				return file;
		}
		return null;
	}

	private boolean isWantedModel(Process p, String processId) {
		return p != null && processId.equals(p.getId());
	}

	// calls recursive findProcessModel
	private IFile searchAllFolders(URI pathToSearch, String processId) {
		IContainer[] containers = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(pathToSearch);
		for (IContainer container : containers) {
			try {
				IResource[] resources = container.members();
				for (IResource res : resources) {
					// should prevent stack overflow loop
					if (pathToSearch.equals(res.getLocationURI()))
						continue;
					IFile f = findProcessModel(res.getLocationURI(), processId);
					if (f != null)
						return f;
				}
			} catch (CoreException e) {
			}
		}
		return null;
	}

	private Process getProcess(IFile file) {
		if (!EXTENSION_MODEL.equals(file.getFileExtension()))
			return null;
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(org.eclipse.emf.common.util.URI.createURI(file.getFullPath().toString()),
				true);
		return (Process) resource.getContents().get(1);
	}

}
