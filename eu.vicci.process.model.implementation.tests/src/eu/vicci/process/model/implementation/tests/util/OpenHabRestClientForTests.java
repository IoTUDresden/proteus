package eu.vicci.process.model.implementation.tests.util;

import java.util.List;

import eu.vicci.process.devices.core.Sensor;
import eu.vicci.process.model.util.messages.core.SemanticPerson;
import eu.vicci.process.openhab.util.IOpenHabRestClient;
import eu.vicci.process.openhab.util.OpenHabItem;

public class OpenHabRestClientForTests implements IOpenHabRestClient {

	@Override
	public String getOpenHabRestVersion() {
		return "test_client";
	}

	@Override
	public String executeSelect(String queryStmt, boolean withLatest) {
		return null;
	}

	@Override
	public boolean executeAsk(String queryStmt, boolean withLatest) {
		return false;
	}

	@Override
	public String postCommandSemantic(String queryStmt, String command, boolean withLatest) {
		return null;
	}

	@Override
	public String getLocationForItem(String itemName) {
		return null;
	}

	@Override
	public String getSemanticType(String itemName) {
		return null;
	}

	@Override
	public List<OpenHabItem> getAllItems() {
		return null;
	}

	@Override
	public void close() {
		
	}

	@Override
	public void postCommand(OpenHabItem item, String command) {
		
		
	}

	@Override
	public List<Sensor> getAllSensorsSemantic() {
		return null;
	}

	@Override
	public List<SemanticPerson> getSemanticPersons() {
		return null;
	}

}
