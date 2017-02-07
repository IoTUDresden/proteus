package eu.vicci.process.model.util.messages.core;

/**
 * Listener for receiving updates e.g. if a new process or instance was deployed.
 * For internal use. This listener mostly calls the methods defined in {@link ProcessEngineListener}
 */
public interface ProcessEngineListenerInternal extends IMessageReceiver<IProcessEngineUpdate> {

}
