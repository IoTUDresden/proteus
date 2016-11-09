package eu.vicci.process.kodi.util;

import com.google.gson.JsonObject;

public class KodiPlayer {
	
	public enum PlayerOpenType{
		FILE("file"),
		DIRECTORY("directory");
		
		private final String name;
		
		private PlayerOpenType(String name){
			this.name = name;			
		}
		
		public String getAsString(){
			return name;
		}
		
		public static PlayerOpenType fromString(String string){
			if("file".equals(string))
				return FILE;
			return DIRECTORY;
		}
	}
	
	
	public static class Stop{
		public static final String PLAYER_CLOSE = "Player.Stop";
		
		private String jsonString = null;
		private JsonObject jsonObject = null;
		
		public Stop(int playerId) {
			process(playerId);
		}

		private void process(int playerId) {
			JsonObject notiObj = new JsonObject();
			notiObj.addProperty("jsonrpc", "2.0");
			notiObj.addProperty("method",PLAYER_CLOSE);			
			
			JsonObject params = new JsonObject();
			params.addProperty("playerid", playerId);
			notiObj.add("params", params);
			
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
	
	
	public static class Open{
		public static final String PLAYER_OPEN = "Player.Open";
		
		private String jsonString = null;
		private JsonObject jsonObject = null;
		
		public Open(String path, PlayerOpenType type) {
				process(path, type);
		}
		
		private void process(String path, PlayerOpenType type)	{		
			JsonObject notiObj = new JsonObject();
			notiObj.addProperty("jsonrpc", "2.0");
			notiObj.addProperty("method", PLAYER_OPEN);
			
			JsonObject itemObj = new JsonObject();
			itemObj.addProperty(type.getAsString(), path);
			
			JsonObject params = new JsonObject();
			params.add("item", itemObj);
			
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

}
