package eu.vicci.process.engine;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.engine.core.ClientBuilderFactory;
import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.engine.internal.IProcessManagerInternal;
import eu.vicci.process.engine.internal.ProcessInstanceExecutor;
import eu.vicci.process.engine.internal.ProcessInstancePersistor;
import eu.vicci.process.engine.internal.ProcessManagerInternal;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofiainstance.Configuration;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ConfigurationImplCustom;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.util.ProcessInfo;
import eu.vicci.process.model.util.ProcessInstanceInfo;
import eu.vicci.process.model.util.logging.InstanceLogger;
import eu.vicci.process.model.util.logging.LoggingManager;
import eu.vicci.process.model.util.messages.MessageQueue;
import eu.vicci.process.model.util.messages.core.HumanTaskRequestListener;
import eu.vicci.process.model.util.messages.core.HumanTaskResponseListener;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.ProcessEngineListener;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

/**
 * Process manager providing external interfaces
 * 
 * @author ronsei, Reik Mueller
 * 
 */
public class ProcessManagerPublic implements IProcessManager {
	private static final String PATH_MODEL = "./processes/models/";
	private static final String PATH_DIAGRAM = "./processes/diagrams/";	
	
	private ProcessInstanceExecutor processInstanceExecutor;
	private ProcessInstancePersistor processInstancePersistor;
	private IProcessManagerInternal processManager;
	private final MessageQueue messageQueue;
	private ClientBuilderFactory clientBuilderFactory;

	private List<ProcessEngineListener> engineListeners = new ArrayList<>();

	public ProcessManagerPublic() {
		processManager = new ProcessManagerInternal();
		messageQueue = new MessageQueue();
		messageQueue.schedule();
		processInstanceExecutor = new ProcessInstanceExecutor(processManager, messageQueue, this);
		processInstancePersistor = new ProcessInstancePersistor(processManager, this);
		processManager.setProcessInstancePersistor(processInstancePersistor);
	}

	@Override
	public String uploadProcessDefinition(String processid, String processdocument, boolean isDiagram) {
		return uploadProcessDefinition(processid, processdocument, isDiagram, false);
	}

