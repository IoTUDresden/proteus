package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import eu.vicci.process.model.sofia.TriggeredEvent;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EventInstance;
import eu.vicci.process.model.sofiainstance.util.TriggeredEventWorker;

/**
 * Implementation of the Triggering Event Process Step This process step is used
 * for waiting for a specified event pattern from the CEP engine to appear and
 * to trigger the following process steps. In addition, the ingoing data are
 * transfered to the outgoing ports of the same data type so the data can be
 * used in the following process steps.
 * 
 * @author ronsei
 * 
 */
public class TriggeredEventInstanceImplCustom extends
		ProcessStepInstanceImplCustom implements EventInstance {	

	private Date timeStamp;
	private TriggeredEventWorker triggeredEventWorker;

	/**
	 * The work to be done by the ProcessStep.<br>
	 * <br>
	 * Please fill in here all necessary business logic.
	 */
	@Override
	public void work() {
		timeStamp = new Date(System.currentTimeMillis());
		triggeredEventWorker = new TriggeredEventWorker();
		String eplStmt = ((TriggeredEvent)getProcessStepType()).getEPLStatement();
		
		//TODO use startParameter for replacing the placeholder in the epl statement
		List<EndDataPortInstance> endports = ports.stream()
				.filter(p -> p instanceof EndDataPortInstance)
				.map(p -> (EndDataPortInstance)p)
				.collect(Collectors.toList());
		
		//This blocks till the event is received
		returnValues = triggeredEventWorker.work(eplStmt, startParameter, endports);
	}
	
	@Override
	public void preReset() {
		super.preReset();
		timeStamp = null;
		if(triggeredEventWorker != null)
			triggeredEventWorker.reset();
		triggeredEventWorker = null;
	}

	@Override
	public Date getTimeStamp() {
		return timeStamp;
	}

	@Override
	public void setTimeStamp(Date value) {
		timeStamp = value;		
	}
}
