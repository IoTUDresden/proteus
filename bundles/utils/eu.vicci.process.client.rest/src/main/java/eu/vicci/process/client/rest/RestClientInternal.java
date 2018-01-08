package eu.vicci.process.client.rest;

import java.util.ArrayList;
import java.util.Map;

import eu.vicci.process.client.core.UploadAndDeployRequest;
import eu.vicci.process.model.util.ProcessInfo;
import eu.vicci.process.model.util.ProcessInstanceInfo;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.StateChangeMessage;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONProcessStepInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONProcessStepInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface RestClientInternal {

	/**
	 * listing deployed processes
	 */
	@RequestLine("GET /rest/processes")
	ArrayList<ProcessInfo> listDeployedProcesses();

	/**
	 * listing deployed process instances
	 */
	@RequestLine("GET /rest/processinstances")
	ArrayList<ProcessInstanceInfo> listDeployedProcessInstances();

	/**
	 * Upload and deploy a process.
	 * 
	 * @return process id
	 */
	@Headers("Content-Type: application/json")
	@RequestLine("PUT /rest/processes")
	String uploadAndDeploy(UploadAndDeployRequest request);

	/**
	 * Deploy a process instance id
	 * 
	 * @param id
	 *            the process id
	 * @return the process instance id.
	 */
	@RequestLine("POST /rest/processes/{processId}")
	String deployProcessInstance(@Param("processId") String processId);

	/**
	 * @param processInstanceId
	 *            the instance id of the process which should be started
	 */
	@RequestLine("POST /rest/processinstances/{processInstanceId}")
	void startProcessInstance(@Param("processInstanceId") String processInstanceId);

	/**
	 * 
	 * @param processInstanceId
	 *            the instance id of the process which should be started
	 * @param inputParameters
	 *            the input parameters as map, with the id of the
	 *            datatype as key (not instance id!)
	 */
	@Headers("Content-Type: application/json")
	@RequestLine("POST /rest/processinstances/{processInstanceId}")
	void startProcessInstance(@Param("processInstanceId") String processInstanceId,
			Map<String, IJSONTypeInstance> inputParameters);

	/**
	 * Get the process step instance.
	 * 
	 * @param processInstanceId
	 *            The instance id of the root process.
	 * @return {@link IJSONProcessStepInstance}
	 */
	@RequestLine("GET /rest/processinstances/{processInstanceId}")
	JSONProcessStepInstance getProcessStepInstance(@Param("processInstanceId") String processInstanceId);
	
	/**
	 * Gets the most recent state change message for the given process.
	 * @param processInstanceId
	 * @return {@link IStateChangeMessage}
	 */
	@RequestLine("GET /rest/processinstances/recentstate/{processInstanceId}")
	StateChangeMessage getRecentState(@Param("processInstanceId") String processInstanceId);

}
