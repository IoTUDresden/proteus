package eu.vicci.process.model.sofiainstance.util;

import javax.xml.parsers.DocumentBuilder;

import org.reficio.ws.builder.SoapBuilder;
import org.reficio.ws.builder.SoapOperation;
import org.reficio.ws.builder.core.Wsdl;
import org.reficio.ws.client.core.SoapClient;
import org.reficio.ws.client.core.SoapClient.Builder;

@SuppressWarnings("unused")
public class SOAPWorker {

	private DocumentBuilder db;
	private String dummyRequestString = null;
	private SoapClient client = null;

	private String tragetURL = null;
	
	public SOAPWorker(String URI, String WSDLUri, String bindingName, String methodName, int timeoutInMilliSec) {
		// construct the client
		tragetURL = URI;
		
		Builder builder = SoapClient.builder();
		builder.connectTimeoutInMillis(timeoutInMilliSec);
		builder.endpointUri(URI);
		client = builder.build();
		// parse WSDL
		Wsdl parser = Wsdl.parse(WSDLUri);
		// select Binding
		if(bindingName == null){
			bindingName = parser.getBindings().get(0).toString();
		}		
		// select Binding and create SoapBuilder
		SoapBuilder soapBuilder = parser.binding().name(bindingName).find();
		// select Operation
		SoapOperation operation = soapBuilder.operation().name(methodName)
				.find();
		// construct the request
		dummyRequestString = soapBuilder.buildInputMessage(operation);
	}
	
	public String sendRequest(String requestString){
		return client.post(requestString);
		
	}

	public String getDummyRequestString() {
		return dummyRequestString;
	}
	
	
}
