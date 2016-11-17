package eu.vicci.process.openhab.util;

import java.util.List;

import eu.vicci.process.devices.core.Sensor;
import eu.vicci.process.model.util.messages.core.SemanticPerson;

/**
 * Interface for a OpenHabRestClient.
 * @author André Kühnert
 *
 */
public interface IOpenHabRestClient {

	public static final String ITEMS_PATH = "/rest/items";
	public static final String REST_PATH = "/rest";
	public static final String SEMANTIC_PATH = "/rest/semantic";
	public static final String SELECT_PATH = "/rest/semantic/select";
	public static final String ASK_PATH = "/rest/semantic/ask";
	public static final String COMMAND_PATH = "rest/semantic/post/command";
	public static final String SEMANTIC_LOCATION_PATH = "/location";
	public static final String SEMANTIC_SENSOR_PATH = "/rest/semantic/sensors";
	public static final String SEMANTIC_PERSONS = "/rest/semantic/extended/persons";
		
	public static final String ERR_JSON_CONVERT = "error converting json result to class {}: {}";

	/**
	 * Gets the current OpenHab rest API version
	 * 
	 * @return The OpenHab Version as String
	 */
	public abstract String getOpenHabRestVersion();

	/**
	 * Executes a select and gets the result as json string
	 * 
	 * @param queryStmt
	 *            The Select Statement
	 * @param withLatest
	 *            If true, all stateValues in the model will be updated before the query
	 *            is executed.
	 * @return
	 */
	public abstract String executeSelect(String queryStmt, boolean withLatest);

	/**
	 * Executes an AskQuery.
	 * 
	 * @param queryStmt
	 *            The Ask Statement
	 * @param withLatest
	 *            If true, all stateValues in the model will be updated before the query
	 *            is executed.
	 * @return The result of the AskQuery, or also false, if an error happened.
	 */
	public abstract boolean executeAsk(String queryStmt, boolean withLatest);

	/**
	 * Posts a command to semantic layer in OpenHab.
	 * 
	 * @param queryStmt
	 *            The query should select the functionalities, which should receive the
	 *            command. E.g. '?subject dogont:hasFunctionality ?func' where the var
	 *            '?func' represents all the functionalities, which receives the command.
	 * @param command
	 *            The command, supported by the functionalities and the specific items.
	 * @param withlatest
	 *            If true, all stateValues in the model will be updated before the query
	 *            is executed.
	 * @return
	 */
	public abstract String postCommandSemantic(String queryStmt, String command, boolean withLatest);

	/**
	 * Gets the location of a item, which is defined in openhab 
	 * @param itemName
	 * @return
	 */
	public abstract String getLocationForItem(String itemName);

	/**
	 * Gets the type of the item, defined in the semantic model
	 * @param itemName
	 * @return
	 */
	public abstract String getSemanticType(String itemName);

	/**
	 * Gets a list with all openhab items.
	 * @return
	 */
	public abstract List<OpenHabItem> getAllItems();
	
	/**
	 * Gets all available persons semantically annotated
	 * @return
	 */
	public abstract List<SemanticPerson> getSemanticPersons();

	/**
	 * Closes this client. Have to be called after use
	 */
	public abstract void close();

	/**
	 * Posts a command to the specified openhab item. (Not implemented yet)
	 */
	public abstract void postCommand(OpenHabItem item, String command);
	
	/**
	 * Gets a list with all sensors. The informations are received from the semantic layer.
	 */
	public abstract List<Sensor> getAllSensorsSemantic();

}