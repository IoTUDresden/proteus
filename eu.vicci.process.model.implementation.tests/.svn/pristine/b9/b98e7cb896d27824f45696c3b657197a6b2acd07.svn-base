package eu.vicci.process.client.tests;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.kodi.util.KodiPlayer.PlayerOpenType;
import eu.vicci.process.kodi.util.KodiRemote;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class KodiRemoteTests extends ProcessExecutionTestsBase {
	private static final String serverPath = "http://192.168.1.64:8080";
	private static final String itemToOpenPath = "/sdcard/Limp Bizkit - Break Stuff.mp3";
	private static final String imageToOpenPath = "/sdcard/areyouok.png";
	
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();
	private static final String OPEN_FILE_PATH = "processes/KodiWorkerTest.diagram";
	private static final String OPEN_FILE_ID = "_XnXtsB6XEeW6wJYnXI3m1w";
	
	private static final String SHOW_NOTI_PATH = "processes/KodiWorkerNotificationTest.diagram";
	private static final String SHOW_NOTI_ID = "_2UUb0B6aEeW6wJYnXI3m1w";
	
	private static final String OPTIONAL_PORT_PATH = "processes/KodiWorkerOptionalPortTest.diagram";
	private static final String OPTIONAL_PORT_ID = "_v-68YB8QEeWL5No5aoBvhg";
	

	
	/**
	 * This simple tests the playing of some music file on kodi.
	 * You should here something. No automated test.
	 */
	@Test
	public void playOpenTest() {
		KodiRemote remote = new KodiRemote(serverPath);
		remote.open(itemToOpenPath, PlayerOpenType.FILE);
	}
	
	@Test
	public void playOpenImageTest(){
		KodiRemote remote = new KodiRemote(serverPath);
		remote.open(imageToOpenPath, PlayerOpenType.FILE);
	}
	
	/**
	 * Shows a notification in the kodi gui. You should read it from the display.
	 * No automated test.
	 */
	@Test
	public void guiNotificationTest(){
		KodiRemote remote = new KodiRemote(serverPath);
		remote.sendNotification("Test Notification", "You should read this", 20000);
	}
	
	/**
	 * Stops the playing of something. There should a file playing before running this test
	 */
	@Test
	public void playerStopTest(){
		KodiRemote remote = new KodiRemote(serverPath);
		remote.stop(0);
	}
	
	/**
	 * Executes a process with the worker for playing a soundfile.
	 * You should edit the process on other systems (the soundfile probably not present on other systems)
	 * Also no automated test. You should hear music playing on your kodi-system
	 * @throws InterruptedException 
	 */
	@Test
	public void processWorkerTest() throws InterruptedException{
		ProcessStepInstance pi = uploadAndStartProcess(OPEN_FILE_PATH, OPEN_FILE_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		LifeCycleManager.INSTANCE.stopActorSystem();		
	}
	
	/**
	 * The Ports on the LoadClassSteps have optional Ports with the reuqired values. 
	 * So they must not defined on the root process. No automated test.
	 * @throws InterruptedException 
	 */
	@Test
	public void processWorkerTestWithOptionalPorts() throws InterruptedException{
		ProcessStepInstance pi = uploadAndStartProcess(OPTIONAL_PORT_PATH, OPTIONAL_PORT_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		LifeCycleManager.INSTANCE.stopActorSystem();		
	}
	
	/**
	 * Executes a process with worker for showing a gui notification.
	 * You should see the notification on your kodi-system.
	 * No automated test.
	 * @throws InterruptedException 
	 */
	@Test
	public void processWorkerNotificationTest() throws InterruptedException{
		ProcessStepInstance pi = uploadAndStartProcess(SHOW_NOTI_PATH, SHOW_NOTI_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		LifeCycleManager.INSTANCE.stopActorSystem();			
	}
	
	private ProcessStepInstance uploadAndStartProcess(String path, String processId) throws InterruptedException {
		PROCESS_MANAGER.uploadModelFile(path);
		PROCESS_MANAGER.deployProcess(processId);
		String processInstanceId = PROCESS_MANAGER.deployProcessInstance(processId);

		Thread.sleep(WAIT_DEPLOY_TIME);

		ProcessStepInstance instance = PROCESS_MANAGER.getProcessInstanceInfos(processInstanceId);
		PROCESS_MANAGER.startProcessInstance(processInstanceId, null);
		return instance;
	}

}
