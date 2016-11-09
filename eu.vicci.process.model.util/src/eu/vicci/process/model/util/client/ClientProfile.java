package eu.vicci.process.model.util.client;

import java.util.ArrayList;
import java.util.List;

public class ClientProfile {
	public static final String ClientBaseRpc = "http://vicci.eu/processes/client/";

	private final String uuid;
	private final String name;
	private final String rpcBase;
	private List<String> topics = new ArrayList<String>();

	public ClientProfile(String name, String uuid) {
		this.name = name;
		this.uuid = uuid;
		rpcBase = ClientBaseRpc + uuid + "/";
	}

	public String getName() {
		return name;
	}

	public String getUuid() {
		return uuid;
	}
	
	/**
	 * Add a topic e.g. "printHello"
	 * @param topic
	 */
	public void addTopic(String topic){
		topics.add(topic);
	}
	
	/**
	 * Gets all registered topics.
	 * @return
	 */
	public List<String> getTopics(){
		return topics;
	}

	/**
	 * Gets the RpcBase for this profile. You can call later call(rpcBase + "topic")
	 * 
	 * @return e.g. http://vicci.eu/processes/client/KLLKJ987987/
	 */
	public String getRpcBase() {
		return rpcBase;
	}
}
