package eu.vicci.process.graphiti.execution.debug.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.graphiti.execution.debug.dispatcher.EventDispatchJob;
import eu.vicci.process.graphiti.execution.debug.dispatcher.IEventProcessor;
import eu.vicci.process.graphiti.execution.debug.events.DebuggerStartedEvent;
import eu.vicci.process.graphiti.execution.debug.events.IDebugEvent;
import eu.vicci.process.graphiti.execution.debug.events.ResumeEvent;
import eu.vicci.process.graphiti.execution.debug.events.StateChangedEvent;
import eu.vicci.process.graphiti.execution.debug.events.TerminateEvent;
import eu.vicci.process.graphiti.execution.debug.events.TerminatedEvent;
import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessVariable;
import eu.vicci.process.graphiti.execution.debug.model.variables.PortListVariable;
import eu.vicci.process.graphiti.execution.debug.model.variables.PortValue;
import eu.vicci.process.graphiti.execution.debug.model.variables.PortVariable;
import eu.vicci.process.graphiti.execution.debug.model.variables.StateVariable;
import eu.vicci.process.graphiti.execution.debug.model.variables.StringVariable;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

/**
 * Debug target for vicci processes. Example taken from
 * <a href= "http://codeandme.blogspot.de/2013/11/debugger-3-tale-of-debuggers-processes.html" >
 * codeandme.blogspot.de </a>
 * 
 */
public class ProcessDebugTarget extends DebugElement implements IDebugTarget, IEventProcessor {
	private static final Logger logger = LoggerFactory.getLogger(ProcessDebugTarget.class);
	private final String name;

	private final ILaunch launch;
	private final IFile file;
	private final ProcessDebugProcess process;
	private final String instanceId;

	private final List<ProcessThread> threads = new ArrayList<>();

	private EventDispatchJob dispatcher;

	private DebugTargetState state = DebugTargetState.NOT_STARTED;

	private enum DebugTargetState {
		NOT_STARTED, SUSPENDED, RESUMED, TERMINATED, DISCONNECTED
	};

	public ProcessDebugTarget(final ILaunch launch, IFile file, String instanceId) {
		super(null);
		this.launch = launch;
		this.file = file;
		this.instanceId = instanceId;
		
		if(instanceId == null)
			throw new IllegalArgumentException("the instanceId cant be null for this debug target");
		
		name = file.getName();

		fireCreationEvent();

		process = new ProcessDebugProcess(this);
		process.fireCreationEvent();
	}

	@Override
	public String getModelIdentifier() {
		return null;
	}

	@Override
	public boolean canTerminate() {
		return !isTerminated() && !isDisconnected();
	}

	@Override
	public boolean isTerminated() {
		return state == DebugTargetState.TERMINATED;
	}

	@Override
	public void terminate() throws DebugException {
		fireModelEvent(new TerminateEvent());
	}

	@Override
	public boolean canResume() {
		return isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return false;
	}

	@Override
	public boolean isSuspended() {
		return state == DebugTargetState.SUSPENDED;
	}

	@Override
	public void resume() throws DebugException {
		fireModelEvent(new ResumeEvent());
	}

	@Override
	public void suspend() throws DebugException {
		throw new DebugException(
				new Status(IStatus.ERROR, "eu.vicci.process.execution.debug", "suspend() not supported"));
	}

	@Override
	public void breakpointAdded(IBreakpoint breakpoint) {
	}

	@Override
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	@Override
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	@Override
	public boolean canDisconnect() {
		return false;
	}

	@Override
	public void disconnect() throws DebugException {
		throw new DebugException(
				new Status(IStatus.ERROR, "eu.vicci.process.execution.debug", "disconnect() not supported"));
	}

	@Override
	public boolean isDisconnected() {
		return false;
	}

	@Override
	public boolean supportsStorageRetrieval() {
		return false;
	}

	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

	public IFile getFile() {
		return file;
	}

	@Override
	public IProcess getProcess() {
		return process;
	}

	@Override
	public ProcessThread[] getThreads() throws DebugException {
		return threads.toArray(new ProcessThread[threads.size()]);
	}

	@Override
	public boolean hasThreads() throws DebugException {
		return !threads.isEmpty();
	}

