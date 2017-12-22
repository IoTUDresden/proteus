package eu.vicci.process.client.rest.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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

}
