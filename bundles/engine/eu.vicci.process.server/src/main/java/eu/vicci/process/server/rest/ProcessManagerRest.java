package eu.vicci.process.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.server.util.RuntimeContext;

//TODO use swagger.io for api description
@Path("processes")
public class ProcessManagerRest {
	private final IProcessManager processManager;
	
	public ProcessManagerRest() {	
		processManager = RuntimeContext.getInstance().getProcessManager();		
	}

	public IProcessManager getProcessManager() {
		return processManager;
	}
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String uploadAndDeploy(){
		return "ready? " + (processManager != null);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String allProcesses(){
		return "returns all processes";		
	}
	

}
