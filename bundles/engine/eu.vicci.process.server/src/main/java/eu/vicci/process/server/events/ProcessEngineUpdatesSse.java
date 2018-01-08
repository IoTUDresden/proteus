package eu.vicci.process.server.events;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.messages.core.ProcessEngineListener;
import eu.vicci.process.server.util.RuntimeContext;

@Path("engineupdates")
public class ProcessEngineUpdatesSse {
	
	private final IProcessManager processManager;
	
	private final SseBroadcaster broadcaster;
	
	public ProcessEngineUpdatesSse() {
		processManager = RuntimeContext.getInstance().getProcessManager();
		broadcaster = new SseBroadcaster();
		processManager.addProcessEngineListener(engineListener);
	}
	
	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getEngineUpdates(){
		EventOutput output = new EventOutput();
		broadcaster.add(output);
		return output;
	}
	
	private final ProcessEngineListener engineListener = new ProcessEngineListener() {		
		@Override
		public void onProcessInstanceDeployed(IProcessInstanceInfo processInstanceInfo) {
			broadcast(processInstanceInfo);			
		}
		
		@Override
		public void onProcessDeployed(IProcessInfo processInfo) {
			broadcast(processInfo);			
		}
	};
	
	private void broadcast(Object object){
		broadcaster.broadcast(new OutboundEvent.Builder()
				.data(object)
				.mediaType(MediaType.APPLICATION_JSON_TYPE)
				.build());
	}

}
