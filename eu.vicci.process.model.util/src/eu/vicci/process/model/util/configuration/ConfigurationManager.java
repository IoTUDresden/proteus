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
	
	public void setClientManager(IClientManager clientManager){
		this.clientManager = clientManager;
	}
	
	public IClientManager getClientManager(){
		return clientManager;
	}
	
	public boolean hasClientManager(){
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
		String msg = String
				.format(msgWrongType, key, clazz.getSimpleName(), value.getClass().getSimpleName());
		logger.error(msg);
		return null;
	}
	
	/**
	 * Updates following values in the config:
	 * - ConfigProperties.OPENHAB_URI
	 * 
	 * @param reader
	 */
	public void updateFromConfigReader(IConfigurationReader reader){
		configurations.put(ConfigProperties.OPENHAB_URI, reader.getOpenHabUri());
	}

}
