package eu.vicci.process.model.sofiainstance.util;

import java.util.TimerTask;

import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;

public class CheckStateTask extends TimerTask {
	
	public ProcessStepInstance processStepInstance;
	public long timeOut;
	public Thread InterruptedThread;
	
	@Override
	public void run() {
		System.out.println("Checking state, Timeout: "+timeOut );
		if (!processStepInstance.getExecutionState().equals(State.EXECUTED)) {
			LifeCycleManager.INSTANCE.escalateProcessStep(processStepInstance);
				processStepInstance.escalate();
		}
		
	}

	public ProcessStepInstance getProcessStepInstance() {
		return processStepInstance;
	}

	public void setProcessStepInstance(ProcessStepInstance processStepInstance) {
		this.processStepInstance = processStepInstance;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}

	public Thread getInterruptedThread() {
		return InterruptedThread;
	}

	public void setInterruptedThread(Thread interruptedThread) {
		InterruptedThread = interruptedThread;
	}
	
	

}
