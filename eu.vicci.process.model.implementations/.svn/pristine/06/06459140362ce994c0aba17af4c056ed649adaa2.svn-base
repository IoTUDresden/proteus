package eu.vicci.process.model.sofiainstance.util;

import java.util.TimerTask;

import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;

/**
 * ProcessStepTimerTask is used to delay the execution of a ProcessStep.
 * 
 * @author Reik Mueller
 * 
 */
public class ProcessStepTimerTask extends TimerTask {

	private ProcessStepInstance processStepInstance = null;

	/**
	 * Retruns a ProcessStepTimerTask object.
	 * 
	 * @param ps
	 *            The ProcessStep that shall be delayed.
	 */
	public ProcessStepTimerTask(ProcessStepInstance ps) {
		processStepInstance = ps;
	}

	@Override
	public void run() {
		// System.err.println("Process started after Delay: "
		// + processStepInstance.getProcessStepType().getId());
		// execution occurs automatically
		processStepInstance.setPermission(ExecutionPermission.GRANTED);
	}

}
