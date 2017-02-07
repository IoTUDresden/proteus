package eu.vicci.process.model.util.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import eu.vicci.process.client.core.ClientProfile;
import eu.vicci.process.client.core.IClientManager;

public class ClientManager implements IClientManager {	
	private List<ClientProfile> clients = Collections.synchronizedList(new ArrayList<ClientProfile>());
	
	private ClientManager() {
	}
	
	private static class Loader {
		static ClientManager INSTANCE = new ClientManager();
	}
	
	public static ClientManager getInstance() {
		return Loader.INSTANCE;
	}

	@Override
	public List<ClientProfile> getClients() {
		return clients;
	}

	@Override
	public void addClient(ClientProfile client) {
		clients.add(client);		
	}

	@Override
	public void removeClient(ClientProfile client) {
		clients.remove(client);		
	}
}
