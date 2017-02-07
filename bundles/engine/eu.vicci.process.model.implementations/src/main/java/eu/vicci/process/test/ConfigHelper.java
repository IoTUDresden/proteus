package eu.vicci.process.test;

import java.util.HashMap;
import java.util.Map;

public class ConfigHelper {
	
	private static ConfigHelper instance;
	private ConfigHelper(){
		
	}

	public static ConfigHelper getInstance(){
		if(instance == null){
			instance = new ConfigHelper();
		}
		return instance;
	}
	
	private Map<RestInvokeConf, Integer> restSteps = new HashMap<>();
	private Map<SoapInvokeConf, Integer> soapSteps = new HashMap<>();
	
	public RestInvokeConf getNextRestConf(){
		Integer order = 999999;
		RestInvokeConf wanted = null;
		for(RestInvokeConf conf : restSteps.keySet()){
			if(restSteps.get(conf) < order){
				order = restSteps.get(conf);
				wanted = conf;
			}
		}
		return wanted;
	}
	
	public SoapInvokeConf getNextSoapConf(){
		Integer order = 999999;
		SoapInvokeConf wanted = null;
		for(SoapInvokeConf conf : soapSteps.keySet()){
			if(soapSteps.get(conf) < order){
				order = soapSteps.get(conf);
				wanted = conf;
			}
		}
		return wanted;
	}

	public Map<RestInvokeConf, Integer> getRestSteps() {
		return restSteps;
	}

	public void setRestSteps(Map<RestInvokeConf, Integer> restSteps) {
		this.restSteps = restSteps;
	}

	public Map<SoapInvokeConf, Integer> getSoapSteps() {
		return soapSteps;
	}

	public void setSoapSteps(Map<SoapInvokeConf, Integer> soapSteps) {
		this.soapSteps = soapSteps;
	}
	
	
}

