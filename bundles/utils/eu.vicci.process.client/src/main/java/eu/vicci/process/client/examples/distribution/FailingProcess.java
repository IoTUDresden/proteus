package eu.vicci.process.client.examples.distribution;

import eu.vicci.process.client.examples.AbstractProcessRunner;
import eu.vicci.process.model.sofia.Process;

public class FailingProcess extends AbstractProcessRunner {
	private final String ID_DIST_1 = "_T49g0ElPEeelBtkG3Ey9fQ";
	
	//change this to the peer id where the process should be executed on
	private final String IP_DIST_1 = "192.168.2.101";
	
	//change this to true, if you want to distribute the process
	private final boolean DISTRIBUTED = true;

	public static void main(String[] args) {
		new FailingProcess().run();		
	}

	@Override
	protected String getModelFilePath() {
		return "processes/distributed/FailingProcess.diagram";
	}
	
	@Override
	protected void doProcessChange(Process process) {
		Process dist1 = (Process)process.getSubSteps().stream()
				.filter(p -> p.getId().equals(ID_DIST_1))
				.findFirst().get();
		dist1.setExecutionPeer(IP_DIST_1);
		dist1.setDistributed(DISTRIBUTED);
	}
	
	@Override
	protected boolean doProcessChangesBeforeUploading() {
		return true;
	}
}
