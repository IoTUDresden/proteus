package eu.vicci.process.test;

public class SoapInvokeConf {

	private String serverUri = "";
	private String methodName ="";
	private String wsdlUri = "";
	private String configFile = "";
	
	public String getServerUri() {
		return serverUri;
	}
	public void setServerUri(String serverUri) {
		this.serverUri = serverUri;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public String getWsdlUri() {
		return wsdlUri;
	}
	public void setWsdlUri(String wsdlUri) {
		this.wsdlUri = wsdlUri;
	}
	public String getConfigFile() {
		return configFile;
	}
	public void setConfigFile(String configFile) {
		this.configFile = configFile;
	}
}
