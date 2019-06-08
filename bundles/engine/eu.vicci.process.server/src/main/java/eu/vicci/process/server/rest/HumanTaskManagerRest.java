package eu.vicci.process.server.rest;

import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.vicci.process.model.util.messages.HumanTaskMessageManager;
import eu.vicci.process.model.util.messages.HumanTaskResponse;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;
import eu.vicci.process.server.exception.BadRequestException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Rest API for HumanTasks
 * Is picked up by ProteusHttpServer.
 */
@Path("humantasks")
@Api(tags = { "humantasks" })
public class HumanTaskManagerRest {

	public HumanTaskManagerRest() {
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "send a new human task response")
	public void addHumanTaskResponse(
			@ApiParam(value = "the response", required = true)
			HumanTaskResponse response) throws BadRequestException{
		if(response == null){
			throw new BadRequestException("response is null");
		}
		HumanTaskMessageManager.getInstance().addHumanTaskResponse(response);		
//		"Can not construct instance of eu.vicci.process.model.util.messages.core.IHumanTaskResponse: 
//		abstract types either need to be mapped to concrete types, have custom deserializer, 
//		or contain additional type information\n at [Source: org.glassfish.jersey.message.internal.ReaderInterceptorExecutor$UnCloseableInputStream@50d88b15; line: 1, column: 1]"
		
		
//		Unexpected token (END_OBJECT), expected FIELD_NAME: missing property '@class' that is to contain type id  
//		(for class eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance)\n at [Source: org.glassfish.jersey.message.internal.ReaderInterceptorExecutor$UnCloseableInputStream@3cf52a2c; line: 26, column: 5] 
//		(through reference chain: eu.vicci.process.model.util.messages.HumanTaskResponse[\"endControlPorts\"]->java.util.HashMap[\"_CowCcIlpEem6b9zSoTSELQ\"])"
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "List all open human task requests", 
	response = IHumanTaskRequest.class, 
	responseContainer = "Map")
	public Map<String, IHumanTaskRequest>  getOpenHumanTasks()	{
		return HumanTaskMessageManager.getInstance().getOpenRequest();
	}	
	
	@GET
	@Path("{processId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, IHumanTaskRequest>  getOpenHumanTasksForRootProcess(
			@ApiParam(value = "The process id for the root process, to which the human task belongs", required = true)
			@PathParam("processId") String processId) {
		
		return HumanTaskMessageManager.getInstance()
		.getOpenRequest()
		.values()
		.stream()
		.filter(ht -> ht.getRootProcessId().equals(processId))
		.collect(Collectors.toMap(ht -> ht.getHumanTaskInstanceId(), ht -> ht ));
	}
	
	public void HandleHumanTaskResponse(IHumanTaskResponse response){
		HumanTaskMessageManager.getInstance().addHumanTaskResponse(response);
	}

}
