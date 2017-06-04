package eu.vicci.process.client.examples.distribution;

import eu.vicci.process.client.examples.AbstractProcessRunner;
import eu.vicci.process.model.sofia.Process;

public class DistributedProcess extends AbstractProcessRunner {
	private static final String ID_DIST_1 = "_N62RQNl9EeaER9UBQCFXlQ";
	
	//IP for the peer
	private static final String IP_DIST_1 = "192.168.2.101";
	
	public static void main(String[] args) {
		new DistributedProcess().run();
	}
	
	@Override
	protected void doProcessChange(Process process) {
		Process dist1 = (Process)process.getSubSteps().stream()
				.filter(p -> p.getId().equals(ID_DIST_1))
				.findFirst().get();
		dist1.setExecutionPeer(IP_DIST_1);
	}
	
	@Override
	protected boolean doProcessChangesBeforeUploading() {
		return true;
	}

	@Override
	protected String getModelFilePath() {
		return "processes/distributed/DistributedSimple.diagram";
	}

}
