package eu.vicci.process.model.sofiainstance.util;

import java.util.List;
import java.util.Timer;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.State;

public interface InternalProcessStepInterface {

	public Timer getTimer();

	public void setTimer(Timer timer);

	public ProcessStepTimerTask getTimerTask();

	public void setTimerTask(ProcessStepTimerTask timerTask);

	public List<DataTypeInstance> getStartParameter();

	public void setStartParameter(List<DataTypeInstance> startParameter);

	public List<DataTypeInstance> getReturnValues();

	public void setReturnValues(List<DataTypeInstance> returnValues);

	public void work();
	
	public boolean allStartPortsActive();

	public void forwardReactivation();

	public void changeExecutionState(State state);

	public void startSubProcesses();

	public void cancelTimer();

	public void aggregateStartParameter();

	public void aggregateEndParameter();
	
	public void activateDataEndPorts();

	public void activateControlEndPorts();

	public void executeDelay();

	public void logInfo(String info);
}
