package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofia.GoalInvoke;
import eu.vicci.process.model.sofiainstance.GoalInvokeInstance;

public class GoalInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements GoalInvokeInstance{
	
	@Override
	public void work() {
		// TODO steffen: implement me
		
		String test = getGoalInvoke().getInvokeGoal();
		System.out.println("Goal: " + test);
				
	}
	
	private GoalInvoke getGoalInvoke(){
		return (GoalInvoke)getProcessStepType();		
	}


}