	@Override
	public String uploadProcessDefinition(String processid, String processdocument, boolean isDiagram,
			boolean overrideExisting) {
		try {
			printUploadedDoc(processdocument);			
			String path = "";
			if (isDiagram) {
				path = URI.createURI(PATH_DIAGRAM + processid + EXT_DIAGRAM).toFileString();
			} else {
				path = URI.createURI(PATH_MODEL + processid + EXT_SOFIA).toFileString();
			}

			File file = new File(path);
			file.getParentFile().mkdirs();

			if (file.exists() && overrideExisting)
				file.delete();

			if (!file.exists()) {
				file.createNewFile();
				FileWriter fw = new FileWriter(file, true);
				fw.write(processdocument);
				fw.close();
				printPath(path.toString());
				processManager.getUploadedProcesses().put(processid, path);
			} else {
				processManager.getUploadedProcesses().put(processid, path);
				return processid;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return processid;
	}

	public Map<String, String> getUploadedProcesses() {
		return processManager.getUploadedProcesses();
	}

	@Override
	public String deployProcess(Process process) {
		System.out.println("ProcessManager.deployProcess()");
		processManager.getDeployedprocesses().put(process.getId(), process);
		IProcessInfo info = new ProcessInfo(process);
		engineListeners.stream().forEach(l -> l.onProcessDeployed(info));
		return process.getId();
	}

	@Override
	public String deployProcess(String processid) {
		ProcessModelLoader pml = new ProcessModelLoader();
		Process p = pml.loadUri(processManager.getUploadedProcesses().get(processid));
		return deployProcess(p);
	}

	@Override
	public String deployProcessInstance(String processid) {
		System.out.println("ProcessManager.deployProcessInstance()");
		ProcessInstance instance = processInstanceExecutor.deploy(processid);
		IProcessInstanceInfo info = new ProcessInstanceInfo(instance);
		engineListeners.stream().forEach(l -> l.onProcessInstanceDeployed(info));
		return instance.getInstanceId();
	}

	@Override
	public String configureProcessInstance(String processid, String configuration) {
		try {
			InputStream stream = new ByteArrayInputStream(configuration.getBytes());
			Configuration recoveredConfig = null;

			// UnMarshal the configuration
			JAXBContext context = JAXBContext.newInstance(ConfigurationImplCustom.class);
			Unmarshaller um = context.createUnmarshaller();
			recoveredConfig = (Configuration) um.unmarshal(stream);

			// configure the ProcessInstance
			processInstanceExecutor.configure(processid, recoveredConfig);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

		return ReplyState.SUCCESS;
	}

	@Override
	public String startProcessInstance(String processInstanceId, Map<String, DataTypeInstance> inputParameters) {
		return startProcessInstance(processInstanceId, inputParameters, false);
	}

	@Override
	public String startProcessInstance(String processInstanceId, Map<String, DataTypeInstance> inputParameters, 
			boolean runInLoop) {
		return startProcessInstance(processInstanceId, null, inputParameters, runInLoop);
	}
	
	@Override
	public String startProcessInstance(String processInstanceId, String runningForInstanceId,
			Map<String, DataTypeInstance> inputParameters, boolean runInLoop) {
		// TODO RUN IN LOOP
		System.out.println("ProcessManager.startProcessInstance()");
		processInstanceExecutor.execute(processInstanceId, runningForInstanceId, inputParameters);
		return ReplyState.SUCCESS;
	}

	@Override
	public String stopProcessInstance(String instanceid) {
		// ProcessInstance pi = processManager.getProcessInstance(instanceid);
		// pi.stop();

		// FIXME at the moment only killing the whole actor system is supported
		// all deployed or running processes will be killed
		LifeCycleManager.INSTANCE.reset();

		// processInstancePersistor.persistInstance(pi);

		return ReplyState.SUCCESS;
	}

	@Override
	public String pauseProcessInstance(String instanceid) {
		ProcessInstance pi = processManager.getProcessInstance(instanceid);
		pi.pause();
		return ReplyState.SUCCESS;
	}

	@Override
	public String getProcessDefinition(String processid) {
		String path = processManager.getUploadedProcesses().get(processid);
		String text = "";

		File file = new File(path);

		try {
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\z");
			text = scanner.next();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return text;
	}

	@Override
	public List<String> listUploadedProcessDefinitions() {
		List<String> processids = new LinkedList<String>();
		for (String id : processManager.getUploadedProcesses().keySet()) {
			processids.add(id);
		}

		return processids;
	}

	@Override
	public List<IProcessInfo> listDeployedProcesses() {
		List<IProcessInfo> processInfos = new ArrayList<IProcessInfo>();
		for (Process p : processManager.getDeployedprocesses().values()) {
			ProcessInfo info = new ProcessInfo(p);
			processInfos.add(info);
		}

		return processInfos;
	}

	@Override
	public List<IProcessInstanceInfo> listProcessInstances() {
		List<IProcessInstanceInfo> instanceInfos = new ArrayList<IProcessInstanceInfo>();
		for (ProcessInstance procIns : processManager.getProcessinstances().keySet()) {
			ProcessInstanceInfo pii = new ProcessInstanceInfo(procIns);
			instanceInfos.add(pii);
		}

		return instanceInfos;
	}

	@Override
	public String resumeProcessInstance(String processInstanceId) {
		ProcessInstance pi = processManager.getProcessInstance(processInstanceId);
		pi.resume();
		return ReplyState.SUCCESS;
	}

	@Override
	public Process getProcessInfos(String processId) {
		Process proc = processManager.getProcess(processId);
		return proc;
	}

	@Override
	public ProcessInstance getProcessInstanceInfos(String processInstanceId) {
		ProcessInstance procIns = processManager.getProcessInstance(processInstanceId);
		return procIns;
	}

	@Override
	public String uploadModelFile(String filepath) {
		return uploadModelFile(filepath, false);
	}
	
	@Override
	public String uploadModelFile(String filepath, boolean overrideExisting) {
		Process model = null;
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(org.eclipse.emf.common.util.URI.createURI(filepath), true);


		if (filepath.endsWith(EXT_DIAGRAM)) {
			model = (Process) resource.getContents().get(1);
		} else {
			model = (Process) resource.getContents().get(0);
		}

		String processId = model.getId();

		XMLResourceImpl resource2 = new XMLResourceImpl();
		XMLProcessor processor = new XMLProcessor();
		resource2.getContents().add(model);

		try {
			String text = processor.saveToString(resource2, null);
			printModel(text);
			return uploadProcessDefinition(processId, text, false, overrideExisting);
		} catch (IOException e) {
			e.printStackTrace();			
		}
		
		return null;
	}

	@Override
	public void loadExistingModels() {

		File modelFolder = new File(PATH_MODEL);
		for (File modelFile : modelFolder.listFiles()) {
			String path = "";
			try {
				path = modelFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
			}

			Process deployedprocess = null;

			// Obtain a new resource set
			ResourceSet resSet = new ResourceSetImpl();

			// Get the resource
			Resource resource = resSet.getResource(URI.createURI(path), true);

			// Get the first model element and cast it to the right type

			deployedprocess = (Process) resource.getContents().get(0);

			processManager.getUploadedProcesses().put(deployedprocess.getId(), path);

			deployProcess(deployedprocess.getId());

		}

		File diagramFolder = new File(PATH_DIAGRAM);

		for (File diagramFile : diagramFolder.listFiles()) {
			String path = "";
			try {
				path = diagramFile.getCanonicalPath();
			} catch (IOException e) {
				e.printStackTrace();
			}

			path = path.replace("\\", "/");
			int temp = path.lastIndexOf('/');
			int temp2 = path.indexOf(EXT_DIAGRAM);
			String filename = path.substring(temp, temp2);
			String path2 = PATH_MODEL + filename + EXT_SOFIA;

			File model = new File(path2);

			if (!model.exists()) {
				Process deployedprocess = null;

				// Obtain a new resource set
				ResourceSet resSet = new ResourceSetImpl();

				// Get the resource
				Resource resource = resSet.getResource(URI.createURI(path), true);

				deployedprocess = (Process) resource.getContents().get(1);

				deployProcess(deployedprocess.getId());

				// Obtain a new resource set
				// Save diagram to model file
				ResourceSet resSet2 = new ResourceSetImpl();

				Resource resource2 = resSet2.createResource(URI.createURI(path2));

				resource2.getContents().add(deployedprocess);

				// Now save the content.
				try {
					resource2.save(Collections.EMPTY_MAP);
				} catch (IOException e) {
					e.printStackTrace();
				}

				processManager.getUploadedProcesses().put(deployedprocess.getId(), path2);
			} else
				System.out.println("Model already existing");

		}

	}

	@Override
	public Map<String, String> getProcessInstanceInfosReduced(String processInstanceId) {
		ProcessInstance procIns = getProcessInstanceInfos(processInstanceId);

		// ProcessStep-ID and ProcessStepInstance-ID
		Map<String, String> processStepsList = new HashMap<String, String>();
		processStepsList.put(procIns.getProcessStepType().getId(), procIns.getInstanceId());

		if (procIns.getSubSteps().size() > 0)
			traverseSteps(procIns, processStepsList);
		return processStepsList;
	}

	@Override
	public String removeInstance(String processInstanceId) {
		for (ProcessInstance pi : processManager.getProcessinstances().keySet()) {
			if (pi.getInstanceId().equals(processInstanceId)) {
				processManager.getProcessinstances().keySet().remove(pi);
				// FIXME make a method to destroy the actors for this process
				// step
				// otherwise a new process with the same id cant deploy
				// resetting the actorsystem destroys all deployed process
				// instances
				LifeCycleManager.INSTANCE.reset();
				return ReplyState.SUCCESS;
			}
		}
		return ReplyState.ERROR;
	}

	@Override
	public IStateChangeMessage getInstanceState(String processInstanceId) {
		InstanceLogger il = LoggingManager.getInstance().getLoggers().get(processInstanceId);
		return il.getRecentLoggingMessage();
	}

	@Override
	public List<IStateChangeMessage> getInstanceLog(String processInstanceId) {
		InstanceLogger il = LoggingManager.getInstance().getLoggers().get(processInstanceId);
		return il.getLoggingMessages();
	}

	private void traverseSteps(ProcessStepInstance psi, Map<String, String> stepList) {
		for (ProcessStepInstance psubi : psi.getSubSteps()) {
			stepList.put(psubi.getProcessStepType().getId(), psubi.getInstanceId());
			if (psubi.getSubSteps().size() > 0) {
				traverseSteps(psubi, stepList);
			}
		}
	}

	@Override
	public List<IStateChangeMessage> getRecentStateChanges() {
		return LoggingManager.getInstance().getRecentStateChanges();
	}

	/**
	 * @deprecated seems is not used by any of
	 */
	@Override
	public ProcessStepInstance executeProcessStep(ProcessStepInstance psi, ProcessStep ps, boolean alreadyExecuting) {
		psi.setProcessStepType(ps);
		if (!alreadyExecuting) {
			psi.execute();
			while (!psi.getExecutionState().equals(State.EXECUTED)) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return psi;
		}
		return null;
	}

	@Override
	public String uploadAndDeploy(Process process) {
		ResourceSet resSet = new ResourceSetImpl();
		String path = PATH_MODEL + process.getId() + EXT_SOFIA;
		Resource r = resSet.createResource(URI.createURI(path));
		r.getContents().add(process);

		try {
			r.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}

		processManager.getUploadedProcesses().put(process.getId(), path);
		deployProcess(process);
		return process.getId();
	}

	@Override
	public void setClientBuilderFactory(ClientBuilderFactory factory) {
		this.clientBuilderFactory = factory;
	}

	@Override
	public AbstractClientBuilder createNewClientBuilder() {
		if (clientBuilderFactory == null)
			return null;
		return clientBuilderFactory.createClientBuilder();
	}

	@Override
	public void addStateChangeListener(StateChangeListener stateChangeListener) {
		messageQueue.addStateChangeListener(stateChangeListener);
	}

	@Override
	public void removeStateChangeListener(StateChangeListener stateChangeListener) {
		messageQueue.removeStateChangeListener(stateChangeListener);
	}

	@Override
	public void addHumanTaskRequestListener(HumanTaskRequestListener humanTaskRequestListener) {
		messageQueue.addHumanTaskRequestListener(humanTaskRequestListener);
	}

	@Override
	public void removeHumanTaskRequestListener(HumanTaskRequestListener humanTaskRequestListener) {
		messageQueue.removeHumanTaskRequestListener(humanTaskRequestListener);
	}
	
	@Override
	public void addHumanTaskResponseLister(HumanTaskResponseListener listener) {
		throw new UnsupportedOperationException("not implemented yet");				
	}

	@Override
	public void removeHumanTaskResponseListener(HumanTaskResponseListener listener) {
		throw new UnsupportedOperationException("not implemented yet");			
	}

	@Override
	public void addProcessEngineListener(ProcessEngineListener listener) {
		if (!engineListeners.contains(listener))
			engineListeners.add(listener);
	}

	@Override
	public void removeProcessEngineListener(ProcessEngineListener listener) {
		engineListeners.remove(listener);
	}
	
	private void printModel(String text){
		System.out.println("Text: \n" + text);		
	}
	
	private void printPath(String path){
		System.out.println("Path: " + path);		
	}
	
	private void printUploadedDoc(String doc){
		System.out.println("uploaded document: \n" + doc);		
	}
}
