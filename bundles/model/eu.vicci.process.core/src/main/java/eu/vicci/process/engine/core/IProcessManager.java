package eu.vicci.process.engine.core;

import java.util.List;
import java.util.Map;

import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.util.messages.core.HumanTaskRequestListener;
import eu.vicci.process.model.util.messages.core.HumanTaskResponseListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.ProcessEngineListener;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

public interface IProcessManager {
	static final String EXT_SOFIA = ".sofia";
	static final String EXT_DIAGRAM = ".diagram";

	/**
	 * 
	 * Upload a process model document (either *.sofia or *.diagram). Existing
	 * models are not overridden.
	 * 
	 * @return the process id if success or null if failed
	 */
	String uploadProcessDefinition(String processid, String processdocument, boolean isDiagram);

	/**
	 * 
	 * Upload a process model document (either *.sofia or *.diagram)
	 * 
	 * @param overrideExisting
	 *            should override an existing model file for the same process
	 *            id?
	 * 
	 * @return the process id if success or null if failed
	 */
	String uploadProcessDefinition(String processid, String processdocument, boolean isDiagram,
			boolean overrideExisting);

	/**
	 * Uploads the process and deploys it.
	 * 
	 * @param process
	 * @return process id or null if failed
	 */
	String uploadAndDeploy(Process process);

	/**
	 * Model file must exist on server.
	 * 
	 * @param processid
	 * @return process id or null if failed
	 */
	String deployProcess(String processid);

	/**
	 * Model file must exist on server.
	 * 
	 * @param process
	 * @return process id or null if failed
	 */
	String deployProcess(Process process);

	/**
	 * Deploy a process instance, i.e. create and prepare an instance for
	 * execution. Returns the new Instance ID of the process.
	 * 
	 * @param processId
	 *            the process id
	 * 
	 * @return new instance id of the process
	 */
	String deployProcessInstance(String processId);

	/**
	 * Uploads a process model from a local file
	 * 
	 * @return process id or null if failed
	 */
	String uploadModelFile(String filepath);

	/**
	 * Uploads a process model from a local file
	 * 
	 * @param overrideExisting
	 *            Override existing model files?
	 * 
	 * @return process id or null if failed
	 */
	String uploadModelFile(String filepath, boolean overrideExisting);

	/**
	 * Configure a process instance
	 */
	String configureProcessInstance(String processInstanceId, String configuration);

	String startProcessInstance(String processInstanceId, Map<String, DataTypeInstance> inputParameters);

	/**
	 * Starts a process instance and runs the given process in a loop. This
	 * means, if the process reaches the state 'executed', the process is
	 * started in a new process instance. While a process is running, the
	 * follower is deployed.
	 * 
	 * @param processInstanceId
	 * @param inputParameters
	 * @param runInLoop
	 * @return
	 */
	String startProcessInstance(String processInstanceId, Map<String, DataTypeInstance> inputParameters, 
			boolean runInLoop);

	String stopProcessInstance(String processInstanceId);

	String pauseProcessInstance(String processInstanceId);

	String resumeProcessInstance(String processInstanceId);

	String getProcessDefinition(String processid);

	/**
	 * Returns a list of uploaded (undeployed) process models (their ids)
	 */
	List<String> listUploadedProcessDefinitions();

	/**
	 * Returns a list of deployed process models (in memory of engine) with
	 * additional information according to the ProcessInfo class
	 */
	List<IProcessInfo> listDeployedProcesses();

	Process getProcessInfos(String processId);

	ProcessInstance getProcessInstanceInfos(String processInstanceId);

	/**
	 * Returns reduced information with respect a process instance, i.e. a map
	 * of all process step instances - a mapping of their instance-ids to their
	 * corresponding model-ids
	 */
	Map<String, String> getProcessInstanceInfosReduced(String processInstanceId);

	/**
	 * Returns a list of existing process instances and additional information
	 * according to the ProcessInstanceInfo class
	 */
	List<IProcessInstanceInfo> listProcessInstances();

	String removeInstance(String processInstanceId);

	IStateChangeMessage getInstanceState(String processInstanceId);

	List<IStateChangeMessage> getInstanceLog(String processInstanceId);

	List<IStateChangeMessage> getRecentStateChanges();

	/**
	 * @deprecated seems this is not used, so we can drop this.
	 * @param psi
	 * @param ps
	 * @param alreadyExecuting
	 * @return
	 */
	@Deprecated
	ProcessStepInstance executeProcessStep(ProcessStepInstance psi, ProcessStep ps, boolean alreadyExecuting);

	void loadExistingModels();

	Map<String, String> getUploadedProcesses();

	/**
	 * Register {@link StateChangeListener}s which receiving all
	 * {@link IStateChangeMessage}s.
	 * 
	 * @param stateChangeListener
	 */
	void addStateChangeListener(StateChangeListener stateChangeListener);

	/**
	 * Removes a {@link StateChangeListener}.
	 * 
	 * @param stateChangeListener
	 */
	void removeStateChangeListener(StateChangeListener stateChangeListener);

	/**
	 * Register a {@link HumanTaskRequestListener} which receives all
	 * {@link IHumanTaskRequest}s
	 * 
	 * @param humanTaskRequestListener
	 */
	void addHumanTaskRequestListener(HumanTaskRequestListener humanTaskRequestListener);

	/**
	 * Removes a {@link HumanTaskRequestListener}
	 * 
	 * @param humanTaskRequestListener
	 */
	void removeHumanTaskRequestListener(HumanTaskRequestListener humanTaskRequestListener);
	
	/**
	 * Adds a {@link HumanTaskResponseListener} to receive all human task responses.
	 * @param listener
	 */
	void addHumanTaskResponseLister(HumanTaskResponseListener listener);
	
	/**
	 * Removes a {@link HumanTaskResponseListener} to receive all human task responses.
	 * @param listener
	 */
	void removeHumanTaskResponseListener(HumanTaskResponseListener listener);

	/**
	 * Sets the {@link ClientBuilderFactory} which creates a
	 * {@link AbstractClientBuilder} to create a new
	 * {@link IProcessEngineClient}
	 * 
	 * @param factory
	 */
	void setClientBuilderFactory(ClientBuilderFactory factory);

	/**
	 * Creates a new {@link AbstractClientBuilder} to create a new
	 * {@link IProcessEngineClient}. This method returnes a client builder
	 * accoding to the given {@link ClientBuilderFactory} which you can set via
	 * {@link #setClientBuilderFactory(ClientBuilderFactory)}
	 * 
	 * @return null if no {@link ClientBuilderFactory} is set.
	 */
	AbstractClientBuilder createNewClientBuilder();

	/**
	 * adds a {@link ProcessEngineListener}
	 * 
	 * @param listener
	 */
	void addProcessEngineListener(ProcessEngineListener listener);

	/**
	 * removes a {@link ProcessEngineListener}
	 * 
	 * @param listener
	 */
	void removeProcessEngineListener(ProcessEngineListener listener);
}
