package eu.vicci.process.client.rest.examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadAndRunProcess extends AbstractExample {

	public static void main(String[] args) {
		new UploadAndRunProcess().run();
	}

	protected void run() {
		String doc = null;
		try {
			byte[] encoded = Files.readAllBytes(Paths.get("processes/SimpleOrTest.diagram"));
			doc = new String(encoded);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// at the moment override exisiting will have no affect. better restart
		// the engine.
		String id = getClient().uploadAndDeploy(doc, true);
		System.out.println("Process Id: " + id);
	}

}
