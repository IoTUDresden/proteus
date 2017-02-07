package eu.vicci.process.messages;

import eu.vicci.process.model.sofiainstance.PortInstance;

public final class PortExecutionStateChangedMessage {	
	private final PortInstance port;

	public PortExecutionStateChangedMessage(PortInstance port) {
		this.port = port;
	}

	public PortInstance getPort() {
		return port;
	}

}
