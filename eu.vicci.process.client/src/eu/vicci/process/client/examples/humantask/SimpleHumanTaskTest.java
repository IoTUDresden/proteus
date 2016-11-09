package eu.vicci.process.client.examples.humantask;

import eu.vicci.process.client.examples.AbstractProcessRunner;

public class SimpleHumanTaskTest extends AbstractProcessRunner {

	@Override
	protected String getModelFilePath() {
		return "processes/humanTask/simpleHumanTask.diagram";
	}
	
	public static void main(String[] args) {
		SimpleHumanTaskTest test = new SimpleHumanTaskTest();
		test.run();
	}

}
