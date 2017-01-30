package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.distribution.core.IDistributionManager;
import eu.vicci.process.distribution.manager.DistributionManager;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.sofiainstance.util.RemoteStepInvokeWorker;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;

public class DistributingProcessInstanceImplCustom extends ProcessInstanceImplCustom {
	private RemoteStepInvokeWorker worker;
	private IDistributionManager distributionManager = DistributionManager.getInstance();

	@Override
	public boolean onExecute() {
		LOGGER.debug("Distributed Process Step, start remote execution");

		if (distributionManager == null)
			throw new IllegalArgumentException(ERR_NO_DIST_MGR);
		worker = new RemoteStepInvokeWorker(this, distributionManager);
		worker.work(); // blocks till finished

		// TODO check if this is working
		// - we dont need to wait for the subprocesses as they are executed on
		// the peer
		// - what is done with the state change messages? we must delegate them
		// to the super peer
		doingEndoperations();
		return true;
	}
	
	@Override
	public boolean allSubstepsHasFinishedExecution() {
		return true; // we dont have to wait for the substeps as they were executed on the peer.
	}

	/**
	 * Sets the an {@link IDistributionManager} for distributing this process.
	 * 
	 * @param distributionManager
	 */
	public void setDistributionManager(IDistributionManager distributionManager) {
		this.distributionManager = distributionManager;
	}

	@Override
	public void activateDataEndPorts() {
		getPorts().stream().filter(p -> p instanceof EndDataPortInstance)
				.forEach(p -> activateEndDataPort((EndDataPortInstance) p));
	}

	@Override
	public void activateControlEndPorts() {
		getPorts().stream().filter(p -> p instanceof EndControlPortInstance)
				.forEach(p -> activateEndControlPort((EndControlPortInstance) p));
	}

	private void activateEndControlPort(EndControlPortInstance port) {
		IJSONPortInstance remote = worker.getEndControlPorts().get(port.getPortType().getId());
		checkControl(remote);
		if (remote.getExecutionState() == State.ACTIVE)
			LifeCycleManager.INSTANCE.activatePortSync(port);
		else
			LifeCycleManager.INSTANCE.deactivatePort(port);
	}

	private void checkControl(IJSONPortInstance remote) {
		if (remote == null)
			throw new RuntimeException(ERR_PEER_MISS_PORT);
	}

	// activates or deactivates the port with the received data
	private void activateEndDataPort(EndDataPortInstance port) {
		IJSONDataPortInstance remote = worker.getEndDataPorts().get(port.getPortType().getId());
		checkData(port.getDataInstance(), remote);
		if (remote.getExecutionState() == State.ACTIVE) {
			safeValueSetting(port.getDataInstance(), remote.getDataTypeInstance());
			LifeCycleManager.INSTANCE.activatePortSync(port, port.getDataInstance());
		} else {
			LifeCycleManager.INSTANCE.deactivatePort(port);
		}
	}

	private void checkData(DataTypeInstance original, IJSONDataPortInstance remote) {
		if (remote == null || remote.getDataTypeInstance() == null || remote.getDataTypeInstance().getDataType() == null
				|| remote.getDataTypeInstance().getDataType().getID() == null)
			throw new RuntimeException(ERR_MISS_PORT_OR_CUR);
		if (!original.getDataTypeType().getId().equals(remote.getDataTypeInstance().getDataType().getID()))
			throw new RuntimeException(ERR_DIFF_DT);
	}

	// TODO complete with other values
	private void safeValueSetting(DataTypeInstance original, IJSONTypeInstance remote) {
		if (original instanceof StringTypeInstance)
			((StringTypeInstance) original).setValue((String) remote.getValueAsObject());
		else if (original instanceof DoubleTypeInstance)
			((DoubleTypeInstance) original).setValue((Double) remote.getValueAsObject());
		else if (original instanceof IntegerTypeInstance)
			((IntegerTypeInstance) original).setValue((Integer) remote.getValueAsObject());
		else if (original instanceof BooleanTypeInstance)
			((BooleanTypeInstance) original).setValue((Boolean) remote.getValueAsObject());
		else
			throw new RuntimeException("Not supported DataTypeInstance for remote processing. Class: "
					+ original.getClass().getSimpleName());
	}
	
	private static final String ERR_MISS_PORT_OR_CUR = "Cant activate or deactivate EndDataPort. "
					+ "Port is missing on peer side or data received is corrupt";
	
	private static final String ERR_DIFF_DT = "Different Type Id on data received from remote peer";
	
	private static final String ERR_PEER_MISS_PORT = "Cant activate or deactivate EndControlPort. Port is missing on peer side.";
	
	private static final String ERR_NO_DIST_MGR = "no DistributionManager available. "
					+ "Cant remote execute process. At the moment no option implemented to execute the process local in this case";

}
