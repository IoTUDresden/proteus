package eu.vicci.process.model.util.serialization.jsonprocesssteps;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofia.EndControlPort;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.EscalationPort;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.StartControlPort;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.Transition;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONPort;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONTransition;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.PortType;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = JSONDataPort.class, name = "JSONDataPort"),
		@Type(value = JSONEscalationPort.class, name = "JSONEscalationPort")})
public class JSONPort implements IJSONPort {
	private String type;
	private String id;
	private String description;
	private String name;
	private PortType portType;
	private boolean isOptional;
	
	@JsonDeserialize(as=JSONTransition.class)
	private IJSONTransition inTransition;
	
	@JsonDeserialize(contentAs=JSONTransition.class)
	private List<IJSONTransition> outTransitions = new ArrayList<IJSONTransition>();
	
	public JSONPort() {
	}

	public JSONPort(Port port) {
		type = port.getClass().getCanonicalName();
		portType = getPortType(port);
		id = port.getId();
		name = port.getName();		
		description = port.getDescription();
		isOptional = port.isOptional();
		
		JSONProcessStepSerializer.alreadySerialized.put(id, this);
		processTransitions(port);
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
	public String getId() {
		return id;
	}

	@Override
	public void setId(String Id) {
		this.id = Id;
	}

	@Override
	public List<IJSONTransition> getOutTransitions() {
		return outTransitions;
	}

	@Override
	public void setOutTransitions(List<IJSONTransition> outTransitions) {
		this.outTransitions = outTransitions;
	}

	@Override
	public IJSONTransition getInTransitions() {
		return inTransition;
	}

	@Override
	public void setInTransitions(IJSONTransition inTransitions) {
		this.inTransition = inTransitions;
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
	public PortType getPortType() {
		return portType;
	}

	@Override
	public void setPortType(PortType portType) {
		this.portType = portType;
	}

	@Override
	public Port makePort() {
		if (JSONProcessStepSerializer.alreadyInstanciated.containsKey(id))
			return (Port) JSONProcessStepSerializer.alreadyInstanciated.get(id);
		Port port = null;		
		switch (portType) {
		case StartControlPort:		
			port = SofiaFactory.eINSTANCE.createStartControlPort();
			break;
		case EndControlPort:	
			port = SofiaFactory.eINSTANCE.createEndControlPort();
			break;
		case StartDataPort:			
			port = SofiaFactory.eINSTANCE.createStartDataPort();
			break;
		case EndDataPort:			
			port = SofiaFactory.eINSTANCE.createEndDataPort();
			break;
		case EscalationPort:			
			port = SofiaFactory.eINSTANCE.createEscalationPort();
			break;
		default:
			throw new IllegalArgumentException("cant make port for type " + portType.name());
		}
		
		addBaseInformationsToPort(port);
		return port;
	}
	
	@Override
	public boolean isOptional() {
		return isOptional;
	}

	@Override
	public void setOptional(boolean isOptional) {
		this.isOptional = isOptional;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	
	protected void addBaseInformationsToPort(Port port){
		port.setName(name);
		port.setId(id);
		port.setOptional(isOptional);
		port.setDescription(description);
		
		if(inTransition != null)
			port.setInTransitions(inTransition.makeTransition());		
		for(IJSONTransition trans : outTransitions)
			port.getOutTransitions().add(trans.makeTransition());
		JSONProcessStepSerializer.alreadyInstanciated.put(id, port);
	}
	
	private boolean isVisible(Transition inTransition) {
		Port[] ports = { inTransition.getSourcePort(), inTransition.getTargetPort() };
		for (Port port : ports) {
			String portParentId = port.getProcessStep().getId();
			if (!JSONProcessStepSerializer.alreadySerialized.containsKey(portParentId))
				return false;
		}
		return true;
	}
	
	private void processTransitions(Port port){
		Transition it = port.getInTransitions();
		if (it != null && isVisible(it))
			if (JSONProcessStepSerializer.alreadySerialized.containsKey(it.getId()))
				inTransition = (IJSONTransition) JSONProcessStepSerializer.alreadySerialized.get(it.getId());
			else
				inTransition = new JSONTransition(port.getInTransitions());

		for (Transition transition : port.getOutTransitions()) {
			if (isVisible(transition)) {
				if (JSONProcessStepSerializer.alreadySerialized.containsKey(transition.getId()))
					outTransitions.add((JSONTransition) JSONProcessStepSerializer.alreadySerialized.get(transition.getId()));
				else
					outTransitions.add(new JSONTransition(transition));
			}
		}
	}
	
	private static PortType getPortType(Port port) {
		if(port instanceof StartDataPort)
			return PortType.StartDataPort;
		if(port instanceof EndDataPort)
			return PortType.EndDataPort;
		if(port instanceof StartControlPort)
			return PortType.StartControlPort;
		if(port instanceof EndControlPort)
			return PortType.EndControlPort;
		if(port instanceof EscalationPort)
			return PortType.EscalationPort;
		throw new IllegalArgumentException("cant serialize port of type" + port.getClass().getCanonicalName());
	}

}
