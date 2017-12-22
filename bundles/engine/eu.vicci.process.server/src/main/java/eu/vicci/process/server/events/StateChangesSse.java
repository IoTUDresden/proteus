package eu.vicci.process.server.events;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;
import eu.vicci.process.server.exception.NotFoundErrorException;
import eu.vicci.process.server.util.RuntimeContext;

@Path("statechanges")
public class StateChangesSse {
	private final IProcessManager processManager;
	
	private final SseBroadcaster broadcaster;

	public StateChangesSse() {
		processManager = RuntimeContext.getInstance().getProcessManager();
		broadcaster = new SseBroadcaster();
		processManager.addStateChangeListener(stateChangeListener);
	}

	@GET
	@Path("{processInstanceId}")
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getStateChangesForInstance(@PathParam("processInstanceId") final String processInstanceId)
			throws NotFoundErrorException, IOException 
	{
//		TODO Not sure about this one. Error if instance is not already exists?
//		ProcessInstance processInstance = processManager.getProcessInstanceInfos(processInstanceId);
//		if (processInstance == null)
//			throw new NotFoundErrorException(ERR_PROCESS_INSTANCE_WITH_ID_NOT_FOUND, processInstanceId);
		
		final EventOutput event = new StateChangeEventOutput(processInstanceId);		
		broadcaster.add(event);
		return event;
	}
	
	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getAllStateChanges()	throws NotFoundErrorException, IOException 	{
		final EventOutput event = new StateChangeEventOutput();		
		broadcaster.add(event);
		return event;
	}
	
	private final StateChangeListener stateChangeListener = new StateChangeListener() {		
		@Override
		public void onMessage(IStateChangeMessage arg) {
			broadcaster.broadcast(new OutboundEvent.Builder()
					.mediaType(MediaType.APPLICATION_JSON_TYPE)
					.data(arg)
					.build());
		}
	};

}
