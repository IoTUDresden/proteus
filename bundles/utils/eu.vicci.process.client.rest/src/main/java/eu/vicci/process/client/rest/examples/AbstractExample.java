package eu.vicci.process.client.rest.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CountDownLatch;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import eu.vicci.process.client.rest.ProteusRestClient;
import eu.vicci.process.model.util.messages.StateChangeMessage;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public abstract class AbstractExample {
	private final ProteusRestClient client;
	private final String port;
	private final String host;
	private String processInstanceId;
	private Client sseClient;
	private CountDownLatch waitForProcess;
	
	public AbstractExample() {
		this("localhost", "8082");	
	}
	
	public AbstractExample(String host, String port){
		this.host = host;
		this.port = port;
		client = new ProteusRestClient(host, port);		
	}
	
	protected ProteusRestClient getClient(){
		return client;
	}
	
	protected void enableWaitForInstance(String processInstanceId){
		this.processInstanceId = processInstanceId;	
		waitForProcess = new CountDownLatch(1);
		runSse();
	}
	
	protected void waitForProcess(){
		if(waitForProcess == null || processInstanceId == null)
			throw new IllegalStateException("you have to call enableWaitForInstance() first");
		try {
			waitForProcess.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	protected abstract void run();
	
	protected static String readProcessDoc(String filePath){
		String doc = null;
		try {
			byte[] encoded = Files.readAllBytes(Paths.get(filePath));
			doc = new String(encoded);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return doc;
	}
	
	private void runSse() {		
		sseClient = createSseClient();
		String uri = host + ":" + port + "/events/statechanges";
		if(!uri.startsWith("http"))
			uri = "http://" + uri;
		WebTarget target = sseClient.target(uri);
		EventSource eventSource = new EventSource(target, false) {
			@Override
			public void onEvent(InboundEvent inboundEvent) {
				IStateChangeMessage message = inboundEvent.readData(StateChangeMessage.class);
				onStateChangeInternal(message);
				onStateChange(message);
			}
		};
		eventSource.open();
	}
	
	private void onStateChangeInternal(IStateChangeMessage message){
		if(waitForProcess == null || processInstanceId == null)
			return;
		if(processInstanceId.equals(message.getInstanceId()) && isFinished(message))
			waitForProcess.countDown();
	}
	
	protected void onStateChange(IStateChangeMessage message){
		System.out.println(message.getProcessName() + " changed to " + message.getState().name());				
	}
	
	private Client createSseClient(){
		return ClientBuilder.newBuilder().register(SseFeature.class).build();
	}
	
	private boolean isFinished(IStateChangeMessage message){
		switch (message.getState()) {
		case EXECUTED:
		case FAILED:
		case DEACTIVATED:			
			return true;
		default: 
			return false;
		}
	}

}
