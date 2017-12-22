package eu.vicci.process.client.rest;

import java.util.List;

import eu.vicci.process.client.core.UploadAndDeployRequest;
import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;
import feign.Feign;

/**
 * Implementation of a REST Client which can access the PROtEUS REST API.
 * This backs a  <a href="https://github.com/OpenFeign/feign">Feign Rest Client</a>
 * 
 * @author andre
 */
public class ProteusRestClient {
//	private static final Logger LOG = LoggerFactory.getLogger(ProteusRestClient.class);
	private final RestClientInternal restClient;

	public ProteusRestClient() {
		this("localhost", "8082");
	}

	public ProteusRestClient(String host, String port) {
		checkNullOrEmpty(host, "host");
		checkNullOrEmpty(port, "port");
		restClient = createRestClient(host, port);
	}

	private static void checkNullOrEmpty(String value, String name) {
		boolean check = value == null || value.isEmpty();
		if (check)
			throw new IllegalArgumentException(name + " cant be null");
	}

	private static RestClientInternal createRestClient(String host, String port) {
		if (!host.startsWith("http"))
			host = "http://" + host;
		host = host + ":" + port;
		// due to jackson version conflicts we use our own decoder and encoders
		return Feign.builder().encoder(new JacksonEncoder()).decoder(new JacksonDecoder())
				.target(RestClientInternal.class, host);
	}

	/**
	 * Lists all deployed processes, which can be executed.
	 */
	public List<? extends IProcessInfo> listDeployedProcesses() {
		return restClient.listDeployedProcesses();
	}
	
	/**
	 * listing deployed process instances
	 */
	public List<? extends IProcessInstanceInfo> listDeployedProcessInstances(){
		return restClient.listDeployedProcessInstances();
	}

	/**
	 * 
	 * @param processDocument
	 *            the process as string
	 * @param overrideExisting
	 *            override the existing model file
	 * @return process id or null if failed
	 */
	public String uploadAndDeploy(String processDocument, boolean overrideExisting) {
		UploadAndDeployRequest request = new UploadAndDeployRequest();
		request.setProcessdocument(processDocument);
		request.setOverrideExisting(overrideExisting);
		return restClient.uploadAndDeploy(request);	
	}
	
	/**
	 * 
	 * Same as {@link #uploadAndDeploy(String, boolean)} with args (processDocument, true).
	 * 
	 * @param processDocument
	 *            the process as string
	 * @return process id or null if failed
	 */
	public String uploadAndDeploy(String processDocument) {
		return uploadAndDeploy(processDocument, true);
	}

	/**
	 * Deploy a process instance
	 * 
	 * @param processId
	 *            the process id for the process which should be deployed as
	 *            instance.
	 * @return instance id or null if failed
	 */
	public String deployProcessInstance(String processId) {
		return restClient.deployProcessInstance(processId);		
	}
	
	/**
	 * @param processInstanceId
	 *            the instance id of the process which should be started
	 */
	public void startProcessInstance(String processInstanceId){
		restClient.startProcessInstance(processInstanceId);
	}

}
