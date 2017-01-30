package eu.vicci.process.model.sofiainstance.impl.custom;

import javax.xml.bind.annotation.XmlRootElement;

import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.impl.ConfigurationImpl;

@XmlRootElement(name = "Configuration")
public class ConfigurationImplCustom extends ConfigurationImpl {
	public ConfigurationImplCustom() {
		this.decoupleNextSteps = false;
		this.permission = ExecutionPermission.GRANTED;
		this.delay = 0;
		this.instanceId = null;
	}
	
	
}
