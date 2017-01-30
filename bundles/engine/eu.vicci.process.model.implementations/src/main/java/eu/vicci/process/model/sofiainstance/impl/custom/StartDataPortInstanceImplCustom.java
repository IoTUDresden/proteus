package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.impl.DataPortImpl;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.impl.StartDataPortInstanceImpl;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.sofiainstance.util.PortUtil;

public class StartDataPortInstanceImplCustom extends StartDataPortInstanceImpl implements ActorAssignable {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());
	private ActorRef actorReference = null;
	
	protected volatile State executionState = State.INACTIVE;

	@Override
	public void deploy(MappingUtil mapper) {
		deploy(mapper, null);	
	}
	
	@Override
	public void deploy(MappingUtil mapper, ActorRef parent) {
		actorReference = LifeCycleManager.INSTANCE.createActorForStartDataPortSync(this, parent);
		// General port deployment
		PortUtil.deploy(this, mapper, actorReference);

		DataPortImpl dataPort = (DataPortImpl) getPortType();
		if (dataPort.getPortDatatype() != null)
			dataInstance = mapper.mapDataType(dataPort.getPortDatatype());

		// In case that a default value for that port was set during modeling,
		String presetValue = dataPort.getValue();
		if (presetValue != null && !presetValue.isEmpty())
			dataInstance.parse(presetValue);			
	}

	/**
	 * Activates this port.
	 * 
	 * When a port gets activated it receives information that it will store and
	 * provide for its corresponding ProcessStep when requested.
	 * 
	 * @param parameter
	 *            The information to be provided for the ProcessStep.
	 */
	@Override
	public boolean activate(DataTypeInstance parameter) {
		if(!canProceed())
			return true;
		
		DataPort dp1 = (DataPort) getPortType();
		String dataPortTypeID = dp1.getPortDatatype().getId();

		if (parameter.getTypeId().equals(dataPortTypeID)) {
			dataInstance = parameter;
		} else {
			DataPort dp = (DataPort) getPortType();
			Set<DataMapping> mappings = new HashSet<>(dp.getMappings());
			dataInstance = mapp(parameter, mappings, getDataInstance());
		}
		
		executionState = State.ACTIVE;
		LifeCycleManager.INSTANCE.executeProcessStep(getProcessStepInstance());
		return true;
	}
	
	@Override
	public void deactivate() {
		if(!canProceed())
			return;
		executionState = State.DEACTIVATED;
		LifeCycleManager.INSTANCE.executeProcessStep(getProcessStepInstance());
	}
	
	@Override
	public void deactivateSubSteps() {
		LOGGER.debug("{}: deactivate substeps", getPortType().getName());
		for (TransitionInstance t : getOutTransitionInstances())
			LifeCycleManager.INSTANCE.deactivateTransition(t);		
	}

	/**
	 * Executes SubSteps of it's corresponding ProcessStep.
	 * 
	 * ProcessSteps themselves have no direct relations to other ProcessSteps
	 * but are connected via Ports and Transitions. Therefore StartPorts must
	 * not only activate their respective ProcessStep but also its SubSteps
	 * which are connected to them via Transitions. Due to the fact that only
	 * the corresponding ProcessStep can determine if the execution of SubSteps
	 * is valid, the method executeSubSteps() should be called by the
	 * ProcessStep (and only by this!) containing this StartPort.
	 */
	@Override
	public synchronized void executeSubSteps() {
		LOGGER.debug("{}: activate substeps", getPortType().getName());
		setInstanceId("StartDataPort " + getPortType().getName() + "_instance_"
				+ getInstancenumber());

		for (TransitionInstance t : getOutTransitionInstances())
			LifeCycleManager.INSTANCE.executeTransition(t, dataInstance.copy());
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
	
	@Override
	public ActorRef getActorReference() {
		return actorReference;
	}

	/**
	 * This method returns the sub-data-type of a given DataType that has a
	 * specific ID.
	 * 
	 * @param id
	 *            the searched Id of an DataType
	 * @param dt
	 *            the DataType to be searched in
	 * @return the DataType with the given ID or null
	 */
	private DataTypeInstance getDataTypeInstanceByDataTypeId(String id, DataTypeInstance dti) {
		if (dti.getDataTypeType().getId().equals(id))
			return dti;

		if (dti instanceof ComplexTypeInstance) {
			ComplexTypeInstance ct = (ComplexTypeInstance) dti;
			for (DataTypeInstance dataTypeInstance : ct.getSubtypes()) {
				DataTypeInstance d = getDataTypeInstanceByDataTypeId(id, dataTypeInstance);
				if (d != null)
					return d;
			}
		}
		return null;
	}

	private DataTypeInstance mapp(DataTypeInstance sourceDataTypeInstance,
			Set<DataMapping> allMappings, DataTypeInstance targetDataTypeInstance) {

		for (DataMapping dm : allMappings) {
			String targetId = dm.getSource().getId();

			if (sourceDataTypeInstance != null) {
				DataTypeInstance dtiTarget = getDataTypeInstanceByDataTypeId(targetId,
						sourceDataTypeInstance);
				String classSource = sourceDataTypeInstance.getClass().getSimpleName();
				String classTarget = dtiTarget.getClass().getSimpleName();
				if (dtiTarget != null && classSource.equals(classTarget)) {
					targetDataTypeInstance.parse(dtiTarget.toString());
				}
			}
		}
		return targetDataTypeInstance;
	}
	
	@Override
	public void setExecutionState(State newExecutionState) {
		executionState = newExecutionState;
	}
	
	@Override
	public State getExecutionState() {
		return executionState;
	}
	
	/**
	 * Checks if the transition was already activated or deactivated
	 * @return true if the port can activate or deactivate
	 */
	private boolean canProceed(){
		return executionState == State.INACTIVE;
	}
}
