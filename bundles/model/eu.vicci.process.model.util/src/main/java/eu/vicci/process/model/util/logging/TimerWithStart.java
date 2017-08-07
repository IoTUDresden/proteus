package eu.vicci.process.model.util.logging;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimerWithStart {
	
	@JsonProperty
	String name;
	
	@JsonProperty
	String step;

	@JsonProperty
	String stepInstance;

	@JsonProperty
	String model;

	@JsonProperty("@timestamp")
	Date timestamp;
	
	@JsonProperty
	Date startTime;
	
	@JsonProperty
	Date endTime;

	/**
	 * Duration in ms
	 */
	@JsonProperty
	long duration;

	@JsonProperty
	String process;
	
	@JsonProperty
	String peer;
	
	static TimerWithStart create() {
		TimerWithStart timer = new TimerWithStart();
		timer.startTime = timer.timestamp = Calendar.getInstance().getTime();			
		return timer;
	}

	@JsonIgnore
	TimerWithStart stop() {
		endTime = Calendar.getInstance().getTime();
		duration = endTime.getTime() - startTime.getTime();
		return this;
	}
	
}