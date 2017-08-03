package eu.vicci.process.client.examples.distribution;

import eu.vicci.process.client.examples.AbstractProcessRunner;
import eu.vicci.process.model.sofia.Process;

public class MoveTurtle extends AbstractProcessRunner{
	private final String ID_DIST_1 = "_5bkv0HawEeexVf8Jvgvr3w";
	
	//change this to the peer id where the process should be executed on first
	private final String IP_DIST_1 = "192.168.1.56";
	

	@Override
	protected String getModelFilePath() {
		return "processes/distributed/MoveTurtle.diagram";
	}
	
	@Override
	protected boolean doProcessChangesBeforeUploading() {
		return true;
	}
	
	@Override
	protected void doProcessChange(Process process) {
		Process dist1 = (Process)process.getSubSteps().stream()
				.filter(p -> p.getId().equals(ID_DIST_1))
				.findFirst().get();
		dist1.setExecutionPeer(IP_DIST_1);
		dist1.setDistributed(true);
	}
	
	public static void main(String[] args) {
		new MoveTurtle().run();		
	}

}
