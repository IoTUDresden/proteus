package eu.vicci.process.model.util.logging;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import feign.Feign;

public class LoggingManager {
	private static final Logger log = LoggerFactory.getLogger(LoggingManager.class);

	private static LoggingManager lm;
	private Map<String, InstanceLogger> loggers = new ConcurrentHashMap<>();
	private List<IStateChangeMessage> recentStateChanges = new CopyOnWriteArrayList<>();

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
		String esHost = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.ELASTICSEARCH_HOST);
		objectMapper = new ObjectMapper();
		if(esHost != null)
			esClient = Feign.builder().target(ElasticsearchClient.class, "http://" + esHost);
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

	public void createLoggingForInstance(ProcessInstance processInstance) {
		InstanceLogger il = new InstanceLogger(processInstance, new CopyOnWriteArrayList<IStateChangeMessage>());
		loggers.put(processInstance.getInstanceId(), il);
	}

	public void logStateMessage(IStateChangeMessage message) {
		report(message);
		loggers.get(message.getProcessInstanceId()).logStateMessage(message);
		recentStateChanges.add(message);
	}

	private void report(IStateChangeMessage message) {
		if(esClient == null) return; //no reporting needed
		
		if (State.EXECUTING == message.getState()) {
			logExecutingIfNeeded(message);
		} else if (isFinishedState(message)) {
			logExecuted(message);
		}
	}

	private void logExecuted(IStateChangeMessage message) {
		LogIdentifier logId = new LogIdentifier(message);
		TimerWithStart timer = timerContexts.remove(logId.stepInstance).stop();

		Calendar cal = getCurrentCalendar();
		final int iMonth = cal.get(Calendar.MONTH) + 1; // zero based month
		final int iYear = cal.get(Calendar.YEAR);
		final String month = iMonth < 10 ? "0" + String.valueOf(iMonth) : String.valueOf(iMonth);
		final String year = String.valueOf(iYear);

		try {
			esClient.post(year, month, objectMapper.writeValueAsString(timer));
		} catch (Exception e) {
			log.error("failed to send the logging to elasticsearch: '{}'", e.getMessage());
		}
	}

	private void logExecutingIfNeeded(IStateChangeMessage message) {
		final LogIdentifier logId = new LogIdentifier(message);
		if (timerContexts.containsKey(logId.stepInstance)) // time already started
			return;

		TimerWithStart timer = TimerWithStart.create();
		timer.model = message.getProcessId();
		timer.step = message.getModelId();
		timer.stepInstance = message.getInstanceId();
		timer.name = "proteus." + timer.stepInstance;
		timer.process = message.getProcessName();
		timerContexts.put(logId.stepInstance, timer);
	}

	private static Calendar getCurrentCalendar() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal;
	}

	private boolean isFinishedState(IStateChangeMessage message) {
		switch (message.getState()) {
		case EXECUTED:
		case FAILED:
		case ESCALATED:
			return true;
		default:
			return false;
		}
	}

	private class LogIdentifier {
		private final String model;
		private final String step;
		private final String stepInstance;

		public LogIdentifier(IStateChangeMessage message) {
			model = "model-" + message.getProcessId();
			step = model + ".step-" + message.getModelId();
			stepInstance = step + ".step-instance-" + message.getInstanceId();
		}
	}

}