	@Override
	public String getName() throws DebugException {
		return name;
	}

	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return instanceId.equals(breakpoint.getModelIdentifier());
	}

	@Override
	public void handleEvent(IDebugEvent event) {
		if (event instanceof StateChangedEvent)
			handleStateChanged((StateChangedEvent)event);
		else if (event instanceof TerminatedEvent)
			handleTerminated();
		else if (event instanceof DebuggerStartedEvent)
			handleStartedEvent((DebuggerStartedEvent)event);
	}

	@Override
	public ProcessDebugTarget getDebugTarget() {
		return this;
	}

	@Override
	public ILaunch getLaunch() {
		return launch;
	}

	public void setEventDispatcher(final EventDispatchJob dispatcher) {
		this.dispatcher = dispatcher;
	}
	
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * Pass an event to the {@link EventDispatchJob} where it is handled asynchronously.
	 * 
	 * @param event
	 *            event to handle
	 */
	private void fireModelEvent(final IDebugEvent event) {
		dispatcher.addEvent(event);
	}
	
	private void handleStartedEvent(DebuggerStartedEvent event){
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
	}

	private void handleStateChanged(StateChangedEvent event) {		
		try {
			String id = event.getMessage().getProcessId();
			String name = event.getMessage().getProcessName();

			ProcessThread t = addThreadIfNotExists(id, name);
			if (t == null)
				return;
			List<AbstractProcessVariable> tmpVars = createVarsFromStateChangedMessage(event.getMessage());
			t.getTopStackFrame().addVariables(tmpVars);
			
		} catch (DebugException e) {
			logger.error("cant handle StateChangeMessage");
			e.printStackTrace();
		}
	}

	private ProcessThread addThreadIfNotExists(String id, String name) {
		ProcessThread t = new ProcessThread(this, id, name);
		if (!threads.contains(t)) {
			threads.add(t);
			t.fireCreationEvent();
			return t;
		}
		return getThreadById(id);
	}

	private ProcessThread getThreadById(String id) {
		Optional<ProcessThread> thread = threads.stream().filter(t -> t.getVicciProcessId().equals(id)).findFirst();
		if (thread.isPresent())
			return thread.get();
		return null;
	}

	private void handleTerminated() {
		state = DebugTargetState.TERMINATED;
		dispatcher.terminate();

		// inform eclipse of terminated state
		fireTerminateEvent();
	}

	/**
	 * Creates all Variables from the IStateMessage.
	 * 
	 * @param message
	 * @return
	 */
	private List<AbstractProcessVariable> createVarsFromStateChangedMessage(IStateChangeMessage message)
			throws DebugException {
		List<AbstractProcessVariable> tmpVars = new ArrayList<AbstractProcessVariable>();
		addStateVariable(tmpVars, message);
		addEndDataPorts(tmpVars, message);
		addStartDataPorts(tmpVars, message);

		addStartControlPorts(tmpVars, message);
		addEndControlPorts(tmpVars, message);
		return tmpVars;
	}

	private void addStartControlPorts(List<AbstractProcessVariable> vars, IStateChangeMessage message)
			throws DebugException {
		if (!message.getStartControlPorts().isEmpty())
			addControlPortsList(vars, message.getStartControlPorts(), "startControlPorts");
	}

	private void addEndControlPorts(List<AbstractProcessVariable> vars, IStateChangeMessage message)
			throws DebugException {
		if (!message.getEndControlPorts().isEmpty())
			addControlPortsList(vars, message.getEndControlPorts(), "endControlPorts");
	}

	private void addStartDataPorts(List<AbstractProcessVariable> vars, IStateChangeMessage message)
			throws DebugException {
		if (!message.getStartDataPorts().isEmpty())
			addDataPortList(vars, message.getStartDataPorts(), "startDataPorts");
	}

	private void addEndDataPorts(List<AbstractProcessVariable> vars, IStateChangeMessage message)
			throws DebugException {
		if (!message.getEndDataPorts().isEmpty())
			addDataPortList(vars, message.getEndDataPorts(), "endDataPorts");
	}

	private void addDataPortList(List<AbstractProcessVariable> vars, Map<String, IJSONDataPortInstance> ports, String name)
			throws DebugException {
		PortListVariable portsList = new PortListVariable(this, name);

		for (Entry<String, IJSONDataPortInstance> port : ports.entrySet()) {
			PortVariable portVar = new PortVariable(this, port.getValue().getName());
			
			StringVariable id = new StringVariable(this, "id");
			id.setValue(port.getKey());

			StateVariable state = new StateVariable(this, "state");
			state.setValue(port.getValue().getExecutionState().toString());
			
			portVar.getValue().addVariable(id);
			portVar.getValue().addVariable(state);

			addDataTypeInfos(portVar.getValue(), port.getValue());

			portsList.getValue().addVariable(portVar);
		}
		vars.add(portsList);
	}

	private void addControlPortsList(List<AbstractProcessVariable> vars, Map<String, IJSONPortInstance> ports, String name)
			throws DebugException {
		PortListVariable portsList = new PortListVariable(this, name);

		for (Entry<String, IJSONPortInstance> port : ports.entrySet()) {
			PortVariable portVar = new PortVariable(this, port.getValue().getName());

			StringVariable id = new StringVariable(this, "id");
			id.setValue(port.getKey());
			
			StateVariable state = new StateVariable(this, "state");
			state.setValue(port.getValue().getExecutionState().toString());

			portVar.getValue().addVariable(id);
			portVar.getValue().addVariable(state);
			portsList.getValue().addVariable(portVar);
		}
		vars.add(portsList);
	}

	private void addDataTypeInfos(PortValue portValue, IJSONDataPortInstance dto) throws DebugException {
		StringVariable tmpStringVar = new StringVariable(this, "TypeInstanceName");
		tmpStringVar.setValue(dto.getDataTypeInstance().getName());
		portValue.addVariable(tmpStringVar);

		tmpStringVar = new StringVariable(this, "value");
		tmpStringVar.setValue(dto.getDataTypeInstance().getValueString());
		portValue.addVariable(tmpStringVar);
	}

	private void addStateVariable(List<AbstractProcessVariable> vars, IStateChangeMessage message) {
		StateVariable processState = new StateVariable(this, "state");
		processState.setValue(message.getState().toString());
		vars.add(processState);
	}

}
