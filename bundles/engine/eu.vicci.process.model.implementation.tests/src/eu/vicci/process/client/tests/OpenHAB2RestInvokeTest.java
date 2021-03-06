package eu.vicci.process.client.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class OpenHAB2RestInvokeTest extends ProcessExecutionTestsBase {	
	private final static String PROCESS_PATH = "processes/OpenHAB2RestInvokeTest.diagram";
	private final static String PROCESS_ID = "_WQbqEPiyEeSvHOmQFpzA-w";
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	/**
	 * The target Address. Change this to your current address of the yahoo weather
	 * binding.
	 */
	private final static String REST_URL = "http://localhost:8080/rest/items/dd_weather";

	/**
	 * Simple Test, to access openhab via the rest api. This tests gets a value from the
	 * yahoo weather binding.
	 * 
	 * This test loads the definition and changes the rest url and save the definition
	 * back to the file. If something goes wrong, there is a backup file called
	 * 'OpenHAB2RestInvokeTest.diagram.bak'.
	 * 
	 * Maybe saving back the model is not necessary if the process manager allows to
	 * upload a definition directly. At the moment the process manager do some stuff with
	 * the model-file and than uploads the definition.
	 * 
	 * ATTENTION:<br>
	 * OpenHAB2 must run. If OpenHAB2 runs, this test should succeed.
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void openHAB2RestInvokeTest() throws InterruptedException, IOException {
		if (!REST_URL.startsWith("http://"))
			fail("wrong uri format in var REST_URL. Please start with 'http://'");

		replaceUrlInProcessDefinition();

		ProcessStepInstance pi = uploadAndStartProcess();
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);

		LifeCycleManager.INSTANCE.stopActorSystem();
		checkPorts(pi);
		checkSubSteps(pi);
		checkPortValue(pi);
	}

	// replaces the old url, with REST_URL
	private void replaceUrlInProcessDefinition() throws IOException {
		String def = loadProcessDefinitionFromFile();
		def = changeFirstOccurence(def);
		def = changeSecondOccurence(def);
		saveDefinitionToFile(def);
	}

	private String changeSecondOccurence(String def) {
		String search = "ServerUri=\"";
		int index = def.indexOf(search);
		if (index < 0)
			fail("no second rest url definition found in the process definition");
		String subEnd = def.substring(index + search.length());
		subEnd = subEnd.trim();
		String subStart = def.substring(0, index + search.length());
		subStart = subStart.trim();

		index = subEnd.indexOf("\""); // the uri should end on this point
		String uri = subEnd.substring(0, index);
		uri = uri.trim();
		System.out.println(subEnd);
		if (!uri.startsWith("http://"))
			fail("uri not found or wrong uri format in the current process definition file");

		String afterUri = subEnd.substring(index);
		subEnd = REST_URL + afterUri;
		def = subStart + subEnd;
		return def;
	}

	private String changeFirstOccurence(String def) {
		String search = "value=\"server:";
		int index = def.indexOf(search);
		if (index < 0)
			fail("no first rest url definition found in the process definition");
		String subEnd = def.substring(index + search.length() + 1);
		subEnd = subEnd.trim();
		String subStart = def.substring(0, index + search.length() + 1);
		subStart = subStart.trim();

		index = subEnd.indexOf("\""); // the uri should end on this point
		String uri = subEnd.substring(0, index);
		uri = uri.trim();
		if (!uri.startsWith("http://"))
			fail("uri not found or wrong uri format in the current process definition file");

		String afterUri = subEnd.substring(index);
		subEnd = " " + REST_URL + afterUri;
		def = subStart + subEnd;
		return def;
	}

	private void saveDefinitionToFile(String def) throws IOException {
		FileWriter fw = new FileWriter(PROCESS_PATH);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(def);
		bw.close();
	}

	private String loadProcessDefinitionFromFile() throws IOException {
		FileReader fr = new FileReader(PROCESS_PATH);
		BufferedReader br = new BufferedReader(fr);
		StringBuilder builder = new StringBuilder();
		String lineSeperator = System.getProperty("line.separator");

		String out = null;
		boolean isFirst = true;
		while ((out = br.readLine()) != null) {
			if (isFirst) {
				builder.append(out);
				isFirst = false;
			} else
				builder.append(lineSeperator).append(out);
		}

		br.close();
		return builder.toString();
	}

	private void checkSubSteps(ProcessStepInstance pi) {
		for (ProcessStepInstance subStep : pi.getSubSteps()) {
			assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType().getName(),
					subStep.getExecutionState()), subStep.getExecutionState() == State.EXECUTED);
			checkPorts(subStep);
		}
	}

	private void checkPorts(ProcessStepInstance pi) {
		for (PortInstance port : pi.getPorts())
			assertTrue(String.format(PORT_WRONG_STATE, port.getName(), port.getExecutionState()),
					port.getExecutionState() == State.ACTIVE);
	}

	private void checkPortValue(ProcessStepInstance pi) {
		String endportname = "end_exit_data";
		String errorMessage = "the endport '%s' was not found. has the model changed?";
		Optional<PortInstance> port = pi.getPorts().stream().filter(p -> endportname.equals(p.getName()))
				.findFirst();
		assertTrue(String.format(errorMessage, endportname), port.isPresent());
		EndDataPortInstance endPort = (EndDataPortInstance) port.get();
		String value = (String) endPort.getDataInstance().getValueAsObject();
		int temp = 0;
		try {
			temp = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			fail(String.format("the reiceived value can't parsed to an int. received: '%s'", value));
		}
		System.out.println(String.format("\n\nReceived Temperature is %d\n\n", temp));
	}

	private ProcessStepInstance uploadAndStartProcess() throws InterruptedException {
		PROCESS_MANAGER.uploadModelFile(PROCESS_PATH);
		PROCESS_MANAGER.deployProcess(PROCESS_ID);
		String processInstanceId = PROCESS_MANAGER.deployProcessInstance(PROCESS_ID);

		Thread.sleep(WAIT_DEPLOY_TIME);

		ProcessStepInstance instance = PROCESS_MANAGER.getProcessInstanceInfos(processInstanceId);
		PROCESS_MANAGER.startProcessInstance(processInstanceId, null);
		return instance;
	}
}
