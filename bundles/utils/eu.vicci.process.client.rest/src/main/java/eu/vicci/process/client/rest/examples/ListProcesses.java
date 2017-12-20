package eu.vicci.process.client.rest.examples;

import java.util.List;

import eu.vicci.process.engine.core.IProcessInfo;

public class ListProcesses extends AbstractExample {
	
	public static void main(String[] args) {
		new ListProcesses().run();
	}

	protected void run() {
		List<? extends IProcessInfo> infos = getClient().listDeployedProcesses();
		
		for (IProcessInfo info : infos) {
			System.out.println(info.getProcessName() + " " + info.getProcessId());			
		}
	}

}
