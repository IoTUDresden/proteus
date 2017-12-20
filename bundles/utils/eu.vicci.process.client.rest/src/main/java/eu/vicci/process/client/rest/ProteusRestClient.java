package eu.vicci.process.client.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.client.core.UploadAndDeployRequest;
import eu.vicci.process.engine.core.IProcessInfo;
import feign.Feign;
import feign.Response;

public class ProteusRestClient {
	private static final Logger LOG = LoggerFactory.getLogger(ProteusRestClient.class);
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
	 * 
	 * @param processDocument
	 *            the process as string
	 * @param overrideExisting
	 *            override the existing model file
	 * @return
	 */
	public String uploadAndDeploy(String processDocument, boolean overrideExisting) {
		UploadAndDeployRequest request = new UploadAndDeployRequest();
		request.setProcessdocument(processDocument);
		request.setOverrideExisting(overrideExisting);
		Response response = restClient.uploadAndDeploy(request);

		if (response.status() != 200) {
			LOG.error("uploadAndDeployed failed: \n{}", response.body().toString());
			return null;
		}
		return response.body().toString();
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
		return null;
	}

}
