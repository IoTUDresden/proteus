package eu.vicci.process.client.example.feedback;

import eu.vicci.process.client.examples.AbstractProcessRunner;

public class CoffeeProcess extends AbstractProcessRunner {
	
	public static void main(String[] args) {
		new CoffeeProcess().run();
	}

	@Override
	protected String getModelFilePath() {
		return "processes/feedback/CoffeeProcess.diagram";
	}

}
