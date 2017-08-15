package eu.vicci.process.client.example.feedback;

import eu.vicci.process.client.examples.AbstractProcessRunner;

public class MoveTurtleWhileFeedback extends AbstractProcessRunner{
	
	public static void main(String[] args) {
		//in default it tries to drive to person 'Ronny'
		new MoveTurtleWhileFeedback().run();
	}

	@Override
	protected String getModelFilePath() {
		return "processes/feedback/MoveTurtleHumanTask.diagram";
	}

}
