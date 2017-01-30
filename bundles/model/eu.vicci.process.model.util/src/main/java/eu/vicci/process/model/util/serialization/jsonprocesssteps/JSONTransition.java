package eu.vicci.process.model.util.serialization.jsonprocesssteps;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofia.FalseTransition;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.Transition;
import eu.vicci.process.model.sofia.TrueTransition;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONPort;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONTransition;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class JSONTransition implements IJSONTransition {
	private String id;
	private String type;
	@JsonDeserialize(as=JSONPort.class)
	private IJSONPort sourcePort;
	@JsonDeserialize(as=JSONPort.class)
	private IJSONPort targetPort;
	
	public JSONTransition() {
		super();
	}

	public JSONTransition(Transition transition) {
		id = transition.getId();
		JSONProcessStepSerializer.alreadySerialized.put(id, this);

		if (JSONProcessStepSerializer.alreadySerialized.containsKey(transition
				.getSourcePort().getId()))
			sourcePort = (IJSONPort) JSONProcessStepSerializer.alreadySerialized
					.get(transition.getSourcePort().getId());
		else
			sourcePort = new JSONPort(transition.getSourcePort());

		if (JSONProcessStepSerializer.alreadySerialized.containsKey(transition
				.getTargetPort().getId()))
			targetPort = (IJSONPort) JSONProcessStepSerializer.alreadySerialized
					.get(transition.getTargetPort().getId());
		else
			targetPort = new JSONPort(transition.getTargetPort());

		type = transition.getClass().getCanonicalName();
	}

	@Override
	public Transition makeTransition() {
		Transition transition = null;
		if (JSONProcessStepSerializer.alreadyInstanciated.containsKey(id))
			return (Transition) JSONProcessStepSerializer.alreadyInstanciated
					.get(id);

		if (type.equals(TrueTransition.class.getCanonicalName()))
			transition = SofiaFactory.eINSTANCE.createTrueTransition();
		if (type.equals(FalseTransition.class.getCanonicalName()))
			transition = SofiaFactory.eINSTANCE.createFalseTransition();
		else
			transition = SofiaFactory.eINSTANCE.createTransition();

		transition.setId(id);
		transition.setSourcePort(sourcePort.makePort());
		transition.setTargetPort(targetPort.makePort());

		JSONProcessStepSerializer.alreadyInstanciated.put(id, transition);
		return transition;
	}

}
