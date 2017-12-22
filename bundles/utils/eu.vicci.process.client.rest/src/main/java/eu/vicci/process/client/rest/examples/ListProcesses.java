package eu.vicci.process.client.rest.examples;

import java.util.List;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;

public class ListProcesses extends AbstractExample {
	
	public static void main(String[] args) {
		new ListProcesses().run();
	}

	protected void run() {
		// Listing all processes which can be deployed as instances
		List<? extends IProcessInfo> infos = getClient().listDeployedProcesses();		
		for (IProcessInfo info : infos) {
			System.out.println(info.getProcessName() + " " + info.getProcessId());			
		}
		
		System.out.println();
		
		// Listing all process instances which are existing in the engine
		List<? extends IProcessInstanceInfo> instanceInfos = getClient().listDeployedProcessInstances();		
		for (IProcessInstanceInfo info : instanceInfos) {
			System.out.println(info.getProcessName() + " " + info.getProcessInstanceId());			
		}
		
	}

}
