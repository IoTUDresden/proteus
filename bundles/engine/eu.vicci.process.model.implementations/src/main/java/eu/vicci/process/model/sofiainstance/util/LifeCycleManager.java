package eu.vicci.process.model.sofiainstance.util;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.TypedActor;
import akka.actor.UntypedActor;
import akka.japi.Creator;
import akka.util.Timeout;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.actors.EndPortActorFactory;
import eu.vicci.process.actors.IProcessExecutionMasterActor;
import eu.vicci.process.actors.ProcessExecutionMasterActor;
import eu.vicci.process.actors.ProcessStepActorFactory;
import eu.vicci.process.actors.StartControlPortActorFactory;
import eu.vicci.process.actors.StartDataPortActorFactory;
import eu.vicci.process.actors.TransitionActorFactory;
import eu.vicci.process.messages.ActivatePortMessage;
import eu.vicci.process.messages.ChangePortExecutionStateMessage;
import eu.vicci.process.messages.CreateChildActorMessage;
import eu.vicci.process.messages.DeactivatePortMessage;
import eu.vicci.process.messages.DeactivateProcessStepMessage;
import eu.vicci.process.messages.DeactivateTransitionMessage;
import eu.vicci.process.messages.EscalateProcessStepMessage;
import eu.vicci.process.messages.ExecuteProcessStepMessage;
import eu.vicci.process.messages.ExecuteTransitionMessage;
import eu.vicci.process.messages.KillProcessStepMessage;
import eu.vicci.process.messages.PauseProcessStepMessage;
import eu.vicci.process.messages.PortExecutionStateChangedMessage;
import eu.vicci.process.messages.ProcessExecutedMessage;
import eu.vicci.process.messages.ProcessResetMessage;
import eu.vicci.process.messages.ResetProcessMessage;
import eu.vicci.process.messages.ResumeProcessStepMessage;
import eu.vicci.process.messages.SetPortDataTypeInstanceMessage;
import eu.vicci.process.messages.StopProcessStepMessage;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartControlPortInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.states.PortExecutionStateChangedListener;
import eu.vicci.process.model.sofiainstance.states.ProcessExecutedListener;
import eu.vicci.process.model.sofiainstance.states.ProcessResetListener;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;

/**
 * This LifeCycleManager should be used to interact with port-, transition- and
 * processstepinstances (e.g. activate port, execute processstep,...). It uses
 * an Akka ActorSystem to execute the processsteps decoupled. Synchronus /
 * blocking calls are indicated (*Sync())
 */
public enum LifeCycleManager {
	/**
	 * The singleton-instance of the LifeCycleManager
	 */
	INSTANCE;

	private final static String EXECUTION_SYSTEM_NAME = "processExecutionSystem";
	private final static String EXECUTION_MASTER_NAME = "executionMaster";
	private final static int DEFAULT_TIMEOUT = 5;
	
