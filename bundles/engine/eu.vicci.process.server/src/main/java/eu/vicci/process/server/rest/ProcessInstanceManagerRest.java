package eu.vicci.process.server.rest;

import static eu.vicci.process.server.rest.Messages.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.server.exception.BadRequestException;
import eu.vicci.process.server.exception.NotFoundErrorException;
import eu.vicci.process.server.util.RuntimeContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("processinstances")
@Api(tags = { "processinstances" })
public class ProcessInstanceManagerRest{
	private final IProcessManager processManager;

	public ProcessInstanceManagerRest() {
		processManager = RuntimeContext.getInstance().getProcessManager();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "List all available process instances", 
		response = IProcessInstanceInfo.class, 
		responseContainer = "List")
	public List<IProcessInstanceInfo> deployedProcesseInstances() {
		return processManager.listProcessInstances();
	}

	@POST
	@Path("{processInstanceId}")
	@ApiOperation(value = "Start the given process instance.")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Process instance with the given id was not found."),
			@ApiResponse(code = 200, message = "Process instance was started.") })
	public void executeProcess(
			@ApiParam(value = "Process instance id for the process which should be started.", required = true) 
			@PathParam("processInstanceId") String processInstanceId)
			throws NotFoundErrorException 
	{
		ProcessInstance pi = processManager.getProcessInstanceInfos(processInstanceId);
		if (pi == null)
			throw new NotFoundErrorException(ERR_PROCESS_INSTANCE_WITH_ID_NOT_FOUND, processInstanceId);
		processManager.startProcessInstance(processInstanceId, null);
	}

	@GET
	@Path("recentstate/{processInstanceId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get the latest state message for the given process instance.", 
		response = IStateChangeMessage.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Latest state message found and returned."),
			@ApiResponse(code = 400, message = "Latest state message found and returned."),
			@ApiResponse(code = 404, message = "No state message found for the given process.") })
	public Response getRecentState(
			@ApiParam(value = "Process instance id for the process you want to have the latest state message.", required = true) 
			@PathParam("processInstanceId") String instanceId)
			throws BadRequestException, NotFoundErrorException 
	{		
		if (instanceId == null || instanceId.isEmpty())
			throw new BadRequestException(ERR_MISSING_INSTANCE_ID);

		Optional<IStateChangeMessage> recentMessage = processManager.getRecentStateChanges().stream()
				.filter(m -> instanceId.equals(m.getInstanceId()))
				.sorted(Comparator
						.comparing(IStateChangeMessage::getTimestamp)
						.thenComparing(IStateChangeMessage::getTimestamp)
						.reversed())
				.findFirst();

		if (!recentMessage.isPresent())
			throw new NotFoundErrorException(ERR_STATE_NOT_FOUND_FOR, instanceId);
	
		return Response.ok(recentMessage.get()).build();
	}

}
