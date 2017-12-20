package eu.vicci.process.client.rest;

import java.util.ArrayList;

import eu.vicci.process.client.core.UploadAndDeployRequest;
import eu.vicci.process.model.util.ProcessInfo;
import feign.Headers;
import feign.RequestLine;
import feign.Response;

public interface RestClientInternal {

	/**
	 * listing deployed processed
	 */
	@RequestLine("GET /rest/processes")
	ArrayList<ProcessInfo> listDeployedProcesses();

	/**
	 * Upload and deploy a process.
	 * 
	 * @return response with status ok (200) and the process id.
	 */
	@Headers("Content-Type: application/json")
	@RequestLine("PUT /rest/processes")
	Response uploadAndDeploy(UploadAndDeployRequest request);

	/**
	 * Deploy a process instance id
	 * 
	 * @param id
	 *            the process id
	 * @return response with status ok (200) and the process instance id.
	 */
	@RequestLine("POST /rest/processes")
	Response deployProcessInstance(String id);

}
