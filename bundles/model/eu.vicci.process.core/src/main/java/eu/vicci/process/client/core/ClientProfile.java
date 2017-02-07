package eu.vicci.process.client.core;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientProfile {
	public static final String ClientBaseRpc = "http://vicci.eu/processes/client/";

	private String uuid;
	private String name;
	private List<String> topics;
	
	@JsonIgnore
	private String rpcBase;	

	public ClientProfile(String name, String uuid) {
		this(name, uuid, new ArrayList<String>());
	}
	
	@JsonCreator
	public ClientProfile(@JsonProperty("name") String name, 
			@JsonProperty("uuid") String uuid, 
			@JsonProperty("topics")List<String> topics){
		
		this.name = name;
		this.uuid = uuid;
		this.topics = topics;
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
	 * Gets the RpcBase for this profile. You can call later call(rpcBase + "topic", payload)
	 * 
	 * @return e.g. http://vicci.eu/processes/client/KLLKJ987987/
	 */
	public String getRpcBase() {
		return rpcBase;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if(!(arg0 instanceof ClientProfile))
			return false;
		return ((ClientProfile)arg0).getRpcBase().equals(rpcBase);
	}
}
