package eu.vicci.process.client.demo;

import eu.vicci.process.client.examples.AbstractProcessRunner;

public class PaperTurtleDemo extends AbstractProcessRunner {
	
	public static void main(String[] args) {
		new PaperTurtleDemo().run();
	}

	@Override
	protected String getModelFilePath() {
		return "processes/demo/PaperTurtle.diagram";
	}

}
