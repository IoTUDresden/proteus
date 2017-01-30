package eu.vicci.process.client.examples.humantask;

import eu.vicci.process.client.examples.AbstractProcessRunner;

public class HumanTaskOneBoolean extends AbstractProcessRunner {

	public static void main(String[] args) {
		new HumanTaskOneBoolean().run();		
	}

	@Override
	protected String getModelFilePath() {
		return "processes/humanTask/HumanTaskOneBoolean.diagram";
	}

}
