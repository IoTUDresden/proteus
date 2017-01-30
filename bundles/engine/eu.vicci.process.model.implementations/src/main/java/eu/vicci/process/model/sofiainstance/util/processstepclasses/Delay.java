package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

/**
 * If this worker receives a datatype with the name of {@link #DELAY_TYPE_ID}, and an integer instance,
 * this value is used to wait. Otherwise, the {@link #DEFAULT_DELAY} is used.
 * 
 * All parameters are returned as results.
 * 
 */
public class Delay implements ProcessStepWorker{
	private static final Logger logger = LoggerFactory.getLogger(Delay.class);
	private static final String DELAY_TYPE_ID = "WorkerDelay";
	private static final long DEFAULT_DELAY = 6000;	
	
	@Override
	public void deploy() { }	

	@Override
	public List<DataTypeInstance> work(Context context) {
		long delay = DEFAULT_DELAY;
		Integer tmp = getCustomDelayFromStartPorts(context.startParameter);
		if(tmp != null)
			delay = tmp.longValue();
		
		logger.debug("Delay says: 'I delay execution for {} ms.'", delay);
		try {
			wait(delay);
		} catch (InterruptedException e) {
			logger.error("ProcessStepWorker 'Delay' failed. The waiting was interrupted");
			e.printStackTrace();
		}
		return context.startParameter;
	}
	
	private Integer getCustomDelayFromStartPorts(List<DataTypeInstance> parameter){
		Optional<DataTypeInstance> instance = parameter.stream()
				.filter(d -> DELAY_TYPE_ID.equals(d.getDataTypeType().getName()))
				.filter(d -> d.getDataTypeType() instanceof IntegerType)
				.findFirst();
		if(instance.isPresent())
			return (Integer)instance.get().getValueAsObject();		
		return null;		
	}
}