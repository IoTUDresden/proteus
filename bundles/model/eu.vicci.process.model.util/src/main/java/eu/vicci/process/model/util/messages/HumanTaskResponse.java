package eu.vicci.process.model.util.messages;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.vicci.process.model.sofia.HumanTaskType;
import eu.vicci.process.model.sofia.HumanTaskUseCase;
import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

public class HumanTaskResponse extends WampResponse implements IHumanTaskResponse {
	private String processInstanceId;
	private String humanTaskInstanceId;
	private boolean isSentForReservation = false;
	private boolean cancelReservation = false;
	private String name;
	private String description;
	private HumanTaskType humanTaskType;
	private HumanTaskUseCase humanTaskUseCase;

	@JsonDeserialize(as = HashMap.class, keyAs = String.class, contentAs = JSONDataPortInstance.class)
	private Map<String, IJSONDataPortInstance> startDataPorts = new HashMap<String, IJSONDataPortInstance>();
	@JsonDeserialize(as = HashMap.class, keyAs = String.class, contentAs = JSONDataPortInstance.class)
	private Map<String, IJSONDataPortInstance> endDataPorts = new HashMap<String, IJSONDataPortInstance>();;
	@JsonDeserialize(as = HashMap.class, keyAs = String.class, contentAs = JSONPortInstance.class)
	private Map<String, IJSONPortInstance> endControlPorts = new HashMap<String, IJSONPortInstance>();

	public HumanTaskResponse() {
		super(TopicId.HUMAN_TASK_RESP, null);
	}

	@Override
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	@Override
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Override
	public String getHumanTaskInstanceId() {
		return humanTaskInstanceId;
	}

	@Override
	public void setHumanTaskInstanceId(String humanTaskInstanceId) {
		this.humanTaskInstanceId = humanTaskInstanceId;
	}

	@Override
	public boolean isSentForReservation() {
		return isSentForReservation;
	}

	@Override
	public void setSentForReservation(boolean isSentForSeservation) {
		this.isSentForReservation = isSentForSeservation;
	}

	@Override
	public boolean cancelReservation() {
		return cancelReservation;
	}

	@Override
	public void setCancelReservation(boolean cancelReservation) {
		this.cancelReservation = cancelReservation;
	}

	@Override
	public Map<String, IJSONDataPortInstance> getStartDataPorts() {
		return startDataPorts;
	}

	@Override
	public void setStartDataPorts(Map<String, IJSONDataPortInstance> startDataPorts) {
		this.startDataPorts = startDataPorts;

	}

	@Override
	public Map<String, IJSONDataPortInstance> getEndDataPorts() {
		return endDataPorts;
	}

	@Override
	public void setEndDataPorts(Map<String, IJSONDataPortInstance> endDataPorts) {
		this.endDataPorts = endDataPorts;

	}

	@Override
	public Map<String, IJSONPortInstance> getEndControlPorts() {
		return endControlPorts;
	}

	@Override
	public void setEndControlPorts(Map<String, IJSONPortInstance> endControlPorts) {
		this.endControlPorts = endControlPorts;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;

	}

	@Override
	public HumanTaskType getHumanTaskType() {
		return humanTaskType;
	}

	@Override
	public void setHumanTaskType(HumanTaskType type) {
		this.humanTaskType = type;
	}

	@Override
	public HumanTaskUseCase getHumanTaskUseCase() {
		return humanTaskUseCase;
	}

	@Override
	public void setHumanTaskUseCase(HumanTaskUseCase useCase) {
		this.humanTaskUseCase = useCase;
	}
}
