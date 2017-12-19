package eu.vicci.process.server.events;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;
import eu.vicci.process.server.util.RuntimeContext;

@Path("statechanges")
public class StateChangesSse {
	private final IProcessManager processManager;
	
	public StateChangesSse() {
		processManager = RuntimeContext.getInstance().getProcessManager();
	}
	
	
	private StateChangeListener stateChangeListener = new StateChangeListener() {		
		@Override
		public void onMessage(IStateChangeMessage arg) {
			//at this point we distribute the messages to the subscribers						
		}
	};	
	
	@GET
	@Path("{id}")
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getStateChangesForInstance(@PathParam("id") final String id){
        final EventOutput seq = new EventOutput();

        new Thread() {
            public void run() {
                try {
                    seq.write(new OutboundEvent.Builder().name("domain-progress")
                            .data(String.class, "starting domain " + id + " ...").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "50%").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "60%").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "70%").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "99%").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "done").build());
                    seq.close();

                } catch (final InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return seq;		
	}
	
	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput test(){
        final EventOutput seq = new EventOutput();
        String id = UUID.randomUUID().toString();

        new Thread() {
            public void run() {
                try {
                    seq.write(new OutboundEvent.Builder().name("domain-progress")
                            .data(String.class, "starting domain " + id + " ...").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "50%").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "60%").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "70%").build());
                    Thread.sleep(200);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "99%").build());
                    Thread.sleep(2000);
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "done").build());
                    seq.close();

                } catch (final InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        return seq;
		
	}	

}
