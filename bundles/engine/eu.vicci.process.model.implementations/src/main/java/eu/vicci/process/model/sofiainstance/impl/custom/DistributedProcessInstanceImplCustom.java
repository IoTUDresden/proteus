package eu.vicci.process.model.sofiainstance.impl.custom;

public class DistributedProcessInstanceImplCustom extends ProcessInstanceImplCustom {
	
	@Override
	protected String getOriginalProcessInstanceId() {
		return getRunningForInstanceId();
	}

}
