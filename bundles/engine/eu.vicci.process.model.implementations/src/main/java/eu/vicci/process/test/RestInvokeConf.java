package eu.vicci.process.test;

import eu.vicci.process.model.sofia.HTTPverb;

public class RestInvokeConf {
	
	private HTTPverb httpMethod = null;
	private String serverUri = "";
	
	public HTTPverb getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(HTTPverb httpMethod) {
		this.httpMethod = httpMethod;
	}
	public String getServerUri() {
		return serverUri;
	}
	public void setServerUri(String serverUri) {
		this.serverUri = serverUri;
	}
	
	
	
}
