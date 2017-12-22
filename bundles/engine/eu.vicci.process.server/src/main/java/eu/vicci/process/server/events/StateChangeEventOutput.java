package eu.vicci.process.server.events;

import java.io.IOException;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;

import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

/**
 * {@link EventOutput} which only writes events for the requested process instance (and all subprocesses).
 * Events from peers ({@link IStateChangeMessage#getPeerId()} == null) are ignored.
 * 
 * @author andre
 */
public class StateChangeEventOutput extends EventOutput {
	
	private final String processInstanceId;
	
	public StateChangeEventOutput(){
		this(null);
	}
	
	public StateChangeEventOutput(String processInstanceId) {
		super();
		this.processInstanceId = processInstanceId;
	}
	
	@Override
	public void write(OutboundEvent chunk) throws IOException {
		Object data = chunk.getData();
		if(!(data instanceof IStateChangeMessage))
			throw new RuntimeException("Passed event with wrong type to StateChangeEventOutput");
		
		IStateChangeMessage message = (IStateChangeMessage)data;
		if(message.getPeerId() != null)
			return;
		if(processInstanceId != null && !processInstanceId.equals(message.getProcessInstanceId()))
			return;
		
		super.write(chunk);
	}
	
	

}
