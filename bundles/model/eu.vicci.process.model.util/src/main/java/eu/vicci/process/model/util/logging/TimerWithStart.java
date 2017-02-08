package eu.vicci.process.model.util.logging;

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
	Long timestamp;
	
	@JsonProperty
	Long startTime;

	@JsonProperty
	long duration;

	@JsonProperty
	long endTime;

	@JsonProperty
	String process;
	
	static TimerWithStart create() {
		TimerWithStart timer = new TimerWithStart();
		timer.startTime = timer.timestamp = System.currentTimeMillis();
		return timer;
	}

	@JsonIgnore
	TimerWithStart stop() {
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		return this;
	}
	
}