package eu.vicci.process.graphiti.adapter.view.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.adapter.AdapterConstants;
import eu.vicci.process.adapter.EngineAdapter;
import eu.vicci.process.adapter.util.AdapterUtil;
import eu.vicci.process.adapter.util.ModelFileUtil;
import eu.vicci.process.adapter.wizard.ConnectWizard;
import eu.vicci.process.adapter.wizard.StartValuesWizard;
import eu.vicci.process.client.core.ConnectionListener;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.graphiti.adapter.view.Activator;
import eu.vicci.process.graphiti.adapter.view.internal.StringResource;
import eu.vicci.process.graphiti.execution.interpreter.ProcessInterpreter;
import eu.vicci.process.graphiti.execution.ui.ExecuteProcessEditor;
import eu.vicci.process.graphiti.execution.ui.ExecuteProcessEditorInput;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.ProcessEngineListener;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

public class ProcessListViewController {
	private static final Logger logger = LoggerFactory.getLogger(ProcessListViewController.class);
	private static final String CLIENT_SUFFIX = "Process_List_View";
	private IProcessListView view;

	private IProcessEngineClient client;
	
	private List<IProcessInfo> processInfos = new ArrayList<>();
	private List<IProcessInstanceInfo> instanceInfos = new ArrayList<>();

	public ProcessListViewController(IProcessListView view) {
		this.view = view;
		registerPreferenceListener();
	}

	/**
	 * Shows the {@link ConnectWizard}
	 * @param shell
	 */
	public void showConnectWizard(Shell shell) {
		ConnectWizard wizard = new ConnectWizard();
		WizardDialog wizardDialog = new WizardDialog(shell, wizard);
		wizardDialog.open();
		
		//the wizard changes the prefs, which triggers the pref changed listener
	}
	
	public List<IProcessInfo> getProcessInfos(){
		return processInfos;		
	}
	
	public List<IProcessInstanceInfo> getInstanceInfos(){
		return instanceInfos;
	}

	/**
	 * If shell is not null, the {@link ConnectWizard} is shown, if some values
	 * are missing.
	 * 
	 * @param shell
	 */
	public void tryConnect(Shell shell) {
		IPreferenceStore store = EngineAdapter.getDefault().getPreferenceStore();
		String pHost = store.getString(AdapterConstants.PREF_HOST);
		String pPort = store.getString(AdapterConstants.PREF_PORT);
		String pRealm = store.getString(AdapterConstants.PREF_REALM);
		String pNS = store.getString(AdapterConstants.PREF_NAMESPACE);

		if (pHost.isEmpty() || pPort.isEmpty() || pRealm.isEmpty() || pNS.isEmpty()) {
			logger.warn("not all prefs are found for direct connecting");
			if (shell != null)
				showConnectWizard(shell);
		} else {
			connect(pHost, pPort, pRealm, pNS);
		}
	}

	/**
	 * Tries to connect to proteus
	 */
	public void tryConnect() {
		tryConnect(null);
	}

	/**
	 * deploy instance and start
	 * 
	 * @param processId
	 *            model id of the process
	 */
	public void startProcess(String processId) {
		String instanceId = client.deployProcessInstance(processId);
		
		// TODO deploy async and react to engine update
		try {
			Thread.sleep(2000); // give time to deploy instance
		} catch (Exception e) {
		}	
		
		ProcessInstance instance = client.getProcessInstanceInfos(instanceId);
		List<DataTypeInstance> dataTypeInstances = getDataTypeInstances(instance);
		
		Map<String, DataTypeInstance> startData = null;
		
		if(dataTypeInstances != null && !dataTypeInstances.isEmpty()){
			startData = createStartData(dataTypeInstances, view.getViewShell());	
			if(startData == null){
				logger.error("error happened while creating start values");
				return;
			}
		}
		
		client.startProcessInstance(instanceId, startData);
	}
	
	public void viewDisposed(){
		unRegisterPreferenceListener();
		unregisterListeners();
		if(client != null)
			client.close();
	}
	
	public void viewLoaded(){
		tryConnect();
	}
	
	public void showProcessInExecutionEditor(IProcessInstanceInfo process){
		ProcessInstance processInstance = client.getProcessInstanceInfos(process.getProcessInstanceId());
		if(processInstance == null){
			showInstanceNotFoundError();
			return;			
		}
		
		ModelFileUtil util = new ModelFileUtil();
		final IFile file = util.findModelInWorkspace(process);
		if(file == null){
			showNotFoundError();
			return;
		}

		Display.getDefault().asyncExec(() -> {
			ExecuteProcessEditor editor = openEditor(file);	
			ProcessInterpreter interpreter = new ProcessInterpreter(editor, processInstance);
			interpreter.init();
			interpreter.schedule();
		});				

	}
	
	public void showProcessInModelEditor(IProcessInfo process){
		ModelFileUtil util = new ModelFileUtil();
		final IFile file = util.findModelInWorkspace(process);
		
		// TODO if no model file could be found locally it may be possible to get the process model from the engine, 
		// safe to a temp file and auto layout the model
		if(file == null){
			showNotFoundError();
		}
		else {
			logger.info("found model file: {}", file.getLocationURI().getPath());
			
			Display.getDefault().asyncExec(() -> {
				openEditor(file);
			});
		}
	}
	
