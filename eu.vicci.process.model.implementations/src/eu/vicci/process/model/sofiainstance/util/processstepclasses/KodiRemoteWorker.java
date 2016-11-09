package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.kodi.util.KodiPlayer.PlayerOpenType;
import eu.vicci.process.kodi.util.KodiRemote;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

/**
 * KodiRemote Worker for controling kodi over process steps
 * 
 * The Worker checks the Datainstances for their names.
 * 'KodiServer' and 'KodiMethod' are allways required. Other ports are required to the specific KodiMethod.
 * E.g. Player.Open needs the KodiOpenType, and the KodiItem as Datatypeinstance in the parameters.
 * 
 * @author André Kühnert
 *
 */
public class KodiRemoteWorker implements ProcessStepWorker{
	private static final Logger logger = LoggerFactory.getLogger(KodiRemoteWorker.class);
	
	/**
	 * Datatype with this name should contain ther server path e.g. http://192.168.2.103:8080
	 */
	public static final String SERVER_TYPE_ID = "KodiServer";	
	/**
	 * Datatype with this name should contain the method e.g. Player.Open
	 * See the Api Doc: http://kodi.wiki/view/JSON-RPC_API/v6
	 */
	public static final String METHOD_TYPE_ID = "KodiMethod";
	/**
	 * Datatype with this name should contain the open type ('file' or 'directory')
	 */
	public static final String KODI_OPEN_TYPE_ID = "KodiOpenType";
	/**
	 * Datatype with this name should contain the item path (e.g. /sdcard/musicfile.mp3)
	 */
	public static final String KODI_ITEM_TYPE_ID = "KodiItem";
	/**
	 * Datatype with this name should contain the title for notifications
	 */
	public static final String KODI_TITLE_TYPE_ID = "KodiTitle";
	/**
	 * Datatype with this name should contain the message for notifications
	 */
	public static final String KODI_MESSAGE_TYPE_ID = "KodiMessage";
	/**
	 * Datatype with this name should contain the displaytime for notification
	 */
	public static final String KODI_DISPLAYTIME_TYPE_ID = "KodiTime";
	
	private String serverPath;
	private String method;
	
	@Override
	public void deploy() {	}

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		setServerAndMethod(parameter);
		if(isMethodOrServerEmpty()){
			logger.error("Method or server path is empty. No Kodi remote command is send");
			return parameter;
		}
		
		KodiRemote remote = new KodiRemote(serverPath);
		
		//switch the kodi methods. they are listed in the json-rpc api documentation of kodi
		switch (method) {
		case "Player.Open":
			playerOpen(parameter, remote);
			break;
		case "Player.Stop":
			remote.stop(0);//stops the first player
			break;
		case "GUI.ShowNotification":
			guiNotification(parameter, remote);
			break;
		default:
			throw new UnsupportedOperationException(String.format("The kodi method %s is not implemented yet.", method));
		}		
		return parameter;
	}

	private void playerOpen(List<DataTypeInstance> parameter, KodiRemote remote){
		String item = getValueFromParameters(parameter, KODI_ITEM_TYPE_ID, String.class);
		String openType = getValueFromParameters(parameter, KODI_OPEN_TYPE_ID, String.class);
		if(item == null || openType == null){
			logger.error("Required parameters are missing (item or open type)");
			return;
		}
		remote.open(item, PlayerOpenType.fromString(openType));	
	}
	
	private void guiNotification(List<DataTypeInstance> parameter, KodiRemote remote){
		String title = getValueFromParameters(parameter, KODI_TITLE_TYPE_ID, String.class);
		String message = getValueFromParameters(parameter, KODI_MESSAGE_TYPE_ID, String.class);
		Integer time = getValueFromParameters(parameter, KODI_DISPLAYTIME_TYPE_ID, Integer.class);
		if(title == null || message == null || time == null){
			logger.error("Required parameters are missing (title, message or displaytime)");
			return;
		}
		remote.sendNotification(title, message, time.intValue());
	}

	private void setServerAndMethod(List<DataTypeInstance> parameter) {
		for (DataTypeInstance dataTypeInstance : parameter) {
			if(!(dataTypeInstance instanceof StringTypeInstance))
				continue;
			String name = dataTypeInstance.getDataTypeType().getName();
			
			if(SERVER_TYPE_ID.equals(name))
				serverPath = (String)dataTypeInstance.getValueAsObject();
			else if(METHOD_TYPE_ID.equals(name))
				method = (String)dataTypeInstance.getValueAsObject();			
		}		
	}
	
	private boolean isMethodOrServerEmpty(){
		return serverPath == null || method == null || serverPath.isEmpty() || method.isEmpty();
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getValueFromParameters(List<DataTypeInstance> parameter, String typeName, Class<T> clazz){
		Optional<DataTypeInstance> instance = parameter.stream()
				.filter(d -> d.getDataTypeType().getName().equals(typeName))
				.findFirst();
		if(!instance.isPresent())
			return null;
		Object value = instance.get().getValueAsObject();
		if(value.getClass().equals(clazz))
			return (T)value;						
		return null;		
	}
}
