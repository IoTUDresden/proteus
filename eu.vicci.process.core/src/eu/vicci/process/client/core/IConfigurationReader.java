package eu.vicci.process.client.core;

public interface IConfigurationReader {

	/**
	 * Gets the server ip address. Not used by server.
	 * 
	 * @return
	 */
	String getIp();

	/**
	 * Gets the server port. Also used by server.
	 * 
	 * @return
	 */
	String getPort();

	/**
	 * Gets the namespace for the wamp connection. Also used by server.
	 * 
	 * @return
	 */
	String getNamespace();

	/**
	 * @deprecated seems nobody uses this
	 * @return
	 */
	@Deprecated
	int getPortAsInt();

	/**
	 * Gets the realm name for the wamp connection. Also used by server.
	 * 
	 * @return
	 */
	String getRealmName();

	/**
	 * Should start OSGI runtime?
	 * 
	 * @return
	 */
	boolean startOsgiRuntime();

	/**
	 * Should start Semiwa listener?
	 * 
	 * @deprecated semiwa not used anymore
	 * @return
	 */
	@Deprecated
	boolean startSemiwaListener();

	/**
	 * Should start oh listener? Important for event processing (otherwise, no
	 * events will arrive). OH must run, before vicci runtime is started.
	 * 
	 * @return
	 */
	boolean startOpenHabListener();

	/**
	 * Start CEP (complex event processing)?
	 * 
	 * @return
	 */
	boolean startCepEngine();

	/**
	 * @deprecated not used anymore
	 * @return
	 */
	@Deprecated
	boolean startXmlRpcWebServer();

	/**
	 * 
	 * @return
	 */
	boolean deployExistingProcessModels();

	/**
	 * Gets the OH URI
	 * 
	 * @return
	 */
	String getOpenHabUri();

	/**
	 * Gets the URI for the feedback context
	 * 
	 * @return
	 */
	String getContextUri();

	/**
	 * Gets the URI for the feedback service
	 * 
	 * @return
	 */
	String getFeedbackServiceUri();

	/**
	 * Gets the URI for the feedback service
	 * 
	 * @return
	 */
	String getElasticsearchHost();

	/**
	 * The runtime will act as a peer if the ip to a SuperPeer is set. Comment
	 * out or delete to let the runtime act as SuperPeer. In case of a peer
	 * usage, connection settings under "server settings" (above) are used.
	 * 
	 * @return null if not set
	 */
	String getSuperPeerIp();

}