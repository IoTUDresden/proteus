package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.model.sofia.impl.DataPortImpl;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.impl.EndDataPortInstanceImpl;
import eu.vicci.process.model.sofiainstance.states.PortExecutionStateChangedListener;
import eu.vicci.process.model.sofiainstance.states.PortExecutionStateListenable;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.sofiainstance.util.PortUtil;

public class EndDataPortInstanceImplCustom extends EndDataPortInstanceImpl implements
		ActorAssignable, PortExecutionStateListenable {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());
	private final List<PortExecutionStateChangedListener> listeners = new ArrayList<>();
	private ActorRef actorReference = null;
	
	protected volatile State executionState = State.INACTIVE;

	@Override
	public void deploy(MappingUtil mapper) {
		deploy(mapper, null);
	}

	@Override
	public void deploy(MappingUtil mapper, ActorRef parent) {
		actorReference = LifeCycleManager.INSTANCE.createActorForEndPortSync(this, parent);
		// General port deployment
		PortUtil.deploy(this, mapper, actorReference);

		// Specific StartDataPort deployment
		// Set the right DataTypeInstance by mapping from DataType to
		// DataTypeInstance
		DataPortImpl dataPort = (DataPortImpl) this.getPortType();
		if (dataPort.getPortDatatype() != null)
			this.dataInstance = mapper.mapDataType(dataPort.getPortDatatype());

		// In case that a default value for that port was set during modeling,
		String presetValue = dataPort.getValue();
		if (presetValue != null && !presetValue.isEmpty())
			dataInstance.parse(presetValue);
	}

	@Override
	public boolean activate(DataTypeInstance parameter) {
		switch (executionState) {
		case INACTIVE:
			return performActivate(parameter);
		case WAITING:
			setParameterAsDataInstance(parameter);
			return true;
		default:
			return true;
		}
	}

	/**
	 * Deactivates this port and all outgoing transitions.
	 */
	@Override
	public void deactivate() {
		if (executionState == State.ACTIVE || executionState == State.DEACTIVATED)
			return;
		setExecutionState(State.DEACTIVATED);
		LOGGER.debug("{}.deactivate()", getPortType().getName());
		setInstanceId("EndDataPort " + getPortType().getName() + "_instance_" + getInstancenumber());

		for (TransitionInstance t : getOutTransitionInstances())
			LifeCycleManager.INSTANCE.deactivateTransition(t);
	}

	/**
	 * Sets the process-relevant data of this port.
	 * 
	 * @param the
	 *            data
	 */
	@Override
	public void setDataInstance(DataTypeInstance newDataInstance) {
		this.dataInstance = newDataInstance;
	}

	/**
	 * Provides the process-relevant data of this port.
	 * 
	 * @return the data.
	 */
	@Override
	public DataTypeInstance getDataInstance() {
		return dataInstance;
	}

	@Override
	public ActorRef getActorReference() {
		return actorReference;
	}	

	@Override
	public void addPortExecutionStateChangedListener(PortExecutionStateChangedListener listener) {
		listeners.add(listener);		
	}
	
	@Override
	public void setExecutionState(State newExecutionState) {
		executionState = newExecutionState;
		informListeners();		
	}
	
	@Override
	public State getExecutionState() {
		return executionState;
	}
	
	private boolean performActivate(DataTypeInstance parameter) {
		setParameterAsDataInstance(parameter);
		LOGGER.debug("{}.activate()", getPortType().getName());
		setInstanceId("EndDataPort " + getPortType().getName() + "_instance_" + getInstancenumber());

		for (TransitionInstance t : getOutTransitionInstances())
			LifeCycleManager.INSTANCE.executeTransitionSync(t, dataInstance.copy());
		setExecutionState(State.ACTIVE);
		return true;
	}
	
	private void setParameterAsDataInstance(DataTypeInstance parameter){
		if (parameter != null)
			dataInstance = parameter;		
	}
	
	private void informListeners(){
		for (PortExecutionStateChangedListener listener : listeners)
			LifeCycleManager.INSTANCE.portExecutionStateChanged(listener, this);		
	}
}
