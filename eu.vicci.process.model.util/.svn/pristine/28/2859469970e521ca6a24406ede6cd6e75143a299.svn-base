package eu.vicci.process.model.util.logging;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public class LoggingManager {
	
	private static LoggingManager lm;
	private Map<String, InstanceLogger> loggers = new ConcurrentHashMap<>();
	private List<IStateChangeMessage> recentStateChanges = new CopyOnWriteArrayList<>();
	
	public static synchronized LoggingManager getInstance() {
		if (lm == null) {
			lm = new LoggingManager();
		}		
		return lm;
	}

	public Map<String, InstanceLogger> getLoggers() {
		return loggers;
	}

	public void setLoggers(Map<String, InstanceLogger> loggers) {
		this.loggers = loggers;
	}

	public List<IStateChangeMessage> getRecentStateChanges() {
		return recentStateChanges;
	}
	
	public void createLoggingForInstance(ProcessInstance processInstance){
		InstanceLogger il = new InstanceLogger(processInstance, new CopyOnWriteArrayList<IStateChangeMessage>());
		loggers.put(processInstance.getInstanceId(), il);		
	}
	
	public void logStateMessage(IStateChangeMessage message){
		loggers.get(message.getProcessInstanceId()).logStateMessage(message);
		recentStateChanges.add(message);
	}
	
}
