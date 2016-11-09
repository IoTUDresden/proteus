package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.devices.util.OpenHabEvent.OHItemStateEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemStatePayload;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.openhab.util.OpenHabEventProvider;
import eu.vicci.process.openhab.util.OpenHabEventProvider.OHEventItemStateListener;

/**
 * Same as {@link OpenHabWaitForEvent} but the first result which occurs will mapped to the
 * Datatypeinstances with name {@link #RESULT_TYPE}. This should also be present as a startdata
 * port, so that the correct datatype instance is committed as parameter.
 * 
 * Only for Demo purposes
 */
public class OpenHabWaitForEventWithResult implements ProcessStepWorker, OHEventItemStateListener {
	private static final Logger logger = LoggerFactory.getLogger(OpenHabWaitForEvent.class);
	private static final String serverType = "StepServerBasePath";
	private static final String RESULT_TYPE = "OpenHabResult";

	private Map<String, DataTypeInstance> itemsToWaitFor;
	private DataTypeInstance resultInstance;

	private List<DataTypeInstance> returnValues;

	private String uriBasePath;

	private CountDownLatch eventSignal;

	@Override
	public void deploy() {
	}

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		returnValues = new ArrayList<>();
		eventSignal = new CountDownLatch(1);

		setAllItemsToWaitForAndServerBasePath(parameter);
		setResultParamter(parameter);

		if (uriBasePath == null || uriBasePath.isEmpty())
			return returnValues;

		OpenHabEventProvider provider = new OpenHabEventProvider(uriBasePath);
		provider.registerToItemState(this);

		try {
			eventSignal.await(); // avoids busy waiting and blocks till event was processed
		} catch (InterruptedException e) {
			logger.error("waiting for events was interrupted");
			e.printStackTrace();
		}
		provider.closeAllEventSources();
		return returnValues;
	}
	
	// EventListener Implementation
	// is synchronized necessary at this point, or provides this the
	// jersey/glassfish implementation?
	@Override
	public void onItemState(OHItemStateEvent ohEvent) {
		OHItemStatePayload payload = ohEvent.getTypedPayload();
		String itemName = ohEvent.getItemName();

		if (!itemsToWaitFor.containsKey(itemName))
			return;
		// empty values are not recognized
		if (payload.getValue() == null || payload.getValue().isEmpty())
			return;
		DataTypeInstance instance = itemsToWaitFor.get(itemName);
		instance.parse(payload.getValue());
		returnValues.add(instance);
		if(resultInstance != null){
			resultInstance.parse(payload.getValue());
			returnValues.add(resultInstance);
		}
		eventSignal.countDown();		
	}

	private void setAllItemsToWaitForAndServerBasePath(List<DataTypeInstance> parameter) {
		itemsToWaitFor = new HashMap<String, DataTypeInstance>();
		for (DataTypeInstance dataTypeInstance : parameter) {
			String name = dataTypeInstance.getDataTypeType().getName();

			if (serverType.equals(name))
				uriBasePath = (String) dataTypeInstance.getValueAsObject();
			else
				itemsToWaitFor.put(name, dataTypeInstance);
		}
	}
	
	private void setResultParamter(List<DataTypeInstance> parameter) {
		Optional<DataTypeInstance> di = parameter.stream()
				.filter(d -> RESULT_TYPE.equals(d.getDataTypeType().getName()))
				.findFirst();	
		if(di.isPresent())
			resultInstance = di.get();
		else
			resultInstance = null; //is necessary cause it is not possible to reset this step
	}


}
