package eu.vicci.process.graphiti.execution.launch;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate2;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.adapter.util.AdapterUtil;
import eu.vicci.process.adapter.wizard.StartValuesWizard;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.graphiti.execution.Activator;
import eu.vicci.process.graphiti.execution.debug.ProcessDebugger;
import eu.vicci.process.graphiti.execution.debug.dispatcher.EventDispatchJob;
import eu.vicci.process.graphiti.execution.debug.model.ProcessDebugTarget;
import eu.vicci.process.graphiti.execution.interpreter.ProcessInterpreter;
import eu.vicci.process.graphiti.execution.interpreter.ProcessInterpreterConfig;
import eu.vicci.process.graphiti.execution.ui.ExecuteProcessEditor;
import eu.vicci.process.graphiti.execution.ui.ExecuteProcessEditorInput;
import eu.vicci.process.graphiti.execution.util.StringResource;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;

/**
 * Delegate for launching a process execution
 */
public class ExecuteProcessConfigurationType implements ILaunchConfigurationDelegate2 {
	private static final Logger logger = LoggerFactory.getLogger(ExecuteProcessConfigurationType.class);
	private static final String CLIENT_SUFFIX = "_Launcher";

	private IProcessEngineClient client;

	private ProcessInterpreterConfig config;
	private Map<String, DataTypeInstance> startParameter;
	private ProcessInstance processInstance;

	/**
	 * ID for the configuration type {@link ExecuteProcessConfigurationType}
	 */
	public static final String ID = "eu.vicci.process.graphiti.execution.launch.executeProcessConfigurationType";

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		logger.debug("launched vicci process execution");

		ExecuteProcessEditor editor = openEditor(config.getFile());
		checkEditor(editor);

		editor.setInstanceId(processInstance.getInstanceId());
		ProcessInterpreter interpreter = new ProcessInterpreter(editor, processInstance);

		// Debugging uses the eclipse debug framework
		debug(interpreter, editor, launch, config.getFile());
	}

	private void debug(ProcessInterpreter interpreter, ExecuteProcessEditor editor, ILaunch launch, IFile file) {
		ProcessDebugTarget debugTarget = new ProcessDebugTarget(launch, file, processInstance.getInstanceId());
		ProcessDebugger debugger = new ProcessDebugger(interpreter);
		interpreter.setDebugger(debugger);

		EventDispatchJob dispatcher = new EventDispatchJob(debugTarget, debugger);
		dispatcher.schedule();

		debugger.setEventDispatcher(dispatcher);
		debugTarget.setEventDispatcher(dispatcher);

		launch.addDebugTarget(debugTarget);

		interpreter.init();
		interpreter.schedule();
		client.startProcessInstance(processInstance.getInstanceId(), startParameter);
		client.close();
	}

	private String uploadAndDeploy(IProcessEngineClient client, String modelPath) throws DebugException {
		String id = client.uploadModelFile(modelPath, true);
		if (id == null)
			throwDebugException(StringResource.ERR_MODEL_HANDLING_FAILED);
		id = client.deployProcess(id);
		if (id == null)
			throwDebugException(StringResource.ERR_MODEL_HANDLING_FAILED);
		id = client.deployProcessInstance(id);
		if (id == null)
			throwDebugException(StringResource.ERR_MODEL_HANDLING_FAILED);
		return id;

	}

	private void throwDebugException(String text) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, text));
	}

	private void checkClient(IProcessEngineClient client) throws DebugException {
		if (!client.connect()) {
			logger.error("failed to connect");
			client.close();
			throwDebugException(StringResource.ERR_CANT_CONNECT);
		}
	}

	@Override
	public ILaunch getLaunch(ILaunchConfiguration configuration, String mode) throws CoreException {
		logger.debug("get ILaunch");
		return null;
	}

	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		logger.debug("build for launch");
		return false;
	}

	@Override
	public boolean finalLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		// TODO Progress service or monitor cause it seems to the user, that
		// nothing is happen
		// http://wiki.eclipse.org/FAQ_Why_should_I_use_the_new_progress_service%3F

		logger.debug("final launch check");

		config = new ProcessInterpreterConfig(configuration);
		config.checkConfigValues(logger);

		client = AdapterUtil.createClient(CLIENT_SUFFIX);
		checkClient(client);
		
		String path = config.getFile().getFullPath().toString();
		String instanceId = uploadAndDeploy(client, path);

		processInstance = client.getProcessInstanceInfos(instanceId);
		checkProcessInstance();

		List<DataTypeInstance> dtis = getDataTypeInstances(processInstance);

		if (!dtis.isEmpty()) {
			Shell shell = Display.getDefault().getActiveShell();
			startParameter = createStartData(dtis, shell);
		}
		monitor.worked(1);
		monitor.done();

		return true;
	}

	private void checkProcessInstance() throws DebugException {
		if (processInstance == null || processInstance.getInstanceId() == null
				|| processInstance.getProcessModelID() == null)
			throwDebugException(StringResource.ERR_RECEIVE_INSTANCE_FAILED);
	}

	private Map<String, DataTypeInstance> createStartData(List<DataTypeInstance> dataTypeInstances, Shell shell) {
		StartValuesWizard wizard = new StartValuesWizard(dataTypeInstances);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if (dialog.open() == Window.OK) {
			return wizard.getStartValues();
		}
		return null;
	}

	private List<DataTypeInstance> getDataTypeInstances(ProcessInstance instance) {
		return instance.getPorts().stream().filter(p -> p instanceof StartDataPortInstance).map(p -> {
			return ((StartDataPortInstance) p).getDataInstance();
		}).collect(Collectors.toList());
	}

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		logger.debug("preLaunchCheck");
		return true;
	}

	private static ExecuteProcessEditor openEditor(IFile fileToOpen) {
		OpenEditor open = new OpenEditor(fileToOpen);
		Display.getDefault().syncExec(open);
		return open.editor;
	}

	private static void checkEditor(ExecuteProcessEditor editor) throws DebugException {
		if (editor != null)
			return;
		logger.error(StringResource.ERR_OPEN_EDITOR);
		throw new DebugException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, StringResource.ERR_OPEN_EDITOR));
	}

	private static class OpenEditor implements Runnable {
		ExecuteProcessEditor editor = null;
		IFile fileToOpen;

		public OpenEditor(IFile fileToOpen) {
			this.fileToOpen = fileToOpen;
		}

		@Override
		public void run() {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IPath path = fileToOpen.getFullPath();
			URI uri = URI.createPlatformResourceURI(path.toString(), true);

			ExecuteProcessEditorInput input = new ExecuteProcessEditorInput(uri);
			try {
				editor = (ExecuteProcessEditor) page.openEditor(input, ExecuteProcessEditor.EXECUTE_PROCESS_EDITOR_ID);
			} catch (PartInitException e) {

			}
		}
	}
}
