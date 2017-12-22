package eu.vicci.process.server.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.server.exception.NotFoundErrorException;
import eu.vicci.process.server.util.RuntimeContext;
import static eu.vicci.process.server.rest.Messages.*;

@Path("processinstances")
public class ProcessInstanceManagerRest {
	private final IProcessManager processManager;
	
	public ProcessInstanceManagerRest() {
		processManager = RuntimeContext.getInstance().getProcessManager();		
	}
	
	// List all available process instances
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<IProcessInstanceInfo> deployedProcesseInstances() {
		return processManager.listProcessInstances();
	}
	
	// Start a ProcessInstance
	@POST
	@Path("{processInstanceId}")
	public void executeProcess(@PathParam("processInstanceId") String processInstanceId) 
			throws NotFoundErrorException
	{
		ProcessInstance pi = processManager.getProcessInstanceInfos(processInstanceId);
		if(pi == null)
			throw new NotFoundErrorException(ERR_PROCESS_INSTANCE_WITH_ID_NOT_FOUND, processInstanceId);
		processManager.startProcessInstance(processInstanceId, null);
	}
	
		

}