	public void showPeers(){
		PeersDialog dialog = new PeersDialog(view.getViewShell(), client);
		dialog.setBlockOnOpen(false);
		dialog.open();
	}
		
	private ExecuteProcessEditor openEditor(IFile file){
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	    IPath path  = file.getFullPath();
	    URI uri = URI.createPlatformResourceURI(path.toString(), true);	 
	    
	    ExecuteProcessEditorInput input = new ExecuteProcessEditorInput(uri);
	    try {
	    	return (ExecuteProcessEditor)page.openEditor(input, ExecuteProcessEditor.EXECUTE_PROCESS_EDITOR_ID);
		} catch (PartInitException e) {
			
		}		
	    return null;
	}
	
	private void showNotFoundError(){
		logger.warn(StringResource.ERR_MODEL_FILE_NOT_FOUND);
		ErrorDialog.openError(view.getViewShell(), StringResource.ERR, StringResource.ERR_CANT_SHOW_MODEL,
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, StringResource.ERR_MODEL_FILE_NOT_FOUND));		
	}
	
	private void showInstanceNotFoundError(){
		logger.warn(StringResource.ERR_CANT_FIND_INSTANCE);
		ErrorDialog.openError(view.getViewShell(), StringResource.ERR, StringResource.ERR_CANT_SHOW_MODEL,
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, StringResource.ERR_CANT_FIND_INSTANCE));			
	}

	
	private Map<String, DataTypeInstance> createStartData(List<DataTypeInstance> dataTypeInstances, Shell shell){
		StartValuesWizard wizard = new StartValuesWizard(dataTypeInstances);
		WizardDialog dialog = new WizardDialog(shell, wizard);
		if(dialog.open() == Window.OK){
			return wizard.getStartValues();			
		}
		return null;
	}

	private List<DataTypeInstance> getDataTypeInstances(ProcessInstance instance) {
		return instance.getPorts().stream().filter(p -> p instanceof StartDataPortInstance).map(p -> {
			return ((StartDataPortInstance) p).getDataInstance();
		}).collect(Collectors.toList());
	}

	private void connect(String host, String port, String realm, String namespace) {
		logger.debug("connection to proteus on {}:{}", host, port);

		client = AdapterUtil.createClient(CLIENT_SUFFIX);
		boolean connected = client.connect();
		view.clientIsConnected(connected);
		
		if(connected) listProcesses();	
		registerListeners();
	}
	
	private void listProcesses(){
		processInfos.clear();
		processInfos.addAll(client.listDeployedProcesses());
		
		instanceInfos.clear();
		instanceInfos.addAll(client.listProcessInstances());
		
		view.refreshLists();
	}
	
	private ProcessEngineListener engineListener = new ProcessEngineListener() {		
		@Override
		public void onProcessInstanceDeployed(IProcessInstanceInfo processInstanceInfo) {
			if(containsProcessInstance(processInstanceInfo.getProcessInstanceId()))
				return;
			instanceInfos.add(processInstanceInfo);
			view.refreshLists();		
		}
		
		@Override
		public void onProcessDeployed(IProcessInfo processInfo) {
			if(containsProcess(processInfo.getProcessId()))
				return;
			processInfos.add(processInfo);
			view.refreshLists();	
		}
	};

	
	private StateChangeListener stateChangeListener = new StateChangeListener() {
		@Override
		public void onMessage(IStateChangeMessage message) {
			instanceInfos.stream()
			.filter(p -> p.getProcessInstanceId().equals(message.getProcessInstanceId()))
			.forEach(p -> p.setState(message.getState()));
			view.refreshLists();
		}
	};

	private ConnectionListener connectionListener = new ConnectionListener() {
		@Override
		public void onDisconnect() {
			view.clientIsConnected(false);
			unregisterListeners();
		}

		@Override
		public void onConnect() {
			view.clientIsConnected(true);
			registerListeners();
			listProcesses();
		}
	};
	
	private boolean containsProcess(String processId){
		return processInfos.stream().anyMatch(p -> p.getProcessId().equals(processId));
	}
	
	private boolean containsProcessInstance(String instanceId){
		return instanceInfos.stream().anyMatch(p -> p.getProcessInstanceId().equals(instanceId));
	}
	
	private void registerListeners(){
		client.addStateChangeListener(stateChangeListener);
		client.addConnectionListener(connectionListener);
		client.addProcessEngineListener(engineListener);	
	}
	
	private void unregisterListeners(){
		if(client == null)
			return;
		client.removeStateChangeListener(stateChangeListener);
		client.removeConnectionListener(connectionListener);
		client.removeProcessEngineListener(engineListener);		
	}
	
	private void registerPreferenceListener(){
		EngineAdapter.getDefault().getPreferenceStore().addPropertyChangeListener(propertyChangeListener);
	}
	
	private void unRegisterPreferenceListener(){
		EngineAdapter.getDefault().getPreferenceStore().removePropertyChangeListener(propertyChangeListener);			
	}
	
	private IPropertyChangeListener propertyChangeListener = new IPropertyChangeListener() {
		
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			// just reconnect if connection settings have changed
			tryConnect();			
		}
	};
	
}
