package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.distribution.manager.DistributionManager;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.Configuration;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EndPortInstance;
import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartControlPortInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.StartPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl;
import eu.vicci.process.model.sofiainstance.states.ProcessExecutedListener;
import eu.vicci.process.model.sofiainstance.states.ProcessResetListener;
import eu.vicci.process.model.sofiainstance.states.StateBase;
import eu.vicci.process.model.sofiainstance.states.StateChangable;
import eu.vicci.process.model.sofiainstance.states.UndeployedState;
import eu.vicci.process.model.sofiainstance.util.CompensationWorker;
import eu.vicci.process.model.sofiainstance.util.InternalProcessStepInterface;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.sofiainstance.util.ProcessStepTimerTask;
import eu.vicci.process.model.util.logging.LoggingManager;
import eu.vicci.process.model.util.messages.MessageQueue;
import eu.vicci.process.model.util.messages.StateChangeMessage;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

public abstract class ProcessStepInstanceImplCustomBase extends ProcessStepInstanceImpl
		implements InternalProcessStepInterface, StateChangable, ActorAssignable {

	protected final Logger LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());
	protected List<DataTypeInstance> startParameter = new ArrayList<DataTypeInstance>();
	protected List<DataTypeInstance> endParameter = new ArrayList<DataTypeInstance>();
	protected List<DataTypeInstance> returnValues = new ArrayList<DataTypeInstance>();
	protected List<ProcessExecutedListener> processExecutedListeners = new ArrayList<>();
	protected List<ProcessResetListener> processResetListener = new ArrayList<>();
	protected volatile StateBase currentState;
	protected Timer timer;
	protected ProcessStepTimerTask timerTask;
	protected Timer stateTimer = new Timer();
	protected ActorRef actorReference;
	protected volatile State executionState;

	protected MessageQueue messageQueue;
	protected IProcessManager processManager;
	
	/**
	 * indicates if this process is executing on a peer
	 */
	protected final boolean runsOnPeer;
	
	/**
	 * the peerId if this is not running on a SuperPeer
	 */
	protected final String peerId;

	public ProcessStepInstanceImplCustomBase() {
		currentState = new UndeployedState(this);
		executionState = currentState.getSimpleState();
		delay = 0;
		peerId = DistributionManager.getInstance().getPeerId();
		runsOnPeer = !DistributionManager.getInstance().isSuperPeer();
	}

	@Override
	public void setCurrentState(StateBase currentState) {
		if (currentState == null)
			throw new IllegalArgumentException("the state can´t be null");
		if (this.currentState.getSimpleState() == currentState.getSimpleState())
			return;
		this.currentState = currentState;
		changeExecutionState(currentState.getSimpleState());
	}

	/**
	 * Pausing the execution of the process.
	 * 
	 * This method provides an explicit way to pause the execution of the process instance.
	 */
	@Override
	public final void pause() {
		currentState.pause();
	}

	@Override
	public final void resume() {
		currentState.resume();
	}

	/**
	 * Stopping the execution of the process.
	 * 
	 * This method provides an explicit way to stop the execution of the process instance.
	 */
	@Override
	public final void stop() {
		currentState.stop();
	}

	@Override
	public final boolean execute() {
		logInfo(getExecutionState().toString() + " permission: " + getPermission());
		return currentState.execute();
	}

	@Override
	public final void kill() {
		currentState.kill();
	}

	/**
	 * Reset the ProcessStep. Reset only, if the previous state was 'Executed'
	 */
	public final void reset() {
		currentState.reset();
	}

	/**
	 * Checks if the Execution of this process is finished. The process is finished if its state is
	 * stopped/failed/killed/executed
	 * 
	 * @return true - if finished
	 */
	public final boolean hasFinishedExecution() {
		return currentState.hasFinishedExecution();
	}

	@Override
	public final synchronized void deploy(MappingUtil mapper) {
		currentState.deploy(mapper, null);
	}

	/**
	 * Deployment for the actor based process execution
	 * 
	 * @param mapper
	 * @param parent
	 *            - parent actor for this process step
	 */
	public final synchronized void deploy(MappingUtil mapper, ActorRef parent) {
		currentState.deploy(mapper, parent);
	}

	@Override
	public Timer getTimer() {
		return timer;
	}

	@Override
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	@Override
	public ProcessStepTimerTask getTimerTask() {
		return timerTask;
	}

	@Override
	public void setTimerTask(ProcessStepTimerTask timerTask) {
		this.timerTask = timerTask;
	}

	@Override
	public List<DataTypeInstance> getStartParameter() {
		return startParameter;
	}

	@Override
	public void setStartParameter(List<DataTypeInstance> startParameter) {
		this.startParameter = startParameter;
	}

	public List<DataTypeInstance> getEndParameter() {
		return endParameter;
	}

	public void setEndParameter(List<DataTypeInstance> endParameter) {
		this.endParameter = endParameter;
	}

	@Override
	public List<DataTypeInstance> getReturnValues() {
		return returnValues;
	}

	@Override
	public void setReturnValues(List<DataTypeInstance> returnValues) {
		this.returnValues = returnValues;
	}

	@Override
	public ActorRef getActorReference() {
		return actorReference;
	}

	/**
	 * Sets the {@link MessageQueue} which handles the {@link IStateChangeMessage} which is send
	 * afer each state change.
	 * 
	 * @param messageQueue
	 */
	public void setMessageQueue(MessageQueue messageQueue) {
		this.messageQueue = messageQueue;
	}

	/**
	 * Sets the {@link IProcessManager}.
	 * 
	 * @param processManager
	 */
	public void setProcessManager(IProcessManager processManager) {
		this.processManager = processManager;
	}

	/**
	 * Writes a info to the log. The log contains process step name and the simple class name of
	 * this process step.
	 * 
	 * @param info
	 */
	public void logInfo(String info) {
		LOGGER.info("{}: {}", getProcessStepType().getName(), info);
	}

	public void logInfo(String info, Object... objects) {
		LOGGER.info(info, objects);
	}

	/**
	 * Checks if the AND aspect of the ProcessStep is full filled, meaning whether all in going
	 * Ports are activated. Please note that there might be ports that are not necessary for
	 * execution. These are marked with an optional flag and are considered in the AND-aspect
	 * decision.
	 * 
	 * @return True if all StartPorts are activated. False if one or more StartPorts are not
	 *         activated.
	 */
	public boolean allStartPortsActive() {
		return !getPorts().stream().filter(port -> port instanceof StartPortInstance)
				.anyMatch(port -> port.getExecutionState() != State.ACTIVE && !port.getPortType().isOptional());
	}

	/**
	 * Checks if there is any startport which is required but is deactivated.
	 * 
	 * @return true - if there is a match
	 */
	public boolean hasAnyDeactivatedAndRequiredStartPort() {
		return getPorts().stream().filter(port -> port instanceof StartPortInstance)
				.anyMatch(port -> port.getExecutionState() == State.DEACTIVATED && !port.getPortType().isOptional());
	}

	/**
	 * Adds an Listener to this ProcessStep. The listeners will be informed, when the processStep
	 * was executed.
	 * 
	 * @param listener
	 */
	public void addProcessExecutedListener(ProcessExecutedListener listener) {
		processExecutedListeners.add(listener);
	}

	/**
	 * Adds an Listener to this ProcessStep. The listeners will be informed, when the processStep
	 * was reset.
	 * 
	 * @param listener
	 */
	public void addProcessResetListener(ProcessResetListener listener) {
		processResetListener.add(listener);
	}

	/**
	 * Changing execution state.<br>
	 * <br>
	 * This method sets the ExecutionState and can be used to perform standard behavior related to
	 * execution state changes like informing the user interfaces.
	 * 
	 * @param state
	 *            The new ExecutionState
	 */
	public void changeExecutionState(State state) {
		executionState = state;
		StateChangeMessage scm = createStateChangeMessage();
		addSerializedPortsToMessage(scm);
		LoggingManager.getInstance().logStateMessage(scm);
		
		if (messageQueue != null)
			messageQueue.addMessage(scm); // handles the message async
		else
			LOGGER.warn("There is no message Queue set on '{}'.", getProcessStepType().getName());
	}

	@Override
	public State getExecutionState() {
		return currentState.getSimpleState();
	}

	/**
	 * Gets the {@link StateBase} which holds the current state for the state pattern. This can be
	 * used, to save the old state instance.
	 * 
	 * @return
	 */
	public StateBase getCurrentState() {
		return currentState;
	}

	/**
	 * Activating escalation port.
	 */
	public void activateEscalationPort() {
		for (PortInstance port : getPorts()) {
			if (port instanceof EscalationPortInstance)
				LifeCycleManager.INSTANCE.activatePortSync(port);
		}
	}

	/**
	 * Method for escalating a process step, in case of timeout
	 */
	public void escalate() {
		currentState.escalate();		
	}

	/**
	 * Delays the execution for a certain time span. <br>
	 * <br>
	 * The delay used has to be specified by using the method configure(). The standard delay is
	 * specified in the constructor. Using the timer the control flow goes directly back to the
	 * caller. A delay of zero can be used to decouple the control flow but this is neither the
	 * correct way to do so (please use the flag "isDecoupled" in the configuration class) nor is it
	 * recommended due to overhead.
	 * 
	 */
	public void executeDelay() {
		if (getTimer() == null) {
			Timer timer = new Timer();
			ProcessStepTimerTask timerTask = new ProcessStepTimerTask(this);
			timer.schedule(timerTask, getDelay());
			LOGGER.error("Timer scheduled");
		}
	}

	/**
	 * Activating outgoing data ports.<br>
	 * <br>
	 * This method fills all EndDataPorts with their respective information simply by matching the
	 * names of all items of the field 'returnValue' and the names of the data fields of all
	 * EndDataPorts.
	 */
	public void activateDataEndPorts() {
		if (!getReturnValues().isEmpty()) {
			for (PortInstance port : getPorts()) {
				if (port instanceof EndDataPortInstance) {
					DataPortInstance port1 = (DataPortInstance) port;
					for (DataTypeInstance dataInstance : getReturnValues()) {
						// preparing names for matching
						String dataId = dataInstance.getDataTypeType().getId();
						String wantedDataId = port1.getDataInstance().getDataTypeType().getId();
						// matching names
						if (dataId.equals(wantedDataId)) {
							LifeCycleManager.INSTANCE.activatePortSync(port, dataInstance);
						}
					}
				}
			}
		}
	}

	/**
	 * Getting the parameter from StartDataPorts.<br>
	 * <br>
	 * This method aggregates all parameters from all StartDataPorts and provides them by filling
	 * the field StartParameter.
	 */
	public void aggregateStartParameter() {
		startParameter.clear();
		for (PortInstance port : getPorts()) {
			if (port instanceof StartDataPortInstance) {
				DataPortInstance dataPortInstance = (DataPortInstance) port;
				getStartParameter().add(dataPortInstance.getDataInstance());
			}
		}
	}
	
	/**
	 * Getting the parameter from EndDataPorts.<br>
	 * <br>
	 * This method aggregates all parameters from all EndDataPorts and provides them by filling
	 * the field EndParameter.
	 */
	public void aggregateEndParameter() {
		endParameter.clear();
		for (PortInstance port : getPorts()) {
			if (port instanceof EndDataPortInstance) {
				DataPortInstance dataPortInstance = (DataPortInstance) port;
				getEndParameter().add(dataPortInstance.getDataInstance());
			}
		}
	}

	/**
	 * Activating outgoing control ports.
	 */
	public void activateControlEndPorts() {
		for (PortInstance port : getPorts())
			if (port instanceof EndControlPortInstance)
				if (!(port instanceof EscalationPortInstance))
					LifeCycleManager.INSTANCE.activatePortSync(port);
	}

	/**
	 * @deprecated Don´t set the Execution State from the outer. use the
	 *             {@link eu.vicci.process.model.sofiainstance.util.LifeCycleManager} instead to
	 *             execute(), kill(), pause(), etc... a process. The ProcessStepInstance ownes an
	 *             internal state which provides the specific methods, so you have only to call the
	 *             specific methods.
	 */
	@Override
	@Deprecated
	public void setExecutionState(State newExecutionState) {
		switch (newExecutionState) {
		case EXECUTING:
			LifeCycleManager.INSTANCE.executeProcessStep(this);
			break;
		case KILLED:
			LifeCycleManager.INSTANCE.killProcessStep(this);
			break;
		case PAUSED:
			LifeCycleManager.INSTANCE.pauseProcessStep(this);
			break;
		case STOPPED:
			LifeCycleManager.INSTANCE.stopProcessStep(this);
			break;
		default:
			break;
		}
	}

	/**
	 * Telling the StartPorts to execute linked SubProcessSteps.
	 * 
	 */
	public void startSubProcesses() {
		for (PortInstance port : getPorts()) {
			if (port instanceof StartPortInstance) {
				StartPortInstance startPort = (StartPortInstance) port;
				startPort.executeSubSteps();
			}
		}
	}

	/**
	 * Canceling timer to give free resources and to let the application terminate correctly.
	 * 
	 */
	public void cancelTimer() {
		if (getTimer() != null) {
			getTimer().cancel();
		}
	}

	/**
	 * Checks if all Substeps are finished
	 * 
	 * @return
	 */
	public boolean allSubstepsHasFinishedExecution() {
		for (ProcessStepInstance psi : getSubSteps())
			if (!((ProcessStepInstanceImplCustomBase) psi).hasFinishedExecution())
				return false;
		return true;
	}

	public boolean allSubstepsAreReset() {
		if (getSubSteps().size() == 0)
			return true;
		return getSubSteps().stream().allMatch(step -> step.getExecutionState() == State.INACTIVE);
	}

	/**
	 * Setting the a new execution permission. In case that the ProcessStep might be activated but
	 * blocked (for example by the execution permission "execution denied" the ProcessStep will be
	 * activated immediately.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 * @param newPermission
	 *            The new execution permission
	 */
	public void setPermission(ExecutionPermission newPermission) {
		this.permission = newPermission;
		// avoid setting an inactive process to active, only by setting a new
		// permission
		if (getExecutionState() == State.ACTIVE)
			LifeCycleManager.INSTANCE.executeProcessStep(this);
	}

	/**
	 * Setting an new delay. The delay describes how much time the process step waits between
	 * getting an activation that leads to the execution of the process step and the access of the
	 * execution routine. In case that the process step is already in the delay phase setting a new
	 * delay reschedules the the process step. Thus the delay can be shortened or extended.
	 * 
	 * @param inst
	 *            The ProcessStep instance that is delegating the work.
	 * @param newDelay
	 *            The new delay in milliseconds.
	 */
	public void setDelay(long newDelay) {
		// set new delay
		delay = newDelay;
		// if the processStep start is already scheduled, it must be
		// rescheduled
		if (getTimer() != null && getTimerTask() != null) {
			getTimerTask().cancel();
			getTimer().schedule(getTimerTask(), newDelay);
		}
	}

	/**
	 * Forwards a start or execute call in the case that the ProcessStep is in state EXECUTED.<br>
	 * <br>
	 * This method is used to propagate the reactivating start or execute call after the entire
	 * process had been paused or stopped. The ProcessStep itself will not be executed again.
	 */
	public void forwardReactivation() {
		for (PortInstance port : getPorts()) {
			if (port instanceof EndPortInstance)
				LifeCycleManager.INSTANCE.activatePort(port);
		}
	}

	/**
	 * Checks if the processes endports are in the asked state. If there are no endports, true is
	 * returned (EscalationPortInstance won´t checked).
	 * 
	 * @param askedState
	 * @return true - if no endports, or all endports in the asked state
	 */
	public boolean allEndPortsHaveTheState(State askedState) {
		boolean anyEndport = getPorts().stream()
				.anyMatch(p -> p instanceof EndPortInstance && !(p instanceof EscalationPortInstance));

		if (!anyEndport)
			return true;

		return getPorts().stream().filter(p -> p instanceof EndPortInstance && !(p instanceof EscalationPortInstance))
				.allMatch(p -> p.getExecutionState() == askedState);
	}

	public boolean allEndPortsAreDeactivatedOrActivated() {
		boolean anyEndport = getPorts().stream()
				.anyMatch(p -> p instanceof EndPortInstance && !(p instanceof EscalationPortInstance));

		if (!anyEndport)
			return true;

		return getPorts().stream().filter(p -> p instanceof EndPortInstance && !(p instanceof EscalationPortInstance))
				.allMatch(p -> p.getExecutionState() == State.ACTIVE || p.getExecutionState() == State.DEACTIVATED);
	}

	/**
	 * All ending operations, after work() has finished
	 */
	public abstract void doingEndoperations();

	/**
	 * Configuration
	 */
	public String configure(Configuration conf) {
		boolean correctId = false;

		LOGGER.debug("configure step: {}", getProcessStepType().getId());

		if (getProcessStepType().getId().equals(conf.getInstanceId())) {
			configure1(conf);
			correctId = true;

		} else if (conf.getInstanceId() == null) {
			configure1(conf);
		}

		if (getProcessStepType() instanceof CompositeStep && correctId == false) {
			for (ProcessStepInstance inst : getSubSteps()) {
				inst.configure(conf);
			}
		}
		return "";
	}

	/**
	 * Returns the StartPort instances.
	 * 
	 * @return
	 */
	public List<StartPortInstance> getStartPorts() {
		return getPorts().stream().filter(p -> p instanceof StartPortInstance).map(StartPortInstance.class::cast)
				.collect(Collectors.toList());
	}
	
	protected boolean runsCompensation(){
		if(getProcessStepType().getGoal() == null || getProcessStepType().getGoal().trim().isEmpty()) 
			return false;
		return true;
	}
	
	/**
	 * Checks if the given port is used for the compensation. 
	 * Compensating steps should not activated on other procedures than the compensation worker.
	 * 
	 * @param port
	 * @return
	 */
	protected boolean isCompensatingPort(PortInstance port){
		if(!runsCompensation())
			return false;
		if(!(port instanceof DataPortInstance))
			return false;
		DataPortInstance dpi = (DataPortInstance)port;
		DataTypeInstance dti = dpi.getDataInstance();
		if(!(dti instanceof BooleanTypeInstance))
			return false;
		
		return CompensationWorker.HAS_BEEN_FINISHED.equals(dti.getName()) ||
				CompensationWorker.HAS_BEEN_SATISFIED.equals(dti.getName());
				
	}

	private StateChangeMessage createStateChangeMessage() {
		StateChangeMessage scm = new StateChangeMessage();
		if(runsOnPeer)
			scm.setPeerId(peerId);
		scm.setProcessInstanceId(getProcessInstanceID());
		scm.setProcessModelId(getProcessModelID());
		scm.setInstanceId(getInstanceId());
		scm.setModelId(getProcessModelID());
		scm.setState(getExecutionState());
		scm.setProcessId(getProcessStepType().getId());
		scm.setProcessName(getProcessStepType().getName());
		scm.setOriginalProcessInstanceId(getOriginalProcessInstanceId());
		return scm;
	}
	
	/**
	 * gets the instance id of the original process (on the super peer), if this is a remote executing copy.
	 * @return
	 */
	protected String getOriginalProcessInstanceId(){ 
		return null;
	}

	private void addSerializedPortsToMessage(StateChangeMessage message) {
		Map<String, IJSONDataPortInstance> startDataTypes = new HashMap<String, IJSONDataPortInstance>();
		Map<String, IJSONDataPortInstance> endDataTypes = new HashMap<String, IJSONDataPortInstance>();
		Map<String, IJSONPortInstance> startControlPorts = new HashMap<String, IJSONPortInstance>();
		Map<String, IJSONPortInstance> endControlPorts = new HashMap<String, IJSONPortInstance>();

		for (PortInstance pi : getPorts()) {
			if (pi instanceof StartDataPortInstance) {
				JSONDataPortInstance dto = new JSONDataPortInstance((DataPortInstance) pi);
				startDataTypes.put(pi.getPortType().getId(), dto);
			} else if (pi instanceof EndDataPortInstance) {
				JSONDataPortInstance dto = new JSONDataPortInstance((EndDataPortInstance) pi);
				endDataTypes.put(pi.getPortType().getId(), dto);
			} else if (pi instanceof StartControlPortInstance) {
				startControlPorts.put(pi.getPortType().getId(), new JSONPortInstance(pi));
			} else if (pi instanceof EndControlPortInstance) {
				endControlPorts.put(pi.getPortType().getId(), new JSONPortInstance(pi));
			}
		}
		message.setStartDataPorts(startDataTypes);
		message.setEndDataPorts(endDataTypes);
		message.setStartControlPorts(startControlPorts);
		message.setEndControlPorts(endControlPorts);
	}

	private void configure1(Configuration conf) {
		// set delay
		if (conf.getDelay() >= 0) {
			setDelay(conf.getDelay());
		}

		// set permission
		if (conf.getPermission() != null) {
			setPermission(conf.getPermission());
		}
	}
}
