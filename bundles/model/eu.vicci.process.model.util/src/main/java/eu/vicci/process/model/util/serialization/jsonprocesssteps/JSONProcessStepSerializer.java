package eu.vicci.process.model.util.serialization.jsonprocesssteps;


import java.util.HashMap;
import java.util.Map;

import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.EscalationPort;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONPort;


public class JSONProcessStepSerializer{
	public static Map<String, Object> alreadyInstanciated = new HashMap<String, Object>();
	public static Map<String, Object> alreadySerialized = new HashMap<String, Object>();
	
	
	public static synchronized String serialize(ProcessStep step) {
		alreadySerialized.clear();
		return null;
	}

	public static synchronized ProcessStepInstance deserialize(String json) {
		alreadyInstanciated.clear();
		return null;
	}
	
	public static IJSONPort makeJSONPort(Port port){
		try {
			if(port instanceof DataPort)
				return new JSONDataPort((DataPort)port);
			if(port instanceof EscalationPort)
				return new JSONEscalationPort((EscalationPort)port);
			return new JSONPort(port);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
