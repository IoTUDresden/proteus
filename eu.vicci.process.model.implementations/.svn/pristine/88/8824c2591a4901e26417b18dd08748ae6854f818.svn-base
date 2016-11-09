package eu.vicci.process.model.cep;

import java.util.Map;

import com.espertech.esper.client.ConfigurationOperations;
import com.espertech.esper.client.EPAdministrator;
import com.espertech.esper.client.EPStatement;

import eu.vicci.process.model.sofiainstance.util.TriggeredEventWorker;

public class EsperManager {	
	private EsperManager() {	}
	
	public static EsperManager getInstance() {
		return EsperManagerLoader.INSTANCE;
	}
	
	public EPStatement addEPLStatement(String statement, TriggeredEventWorker tew) {
		EPAdministrator cepAdm = EsperEngine.getInstance().getCepAdm();
		EPStatement cepStatement = cepAdm.createEPL(statement);
		cepStatement.addListener(new CEPListener(tew));
		return cepStatement;
	}
	
	public void removeEPLStatement(EPStatement statement) {
		statement.removeAllListeners();
	}
	
	public void addEventType(String eventTypeName, Map<String,Object> props) {		
		ConfigurationOperations co = EsperEngine.getInstance().getCepAdm().getConfiguration();
		co.addEventType(eventTypeName, props);
	}
	
	public void addEventType(Class<?> eventBeanClass){
		ConfigurationOperations co = EsperEngine.getInstance().getCepAdm().getConfiguration();
		co.addEventType(eventBeanClass);
	}	
	
	private static class EsperManagerLoader{
		static EsperManager INSTANCE = new EsperManager();		
	}
}
