package eu.vicci.process.client.examples.humantask;

import eu.vicci.process.client.examples.AbstractProcessRunner;

public class HumanTaskKodiMessageDemo extends AbstractProcessRunner {
	
	public static void main(String[] args) {
		HumanTaskKodiMessageDemo demo = new HumanTaskKodiMessageDemo();
		demo.run();
	}

	@Override
	protected String getModelFilePath() {
		return "processes/humanTask/humanTaskKodiMessageDemo.diagram";
	}
	

}
