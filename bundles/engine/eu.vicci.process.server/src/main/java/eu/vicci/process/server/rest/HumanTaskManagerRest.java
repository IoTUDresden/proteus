package eu.vicci.process.server.rest;

import java.util.Map;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eu.vicci.process.model.util.messages.HumanTaskMessageManager;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;
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
