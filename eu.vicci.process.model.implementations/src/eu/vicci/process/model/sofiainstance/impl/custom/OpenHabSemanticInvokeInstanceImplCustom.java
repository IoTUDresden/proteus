package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.List;
import java.util.Optional;

import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.openhab.util.IOpenHabRestClient;
import eu.vicci.openhab.util.OpenHabRestClient;

/**
 * Base Class for the OpenHabSemanticInvoke Step. Encapsulate the base informations needed
 * to get access to the semantic layer on OpenHAB.
 * 
 * @author André Kühnert
 *
 */
public abstract class OpenHabSemanticInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements
		OpenHabSemanticInvokeInstance {

	/**
	 * The REST Client for OpenHab
	 */
	protected IOpenHabRestClient client;

	/**
	 * The Server Base Uri for OpenHAB
	 */
	protected String serverBaseUri;
	
	/**
	 * The Query (e.g. Ask, Select or Command)
	 */
	protected String query;
	
	/**
	 * Should Sensor Values up to date before queryExecution
	 */
	protected boolean withLatest;
	
	
	private final static String PLACEHOLDER_START = "<{";
	private final static String PLACEHOLDER_END = "}>";
	private final static String MISSING_END = "The given EPL statement contains the start tag for a placeholder "
			+ "but no endtag. Check the epl statement! \nStatement: '%s'";
	private final static String MISSING_VALUE = "A value for the placeholder name '%s' can not be found. "
			+ "The EPL statement wont compile!";

	/**
	 * Fills the private members with the values from the process type definition and
	 * creates a new OpenHAB REST-client.
	 * 
	 * @return true if all values could be set, otherwise false.
	 */
	protected boolean fillPrivateMembersAndStartClient(List<DataTypeInstance> startParameter) {
		if (!fillPrivateMembers(startParameter))
			return false;
		client = new OpenHabRestClient(serverBaseUri);
		return true;
	}

	/**
	 * Fills the private members with the values from the process type definition.
	 * 
	 * @return true if all values could be set, otherwise false.
	 */
	protected boolean fillPrivateMembers(List<DataTypeInstance> startParameter) {
		if (!(getProcessStepType() instanceof OpenHabSemanticInvoke)) {
			LOGGER.error("OpenHabSemanticInvoke cannot be mapped");
			return false;
		}
		OpenHabSemanticInvoke openhab = (OpenHabSemanticInvoke) getProcessStepType();
		serverBaseUri = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.OPENHAB_URI);
		query = replacePlaceholder(openhab.getQuery(), startParameter);
		withLatest = openhab.isWithLatest();
		return true;
	}
	
	protected static String replacePlaceholder(String query, List<DataTypeInstance> startParameter) {
		if (!query.contains(PLACEHOLDER_START))
			return query;
		int start = query.indexOf(PLACEHOLDER_START);
		int end = query.indexOf(PLACEHOLDER_END);
		if (end < 0)
			throw new IllegalArgumentException(String.format(MISSING_END, query));
		String name = query.substring(start + PLACEHOLDER_START.length(), end);
		String trimmedName = name.trim();
		Object value = getValueForPlaceholder(trimmedName, startParameter);
		if (value == null)
			throw new IllegalArgumentException(String.format(MISSING_VALUE, trimmedName));
		String newEpl = query.replace(PLACEHOLDER_START + name + PLACEHOLDER_END, value.toString());

		// recursive replacement
		return replacePlaceholder(newEpl, startParameter);
	}
	
	// gets a value from a datatypeinstance which name equals the placeholder name
	private static Object getValueForPlaceholder(String name, List<DataTypeInstance> startParameter) {
		Optional<DataTypeInstance> valueHolder = startParameter.stream()
				.filter(d -> d.getDataTypeType() != null && d.getDataTypeType() != null && d.getDataTypeType().getName().equals(name)).findFirst();
		if (valueHolder.isPresent())
			return valueHolder.get().getValueAsObject();
		return null;
	}
}
