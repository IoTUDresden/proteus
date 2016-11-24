package eu.vicci.process.model.util.logging;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer.Context;

import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public class LoggingManager {
	
	private static LoggingManager lm;
	private Map<String, InstanceLogger> loggers = new ConcurrentHashMap<>();
	private List<IStateChangeMessage> recentStateChanges = new CopyOnWriteArrayList<>();
	
	private Optional<MetricRegistry> registry = Optional.empty();
	
	public static synchronized LoggingManager getInstance() {
		if (lm == null) {
			lm = new LoggingManager();
		}		
		return lm;
	}
	
	public void setMetricsReporter(MetricRegistry registry) {
		this.registry = Optional.ofNullable(registry);
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
		if (registry.isPresent()) report(message);
		loggers.get(message.getProcessInstanceId()).logStateMessage(message);
		recentStateChanges.add(message);
	}

	private void report(IStateChangeMessage message) {
		final MetricRegistry r = registry.get();
		
		final String model = "model-" + message.getProcessId();
		final String step  =  model   + ".step-" + message.getModelId();
		final String modelInstance = model + ".model-instance-" + message.getProcessInstanceId();
		final String stepInstance  = step  + ".step-instance-"  + message.getInstanceId();
		
		if (State.EXECUTING == message.getState())
			r.timer(stepInstance).time();
		
		if (State.EXECUTED == message.getState())
			r.timer(stepInstance).time().stop();	
	}
	
}