	private final FiniteDuration duration = Duration.create(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
	private final Timeout timeout = new Timeout(duration);
	
	private ActorSystem processExecutionSystem;
	private IProcessExecutionMasterActor executionMaster;
	private final Logger logger;

	private LifeCycleManager() {
		logger = LoggerFactory.getLogger("LifeCycleManager");
		logger.debug("setting up the process execution system");
		processExecutionSystem = ActorSystem.create(EXECUTION_SYSTEM_NAME);
		executionMaster = ProcessExecutionMasterActor.create(processExecutionSystem, EXECUTION_MASTER_NAME);
	}

	/**
	 * Activates a port
	 * 
	 * @param port
	 * @param parameter
	 */
	public void activatePort(PortInstance port, DataTypeInstance parameter) {
		logger.info("activate port: {}", port.getName());
		ActivatePortMessage message = new ActivatePortMessage(parameter);
		ActorRef receiver = ((ActorAssignable) port).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
	}

	/**
	 * Activates a port
	 * 
	 * @param port
	 */
	public void activatePort(PortInstance port) {
		activatePort(port, null);
	}

	/**
	 * Activates a port. Blocking Call.
	 * 
	 * @param port
	 * @return
	 */
	public boolean activatePortSync(PortInstance port) {
		return activatePortSync(port, null);
	}

	/**
	 * Activates a port. Blocking Call.
	 * @param port
	 * @param parameter
	 * @return
	 */
	public boolean activatePortSync(PortInstance port, DataTypeInstance parameter) {
		logger.info("activate port: {}", port.getName());
		ActivatePortMessage message = new ActivatePortMessage(parameter, true);
		ActorRef receiver = ((ActorAssignable) port).getActorReference();
		Future<Object> result = executionMaster.sendMessageAndReceiveFuture(receiver, message, timeout);

		try {
			return (boolean) Await.result(result, duration);
		} catch (Exception e) {
			logTimeoutPortActivation(port);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Executes a transition
	 * 
	 * @param transition
	 * @param parameter
	 */
	public void executeTransition(TransitionInstance transition, DataTypeInstance parameter) {
		logTransition(transition);
		ExecuteTransitionMessage message = new ExecuteTransitionMessage(parameter);
		ActorRef receiver = ((ActorAssignable) transition).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
	}

	/**
	 * Executes a transition
	 * 
	 * @param transition
	 */
	public void executeTransition(TransitionInstance transition) {
		executeTransition(transition, null);
	}
	
	/**
	 * Executes a transition. Blocking call.
	 * @param transition
	 * @param parameter
	 * @return
	 */
	public boolean executeTransitionSync(TransitionInstance transition, DataTypeInstance parameter){
		logTransition(transition);
		ExecuteTransitionMessage message = new ExecuteTransitionMessage(parameter, true);
		ActorRef receiver = ((ActorAssignable) transition).getActorReference();
		Future<Object> result = executionMaster.sendMessageAndReceiveFuture(receiver, message, timeout);
		
		try {
			return (boolean) Await.result(result, duration);
		} catch (Exception e) {
			logTimeoutTransitionActivation(transition);
			e.printStackTrace();
		}
		return false;		
	}
	
	/**
	 * Executes a transition. Blocking call.
	 * @param transition
	 * @return
	 */
	public boolean executeTransitionSync(TransitionInstance transition){
		return executeTransitionSync(transition, null);
	}

	/**
	 * Executes a process step
	 * 
	 * @param processStep
	 */
	public boolean executeProcessStep(ProcessStepInstance processStep) {
		logger.info("executing process step: {}", processStep.getInstanceId());
		ExecuteProcessStepMessage message = new ExecuteProcessStepMessage();
		ActorRef receiver = ((ActorAssignable) processStep).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
		return true;
	}

	/**
	 * Stops the given process
	 * 
	 * @param processStep
	 */
	public void stopProcessStep(ActorAssignable processStep) {
		logger.info("stopping process step: {}", processStep.getActorReference().path());
		ActorRef receiver = processStep.getActorReference();
		executionMaster.sendSimpleMessage(receiver, new StopProcessStepMessage());
	}

	/**
	 * Resumes the given process
	 * 
	 * @param processStep
	 */
	public void resumeProcessStep(ActorAssignable processStep) {
		logger.info("resume process step: {}", processStep.getActorReference().path());
		ActorRef receiver = processStep.getActorReference();
		executionMaster.sendSimpleMessage(receiver, new ResumeProcessStepMessage());
	}

	/**
	 * Kills the given process
	 * 
	 * @param processStep
	 */
	public void killProcessStep(ActorAssignable processStep) {
		logger.info("kill process step: {}", processStep.getActorReference().path());
		ActorRef receiver = processStep.getActorReference();
		executionMaster.sendSimpleMessage(receiver, new KillProcessStepMessage());
		//TODO to kill or to stop a process step by the hard way, simply the actors for the
		// process have to be destroyed in the actorsystem
	}

	/**
	 * Pauses the given process
	 * 
	 * @param processStep
	 */
	public void pauseProcessStep(ActorAssignable processStep) {
		logger.info("pause process step: {}", processStep.getActorReference().path());
		ActorRef receiver = processStep.getActorReference();
		executionMaster.sendSimpleMessage(receiver, new PauseProcessStepMessage());
	}

	/**
	 * Creates an actor in the context from a parent actor. The created actor
	 * will become the parents child-actor
	 * 
	 * @param endPort
	 * @param parent
	 * @return
	 */
	public ActorRef createActorForEndPortSync(PortInstance endPort, ActorRef parent) {
		logger.info("create actor for endport: {}", endPort.getInstanceId());
		Creator<UntypedActor> factory = new EndPortActorFactory(endPort);
		CreateChildActorMessage message = new CreateChildActorMessage(factory,
				endPort.getInstanceId());
		return executionMaster.createChildActor(parent, message);
	}

	/**
	 * Creates an actor in the context from a parent actor. The created actor
	 * will become the parents child-actor
	 * 
	 * @param processStepInstance
	 * @param parent
	 * @return
	 */
	public ActorRef createActorForProcessSync(ProcessStepInstanceImplCustom processStepInstance,
			ActorRef parent) {
		logger.info("create actor for process: {}", processStepInstance.getInstanceId());
		Creator<UntypedActor> factory = new ProcessStepActorFactory(processStepInstance);
		CreateChildActorMessage message = new CreateChildActorMessage(factory,
				processStepInstance.getInstanceId());
		return executionMaster.createChildActor(parent, message);
	}

	/**
	 * Creates an actor in the context from a parent actor. The created actor
	 * will become the parents child-actor
	 * 
	 * @param portInstance
	 * @param parent
	 * @return
	 */
	public ActorRef createActorForStartControlPortSync(StartControlPortInstance portInstance,
			ActorRef parent) {
		logger.info("create actor for startcontrolport: {}", portInstance.getInstanceId());
		Creator<UntypedActor> factory = new StartControlPortActorFactory(portInstance);
		CreateChildActorMessage message = new CreateChildActorMessage(factory,
				portInstance.getInstanceId());
		return executionMaster.createChildActor(parent, message);
	}

	/**
	 * Creates an actor in the context from a parent actor. The created actor
	 * will become the parents child-actor
	 * 
	 * @param portInstance
	 * @param parent
	 * @return
	 */
	public ActorRef createActorForStartDataPortSync(StartDataPortInstance portInstance,
			ActorRef parent) {
		logger.info("create actor for startdataport: {}", portInstance.getInstanceId());
		Creator<UntypedActor> factory = new StartDataPortActorFactory(portInstance);
		CreateChildActorMessage message = new CreateChildActorMessage(factory,
				portInstance.getInstanceId());
		return executionMaster.createChildActor(parent, message);
	}

	/**
	 * Creates an actor in the context from a parent actor. The created actor
	 * will become the parents child-actor
	 * 
	 * @param instance
	 * @param parent
	 * @return
	 */
	public ActorRef createActorForTransitionSync(TransitionInstance instance, ActorRef parent) {
		logger.info("create actor for transition: {}", instance.getInstanceId());
		Creator<UntypedActor> factory = new TransitionActorFactory(instance);
		CreateChildActorMessage message = new CreateChildActorMessage(factory,	instance.getInstanceId());
		return executionMaster.createChildActor(parent, message);
	}

	/**
	 * Informs a listener, that a process has finished executing
	 * 
	 * @param listener
	 * @param executedProcess
	 */
	public void processExecuted(ProcessExecutedListener listener,
			ProcessStepInstanceImplCustom executedProcess) {

		// in case, the listener has no actor
		if (!(listener instanceof ActorAssignable))
			listener.processExecuted(executedProcess);
		else
			executionMaster.sendSimpleMessage(((ActorAssignable) listener).getActorReference(),
					new ProcessExecutedMessage(executedProcess));
	}

	/**
	 * Informs the listener, when a process has been succesfully reset.
	 * 
	 * @param listener
	 * @param resetProcess
	 */
	public void processReset(ProcessResetListener listener,
			ProcessStepInstanceImplCustom resetProcess) {
		if (!(listener instanceof ActorAssignable))
			listener.processReset(resetProcess);
		else
			executionMaster.sendSimpleMessage(((ActorAssignable) listener).getActorReference(),
					new ProcessResetMessage(resetProcess));
	}

	/**
	 * This stops the Actorsystem. After the execution of the process, the
	 * Actorsystem should be stopped by the user.
	 * This method blocks, till the actorsystem is down.
	 */
	public void stopActorSystem() {
		logger.debug("stopping the process execution master actor and shutdown process execution system");
		TypedActor.get(processExecutionSystem).stop(executionMaster);
		
		// No doc about deprecation so far :(
		// http://doc.akka.io/japi/akka/2.4.1/akka/actor/ActorSystem.html#shutdown--
		processExecutionSystem.shutdown();
		processExecutionSystem.awaitTermination();
	}

	/**
	 * Deactivate a transition.
	 * 
	 * @param instance
	 */
	public void deactivateTransition(TransitionInstance instance) {
		logger.info("deactivating transition: {}", instance.getInstanceId());
		DeactivateTransitionMessage message = new DeactivateTransitionMessage();
		ActorRef receiver = ((ActorAssignable) instance).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
	}

	/**
	 * Deactivate a process step.
	 * 
	 * @param processStep
	 */
	public void deactivateProcessStep(ProcessStepInstance processStep) {
		logger.info("deactivating process step: {}", processStep.getInstanceId());
		DeactivateProcessStepMessage message = new DeactivateProcessStepMessage();
		ActorRef receiver = ((ActorAssignable) processStep).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
	}
	
	public void escalateProcessStep(ProcessStepInstance processStep){
		logger.info("escalate process step {}", processStep.getInstanceId());
		EscalateProcessStepMessage message = new EscalateProcessStepMessage();
		ActorRef receiver = ((ActorAssignable) processStep).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
	}

	/**
	 * Deactivate a port.
	 * 
	 * @param port
	 */
	public void deactivatePort(PortInstance port) {
		logger.info("deactivating port: {}", port.getPortType().getName());
		DeactivatePortMessage message = new DeactivatePortMessage();
		ActorRef receiver = ((ActorAssignable) port).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
	}

	/**
	 * Reset a processstep.
	 * 
	 * @param process
	 */
	public void resetProcess(ProcessStepInstance process) {
		logger.info("reset process step: {}", process.getInstanceId());
		ResetProcessMessage message = new ResetProcessMessage();
		ActorRef receiver = ((ActorAssignable) process).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
	}

	/**
	 * Changes the execution state of a port.
	 * 
	 * @param port
	 * @param newExecutionstate
	 */
	public void changePortExecutionState(PortInstance port, State newExecutionstate) {
		logger.info("change port execution state: {}", port.getPortType().getName());
		ChangePortExecutionStateMessage message = new ChangePortExecutionStateMessage(
				newExecutionstate);
		ActorRef receiver = ((ActorAssignable) port).getActorReference();
		executionMaster.sendSimpleMessage(receiver, message);
	}

	/**
	 * Informs a listener, when the execution state of a port has changed.
	 * 
	 * @param listener
	 * @param port
	 */
	public void portExecutionStateChanged(PortExecutionStateChangedListener listener,
			PortInstance port) {
		if (!(listener instanceof ActorAssignable))
			listener.portExecutionStateChanged(port);
		else
			executionMaster.sendSimpleMessage(((ActorAssignable) listener).getActorReference(),
					new PortExecutionStateChangedMessage(port));
	}

	/**
	 * Sets the DataTypeInstance of a DataPortInstance. Blocking Call.
	 * 
	 * @param port
	 * @param dataTypeInstance
	 * @return
	 */
	public boolean setPortDataTypeInstanceSync(DataPortInstance port,
			DataTypeInstance dataTypeInstance) {
		ActorRef receiver = ((ActorAssignable) port).getActorReference();
		SetPortDataTypeInstanceMessage message = new SetPortDataTypeInstanceMessage(
				dataTypeInstance);
		Timeout timeout = new Timeout(Duration.create(DEFAULT_TIMEOUT, TimeUnit.SECONDS));
		Future<Object> result = executionMaster.sendMessageAndReceiveFuture(receiver, message, timeout);
		
		try {
			return (boolean) Await.result(result, timeout.duration());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Stops the Actor Systems and assigns a new process execution master an sets up a new ActorSystem.
	 * This can be helpful for unit tests.
	 */
	public void reset(){
		stopActorSystem();
		logger.debug("reset actor system");
		processExecutionSystem = ActorSystem.create(EXECUTION_SYSTEM_NAME);
		executionMaster = ProcessExecutionMasterActor.create(processExecutionSystem, EXECUTION_MASTER_NAME);
	}
	
	private void logTimeoutPortActivation(PortInstance port){
		logger.error("timeout while receiving future: {}.{}", 
				port.getProcessStepInstance().getProcessStepType().getName() ,port.getName());		
	}
	
	private void logTransition(TransitionInstance transition){
		String source = transition.getSourcePortInstance().getName();
		String target = transition.getTargetPortInstance().getName();
		logger.info("execute transition: {} --> {}", source, target);
	}
	
	private void logTimeoutTransitionActivation(TransitionInstance transition){
		String source = transition.getSourcePortInstance().getName();
		String target = transition.getTargetPortInstance().getName();
		logger.error("timeout while receiving future: {} --> {}", source, target);	
	}
}
