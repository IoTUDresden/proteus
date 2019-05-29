package eu.vicci.process.model.sofiainstance.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import eu.vicci.process.model.sofia.HumanTask;
import eu.vicci.process.model.sofia.HumanTaskType;
import eu.vicci.process.model.sofia.HumanTaskUseCase;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.sofiainstance.states.StateBase;
import eu.vicci.process.model.sofiainstance.states.WaitingState;
import eu.vicci.process.model.util.messages.HumanTaskMessageManager;
import eu.vicci.process.model.util.messages.HumanTaskMessageManagerListener;
import eu.vicci.process.model.util.messages.HumanTaskRequest;
import eu.vicci.process.model.util.messages.MessageQueue;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONProcessStepInstanceSerializer;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

public class HumanTaskInvokeWorker implements HumanTaskMessageManagerListener {
	public List<DataTypeInstance> returnedData = new LinkedList<DataTypeInstance>();

	private MessageQueue messageQueue;
	private CountDownLatch responseReceived;
	private IHumanTaskResponse receivedResponse;

	private String humanTaskInstanceId;

	public HumanTaskInvokeWorker(MessageQueue messageQueue) {
		if (messageQueue == null)
			throw new IllegalArgumentException("messageQueue cant be null or human task will never finish");
		this.messageQueue = messageQueue;
	}

	/**
	 * creates the {@link IHumanTaskRequest} and waits(blocking) till the
	 * Request is answered with a {@link IHumanTaskResponse}. This method
	 * returnes with the values, for the EndDataPortInstances.
	 * 
	 * Values which are indicating, if endports should activate or deactivate
	 * can get via {@link #getPortActivationValues()}.
	 * 
	 * @param hti
	 * @return null - get the values via {@link #getReturnedPortInstances()}
	 */
	public List<DataTypeInstance> work(ProcessStepInstanceImplCustom hti) {
		responseReceived = new CountDownLatch(1);
		humanTaskInstanceId = hti.getInstanceId();
		HumanTask humanTask = (HumanTask) hti.getProcessStepType();
		HumanTaskRequest humanTaskRequest = createHumanTaskRequest(hti, humanTask);
		HumanTaskMessageManager.getInstance().addHumanTaskMessageManagerListener(this);

		StateBase oldState = hti.getCurrentState();
		hti.setCurrentState(new WaitingState(hti));
		HumanTaskMessageManager.getInstance().AddOpenRequest(humanTaskRequest);
		messageQueue.addMessage(humanTaskRequest);

		try {
			// blocks till response was received
			responseReceived.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		hti.setCurrentState(oldState);	
		createDataTypeInstancesFromResponse();

		// TODO handle response
		// - if response contains errors or missing values, send request again

		return returnedData;
	}
	
	@Override
	public void onHumanTaskResponseAdded(IHumanTaskResponse response) {
		if (!humanTaskInstanceId.equals(response.getHumanTaskInstanceId()))
			return;
		receivedResponse = response;
		HumanTaskMessageManager.getInstance().RemoveOpenRequestIfStillPresent(humanTaskInstanceId);
		HumanTaskMessageManager.getInstance().removeHumanTaskMessageManagerListener(this);
		responseReceived.countDown();
	}

	@Override
	public void onHumanTaskResponseCanceled(IHumanTaskResponse oldResponse, IHumanTaskRequest request) {
		// not interested in this
	}
	
	private void createDataTypeInstancesFromResponse(){
		receivedResponse.getEndDataPorts()
		.values()
		.stream()
		.forEach(port -> {
			DataTypeInstance dti = port.getDataTypeInstance()
					.makeDataTypeInstance(SofiaInstanceFactoryImplCustom.getInstance());
			returnedData.add(dti);
		});
	}

	private HumanTaskRequest createHumanTaskRequest(ProcessStepInstance hti, HumanTask ht) {
		HumanTaskRequest htr = new HumanTaskRequest();
		htr.setRootProcessId(hti.getProcessModelID());
		htr.setHumanTaskInstanceId(hti.getInstanceId());
		htr.setName(ht.getName());
		htr.setDescription(ht.getDescription());
		htr.setHumanTaskType(ht.getHumanTaskType() == null ? HumanTaskType.HINT : ht.getHumanTaskType());
		htr.setHumanTaskUseCase(
				ht.getHumanTaskUseCase() == null ? HumanTaskUseCase.UNIVERSAL : ht.getHumanTaskUseCase());
		htr.setStartDataPorts(getStartDataPortInstances(hti));
		htr.setEndDataPorts(getEndDataPortInstances(hti));
		htr.setEndControlPorts(getEndControlPortInstances(hti));
		// TODO data mappings
		return htr;
	}

	private Map<String, IJSONDataPortInstance> getEndDataPortInstances(ProcessStepInstance hti) {
		Map<String, IJSONDataPortInstance> dtos = new HashMap<String, IJSONDataPortInstance>();
		hti.getPorts().stream().filter(port -> port instanceof EndDataPortInstance).forEach(
				port -> dtos.put(port.getPortType().getId(), new JSONDataPortInstance((EndDataPortInstance) port)));
		return dtos;
	}

	private Map<String, IJSONDataPortInstance> getStartDataPortInstances(ProcessStepInstance hti) {
		HashMap<String, IJSONDataPortInstance> dtos = new HashMap<String, IJSONDataPortInstance>();
		hti.getPorts().stream().filter(port -> port instanceof StartDataPortInstance).forEach(
				port -> dtos.put(port.getPortType().getId(), new JSONDataPortInstance((StartDataPortInstance) port)));
		return dtos;
	}

	private Map<String, IJSONPortInstance> getEndControlPortInstances(ProcessStepInstance hti) {
		HashMap<String, IJSONPortInstance> dtos = new HashMap<String, IJSONPortInstance>();
		hti.getPorts().stream().filter(port -> port instanceof EndControlPortInstance).forEach(port -> dtos
				.put(port.getPortType().getId(), JSONProcessStepInstanceSerializer.makeJSONPortInstance(port)));
		return dtos;
	}
}
