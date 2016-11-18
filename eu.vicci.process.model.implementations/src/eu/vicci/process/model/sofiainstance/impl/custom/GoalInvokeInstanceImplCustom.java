package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.ArrayList;
import java.util.List;

import eu.vicci.openhab.util.IOpenHabRestClient;
import eu.vicci.openhab.util.OpenHabRestClient;
import eu.vicci.openhab.util.beans.ExecuteGoalCommandBean;
import eu.vicci.openhab.util.beans.Goal;
import eu.vicci.openhab.util.beans.Quality;
import eu.vicci.openhab.util.beans.SemanticLocation;
import eu.vicci.process.model.sofia.GoalInvoke;
import eu.vicci.process.model.sofiainstance.GoalInvokeInstance;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;

public class GoalInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements GoalInvokeInstance{
	
	@Override
	public void work() {
		// TODO steffen: implement me
		String serverBaseUri = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.OPENHAB_URI);
		IOpenHabRestClient client = new OpenHabRestClient(serverBaseUri);
		
		ExecuteGoalCommandBean cmd = getCommand();

		client.executeGoal(cmd);				
	}
	
	//maps the modeled stuff to a command
	private ExecuteGoalCommandBean getCommand(){
		GoalInvoke gi = getGoalInvoke();
		ExecuteGoalCommandBean cmd = new ExecuteGoalCommandBean();
		Goal goal = new Goal();
		goal.name = gi.getGoal();
		SemanticLocation sl = new SemanticLocation();
		sl.setSemanticUri(gi.getLocation());				
		
		cmd.goal = goal;
		cmd.location = sl;
		cmd.qualities = mapQuality(gi);		
		return cmd;
	}
	
	private static List<Quality> mapQuality(GoalInvoke gi){
		List<Quality> out = new ArrayList<>();
		for (String qualiName : gi.getQuality()) {
			Quality quality = new Quality();
			quality.name = qualiName;
			out.add(quality);
		}
		return out;
	}
	
	private GoalInvoke getGoalInvoke(){
		return (GoalInvoke)getProcessStepType();		
	}


}
