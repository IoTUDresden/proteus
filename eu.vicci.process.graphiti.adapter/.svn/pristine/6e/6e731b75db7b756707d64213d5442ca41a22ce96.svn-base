package eu.vicci.process.adapter.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import eu.vicci.process.adapter.AdapterConstants;
import eu.vicci.process.adapter.EngineAdapter;
import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IProcessEngineClient;

public class AdapterUtil {

	private AdapterUtil() {
	}

	/**
	 * Retrieve the source file from an {@link ILaunchConfiguration}.
	 * 
	 * @param configuration
	 *            configuration to use
	 * @return source file or <code>null</code>
	 * @throws CoreException
	 */
	public static IFile getSourceFile(final ILaunchConfiguration configuration) throws CoreException {
		String projectName = configuration.getAttribute(AdapterConstants.CFG_LAUNCH_PROJECT, "");
		if (projectName == null || projectName.isEmpty())
			return null;
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		if (!project.exists())
			return null;
		String fileName = configuration.getAttribute(AdapterConstants.CFG_LAUNCH_FILE, "");
		if (fileName == null || fileName.isEmpty())
			return null;
		IFile file = project.getFile(fileName);
		if (file.exists())
			return file;
		return null;
	}

	public static String getClientName() {
		return getClientName(null);
	}

	public static String getClientName(String suffix) {
		String tmp = suffix == null ? "" : suffix;

		try {
			return InetAddress.getLocalHost().getHostName() + tmp;
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "UnknownClient" + tmp;
		}
	}

	/**
	 * Creates an client. You must call {@link IProcessEngineClient#connect()}
	 * to connect the client.
	 * 
	 * @return
	 */
	public static IProcessEngineClient createClient() {
		return createClient(null);
	}

	/**
	 * Creates an client. You must call {@link IProcessEngineClient#connect()}
	 * to connect the client.
	 * 
	 * @param nameSuffix
	 *            suffix for get {@link #getClientName(String)} method, which
	 *            sets the clients name
	 * @return
	 */
	public static IProcessEngineClient createClient(String nameSuffix) {
		String tmp = nameSuffix == null ? "" : nameSuffix;
		ProcessEngineClientBuilder builder = new ProcessEngineClientBuilder();
		return builder.withIp(getConfigValue(AdapterConstants.PREF_HOST))
				.withPort(getConfigValue(AdapterConstants.PREF_PORT))
				.withNamespace(getConfigValue(AdapterConstants.PREF_NAMESPACE))
				.withRealmName(getConfigValue(AdapterConstants.PREF_REALM))
				.withName(getClientName(tmp))
				.build();
	}

	private static String getConfigValue(String key) {
		return EngineAdapter.getDefault().getPreferenceStore().getString(key);
	}

}
