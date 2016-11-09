package eu.vicci.process.client.tests;

import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.junit.Test;

import eu.vicci.process.devices.util.OpenHabEvent.OHItemAddedEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemRemovedEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemStateEvent;
import eu.vicci.process.openhab.util.OpenHabEventProvider;
import eu.vicci.process.openhab.util.OpenHabEventProvider.OHEventItemAddedListener;
import eu.vicci.process.openhab.util.OpenHabEventProvider.OHEventItemRemovedListener;
import eu.vicci.process.openhab.util.OpenHabEventProvider.OHEventItemStateListener;

public class OpenHabEventProviderTests {
	private static final String SERVER_BASE_PATH = "http://localhost:8080";
	private static final int sleepMultiplier = 20;

	/**
	 * Register to all Events on the OpenHab Bus. This Test runs {@value #sleepMultiplier} seconds.
	 * In this time you should toggle a button or something and check the console output on this test.
	 * 
	 * @throws Exception
	 */
	@Test
	public void registerToAllItemsTest() throws Exception {
		OpenHabEventProvider provider = new OpenHabEventProvider(SERVER_BASE_PATH);
		provider.registerToAllEvents(new EventListener() {			
			@Override
			public void onEvent(InboundEvent arg0) {
				System.out.println(arg0.getName() + " : " + arg0.readData(String.class));
			}
		});
		
		printWait("registerToAllItemsTest");
	}
	
	/**
	 * Register only to ItemStateUpdate events. This Test runs {@value #sleepMultiplier} seconds.
	 * In this time you should toggle a button or something and check the console output on this test. 
	 * 
	 * @throws Exception
	 */
	@Test
	public void registerToItemStateTest() throws Exception{
		OpenHabEventProvider provider = new OpenHabEventProvider(SERVER_BASE_PATH);
		provider.registerToItemState(new OHEventItemStateListener() {			
			@Override
			public void onItemState(OHItemStateEvent event) {
				System.out.println("State Event:");
				System.out.println("type: " + event.getType());
				System.out.println("payload: ");
				System.out.println("    type: " + event.getTypedPayload().getType() + " value: " 
				+ event.getTypedPayload().getValue());
				System.out.println();				
			}
		});
		
		printWait("registerToItemStateTest");
	}
	
	/**
	 * Register only to ItemAdded events. This Test runs {@value #sleepMultiplier} seconds.
	 * In this time you should rename a item in a *.item file on openhab.
	 * 
	 * @throws Exception
	 */
	@Test
	public void registerToItemAddedTest() throws Exception{
		OpenHabEventProvider provider = new OpenHabEventProvider(SERVER_BASE_PATH);
		provider.registerToItemAdded(new OHEventItemAddedListener() {			
			@Override
			public void onItemAdded(OHItemAddedEvent event) {
				System.out.println("Added Event: ");
				System.out.println("type: " + event.getType());
				System.out.println("payload: ");
				System.out.println("    type: " + event.getTypedPayload().getType() 
						+ " name: " + event.getTypedPayload().getName() 
						+ " tags: " + appendArray(event.getTypedPayload().getTags() )
						+ " groupNames: " + appendArray(event.getTypedPayload().getGroupNames())
						+ " label: " +  event.getTypedPayload().getLabel());									
			}
		});
		printWait("registerToItemAddedTest");
	}
	
	/**
	 * Register only to ItemRemoved events. This Test runs {@value #sleepMultiplier} seconds.
	 * In this time you should rename a item in a *.item file on openhab.
	 * 
	 * @throws Exception
	 */
	@Test
	public void registerToItemRemovedTest() throws Exception{
		OpenHabEventProvider provider = new OpenHabEventProvider(SERVER_BASE_PATH);
		provider.registerToItemRemoved(new OHEventItemRemovedListener() {			
			@Override
			public void onItemRemoved(OHItemRemovedEvent event) {
				System.out.println("Removed Event: ");
				System.out.println("type: " + event.getType());
				System.out.println("payload: ");
				System.out.println("    type: " + event.getTypedPayload().getType() 
						+ " name: " + event.getTypedPayload().getName() 
						+ " tags: " + appendArray(event.getTypedPayload().getTags() )
						+ " groupNames: " + appendArray(event.getTypedPayload().getGroupNames())
						+ " label: " +  event.getTypedPayload().getLabel());								
			}
		});
		printWait("registerToItemRemovedTest");
	}
	
	private String appendArray(String[] data){
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			b.append(data[i]);
			if(i < data.length - 1)
				b.append(", ");
		}		
		return b.toString();
	}
	
	private void printWait(String name) throws Exception{
		System.out.println(name + ": runs " + sleepMultiplier + " seconds.");
		for (int i = 0; i < sleepMultiplier; i++) {
			System.out.println("wait...");
			Thread.sleep(1000);			
		}
		System.out.println("end");		
	}

}
