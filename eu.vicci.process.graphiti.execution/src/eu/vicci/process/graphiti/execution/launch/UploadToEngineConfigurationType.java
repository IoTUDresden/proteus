package eu.vicci.process.graphiti.execution.launch;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate2;

import eu.vicci.process.adapter.util.AdapterUtil;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.graphiti.execution.Activator;
import eu.vicci.process.graphiti.execution.util.StringResource;

public class UploadToEngineConfigurationType implements ILaunchConfigurationDelegate2 {
	private static final String CLIENT_SUFFIX = "_UploadToEngine";

	/**
	 * ID for the configuration type {@link UploadToEngineConfigurationType}
	 */
	public static final String ID = "eu.vicci.process.graphiti.execution.launch.uploadToEngineConfigurationType";

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		IFile file = AdapterUtil.getSourceFile(configuration);
		checkFile(file);

		IProcessEngineClient client = AdapterUtil.createClient(CLIENT_SUFFIX);
		if (!client.connect())
			throwCantConnect(client);

		String id = client.uploadModelFile(file.getFullPath().toString());
		if (id == null)
			throwAndCloseClient(client, StringResource.ERR_MODEL_HANDLING_FAILED);

		id = client.deployProcess(id);
		if (id == null)
			throwAndCloseClient(client, StringResource.ERR_MODEL_HANDLING_FAILED);
		client.close();
	}

	private void throwAndCloseClient(IProcessEngineClient client, String text) throws DebugException {
		client.close();
		throwDebugException(text);
	}

	private void throwCantConnect(IProcessEngineClient client) throws DebugException {
		client.close();
		throwDebugException(StringResource.ERR_CANT_CONNECT + " " + client.getIp() + ":" + client.getPort());
	}

	private void checkFile(IFile file) throws DebugException {
		if (file == null || !file.exists())
			throwDebugException(
					StringResource.ERR_FILE_NOT_FOUND + " : " + file == null ? "null" : file.getFullPath().toString());
	}

	private void throwDebugException(String text) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, text));
	}

	@Override
	public ILaunch getLaunch(ILaunchConfiguration configuration, String mode) throws CoreException {
		return null;
	}

	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		return false;
	}

	@Override
	public boolean finalLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		return true;
	}

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		return true;
	}

}
