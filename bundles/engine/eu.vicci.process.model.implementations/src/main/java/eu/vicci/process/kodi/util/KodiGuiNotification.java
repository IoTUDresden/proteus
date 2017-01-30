package eu.vicci.process.kodi.util;

import com.google.gson.JsonObject;

//example
//{"jsonrpc": "2.0", "method": "Player.PlayPause", "params": { "playerid": 0 }, "id": 1}
public class KodiGuiNotification {
	public static final String NOTIFACTION_TYPE = "GUI.ShowNotification";
	
	private String jsonString = null;
	private JsonObject jsonObject = null;
	
	public KodiGuiNotification (String title, String message, int displayTime){
			process(title, message, displayTime);

	}
	
	private void process(String title, String message, int displayTime) {		
		JsonObject notiObj = new JsonObject();
		notiObj.addProperty("jsonrpc", "2.0");
		notiObj.addProperty("method", NOTIFACTION_TYPE);
		
		JsonObject params = new JsonObject();
		params.addProperty("title", title);
		params.addProperty("message", message);
		params.addProperty("displaytime", displayTime);
		
		notiObj.add("params", params);
		notiObj.addProperty("id", 1);
		
		jsonObject = notiObj;
		jsonString = notiObj.toString();		
	}	
	
	public String getAsJsonString(){
		return jsonString;
	}
	
	public JsonObject getAsJsonObject(){
		return jsonObject;
	}
	
	

}
