package eu.vicci.process.client.examples;

import java.util.Map;
import java.util.concurrent.CountDownLatch;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.messages.core.HumanTaskRequestListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

public abstract class AbstractProcessRunner {
	protected IProcessEngineClient pec;
	protected CountDownLatch termination = new CountDownLatch(1);
	protected String rootInstanceId;
	protected Process processInfo;
	protected ProcessInstance processInstanceInfo;
	
	public AbstractProcessRunner() {	}	
	
	public void run(){
		createClient();
		pec.connect();
		pec.addStateChangeListener(stateChangeListener);
		pec.addHumanTaskRequestListener(humanTaskRequestListener);
		loadAndStartProcess();
		
		try {
			termination.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		pec.close();
	}
	
	protected abstract String getModelFilePath();
	
	protected IConfigurationReader getConfigurationReader(){
		return new ConfigurationReader("server.conf");
	}
	
	protected Map<String, DataTypeInstance> getInputParameter(){
		return null;
	}
	
	protected void loadAndStartProcess() {
		System.out.println("upload model file...");		
		String processId = pec.uploadModelFile(getModelFilePath());
		System.out.println("model id: " + processId);
		
		System.out.println("deploy " + processId + "...");	
		pec.deployProcess(processId);
		
		System.out.println("deploy instance for " + processId + "...");
		rootInstanceId = pec.deployProcessInstance(processId);
		System.out.println("instance id: " + rootInstanceId);
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		processInstanceInfo = pec.getProcessInstanceInfos(rootInstanceId);		
		processInfo = pec.getProcessInfos(processId);		
		
		System.out.print("Start execution for " + rootInstanceId + "...");
		pec.startProcessInstance(rootInstanceId, getInputParameter());
	}
	
	private void createClient(){
		IConfigurationReader configReader = getConfigurationReader();		
		ProcessEngineClientBuilder builder = new ProcessEngineClientBuilder();
		pec = builder.fromConfig(configReader).build();		
	}
	
	protected void println(String txt){
		System.out.println(txt);
	}
	
	/**
	 * called on all state changes. This method must be called from all overridden methods, 
	 * or the program will not terminate.
	 * @param arg
	 */
	protected void onStateChange(IStateChangeMessage arg){
		println("");
		println((arg.getProcessName() + 
				" changed to " + arg.getState().toString()));
		
		//finished
		if(arg.getProcessInstanceId().equals(rootInstanceId) && State.EXECUTED == arg.getState())
			termination.countDown();				
	}
	
	/**
	 * Receives all {@link IHumanTaskRequest}s. Can be overridden by implementing classes.
	 * @param arg
	 */
	protected void onHumanTaskRequest(IHumanTaskRequest arg){
		println("");
		println("Received HumanTask: " + arg.getName());
	}
	
	private StateChangeListener stateChangeListener = new StateChangeListener() {		
		@Override
		public void onMessage(IStateChangeMessage arg) {
			onStateChange(arg);			
		}
	};
	
	private HumanTaskRequestListener humanTaskRequestListener = new HumanTaskRequestListener() {		
		@Override
		public void onMessage(IHumanTaskRequest arg) {
			onHumanTaskRequest(arg);			
		}
	};
	
	/**
	 * setName setIdOfOrigin setInstanceId setInstancenumber setTypeId setDataTypeType
	 * @param type
	 * @param typeInstance
	 * @param instanceNumber
	 */
	protected static void copyBaseInfosToInstance(DataType type, DataTypeInstance typeInstance, int instanceNumber){
		typeInstance.setName(type.getName());
		typeInstance.setIdOfOrigin(type.getId());
		typeInstance.setInstanceId(type.getId() + "_Instance_" + instanceNumber);
		typeInstance.setInstancenumber(instanceNumber);
		typeInstance.setTypeId(type.getId());
		typeInstance.setDataTypeType(type);
	}

}
