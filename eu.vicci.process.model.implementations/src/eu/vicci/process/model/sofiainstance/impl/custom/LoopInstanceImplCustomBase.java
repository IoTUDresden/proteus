package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.Map.Entry;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EndPortInstance;
import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.LoopInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public abstract class LoopInstanceImplCustomBase extends ProcessStepInstanceImplCustom implements
		LoopInstance {

	protected ConditionInstance loopConditionInstance;
	protected boolean resetRequested = false;
	protected EMap<EndDataPortInstance, StartDataPortInstance> portsCopyToStartport = new BasicEMap<EndDataPortInstance, StartDataPortInstance>();

	@Override
	public boolean onExecute() {
		logInfo("-------------> execution started");
		cancelTimer();
		aggregateStartParameter();
		aggregateEndParameter();
		startStateTimerIfNeeded();

		if (anyEndPortsWhichRequiresWaiting())
			changeEndPortStates(State.WAITING);
		else
			work();
		return true;
	}

	@Override
	public void preReset() {
		resetRequested = true;
		super.preReset();
	}

	@Override
	public void portExecutionStateChanged(PortInstance port) {
		switch (port.getExecutionState()) {
		case WAITING:
			if (allEndPortsHaveTheState(State.WAITING))
				work();
			break;
		case INACTIVE:
			if (allEndPortsHaveTheState(State.INACTIVE)) {
				doingEndoperations();
				super.portExecutionStateChanged(port);
			}
			break;
		default:
			super.portExecutionStateChanged(port);
			break;
		}
	}

	/**
	 * Does the step in the loop. (All subprocesses will be executed)
	 * 
	 * @return
	 */
	protected boolean doLoopStep() {
		if (!loopConditionInstance.evaluate())
			return false;		
		startSubProcesses();
		return true;
	}

	@Override
	public abstract void work();

	@Override
	public ConditionInstance getLoopConditionInstance() {
		return loopConditionInstance;
	}

	@Override
	public void setLoopConditionInstance(ConditionInstance value) {
		this.loopConditionInstance = value;
	}

	@Override
	public EMap<EndDataPortInstance, StartDataPortInstance> getPortsCopyToStartport() {
		return portsCopyToStartport;
	}

	/**
	 * Performs the next step, if it is possible. All substeps must be in the
	 * state inactive and the condition.evaluate() must be true.
	 * 
	 * @return
	 */
	protected boolean performNextStepIfPossible() {
		if ((!allSubstepsAreReset() || !loopConditionInstance.evaluate()))
			return false;
		checkArgs();
		return doLoopStep();
	}

	/**
	 * Method should check the arguments which are passed to the loop. If the
	 * arguments not ok, than throw an exception.
	 */
	protected abstract void checkArgs();

	/**
	 * Changes the State of all endports (the EscalationEndport is not changed).
	 * 
	 * @param newState
	 */
	protected void changeEndPortStates(State newState) {
		getPorts()
				.stream()
				.filter(p -> p instanceof EndPortInstance && !(p instanceof EscalationPortInstance))
				.forEach(p -> LifeCycleManager.INSTANCE.changePortExecutionState(p, newState));
	}

	/**
	 * Sets the defined startdataports with the datatypeinstance from the defined enddataports.
	 * Mapping is defined in the 'portsCopyToStartport' map.
	 */
	protected void copyEndDataPortValuesToStartDataPorts() {
		DataTypeInstance dataTypeInstance = null;
		for (Entry<EndDataPortInstance, StartDataPortInstance> entry : portsCopyToStartport){
			dataTypeInstance = entry.getKey().getDataInstance();
			LifeCycleManager.INSTANCE.setPortDataTypeInstanceSync(entry.getValue(), dataTypeInstance.copy());
		}
	}

	private boolean anyEndPortsWhichRequiresWaiting() {
		return getPorts().stream().anyMatch(
				p -> p instanceof EndPortInstance && !(p instanceof EscalationPortInstance));
	}

	@Override
	public void activateDataEndPorts() {
		if (!returnValues.isEmpty()) {
			super.activateDataEndPorts();
		}
		getPorts()
				.stream()
				.filter(port -> port instanceof EndDataPortInstance)
				.forEach(
						port -> LifeCycleManager.INSTANCE.activatePortSync(port,
								((EndDataPortInstance) port).getDataInstance()));
	}
}
