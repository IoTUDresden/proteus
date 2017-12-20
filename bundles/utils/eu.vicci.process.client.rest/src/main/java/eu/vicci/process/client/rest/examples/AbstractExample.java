package eu.vicci.process.client.rest.examples;

import eu.vicci.process.client.rest.ProteusRestClient;

public abstract class AbstractExample {
	private final ProteusRestClient client;
	
	public AbstractExample() {
		client = new ProteusRestClient(); //connects in localhost 8082		
	}
	
	protected ProteusRestClient getClient(){
		return client;
	}
	
	protected abstract void run();

}
