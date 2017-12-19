package eu.vicci.process.server.util;

import java.util.HashMap;
import java.util.Map;

import eu.vicci.process.engine.core.IProcessManager;

/**
 * This is like a service registry, where you can register services or objects and use them in other classes.
 * Use with care.
 * 
 * @author andre
 */
public class RuntimeContext {
	
	private Map<String, Object> services = new HashMap<>();
	
	public static final String PROCESS_MANAGER = "processmanager";
	
	private static class LazyHolder{
		private static final RuntimeContext INSTANCE = new RuntimeContext();
	}
	
	public static RuntimeContext getInstance(){
		return LazyHolder.INSTANCE;
	}
	
	public void registerProcessManager(IProcessManager processManager){
		putSafe(PROCESS_MANAGER, processManager);
	}
	
	public IProcessManager getProcessManager(){
		return getSafe(PROCESS_MANAGER, IProcessManager.class);
	}
	
	
	@SuppressWarnings("unchecked")
	private <T> T getSafe(String id, Class<T> clazz){
		if(!services.containsKey(id))
			throw new IllegalStateException(id + " was not registered in RuntimeContext");
		return (T) services.get(id);
	}
	
	private void putSafe(String id, Object service){
		if(service == null)
			throw new IllegalArgumentException("registered service cant be null for " + id);
		services.put(id, service);	
	}
	
	

}
