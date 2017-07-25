package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.Map;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.StartControlPortInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class ProcessInstanceImplCustom extends ProcessStepInstanceImplCustom implements ProcessInstance {
	private String runningForInstanceId;

	@Override
	public boolean start(Map<String, DataTypeInstance> parameters) {
		logInfo("Prozess start");
		if (parameters != null && !parameters.isEmpty())
			activateStartDataPortsWithParamter(parameters);
		else
			getPorts().stream().filter(port -> port instanceof StartDataPortInstance)
					.forEach(port -> tryActivateStartDataPort((StartDataPortInstance) port));

		for (PortInstance pi : getPorts()) {
			if (pi instanceof StartControlPortInstance) {
				StartControlPortInstance scpi = (StartControlPortInstance) pi;
				LifeCycleManager.INSTANCE.activatePort(scpi);
			}
		}
		return true;
	}

	private void tryActivateStartDataPort(StartDataPortInstance port) {
		if (port.getDataInstance() == null && port.getExecutionState() == State.INACTIVE)
			return;
		LifeCycleManager.INSTANCE.activatePort(port, port.getDataInstance());
	}

	@Override
	public void work() {
		returnValues = startParameter;
	}

	private void activateStartDataPortsWithParamter(Map<String, DataTypeInstance> parameters) {
		for (String s : parameters.keySet()) {
			for (PortInstance pi : getPorts()) {
				if (pi instanceof StartDataPortInstance) {
					StartDataPortInstance sdpi = (StartDataPortInstance) pi;
					if (sdpi.getDataInstance().getDataTypeType().getId().equals(s)) {
						DataTypeInstance dti = parameters.get(s);
						checkData(dti);
						LifeCycleManager.INSTANCE.activatePort(sdpi, dti);
					}
				}
			}
		}
	}

	private void checkData(DataTypeInstance dataTypeInstance) {
		if (dataTypeInstance.getDataTypeType() == null)
			throw new IllegalArgumentException(
					"At least one of the start parameters is not configured properly. The DataType is missing for "
							+ dataTypeInstance.getName());

	}

	@Override
	public String getRunningForInstanceId() {
		return runningForInstanceId;
	}

	@Override
	public void setRunningForInstanceId(String value) {
		runningForInstanceId = value;		
	}
}
