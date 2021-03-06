package eu.vicci.process.model.cep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.espertech.esper.client.Configuration;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;

import eu.vicci.process.devices.events.SensorEvent;

/**
 * Esper Engine.
 * 
 * @see <a
 *      href="http://esper.sourceforge.net/esper-0.7.5/doc/reference/en/pdf/esper_reference.pdf">Esper
 *      Documentation</a>
 */
public class EsperEngine {
	private static final Logger logger = LoggerFactory.getLogger(EsperEngine.class);
	private static final String PROVIDER_NAME = "vicciCEPEngine";

	private EPServiceProvider esp = null;
	private EPAdministrator cepAdm = null;
	private EPRuntime cep = null;
	private Configuration conf = null;

	private EsperEngine() {
		Configuration cepConfig = new Configuration();

		// Events known at initialization time could be added here
		cepConfig.addEventType(SensorEvent.class);
		cepConfig.addEventTypeAutoName(SensorEvent.class.getPackage().getName());
		
		conf = cepConfig;
		esp = EPServiceProviderManager.getProvider(PROVIDER_NAME, conf);
		cep = esp.getEPRuntime();
		cepAdm = esp.getEPAdministrator();
	}

	public static EsperEngine getInstance() {
		return EsperEngineLoader.INSTANCE;
	}

	public EPServiceProvider getEsp() {
		return esp;
	}

	public EPAdministrator getCepAdm() {
		return cepAdm;
	}

	public EPRuntime getCep() {
		return cep;
	}

	public Configuration getConf() {
		return conf;
	}

	/**
	 * Event is processed as SensorEvent (as Bean). The old implementation uses a map with
	 * static property names.
	 * 
	 * @see <a href=http://www.espertech.com/esper/release-5.2.0/esper-reference/html/
	 *      event_representation.html#eventrep-java-util-map> Java Util Map as Event</a>
	 * @param event
	 */
	public void sendSensorEvent(SensorEvent event) {
		if (event == null || event.getValue() == null) {
			logger.warn("the event or its value should not be null. the event was not logged!");
			return;
		}
		// Performance optimization:
		// http://www.espertech.com/esper/release-5.2.0/esper-reference/html/api.html#api-runtime-eventsender
		
		
		// ESPER should be threadsafe
		// (http://www.espertech.com/esper/release-5.2.0/esper-reference/html/api.html#api-threading)
		cep.sendEvent(event);
	}
	
	private static class EsperEngineLoader {
		static EsperEngine INSTANCE = new EsperEngine();
	}
}
