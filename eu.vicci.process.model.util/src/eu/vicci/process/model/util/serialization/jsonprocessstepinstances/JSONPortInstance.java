package eu.vicci.process.model.util.serialization.jsonprocessstepinstances;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.StartControlPortInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONTransitionInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.PortInstanceType;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.JSONPort;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.JSONProcessStepSerializer;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONPort;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = JSONDataPortInstance.class, name = "JSONDataPortInstance"),
		@Type(value = JSONEscalationPortInstance.class, name = "JSONEscalationPortInstance") })
public class JSONPortInstance implements IJSONPortInstance {
	private String type;
	private State executionState;
	private String instanceId;
	private int instanceNumber;
	private String name;
	private String typeId;
	private PortInstanceType portInstanceType;
	private boolean doDeactivation = false;

	@JsonDeserialize(as = JSONPort.class)
	private IJSONPort portType;
	@JsonDeserialize(contentAs = JSONTransitionInstance.class)
	private List<IJSONTransitionInstance> outTransitions = new ArrayList<IJSONTransitionInstance>();
	@JsonDeserialize(as = JSONTransitionInstance.class)
	private IJSONTransitionInstance inTransitions;

	public JSONPortInstance() {
	}

	public JSONPortInstance(PortInstance portInstance) {
		type = portInstance.getClass().getCanonicalName();
		portInstanceType = getPortInstanceType(portInstance);
		executionState = portInstance.getExecutionState();
		instanceId = portInstance.getInstanceId();
		instanceNumber = portInstance.getInstancenumber();
		name = portInstance.getName();
		typeId = portInstance.getTypeId();

		JSONProcessStepInstanceSerializer.alreadySerialized.put(instanceId, this);

		portType = JSONProcessStepSerializer.makeJSONPort(portInstance.getPortType());
		
		// FIXME processTransitions() will lead to failure which is not visible
		// e.g. in server handler, the serialized type is returned, 
		// but the handler will block at this point (no state messages can be send from the server).
		// unfortunately no exception is thrown :(
		// Now it is time, to search for an good solution for serialization of instances
		
		//processTransitions(portInstance);		
	}

	private void processTransitions(PortInstance portInstance) {
		TransitionInstance inTransition = portInstance.getInTransitionInstances();
		if (inTransition != null && isVisible(inTransition))
			if (JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(inTransition.getInstanceId()))
				inTransitions = (IJSONTransitionInstance) JSONProcessStepInstanceSerializer.alreadySerialized
						.get(inTransition.getInstanceId());
			else
				inTransitions = new JSONTransitionInstance(portInstance.getInTransitionInstances());

		for (TransitionInstance transition : portInstance.getOutTransitionInstances()) {
			if(!isVisible(transition))
				return;
			if (JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(transition.getInstanceId()))
				outTransitions.add((JSONTransitionInstance) JSONProcessStepInstanceSerializer.alreadySerialized
						.get(transition.getInstanceId()));
			else
				outTransitions.add(new JSONTransitionInstance(transition));
		}
	}

	// to avoid cycles in dependencies
	private boolean isVisible(TransitionInstance inTransition) {
		PortInstance[] ports = { inTransition.getSourcePortInstance(), inTransition.getTargetPortInstance() };
		for (PortInstance port : ports) {
			String portParentId = port.getProcessStepInstance().getInstanceId();
			if (!JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(portParentId))
				return false;
		}
		return true;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public State getExecutionState() {
		return executionState;
	}

	@Override
	public void setExecutionState(State executionState) {
		this.executionState = executionState;
	}

	@Override
	public String getInstanceId() {
		return instanceId;
	}

	@Override
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Override
	public int getInstanceNumber() {
		return instanceNumber;
	}

	@Override
	public void setInstanceNumber(int instanceNumber) {
		this.instanceNumber = instanceNumber;
	}

	@Override
	public List<IJSONTransitionInstance> getOutTransitions() {
		return outTransitions;
	}

	@Override
	public void setOutTransitions(List<IJSONTransitionInstance> outTransitions) {
		this.outTransitions = outTransitions;
	}

	@Override
	public IJSONTransitionInstance getInTransitions() {
		return inTransitions;
	}

	@Override
	public void setInTransitions(IJSONTransitionInstance inTransitions) {
		this.inTransitions = inTransitions;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getTypeId() {
		return typeId;
	}

	@Override
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Override
	public PortInstance makePortInstance(SofiaInstanceFactory factory) {
		if (JSONProcessStepInstanceSerializer.alreadyInstanciated.containsKey(instanceId))
			return (PortInstance) JSONProcessStepInstanceSerializer.alreadyInstanciated.get(instanceId);
		PortInstance portInstance = null;

		switch (portInstanceType) {
		case StartControlPortInstance:
			portInstance = factory.createStartControlPortInstance();
			break;
		case StartDataPortInstance:
			portInstance = factory.createStartDataPortInstance();
			break;
		case EndControlPortInstance:
			portInstance = factory.createEndControlPortInstance();
			break;
		case EndDataPortInstance:
			portInstance = factory.createEndDataPortInstance();
			break;
		case EscalationPortInstance:
			portInstance = factory.createEscalationPortInstance();
			break;
		default:
			throw new IllegalArgumentException("cant make portinstance for type " + portInstanceType.name());
		}

		addBaseInformationsToPortInstance(portInstance, factory);
		JSONProcessStepInstanceSerializer.alreadyInstanciated.put(instanceId, portInstance);
		return portInstance;
	}

	protected void addBaseInformationsToPortInstance(PortInstance portInstance, SofiaInstanceFactory factory) {
		
		// FIXME UnsupportedOperationException is thrown for the default factory
		try {
			portInstance.setExecutionState(executionState);			
		} catch (UnsupportedOperationException e) {
			System.out.println("ERROR: Cant set Execution State to Port on default Factory - FIXME");
		}

		portInstance.setInstanceId(instanceId);
		portInstance.setInstancenumber(instanceNumber);
		if (inTransitions != null)
			portInstance.setInTransitionInstances(inTransitions.makeTransitionInstance(factory));

		portInstance.setName(name);
		portInstance.setTypeId(typeId);
		portInstance.setPortType(portType.makePort());
	}

	@Override
	public PortInstanceType getPortInstanceType() {
		return portInstanceType;
	}

	@Override
	public void setPortInstanceType(PortInstanceType portInstanceType) {
		this.portInstanceType = portInstanceType;
	}

	private static PortInstanceType getPortInstanceType(PortInstance port) {
		if (port instanceof StartDataPortInstance)
			return PortInstanceType.StartDataPortInstance;
		if (port instanceof EndDataPortInstance)
			return PortInstanceType.EndDataPortInstance;
		if (port instanceof StartControlPortInstance)
			return PortInstanceType.StartControlPortInstance;
		if (port instanceof EndControlPortInstance)
			return PortInstanceType.EndControlPortInstance;
		if (port instanceof EscalationPortInstance)
			return PortInstanceType.EscalationPortInstance;
		throw new IllegalArgumentException("cant serialize portinstance of type" + port.getClass().getCanonicalName());
	}

	@Override
	public IJSONPort getPortType() {
		return portType;
	}

	@Override
	public void setPortType(IJSONPort portType) {
		this.portType = portType;
	}

	@Override
	public boolean getDoDeactivation() {
		return doDeactivation;
	}

	@Override
	public void setDoDeactivation(boolean doDeactivation) {
		this.doDeactivation = doDeactivation;
	}
}
