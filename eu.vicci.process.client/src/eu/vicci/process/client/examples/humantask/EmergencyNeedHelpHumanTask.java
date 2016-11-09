package eu.vicci.process.client.examples.humantask;

import eu.vicci.process.client.examples.AbstractProcessRunner;

public class EmergencyNeedHelpHumanTask extends AbstractProcessRunner {
	
	public static void main(String[] args) {
		EmergencyNeedHelpHumanTask humanTask = new EmergencyNeedHelpHumanTask();
		humanTask.run();
	}

	@Override
	protected String getModelFilePath() {
		return "processes/humanTask/emergencyNeedHelpHumanTask.diagram";
	}

}
