package eu.vicci.process.server.rest;

import javax.ws.rs.Path;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.server.util.RuntimeContext;

@Path("processinstances")
public class ProcessInstanceManagerRest {
	private final IProcessManager processManager;
	
	public ProcessInstanceManagerRest() {
		processManager = RuntimeContext.getInstance().getProcessManager();		
	}
	
	
	

}
