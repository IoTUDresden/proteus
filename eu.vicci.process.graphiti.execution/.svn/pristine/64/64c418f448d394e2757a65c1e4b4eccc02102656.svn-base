package eu.vicci.process.graphiti.execution.interpreter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.slf4j.Logger;

import eu.vicci.process.graphiti.execution.Activator;
import eu.vicci.process.graphiti.execution.launch.LaunchUtil;
import eu.vicci.process.graphiti.execution.launch.VicciMainTab;
import eu.vicci.process.graphiti.execution.util.StringResource;

public class ProcessInterpreterConfig {
	private IFile file;
	private boolean runInLoop;
	
	public ProcessInterpreterConfig(ILaunchConfiguration configuration) throws CoreException{
		file = LaunchUtil.getSourceFile(configuration);
		runInLoop = VicciMainTab.getRunInLoopFromConfig(configuration);
	}
	
	public void checkConfigValues(Logger logger) throws DebugException {
		if(file != null && file.exists())
			return;
		logger.error(StringResource.ERR_CONFIG_WRONG);		
		throw new DebugException(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
				StringResource.ERR_CONFIG_WRONG_MSG));		
	}

	public IFile getFile() {
		return file;
	}

	public void setFile(IFile file) {
		this.file = file;
	}

	public boolean isRunInLoop() {
		return runInLoop;
	}

	public void setRunInLoop(boolean runInLoop) {
		this.runInLoop = runInLoop;
	}
}
