package eu.vicci.process.model.util.messages;

import java.util.ArrayList;
import java.util.List;

import eu.vicci.process.model.util.messages.core.HumanTaskRequestListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.IWampMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

/**
 * Message Queue for handling async messages. Simply add a message to this queue, 
 * the message is handled in another thread. Messages are handled in FIFO principle.
 */
public final class MessageQueue implements Runnable {
	private static final String THREAD_NAME = "WampMessageQueue";
	private List<StateChangeListener> stateChangeListeners = new ArrayList<StateChangeListener>();	
	private List<HumanTaskRequestListener> humanTaskRequestListeners = new ArrayList<HumanTaskRequestListener>();
	private List<IWampMessage> messages = new ArrayList<IWampMessage>();
	
	private boolean canceled = false;	
	
	/**
	 * Adds a {@link IWampMessage} and returns immediately. 
	 * The message is handled async in another thread. Messages are handled in FIFO principle.
	 * @param message
	 */
	public synchronized void addMessage(IWampMessage message){
		synchronized (messages) {
			messages.add(message);				
		}
		
		synchronized(this){
			notifyAll();
		}
	}

	@Override
	public void run() {
		while(!canceled)
			runTillTerminated();	
	}
	
	/**
	 * Runs the this message queue as a deamon thread.
	 */
	public void schedule(){
		Thread thread = new Thread(this);
		thread.setName(THREAD_NAME);
		thread.setDaemon(true); //should ensure that this thread is stopped if this is the only thread running
		thread.start();				
	}
	
	public void cancel(){
		canceled = true;
	}
	
	public void addStateChangeListener(StateChangeListener stateChangeListener){
		synchronized (stateChangeListeners) {
			stateChangeListeners.add(stateChangeListener);			
		}
	}
	
	public void removeStateChangeListener(StateChangeListener stateChangeListener){
		synchronized (stateChangeListeners) {
			stateChangeListeners.remove(stateChangeListener);			
		}
	}
	
	public void addHumanTaskRequestListener(HumanTaskRequestListener humanTaskRequestListener){
		synchronized (humanTaskRequestListeners) {
			humanTaskRequestListeners.add(humanTaskRequestListener);
		}		
	}
	
	public void removeHumanTaskRequestListener(HumanTaskRequestListener humanTaskRequestListener){
		synchronized (humanTaskRequestListeners) {
			humanTaskRequestListeners.remove(humanTaskRequestListener);
		}	
	}
	
	private void handleMessage(IWampMessage message){
		if(message instanceof IStateChangeMessage)
			for (StateChangeListener stateChangeListener : stateChangeListeners) {
				stateChangeListener.onMessage((IStateChangeMessage)message);
			}
		else if (message instanceof IHumanTaskRequest)
			for (HumanTaskRequestListener humanTaskRequestListener : humanTaskRequestListeners) {
				humanTaskRequestListener.onMessage((IHumanTaskRequest)message);
			}
	}
	
	private void waitForEvents(){
		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
	
	private IWampMessage removeFirstMessage(){
		IWampMessage event = null;
		synchronized(messages){
			if(!messages.isEmpty())
				event = messages.remove(0);				
		}
		return event;
	}
	
	private void runTillTerminated(){
		if(messages.isEmpty())
			waitForEvents();
		if(!canceled){
			IWampMessage message = removeFirstMessage();			
			if(message != null)
				handleMessage(message);
		}
		else
			notifyAll();		
	}

}
