package eu.vicci.process.client.rest.examples;

import java.util.concurrent.CountDownLatch;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

public class ListenToStateChanges extends AbstractExample{
	
	public static void main(String[] args) {
		new ListenToStateChanges().run();
	}
	
	private Client sseClient;

	@Override
	protected void run() {
		sseClient = createSseClient();
		String uri = "http://localhost:8082/events/statechanges";
		WebTarget target = sseClient.target(uri);
		EventSource eventSource = new EventSource(target, false) {
			@Override
			public void onEvent(InboundEvent inboundEvent) {
				String out = "name: %s\nraw data:\n%s";
				System.out.println(String.format(out, 
						inboundEvent.getName(), 
						inboundEvent.readData(String.class)));
			}
		};

		eventSource.open();
		waitForever();
	}
	
	private Client createSseClient(){
		return ClientBuilder.newBuilder().register(SseFeature.class).build();
	}
	
	private void waitForever(){
		CountDownLatch count = new CountDownLatch(1);
		try {
			count.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
