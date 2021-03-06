package eu.vicci.process.client.examples;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

public class JustListenToStateChanges {
	private static final String IP = "localhost";
	private static final String PORT = "8081";
	
	//runs for the given time
	private static final int millis = 600000;
	
	public static void main(String[] args) {
		final JustListenToStateChanges test = new JustListenToStateChanges();	
		Thread t = new Thread(new Runnable() {			
			@Override
			public void run() {
				System.out.println("Listening for " + millis + " millis");
				System.out.println();
				test.run();							
			}
		});		
		
		t.setName("JustListenToStateChanges_Worker");
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
		
		client.addStateChangeListener(new StateChangeListener() {			
			@Override
			public void onMessage(IStateChangeMessage message) {
				handleMessage(message);				
			}
		});
	}
	
	public void closeClient(){
		client.close();
	}
	
	private void handleMessage(IStateChangeMessage message){
		System.out.println("Message: ");	
		System.out.println("Instance Id: " + message.getInstanceId());
		System.out.println(message.getProcessName() + " to state " + message.getState());
		System.out.println();			
	}

}
