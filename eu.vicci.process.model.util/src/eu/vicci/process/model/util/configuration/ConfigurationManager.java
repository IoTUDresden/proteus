package eu.vicci.process.model.util.configuration;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.client.core.IClientManager;
import eu.vicci.process.client.core.IConfigurationReader;

/**
 * Configurations goes here
 */
public final class ConfigurationManager {
	private static final Logger logger = LoggerFactory.getLogger(ConfigurationManager.class);
	private static final String msgWrongType = "configuration value under the key '%s' "
			+ "was found but is from wrong type.\n expected: '%s'\n current: '%s'";

	private Map<String, Object> configurations = Collections.synchronizedMap(new HashMap<String, Object>());

	private IClientManager clientManager;

	// singleton
	private ConfigurationManager() {
	}

	private static class ConfigurationManagerLoader {
		static ConfigurationManager INSTANCE = new ConfigurationManager();
	}

	public static ConfigurationManager getInstance() {
		return ConfigurationManagerLoader.INSTANCE;
	}

	public Object getConfiguration(String key) {
		return configurations.get(key);
	}

	public void setClientManager(IClientManager clientManager) {
		this.clientManager = clientManager;
	}

	public IClientManager getClientManager() {
		return clientManager;
	}

	public boolean hasClientManager() {
		return clientManager != null;
	}

	/**
	 * Gets the config value in the correct type
	 * 
	 * @param key
	 * @param clazz
	 *            the class for the config value
	 * @return null if not found or wrong type
	 */
	@SuppressWarnings("unchecked")
	// is checked
	public <T> T getConfiguration(String key, Class<T> clazz) {
		Object value = configurations.get(key);
		if (value == null)
			return null;
		if (value.getClass().equals(clazz))
			return (T) value;
		String msg = String.format(msgWrongType, key, clazz.getSimpleName(), value.getClass().getSimpleName());
		logger.error(msg);
		return null;
	}

	/**
	 * Gets the config value as String.
	 * 
	 * @param key
	 * @return null if cant convert the value to String or a value for the given
	 *         key does not exist.
	 */
	public String getConfigAsString(String key) {
		return getConfiguration(key, String.class);
	}

	/**
	 * Updates following values in the config: <br>
	 * - OPENHAB_URI, FEEDBACK_SERVICE_URI, ELASTICSEARCH_HOST, CONTEXT_URI,
	 * NAMESPACE, REALMNAME, PORT, SUPER_PEER_IP
	 * 
	 * @param reader
	 */
	public void updateFromConfigReader(IConfigurationReader reader) {
		addIfNotNull(ConfigProperties.OPENHAB_URI, reader.getOpenHabUri());
		addIfNotNull(ConfigProperties.FEEDBACK_SERVICE_URI, reader.getFeedbackServiceUri());
		addIfNotNull(ConfigProperties.ELASTICSEARCH_HOST, reader.getElasticsearchHost());
		addIfNotNull(ConfigProperties.CONTEXT_URI, reader.getContextUri());
		addIfNotNull(ConfigProperties.NAMESPACE, reader.getNamespace());
		addIfNotNull(ConfigProperties.REALMNAME, reader.getRealmName());
		addIfNotNull(ConfigProperties.PORT, reader.getPort());
		addIfNotNull(ConfigProperties.SUPER_PEER_IP, reader.getSuperPeerIp());
	}

	private void addIfNotNull(String key, String value) {
		if (value == null)
			return;
		configurations.put(key, value);
	}

}
