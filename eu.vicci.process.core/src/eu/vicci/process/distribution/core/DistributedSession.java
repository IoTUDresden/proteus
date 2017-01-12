package eu.vicci.process.distribution.core;

import java.util.Objects;

public class DistributedSession {
	private String remoteInstanceId;
	private String peerId;
	
	public DistributedSession(String remoteInstanceId, String peerId) {
		this.remoteInstanceId = remoteInstanceId;
		this.peerId = peerId;
	}
	
	public String getRemoteInstanceId() {
		return remoteInstanceId;
	}

	public String getPeerId() {
		return peerId;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof DistributedSession)) return false;
		DistributedSession org = (DistributedSession)obj;
		return org.peerId.equals(peerId)
				&& org.remoteInstanceId.equals(remoteInstanceId);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(remoteInstanceId, peerId);
	}

}
