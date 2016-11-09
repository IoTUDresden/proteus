package eu.vicci.process.model.util.serialization.jsonprocessstepinstances;

import java.util.Date;

import eu.vicci.process.model.sofiainstance.EventInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONEventInstance;

public class JSONEventInstance extends JSONProcessStepInstance implements IJSONEventInstance{

	private long timeStamp;
	
	public JSONEventInstance(){
		super();
	}

	public JSONEventInstance(EventInstance stepInstance) {
		super(stepInstance);
		timeStamp = stepInstance.getTimeStamp().getTime();
	}
	
	@Override
	public EventInstance makeEventInstance(SofiaInstanceFactory factory){
		EventInstance result = (EventInstance) super.makeProcessStepInstance(factory);
		result.setTimeStamp(new Date(timeStamp));
		return result;		
	}

}
