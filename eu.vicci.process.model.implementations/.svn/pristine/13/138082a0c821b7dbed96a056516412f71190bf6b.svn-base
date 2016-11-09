package eu.vicci.process.model.cep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

import eu.vicci.process.model.sofiainstance.util.TriggeredEventWorker;

public class CEPListener implements UpdateListener {
	private static final Logger logger = LoggerFactory.getLogger(CEPListener.class);
	
	private TriggeredEventWorker tew;
	
	public CEPListener(TriggeredEventWorker tew) {
		this.tew = tew;
	}
	
	@Override
	public void update(EventBean[] newData, EventBean[] oldData) {
        logger.info("Event received: {}", newData[0].getUnderlying());
        tew.activate(newData, oldData);
    }
}
