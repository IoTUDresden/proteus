package eu.vicci.process.kodi.util;

import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.kodi.util.KodiPlayer.PlayerOpenType;

//For post
//	http://<your-ip>:<your-port>/jsonrpc
//For get
//	http://<your-ip>:<your-port>/jsonrpc?request=<url-encoded-request>

//http://kodi.wiki/view/JSON-RPC_API

/**
 * Kodi remote, to control Kodi via the JSON-RPC API
 * 
 * @author André Kühnert
 *
 */
public class KodiRemote {
	private static final Logger logger = LoggerFactory.getLogger(KodiRemote.class);

	// Default authentication
	private static final String auth = "kodi:kodi";

	private final String serverBaseUri;
	private final String creds;

	private Client client;

	/**
	 * This creates a new Kodi Remote. The Default Passwort and Username is used.
	 * 
	 * @param serverBaseUri
	 */
	public KodiRemote(String serverBaseUri) {
		this.serverBaseUri = serverBaseUri;
		client = ClientBuilder.newClient();
		byte[] out = Base64.getEncoder().encode(auth.getBytes());
		creds = new String(out);
	}

	/**
	 * Sends a small notification to Kodi
	 * 
	 * @param title
	 * @param message
	 * @param displayTime
	 *            how long should the message display (milliseconds)
	 */
	public void sendNotification(String title, String message, int displayTime) {
		WebTarget target = client.target(serverBaseUri).path("jsonrpc");
		KodiGuiNotification notification = new KodiGuiNotification(title, message, displayTime);
		logger.debug("JSON-RPC: {}", notification.getAsJsonString());
		logger.debug("Send Notification to {}", target.getUri());
		logger.debug("Authorization: {}", creds);

		Response response = target.request().header("Authorization", "Basic " + creds)
				.post(Entity.entity(notification.getAsJsonString(), MediaType.APPLICATION_JSON_TYPE));

		logger.debug("JSON-RPC: {}", notification.getAsJsonString());
		logger.debug("Notification Response Status: '{}'", response.getStatus());
		logger.debug("Response: {}", response.readEntity(String.class));
	}

	/**
	 * Play a file
	 */
	// public void play() {
	//
	// }

	/**
	 * Path of a folder, or the item (movie, sound file, picture)
	 */
	public void open(String itemPath, PlayerOpenType type) {
		WebTarget target = client.target(serverBaseUri).path("jsonrpc");
		KodiPlayer.Open open = new KodiPlayer.Open(itemPath, type);
		logger.debug("JSON-RPC: {}", open.getAsJsonString());
		Response response = target.request().header("Authorization", "Basic " + creds)
				.post(Entity.entity(open.getAsJsonString(), MediaType.APPLICATION_JSON_TYPE));
		logger.debug("Notification Response Status: '{}'", response.getStatus());
		logger.debug("Response: {}", response.readEntity(String.class));
	}

	/**
	 * Stops the playing of music, videos or the diashow
	 * 
	 * @param playerId
	 *            e.g. 1
	 */
	public void stop(int playerId) {
		WebTarget target = client.target(serverBaseUri).path("jsonrpc");
		KodiPlayer.Stop stop = new KodiPlayer.Stop(playerId);
		logger.debug("JSON-RPC: {}", stop.getAsJsonString());
		Response response = target.request().header("Authorization", "Basic " + creds)
				.post(Entity.entity(stop.getAsJsonString(), MediaType.APPLICATION_JSON_TYPE));
		logger.debug("Notification Response Status: '{}'", response.getStatus());
		logger.debug("Response: {}", response.readEntity(String.class));
	}
}
