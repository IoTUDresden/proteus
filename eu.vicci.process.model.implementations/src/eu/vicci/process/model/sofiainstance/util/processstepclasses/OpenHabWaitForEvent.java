package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.devices.util.OpenHabEvent.OHItemStateEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemStatePayload;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.openhab.util.OpenHabEventProvider;
import eu.vicci.process.openhab.util.OpenHabEventProvider.OHEventItemStateListener;

/**
 * Simple Worker to receive Updates from OpenHab in a process step. This Worker reads all
 * startdata port datatypetype names. The names of this types should match with items in
 * openhab. This worker blocks till an update is received. If the event object name equals
 * an type name, the worker updates the parameter value, add the value to return list,
 * stops the receiving of events and returns the list.
 * 
 * It is only one event supported, so if there are more than one data endports with
 * different data type names, this process may never finish cause some ports will not be
 * activated.
 * 
 * The Uri Base Path is read from the startdata port which type name equals 'stepserverbasepath'.
 * 
 * ATTENTION:
 * At the moment this is only a workaround for demo purposes
 * 
 * @author André Kühnert
 *
 */
public class OpenHabWaitForEvent implements ProcessStepWorker, OHEventItemStateListener {
	private static final Logger logger = LoggerFactory.getLogger(OpenHabWaitForEvent.class);
	private static final String serverType = "StepServerBasePath";
	private static final String timeoutType = "StepTimeout";
	
	private Map<String, DataTypeInstance> itemsToWaitFor;
	
	private List<DataTypeInstance> returnValues;
	private List<DataTypeInstance> timeoutReturnList;
	private String uriBasePath;	
	private CountDownLatch eventSignal;	
	private boolean timeoutHappend = false;

	@Override
	public void deploy() {
	}
	
	@Override
	public List<DataTypeInstance> work(Context context) {
		returnValues = new ArrayList<>();
		eventSignal = new CountDownLatch(1);

		setAllItemsToWaitForAndServerBasePath(context.startParameter);
		
		if(uriBasePath == null || uriBasePath.isEmpty())
			return returnValues;
		
		OpenHabEventProvider provider = new OpenHabEventProvider(uriBasePath);
		provider.registerToItemState(this);
		setTimeoutIfPresent(context.startParameter);

		try {
			eventSignal.await(); //avoids busy waiting and blocks till event was processed
		} catch (InterruptedException e) {
			logger.error("waiting for events was interrupted");
			e.printStackTrace();
		}		
		provider.closeAllEventSources();
		if(timeoutHappend)
			return timeoutReturnList;
		return returnValues;
	}
	
	//EventListener Implementation
	//is synchronized necessary at this point, or provides this the jersey/glassfish implementation?
	@Override
	public synchronized void onItemState(OHItemStateEvent ohEvent) {
		if(ohEvent == null){
			logger.error("error while event processing");
			return;
		}
		
		OHItemStatePayload payload = ohEvent.getTypedPayload();
		String itemName = ohEvent.getItemName();
		
		if(!itemsToWaitFor.containsKey(itemName))
			return;
		
		if (payload.getValue() == null || payload.getValue().isEmpty())
			return;
		DataTypeInstance instance = itemsToWaitFor.get(itemName);
		instance.parse(payload.getValue());
		returnValues.add(instance);	
		eventSignal.countDown();		
	}
	
	private void setAllItemsToWaitForAndServerBasePath(List<DataTypeInstance> parameter) {
		itemsToWaitFor = new HashMap<String, DataTypeInstance>();
		for (DataTypeInstance dataTypeInstance : parameter){
			String name = dataTypeInstance.getDataTypeType().getName();
			
			if(serverType.equals(name))
				uriBasePath = (String)dataTypeInstance.getValueAsObject();
			else
				itemsToWaitFor.put(name, dataTypeInstance);
		}
	}
	
	private void setTimeoutIfPresent(List<DataTypeInstance> parameter){
		timeoutReturnList = parameter;
		Optional<DataTypeInstance> instance = parameter.stream()
				.filter(d -> timeoutType.equals(d.getDataTypeType().getName()))
				.filter(d -> d instanceof IntegerTypeInstance)
				.findFirst();
		if(!instance.isPresent()){
			return;
		}
		long delay = ((IntegerTypeInstance)instance.get()).getValue();	
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {			
			@Override
			public void run() {
				timeoutHappend = true;
				eventSignal.countDown();				
			}
		}, delay);
	}

}
