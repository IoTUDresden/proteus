package eu.vicci.process.client.core;

import java.util.List;

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
	 * The runtime will act as a peer if the IP to a SuperPeer is set. Comment
	 * out or delete to let the runtime act as SuperPeer. In case of a peer
	 * usage, connection settings under "server settings" (above) are used.
	 * 
	 * @return null if not set
	 */
	String getSuperPeerIp();

	/**
	 * This is used to check for the correct (local) IP address,<br/>
	 * since <code>Inet4Address.getLocalHost().getHostAddress()</code> may
	 * return the wrong address, cause the host can have more than one network
	 * interface.
	 * 
	 * The filter will be used like the following: <br/>
	 * <br/>
	 * <code>
	 * String candidate = "10.5.x.x.x";
	 * <br/>
	 * candidate.startsWith(ipFilter);
	 * </code> <br/>
	 * <br/>
	 * 
	 * So example for a local address filter would be <code>192.168</code>
	 * 
	 * @return
	 */
	String getIpFilter();
	
	/**
	 * List devices, which are connected to the peer. 
	 * @return
	 */
	List<String> getDevices();

}