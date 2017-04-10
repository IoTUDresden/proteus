package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.Date;
import java.util.List;

import akka.actor.ActorRef;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.EscalationPort;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofiainstance.EndPortInstance;
import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.states.PortExecutionStateChangedListener;
import eu.vicci.process.model.sofiainstance.states.PortExecutionStateListenable;
import eu.vicci.process.model.sofiainstance.states.ProcessExecutedListener;
import eu.vicci.process.model.sofiainstance.states.ProcessResetListener;
import eu.vicci.process.model.sofiainstance.util.CheckStateTask;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class ProcessStepInstanceImplCustom extends ProcessStepInstanceImplCustomBase implements
		ProcessExecutedListener, ProcessResetListener, PortExecutionStateChangedListener {

	@Override
	public void work() {
	}

	@Override
	public void onDeploy(MappingUtil mapper, ActorRef parent) {
		actorReference = LifeCycleManager.INSTANCE.createActorForProcessSync(this, parent);
		deploySubsteps(mapper);
		deployPorts(mapper);
		addListenerToSubsteps();
		addListenerToEndPorts();
	}

	@Override
	public boolean onExecute() {
		logInfo("-------------> execution started");
		cancelTimer();
		aggregateStartParameter();
		aggregateEndParameter();
		startSubProcesses();
		startStateTimerIfNeeded();

		work();

		if (allSubstepsHasFinishedExecution())
			doingEndoperations();

		return true;
	}

	@Override
	public void onKill() {
	}

	@Override
	public void onResume() {
	}

	@Override
	public void onStop() {
	}

	@Override
	public void onPause() {
	}

	@Override
	public void onEscalate() {
		if (stateTimer == null)
			return;
		stateTimer.cancel();
		logInfo("-------------> escalation started");
		deactivateAllEndports(false);
		activateEscalationPort();	
	}
	
	@Override
	public void postEscalated() {		
		logInfo("------------>>> Escalated <<<--------------");
		if(processExecutedListeners.isEmpty())
			LOGGER.error("no executed listeners are set");
		for (ProcessExecutedListener listener : processExecutedListeners)
			LifeCycleManager.INSTANCE.processExecuted(listener, this);
	}

	@Override
	public void postExecuted() {
		logInfo("------------>>> Executed <<<--------------");
		if(processExecutedListeners.isEmpty())
			LOGGER.error("no executed listeners are set");
		for (ProcessExecutedListener listener : processExecutedListeners)
			LifeCycleManager.INSTANCE.processExecuted(listener, this);
	}

	@Override
	public void preReset() {
		setAllPortsToInactive();
		resetAllSubsteps();		
	}
	
	@Override
	public void postReset() {
		logInfo("------------>>> Reset <<<--------------");
		if(processResetListener.isEmpty())
			LOGGER.error("no reset listeners are set");
		for(ProcessResetListener listener : processResetListener)
			LifeCycleManager.INSTANCE.processReset(listener, this);
	}

	//ProcessExecutedListener Implementation
	@Override
	public void processExecuted(ProcessStepInstanceImplCustom process) {
		currentState.processExecuted(process);
	}
	
	//ProcessResetListener Implementation
	@Override
	public void processReset(ProcessStepInstanceImplCustom process) {
		currentState.processReset(process);
	}
	
	//PortExecutionStateChangedListener Implementation
	@Override
	public void portExecutionStateChanged(PortInstance port) {
		currentState.portExecutionStateChanged(port);		
	}

	@Override
	public void postDeactivated() {
		logInfo("------------>>> Deactivated <<<--------------");
		if(processExecutedListeners.isEmpty())
			LOGGER.error("no executed listeners are set");
		for (ProcessExecutedListener listener : processExecutedListeners)
			LifeCycleManager.INSTANCE.processExecuted(listener, this);
	}
	
	@Override
	public void preDeactivated() {
		deactivateAllEndports();
		deactivateAllSubsteps();
	}

	@Override
	public void doingEndoperations() {
		stateTimer.cancel();
		activateControlEndPorts();
		activateDataEndPorts();
		deactivateEscalationPorts();
	}
	
	private void deactivateEscalationPorts(){
		ports.stream().filter(port -> port instanceof EscalationPortInstanceImplCustom)
		.forEach(port -> LifeCycleManager.INSTANCE.deactivatePort(port));		
	}
	
	protected void setAllPortsToInactive() {
		for(PortInstance port : getPorts())
			LifeCycleManager.INSTANCE.changePortExecutionState(port, State.INACTIVE);
	}

	protected void resetAllSubsteps() {
		for(ProcessStepInstance process : getSubSteps())
			LifeCycleManager.INSTANCE.resetProcess(process);		
	}

	private void deploySubsteps(MappingUtil mapper) {
		if (getProcessStepType() instanceof CompositeStep) {
			CompositeStep sofiaModelCompositeStep = (CompositeStep) getProcessStepType();
			List<ProcessStep> steps = sofiaModelCompositeStep.getSubSteps();
			ProcessStepInstanceImplCustomBase instance = null;
			for (ProcessStep step : steps) {
				instance = (ProcessStepInstanceImplCustomBase) mapper.mapProcessStep(step);
				instance.deploy(mapper, actorReference);
				getSubSteps().add(instance);
			}
		}
	}

	protected void startStateTimerIfNeeded() {
		long escalationTimeMins;
		long escalationTime = 0;
		long timeOut;
		boolean escalationAvailable = false;

		for (PortInstance piend : this.getPorts())
			if (piend instanceof EscalationPortInstance) {
				escalationAvailable = true;
				EscalationPort ep = (EscalationPort) piend.getPortType();
				escalationTimeMins = ep.getEscalationTime();
				escalationTime = escalationTimeMins * 1000;
			}

		if (!escalationAvailable)
			return;

		long currentTime = System.currentTimeMillis();
		timeOut = currentTime + escalationTime;
		CheckStateTask cst = new CheckStateTask();
		cst.setProcessStepInstance(this);
		cst.setTimeOut(timeOut);
		cst.setInterruptedThread(Thread.currentThread());
		Date time = new Date(timeOut);
		stateTimer.schedule(cst, time);
	}

	private void deployPorts(MappingUtil mapper) {
		boolean isMapped = false;
		for (Port p : getProcessStepType().getPorts()) {
			isMapped = false;
			for (PortInstance instance : getPorts())
				if (instance.getPortType().getId().equals(p.getId()))
					isMapped = true;

			if (!isMapped) {
				PortInstance portInstance = mapper.mapPort(p);
				getPorts().add(portInstance);
				((ActorAssignable) portInstance).deploy(mapper, actorReference);
			}
		}
	}

	private void addListenerToSubsteps() {
		ProcessStepInstanceImplCustomBase step;
		for (ProcessStepInstance instance : getSubSteps()){
			step = (ProcessStepInstanceImplCustomBase) instance;
			step.addProcessExecutedListener(this);
			step.addProcessResetListener(this);
		}
	}
	
	private void addListenerToEndPorts(){
		getPorts()
		.stream()
		.filter(port -> port instanceof PortExecutionStateListenable)
		.forEach(
				port -> ((PortExecutionStateListenable) port)
						.addPortExecutionStateChangedListener(this));		
	}

	private void deactivateAllEndports() {
		deactivateAllEndports(true);
	}
	
	private void deactivateAllEndports(boolean deactivateEscalationPort) {
		getPorts().stream().filter(port -> port instanceof EndPortInstance && !(port instanceof EscalationPortInstance))
				.forEach(port -> LifeCycleManager.INSTANCE.deactivatePort(port));
	}

	private void deactivateAllSubsteps() {
		getPorts().stream().filter(port -> port instanceof StartPortInstance)
				.forEach(port -> ((StartPortInstance) port).deactivateSubSteps());
	}
}
