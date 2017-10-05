package eu.vicci.process.client.example.feedback;

import eu.vicci.process.client.examples.AbstractProcessRunner;
import eu.vicci.process.model.sofia.Process;

public class BatteryTurtle extends AbstractProcessRunner {
	private static final String EXEC_PEER = "192.168.1.56";
	private static final String REMOTE_NAME = "MoveRemote";
	
	public static void main(String[] args) {
		new BatteryTurtle().run();
	}

	@Override
	protected String getModelFilePath() {
		return "processes/feedback/MoveTurtleBatteryCheck.diagram";
	}
	
	@Override
	protected boolean doProcessChangesBeforeUploading() {
		return true;
	}
	
	@Override
	protected void doProcessChange(Process process) {
		Process dist1 = (Process)process.getSubSteps().stream()
				.filter(p -> p.getName().equals(REMOTE_NAME))
				.findFirst().get();
		dist1.setExecutionPeer(EXEC_PEER);
	}

}

//TODO complete query
//MATCH (process:NeoProcess {id: '_N62RQNl9EeaER9UBQCFXlQ_Instance_1'}) 
//MATCH (remote:NeoProcess)-[REMOTE_FOR]->(process)
//MATCH (peer1:NeoPeer {name: 'turtlebot2-X201EP'})
//MATCH (peer2:NeoPeer {name: 'tb-Satellite-R630'})
//MATCH (remote)-[runsOn2:RUNS_ON]->(peer2)
//MATCH (peer)-[HAS_METRIC]->(metric1:NeoPeerMetric)
//MATCH (peer2)-[HAS_METRIC]->(metric2:NeoPeerMetric)
//RETURN
//CASE WHEN metric IS NOT NULL AND metric.hasBattery = true THEN metric.batteryValue ELSE 100 END AS state
//CASE WHEN runsOn2 IS NOT NULL THEN peer2 ELSE peer1 AS peer
//CASE WHEN process IS NOT NULL THEN id(process) ELSE 0 END AS nodeId
