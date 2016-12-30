package eu.vicci.process.model.util.logging;

import java.util.Calendar;
import java.util.Date;
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
		if (State.EXECUTING == message.getState()) {
			logExecutingIfNeeded(message);
		}		
		else if (State.EXECUTED == message.getState()) { 
			logExecuted(message);
		}
	}
	
	private void logExecuted(IStateChangeMessage message){
		LogIdentifier logId = new LogIdentifier(message);
		TimerWithStart timer = timerContexts.remove(logId.stepInstance).stop();
		
		Calendar cal = getCurrentCalendar();
		final int iMonth = cal.get(Calendar.MONTH) + 1; //zero based month
		final int iYear = cal.get(Calendar.YEAR);
		final String month = iMonth < 10 ? "0" + String.valueOf(iMonth) : String.valueOf(iMonth);
		final String year = String.valueOf(iYear);
		
		try {
			esClient.post(year, month, objectMapper.writeValueAsString(timer));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}		
	}
	
	private void logExecutingIfNeeded(IStateChangeMessage message){
		final LogIdentifier logId = new LogIdentifier(message);		
		if(timerContexts.containsKey(logId.stepInstance)) //time already started
			return;
		
		final MetricRegistry r = registry.get();			
		TimerWithStart timer = TimerWithStart.create(r.timer(logId.stepInstance).time());
		timer.model = message.getProcessId();
		timer.step = message.getModelId();
		timer.stepInstance = message.getInstanceId();
		timer.name = "proteus." + timer.stepInstance;
		timer.process = message.getProcessName();
		timerContexts.put(logId.stepInstance, timer);
	}
	
	private static Calendar getCurrentCalendar(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal;
	}
	
	private class LogIdentifier {
		private final String model;
		private final String step;
		private final String stepInstance;
		
		public LogIdentifier(IStateChangeMessage message) {
			model = "model-" + message.getProcessId();
			step  =  model   + ".step-" + message.getModelId();
			stepInstance  = step  + ".step-instance-"  + message.getInstanceId();				
		}				
	}

}
