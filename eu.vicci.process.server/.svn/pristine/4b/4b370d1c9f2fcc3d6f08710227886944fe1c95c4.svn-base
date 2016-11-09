package eu.vicci.process.wampserver.handlers;

import java.util.List;

import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.model.util.messages.core.SemanticPerson;
import eu.vicci.process.openhab.util.IOpenHabRestClient;
import eu.vicci.process.openhab.util.OpenHabRestClient;
import ws.wamp.jawampa.ApplicationError;
import ws.wamp.jawampa.Request;

public class SemanticPersonsHandler extends AbstractRpcHandler {
	private static final String httpBase = "http://";
	private static final String errMessage = "PROtEUS can´t connect to OpenHab SAL";
	private final String targetPath;	
	
	public SemanticPersonsHandler() {
		targetPath = createTargetPath();		
	}

	@Override
	public void onNext(Request arg) {
		if(targetPath == null){
			sendError(arg);
			return;
		}
		
		IOpenHabRestClient client = new OpenHabRestClient(targetPath);
		List<SemanticPerson> persons = client.getSemanticPersons();
		
		if(persons == null){
			sendError(arg);
			return;
		}
		
		arg.reply(persons);
	}
	
	private String createTargetPath(){
		String tmp = ConfigurationManager.getInstance()
				.getConfiguration(ConfigProperties.OPENHAB_URI, String.class);
		if(tmp == null)
			return null;
		
		if(!tmp.startsWith(httpBase))
			tmp = httpBase + tmp;
		if(tmp.endsWith("/"))
			tmp = tmp.substring(0, tmp.length() - 1);
		return tmp;						
	}
	
	private void sendError(Request arg){
		try {
			arg.replyError(ApplicationError.NOT_CONNECTED, errMessage);
		} catch (ApplicationError e) {
			e.printStackTrace();
		}
	}

}
