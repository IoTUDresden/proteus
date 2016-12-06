package eu.vicci.process.model.util.logging;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.codahale.metrics.MetricRegistry;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import feign.Feign;

public class LoggingManager {
	
	private static LoggingManager lm;
	private Map<String, InstanceLogger> loggers = new ConcurrentHashMap<>();
	private List<IStateChangeMessage> recentStateChanges = new CopyOnWriteArrayList<>();
	
	private Optional<MetricRegistry> registry = Optional.empty();
	
	private Map<String, TimerWithStart> timerContexts = new ConcurrentHashMap<>();
	private ElasticsearchClient esClient;
	private ObjectMapper objectMapper;
	
	public static synchronized LoggingManager getInstance() {
		if (lm == null) {
			lm = new LoggingManager();
		}		
		return lm;
	}
	
	private LoggingManager() {
		String esHost = ConfigurationManager.getInstance()
			.getConfigAsString(ConfigProperties.ELASTICSEARCH_HOST);
		
		objectMapper = new ObjectMapper();
		esClient = Feign.builder().target(ElasticsearchClient.class, "http://" + esHost);
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
		final String stepInstance  = step  + ".step-instance-"  + message.getInstanceId();
		
		if (State.EXECUTING == message.getState()) {
			TimerWithStart timer = TimerWithStart.create(r.timer(stepInstance).time());
			timer.model = message.getProcessId();
			timer.step = message.getModelId();
			timer.stepInstance = message.getInstanceId();
			timer.name = "proteus." + timer.stepInstance;
			timer.process = message.getProcessName();
			timerContexts.put(stepInstance, timer);
		}
		
		if (State.EXECUTED == message.getState()) { 
			TimerWithStart timer = timerContexts.remove(stepInstance).stop();
			
			try {
				esClient.postDecember2016(objectMapper.writeValueAsString(timer));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}

}
