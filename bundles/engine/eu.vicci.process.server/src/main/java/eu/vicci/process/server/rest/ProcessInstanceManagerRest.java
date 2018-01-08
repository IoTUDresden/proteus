package eu.vicci.process.server.rest;

import static eu.vicci.process.server.rest.Messages.ERR_MISSING_INSTANCE_ID;
import static eu.vicci.process.server.rest.Messages.ERR_PROCESS_INSTANCE_WITH_ID_NOT_FOUND;
import static eu.vicci.process.server.rest.Messages.ERR_STATE_NOT_FOUND_FOR;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONProcessStepInstanceSerializer;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONProcessStepInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;
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
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Start the given process instance.")
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Process instance with the given id was not found."),
			@ApiResponse(code = 204, message = "Process instance was started.") })
	public void executeProcess(
			@ApiParam(value = "Process instance id for the process which should be started.", required = true) 
			@PathParam("processInstanceId") String processInstanceId,
			@ApiParam(value = "Input parameters map.", required = false)
			Map<String, IJSONTypeInstance> inputParameters)	throws NotFoundErrorException 
	{
		ProcessInstance pi = processManager.getProcessInstanceInfos(processInstanceId);
		if (pi == null)
			throw new NotFoundErrorException(ERR_PROCESS_INSTANCE_WITH_ID_NOT_FOUND, processInstanceId);
		
		Map<String, DataTypeInstance> convertedInputParameters = createConvertedInputParameters(inputParameters);		
		processManager.startProcessInstance(processInstanceId, convertedInputParameters);
	}
	
	@GET
	@Path("{processInstanceId}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Get the Process Step Instance. Only available for the root processes.", 
		response = IJSONProcessStepInstance.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Process instance with the given id was not found."),
			@ApiResponse(code = 200, message = "Process instance was found and returned.") })
	public Response getProcessInstance(
			@ApiParam(value = "Process instance id for the process which should be started.", required = true)
			@PathParam("processInstanceId") String processInstanceId) throws NotFoundErrorException
	{		
		ProcessInstance processInstance = processManager.getProcessInstanceInfos(processInstanceId);
		if(processInstance == null)
			throw new NotFoundErrorException(ERR_PROCESS_INSTANCE_WITH_ID_NOT_FOUND, processInstanceId);
		
		IJSONProcessStepInstance json = JSONProcessStepInstanceSerializer.makeJSONProcessStepInstance(processInstance);	
		
		return Response
				.ok(json)
				.type(MediaType.APPLICATION_JSON)
				.build();		
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
	
	private static Map<String, DataTypeInstance> createConvertedInputParameters(Map<String, IJSONTypeInstance> inputParameters){
		if(inputParameters == null)
			return null;
		Map<String, DataTypeInstance> converted = new HashMap<String, DataTypeInstance>();
		for (String portName : inputParameters.keySet()) {
			IJSONTypeInstance json = inputParameters.get(portName);
			DataTypeInstance dti = json.makeDataTypeInstance(SofiaInstanceFactoryImplCustom.getInstance());
			converted.put(portName, dti);
		}		
		return converted;		
	}

}
