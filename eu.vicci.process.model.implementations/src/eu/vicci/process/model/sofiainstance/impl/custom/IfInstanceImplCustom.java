package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofia.FalseTransition;
import eu.vicci.process.model.sofia.TrueTransition;
import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.IfInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class IfInstanceImplCustom extends ProcessStepInstanceImplCustom implements IfInstance {

	private Boolean conditionEvaluationResult = false;
	private ConditionInstance conditionInstance;

	public void work() {
		ConditionInstance ci = this.getIfConditionInstance();
		conditionEvaluationResult = ci.evaluate();
		returnValues = startParameter;
	}

	@Override
	public void activateDataEndPorts() {
		getPorts().stream().filter(port -> port instanceof EndDataPortInstance)
				.forEach(port -> activateOrDeactivateDataEndPort(port));
	}

	@Override
	public void activateControlEndPorts() {
		getPorts().stream().filter(port -> port instanceof EndControlPortInstance)
				.forEach(port -> activateOrDeactivateControlEndPort(port));
	}

	@Override
	public ConditionInstance getIfConditionInstance() {
		return conditionInstance;
	}

	@Override
	public void setIfConditionInstance(ConditionInstance value) {
		conditionInstance = value;
	}

	@Override
	public void forwardReactivation() {

	}

	private void activateOrDeactivateDataEndPort(PortInstance port) {
		if (port.getOutTransitionInstances().isEmpty()) {
			LifeCycleManager.INSTANCE.deactivatePort(port);
			return;
		}

		TransitionInstance transitionInstance = port.getOutTransitionInstances().get(0);
		if ((conditionEvaluationResult && transitionInstance instanceof TrueTransition)
				|| (!conditionEvaluationResult && transitionInstance instanceof FalseTransition)) {
			activateDataEndPort(port);
		} else
			LifeCycleManager.INSTANCE.deactivatePort(port);
	}

	private void activateDataEndPort(PortInstance port) {
		DataPortInstance port1 = (DataPortInstance) port;
		for (DataTypeInstance dataInstance : returnValues) {
			// preparing names for matching
			String dataId = dataInstance.getDataTypeType().getName();
			String wantedDataId = port1.getDataInstance().getDataTypeType().getName();
			// matching names
			if (dataId.equals(wantedDataId)) {
				LifeCycleManager.INSTANCE.activatePortSync(port, dataInstance);
			}
		}
	}

	private void activateOrDeactivateControlEndPort(PortInstance port) {
		if (port.getOutTransitionInstances().size() <= 0) {
			LifeCycleManager.INSTANCE.deactivatePort(port);
			return;
		}

		TransitionInstance transitionInstance = port.getOutTransitionInstances().get(0);
		if ((conditionEvaluationResult && transitionInstance.getTransitionType() instanceof TrueTransition)
				|| (!conditionEvaluationResult && transitionInstance.getTransitionType() instanceof FalseTransition))
			LifeCycleManager.INSTANCE.activatePortSync(port);
		else
			LifeCycleManager.INSTANCE.deactivatePort(port);
	}
}