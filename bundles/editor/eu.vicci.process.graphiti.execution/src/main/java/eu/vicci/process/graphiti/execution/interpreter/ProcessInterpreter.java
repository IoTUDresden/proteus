package eu.vicci.process.graphiti.execution.interpreter;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.swt.widgets.Display;

import eu.vicci.process.adapter.util.AdapterUtil;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.graphiti.execution.debug.ProcessDebugger;
import eu.vicci.process.graphiti.execution.ui.ExecuteProcessEditor;
import eu.vicci.process.graphiti.execution.ui.ExecuteProcessEditor.DisposeListener;
import eu.vicci.process.graphiti.execution.util.StringResource;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

/**
 * Runner to execute a process model in the engine and gives feedback about
 * states, port values, etc. in the ui.
 */
public class ProcessInterpreter extends AbstractProcessInterpreter implements DisposeListener {
	private static final String CLIENT_SUFFIX = "_Interpreter";
	private ProcessDebugger debugger;

	private final ProcessInstance rootProcess;

	private boolean isCanceled = false;

	private CountDownLatch waitTillFinished;

	private IProcessEngineClient client;

	// buffer with max. 1000 should be enough
	private ArrayBlockingQueue<Object> messages = new ArrayBlockingQueue<Object>(1000);

	public ProcessInterpreter(ExecuteProcessEditor editor, ProcessInstance rootProcess) {
		super(editor);
		this.rootProcess = rootProcess;
	}

	@Override
	public void init() {
		super.init();
		editor.setDisposeListener(this);

	}

	public void setDebugger(ProcessDebugger debugger) {
		this.debugger = debugger;
	}

	@Override
	protected void canceling() {
		cancelRun();
		super.canceling();
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		logger.debug("running process runner for {}", rootProcess.getInstanceId());
		waitTillFinished = new CountDownLatch(1);
		client = AdapterUtil.createClient(CLIENT_SUFFIX);

		if (!client.connect()) {
			logger.error(StringResource.ERR_CANT_CONNECT + " " + client.getIp() + ":" + client.getPort());
			return Status.CANCEL_STATUS;
		}

		debuggerLoaded();
		registerClientAndInitialStates();
		startStateMessageConsumer();
		waitTillFinishedOrCanceled();
		closeClient();
		debuggerTerminated();

		logger.debug("runner finished for {}", rootProcess.getInstanceId());

		if (isCanceled)
			return Status.CANCEL_STATUS;
		return Status.OK_STATUS;
	}

	/**
	 * This method starts a new thread which will consume all statemessages in
	 * fifo order. If the thread receives a object other than a statemessage,
	 * the {@link #waitTillFinished} is count down, which will force the method
	 * {@link #waitTillFinished} to leave.
	 */
	private void startStateMessageConsumer() {
		Thread stateMessageConsumer = new Thread(() -> {
			while (true) {
				try {
					Object out = messages.take();
					if (out instanceof IStateChangeMessage)
						handleStateMessage((IStateChangeMessage) out);
					else {
						waitTillFinished.countDown();
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		stateMessageConsumer.setName("StateMessageQueue");
		stateMessageConsumer.setDaemon(true);
		stateMessageConsumer.start();
	}

	private void closeClient() {
		client.removeStateChangeListener(stateChangeListener);
		client.close();
	}

	private void waitTillFinishedOrCanceled() {
		try {
			waitTillFinished.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void debuggerLoaded() {
		if (debugger != null)
			debugger.loaded();
	}

	private void debuggerTerminated() {
		if (debugger != null)
			debugger.terminated();
	}

	private void registerClientAndInitialStates() {
		client.addStateChangeListener(stateChangeListener);

		// FIXME this will block till the timeout happens, but why?????
		// happens on all callRpc methods. There is nothing received on the
		// reciever, seems something blocks
		
		// wamp client call backs are in thread WampClientLoop or so
		List<IStateChangeMessage> changes = client.getInstanceLog(rootProcess.getInstanceId());
		changes.stream().forEach(m -> handleStateMessage(m));
		logger.debug("initial states handled");
	}

	private boolean stateFinished(State state) {
		return state == State.DEACTIVATED || state == State.FAILED || state == State.EXECUTED || state == State.STOPPED
				|| state == State.KILLED;
	}

	private synchronized void handleStateMessage(IStateChangeMessage message) {
		if (isCanceled)
			return;
		if (debugger != null)
			debugger.processStateChanged(message);

		Shape shape = objectsMap.get(message.getProcessId());
		if (shape == null)
			return;

		Display.getDefault().asyncExec(() -> {
			changeBorderColor(shape, getStateColor(message.getState()));
		});
	}

	private StateChangeListener stateChangeListener = new StateChangeListener() {
		@Override
		public void onMessage(IStateChangeMessage message) {
			messages.add(message);

			if (rootProcess.getInstanceId().equals(message.getInstanceId()) && stateFinished(message.getState()))
				messages.add(new Object());
		}
	};

	public void terminate() {
		// TODO implement stopping, killing and pausing of process steps
		// client.stopProcessInstance(rootProcess.getInstanceId());
		cancelRun();
	}

	private void cancelRun() {
		isCanceled = true;
		messages.add(new Object());
	}

	@Override
	public void onDispose() {
		cancelRun();
	}
}
