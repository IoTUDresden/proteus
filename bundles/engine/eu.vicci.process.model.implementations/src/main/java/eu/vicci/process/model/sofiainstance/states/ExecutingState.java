package eu.vicci.process.model.sofiainstance.states;

import java.util.concurrent.CountDownLatch;

import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.DistributingProcessInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;
import eu.vicci.process.model.sofiainstance.util.CompensationWorker;
import eu.vicci.process.model.sofiainstance.util.CompensationWorker.CompensationListener;
import eu.vicci.process.model.sofiainstance.util.CompensationWorker.ExecutionFlags;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class ExecutingState extends StateBase {
	private boolean allreadyExecuted = false;
	private boolean executionSuccess = false;
	private boolean endoperationsCalled = false;

	private CompensationWorker compensationWorker;
	private CountDownLatch mWait;
	
	private ExecutionFlags executionFlags;

	/**
	 * true if the compensation is currently running
	 */
	private boolean compensationIsRunning = false;

	public ExecutingState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public boolean execute() {
		if (allreadyExecuted)
			return executionSuccess;

		allreadyExecuted = true;
		runCompensationIfNeeded();

		try {
			executionSuccess = processStep.onExecute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		waitForCompensation();
		setExecutionFlagsToOutPorts();
		
		//TODO error handling e.g. rest request for step failes 
		// -> this process will go to failed even if the compensation can execute the rest on an other address

		if (executionSuccess && processStep.allSubstepsHasFinishedExecution())
			if (processStep.allEndPortsAreDeactivatedOrActivated())
				setExecuted();
			else {
				processStep.doingEndoperations();
				endoperationsCalled = true;
			}
		else if (!executionSuccess)
			processStep.setCurrentState(new FailedState(processStep));

		return executionSuccess;
	}

	private void waitForCompensation() {
		if (!compensationIsRunning)
			return;
		
//		if(executionSuccess){
//			compensationWorker.setListener(null);
//			executionFlags = new ExecutionFlags();
//			executionFlags.hasBeenFinished = false;
//			executionFlags.hasBeenSatisfied = true;
//			mWait.countDown();
//		}

		try {
			mWait.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the execution flags of the fbs compensation to the specific endports
	 * (searchs for datatypes with matching names)
	 */
	private void setExecutionFlagsToOutPorts() {
		if (executionFlags == null)
			return;
		setOutValue(CompensationWorker.HAS_BEEN_SATISFIED, executionFlags.hasBeenSatisfied);
		setOutValue(CompensationWorker.HAS_BEEN_FINISHED, executionFlags.hasBeenFinished);
	}

	private void setOutValue(String dtName, boolean dtValue) {
//		Optional<BooleanTypeInstance> dt = processStep.getEndParameter().stream()
//				.filter(ep -> dtName.equals(ep.getName()))
//				.filter(ep -> ep instanceof BooleanTypeInstance)
//				.map(ep -> (BooleanTypeInstance) ep).findFirst();
		
		processStep.getPorts().stream()
		.filter(p -> p instanceof EndDataPortInstance)
		.map(p -> (EndDataPortInstance)p)
		.filter(p -> p.getDataInstance() instanceof BooleanTypeInstance)
		.filter(p -> dtName.equals(p.getDataInstance().getName()))
		.forEach(p -> {
			BooleanTypeInstance dti = (BooleanTypeInstance)p.getDataInstance();
			dti.setValue(dtValue);
			LifeCycleManager.INSTANCE.activatePort(p, dti);
		});
		
//		if (!dt.isPresent())
//			return;
		
//		BooleanTypeInstance bdt = dt.get();
//		bdt.setValue(dtValue);
//		processStep.getReturnValues().remove(bdt);
//		processStep.getReturnValues().add(bdt);
	}

	@Override
	public void processExecuted(ProcessStepInstanceImplCustom process) {
		setExecutedOrDoingEndoperations();
	}

	@Override
	public void portExecutionStateChanged(PortInstance port) {
		setExecutedOrDoingEndoperations();
	}

	@Override
	public State getSimpleState() {
		return State.EXECUTING;
	}

	@Override
	public void escalate() {
		processStep.onEscalate();
		processStep.setCurrentState(new EscalatedState(processStep));
		processStep.postEscalated();
	}

	private void setExecuted() {
		processStep.setCurrentState(new ExecutedState(processStep));
		processStep.postExecuted();
	}

	private boolean isAllFinished() {
		return processStep.allSubstepsHasFinishedExecution() && processStep.allEndPortsAreDeactivatedOrActivated();
	}

	private void setExecutedOrDoingEndoperations() {
		if (isAllFinished())
			setExecuted();
		else if (!endoperationsCalled && processStep.allSubstepsHasFinishedExecution()) {
			processStep.doingEndoperations();
			endoperationsCalled = true;
		}
	}

	private void runCompensationIfNeeded() {
		String goal = processStep.getProcessStepType().getGoal();
		compensationIsRunning = goal != null && !goal.isEmpty();
		if (!compensationIsRunning)
			return;

		mWait = new CountDownLatch(1);

		compensationWorker = new CompensationWorker();
		compensationWorker.setListener(compensationListener);
		compensationWorker.setInstanceId(processStep.getInstanceId());
		compensationWorker.addGoal(goal);
		compensationWorker.setWorkflowName("Workflow_" + processStep.getProcessStepType().getName());

		Thread workerThread = new Thread(compensationWorker);
		workerThread.setDaemon(true);
		workerThread.setName("Compensation_" + processStep.getInstanceId());
		workerThread.start();
	}

	private final CompensationListener compensationListener = new CompensationListener() {
		@Override
		public void compensationFinished(ExecutionFlags flags) {
			executionFlags = flags;
			compensationIsRunning = false;
			mWait.countDown();
			if(processStep instanceof DistributingProcessInstanceImplCustom)
				((DistributingProcessInstanceImplCustom)processStep).finishDistribution();
		}
	};
}
