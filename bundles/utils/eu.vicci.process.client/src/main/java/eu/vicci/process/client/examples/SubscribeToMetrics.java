package eu.vicci.process.client.examples;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.core.IMessageReceiver;
import eu.vicci.process.model.util.messages.core.PeerMetrics;

public class SubscribeToMetrics {
	private static final String IP = "localhost";
	private static final String PORT = "8081";
	
	//runs for the given time
	private static final int millis = 600000;
	
	public static void main(String[] args) {
		final SubscribeToMetrics test = new SubscribeToMetrics();	
		Thread t = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("Listening for " + millis + " millis");
				System.out.println();
				test.run();							
			}
		});		
		
		t.setName("SubscribeToMetrics_Worker");
		t.start();
		
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
		test.closeClient();
	}
	
	IProcessEngineClient client;
	
	public void run(){				
		client = new ProcessEngineClientBuilder()
				.withIp(IP)
				.withPort(PORT)
				.withName("Example Client")
				.withNamespace(ConfigProperties.DEFAULT_PROTEUS_WAMP_NAMESPACE)
				.withRealmName(ConfigProperties.DEFAULT_PROTEUS_WAMP_REALM_NAME)
				.build();	 		
		client.connect();
		
		client.subscribeToTopic(TopicId.PEER_METRICS, metricsReceiver, PeerMetrics.class);
	}
	
	public void closeClient(){
		client.close();
	}
	
	private IMessageReceiver<PeerMetrics> metricsReceiver = new IMessageReceiver<PeerMetrics>() {
		@Override
		public void onMessage(PeerMetrics arg) {
			System.out.println("Peer:           " + arg.peerId);
			System.out.println("Has Battery:    " + arg.hasBattery);
			System.out.println("Battery Status: " + (arg.batteryStatus == null ? "unknown" : arg.batteryStatus));
			System.out.println();		
		}
	};
	


}
