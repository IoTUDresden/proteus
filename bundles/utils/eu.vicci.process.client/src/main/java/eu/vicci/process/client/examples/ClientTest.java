package eu.vicci.process.client.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

@SuppressWarnings("unused")
public class ClientTest {
	private static final String IP = "localhost";
	private static final String PORT = "8081";
	
	private IProcessEngineClient pec;
	
	public static void main(String[] args) {	
		ClientTest test = new ClientTest();
		test.run();
	}
	
	public void run(){		
		pec = new ProcessEngineClientBuilder()
				.withIp(IP)
				.withPort(PORT)
				.withName("Example Client")
				.withNamespace(ConfigProperties.DEFAULT_PROTEUS_WAMP_NAMESPACE)
				.withRealmName(ConfigProperties.DEFAULT_PROTEUS_WAMP_REALM_NAME)
				.build();
		
		pec.connect();
		
		pec.addStateChangeListener(stateChangeListener);
		
		 //this registers the printHello functionality for this client at the server
		pec.registerProcessExecutionClient();	

		loadTestProcesses();
		
		//this is bad - use a countdownlatch instead (like in SimpleOrTest)
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
//		testPrintStep();
		
//		testHumanTaskWithInputInt();
		
//		testCoffee();
		
//		testCoffeeExtended();
		
//		testHumanTask();
		
//		testHumanTaskWithInputList();
		
//		testHumanTaskWithInputListMapping();
		
//		testRosInvoke();
		
//		testSeMiWaInvoke();
		
//		uploadModel();
//		
//		listModels();
//			
//		uploadModelFile();
//		
//		deployModel();
//		
//		listDeployedModels();
//				
//		getProcessDefinition();
//				
//		getProcessInfos();
		
	}
	
	private StateChangeListener stateChangeListener = new StateChangeListener() {		
		@Override
		public void onMessage(IStateChangeMessage arg) {
			System.out.println(System.currentTimeMillis() + " " + arg.getProcessName() + " to state " + arg.getState());			
		}
	};
	
	private void loadTestProcesses() {
		
		System.out.println("Upload1");
		String processId1 = pec
				.uploadModelFile("processes/SeMiWaInvokeTest.diagram");

		System.out.println("Deploy1");
		pec.deployProcess(processId1);
		
		System.out.println("Upload2");
		String processId2 = pec
				.uploadModelFile("processes/rosinvoke.diagram");

		System.out.println("Deploy2");
		pec.deployProcess(processId2);
		
		System.out.println("Upload4");
		String processId4 = pec
				.uploadModelFile("processes/WeatherProcess.diagram");

		System.out.println("Deploy4");
		pec.deployProcess(processId4);
		
		System.out.println("Upload3");
		String processId3 = pec
				.uploadModelFile("processes/HumanTaskTest.diagram");

		System.out.println("Deploy3");
		pec.deployProcess(processId3);
		System.out.println("DeployInstance");
		String instanceId1 = pec.deployProcessInstance(processId3);
		
		System.out.println("Upload4");
		String processId = pec
				.uploadModelFile("processes/CoffeeMakerProcess.diagram");

		System.out.println("Deploy4");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Deploy4");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId2 = pec.deployProcessInstance(processId);

		System.out.println("Id: " + instanceId);
		System.out.println("Start");

		// declare ingoing data
		Map<String, DataTypeInstance> inputData = new HashMap<String, DataTypeInstance>();
		// Get process model from server
		Process p = pec.getProcessInfos(processId);

		for (Port port : p.getPorts()) {
			if (port instanceof StartDataPort) {
				StartDataPort sdp = (StartDataPort) port;
				// Get id from datatype at dataport
				DataType dt = sdp.getPortDatatype();
				String dtId = dt.getId();

				if (dt instanceof ListType) {
					ListType lt = (ListType) dt;
					ListTypeInstance lti = SofiaInstanceFactory.eINSTANCE
							.createListTypeInstance();
					lti.setCollectionItemType(lt.getCollectionItemType());
					lti.setTypeId(lt.getId());
					lti.setName(lt.getName());
					lti.setInstanceId(lt.getId() + "instance");
					lti.setInstancenumber(1);
					lti.setDataTypeType(lt);

					// Create list items

					if (lt.getCollectionItemType() instanceof StringType) {

						if(lt.getName().equals("AvailableCoffeeTypes")) {
							// type Arabica
							StringTypeInstance strtiOne = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiOne.setName("CoffeeTypeArabica");
							strtiOne.setInstanceId(EcoreUtil.generateUUID());
							strtiOne.setValue("Arabica");
							strtiOne.setDataTypeType(lt.getCollectionItemType());
							
							// type Robusta
							StringTypeInstance strtiTwo = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiTwo.setName("CoffeeTypeRobusta");
							strtiTwo.setInstanceId(EcoreUtil.generateUUID());
							strtiTwo.setValue("Robusta");
							strtiTwo.setDataTypeType(lt.getCollectionItemType());
							
							// type Excelsa 
							StringTypeInstance strtiThree = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiThree.setName("CoffeeTypeExcelsa");
							strtiThree.setInstanceId(EcoreUtil.generateUUID());
							strtiThree.setValue("Excelsa");
							strtiThree.setDataTypeType(lt.getCollectionItemType());
							
							// adding types
							lti.getSubtypes().add(strtiOne);
							lti.getSubtypes().add(strtiTwo);
							lti.getSubtypes().add(strtiThree);
						} else {
							// ingredient sugar
							StringTypeInstance strtiSugar = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiSugar.setName("Ingredient1");
							strtiSugar.setInstanceId(EcoreUtil.generateUUID());
							strtiSugar.setValue("Sugar");
							strtiSugar.setDataTypeType(lt.getCollectionItemType());
							
							// ingredient milk
							StringTypeInstance strtiMilk = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiMilk.setName("Ingredient2");
							strtiMilk.setInstanceId(EcoreUtil.generateUUID());
							strtiMilk.setValue("Milk");
							strtiMilk.setDataTypeType(lt.getCollectionItemType());
							
							// ingredient Sugar 
							StringTypeInstance strtiLiqueur = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiLiqueur.setName("Ingredient3");
							strtiLiqueur.setInstanceId(EcoreUtil.generateUUID());
							strtiLiqueur.setValue("Liqueur");
							strtiLiqueur.setDataTypeType(lt.getCollectionItemType());							
							
							// adding ingredients
							lti.getSubtypes().add(strtiSugar);
							lti.getSubtypes().add(strtiMilk);
							lti.getSubtypes().add(strtiLiqueur);							
						}
					}

					inputData.put(dtId, lti);
				}
			}
		}

		pec.startProcessInstance(instanceId, inputData);
//		pec.startProcessInstance(instanceId2, inputData);
		
	}
	
	private void testCoffeeExtended() {
		System.out.println("Upload");
		String processId = pec
				.uploadModelFile("processes/CoffeeMakerProcess.diagram");

		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);

		System.out.println("Id: " + instanceId);
		System.out.println("Start");

		// declare ingoing data
		Map<String, DataTypeInstance> inputData = new HashMap<String, DataTypeInstance>();
		// Get process model from server
		Process p = pec.getProcessInfos(processId);

		for (Port port : p.getPorts()) {
			if (port instanceof StartDataPort) {
				StartDataPort sdp = (StartDataPort) port;
				// Get id from datatype at dataport
				DataType dt = sdp.getPortDatatype();
				String dtId = dt.getId();

				if (dt instanceof ListType) {
					ListType lt = (ListType) dt;
					ListTypeInstance lti = SofiaInstanceFactory.eINSTANCE
							.createListTypeInstance();
					lti.setCollectionItemType(lt.getCollectionItemType());
					lti.setTypeId(lt.getId());
					lti.setName(lt.getName());
					lti.setInstanceId(lt.getId() + "instance");
					lti.setInstancenumber(1);
					lti.setDataTypeType(lt);

					// Create list items

					if (lt.getCollectionItemType() instanceof StringType) {

						if(lt.getName().equals("AvailableCoffeeTypes")) {
							// type Arabica
							StringTypeInstance strtiOne = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiOne.setName("CoffeeTypeArabica");
							strtiOne.setInstanceId(EcoreUtil.generateUUID());
							strtiOne.setValue("Arabica");
							strtiOne.setDataTypeType(lt.getCollectionItemType());
							
							// type Robusta
							StringTypeInstance strtiTwo = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiTwo.setName("CoffeeTypeRobusta");
							strtiTwo.setInstanceId(EcoreUtil.generateUUID());
							strtiTwo.setValue("Robusta");
							strtiTwo.setDataTypeType(lt.getCollectionItemType());
							
							// type Excelsa 
							StringTypeInstance strtiThree = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiThree.setName("CoffeeTypeExcelsa");
							strtiThree.setInstanceId(EcoreUtil.generateUUID());
							strtiThree.setValue("Excelsa");
							strtiThree.setDataTypeType(lt.getCollectionItemType());
							
							// adding types
							lti.getSubtypes().add(strtiOne);
							lti.getSubtypes().add(strtiTwo);
							lti.getSubtypes().add(strtiThree);
						} else {
							// ingredient sugar
							StringTypeInstance strtiSugar = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiSugar.setName("Ingredient1");
							strtiSugar.setInstanceId(EcoreUtil.generateUUID());
							strtiSugar.setValue("Sugar");
							strtiSugar.setDataTypeType(lt.getCollectionItemType());
							
							// ingredient milk
							StringTypeInstance strtiMilk = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiMilk.setName("Ingredient2");
							strtiMilk.setInstanceId(EcoreUtil.generateUUID());
							strtiMilk.setValue("Milk");
							strtiMilk.setDataTypeType(lt.getCollectionItemType());
							
							// ingredient Sugar 
							StringTypeInstance strtiLiqueur = SofiaInstanceFactory.eINSTANCE
									.createStringTypeInstance();
							strtiLiqueur.setName("Ingredient3");
							strtiLiqueur.setInstanceId(EcoreUtil.generateUUID());
							strtiLiqueur.setValue("Liqueur");
							strtiLiqueur.setDataTypeType(lt.getCollectionItemType());
							
							// adding ingredients
							lti.getSubtypes().add(strtiSugar);
							lti.getSubtypes().add(strtiMilk);
							lti.getSubtypes().add(strtiLiqueur);
							
						}
					}

					inputData.put(dtId, lti);
				}
			}
		}

		pec.startProcessInstance(instanceId, inputData);
	}
	
	private void testPrintStep() {
		System.out.println("Upload");
		String processId = pec.uploadModelFile("processes/LoadClassStepTest.diagram");
			
		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Id: "+instanceId);
		System.out.println("Start");
		pec.startProcessInstance(instanceId, null);
	}
	
	private void testHumanTaskWithInputInt() {
		System.out.println("Upload");
		String processId = pec.uploadModelFile("processes/HumanTaskIntIn.diagram");
			
		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Id: "+instanceId);
		System.out.println("Start");
		
		//This one needs ingoing data
		
		//Needs a map of id of datatype at startport and instance of its datatype
		Map<String, DataTypeInstance> inputData = new HashMap<String, DataTypeInstance>();
		
		//Get process model from server
		Process p = pec.getProcessInfos(processId);
		
		for (Port port : p.getPorts()) {
			if (port instanceof StartDataPort) {
				StartDataPort sdp = (StartDataPort)port;
				//Get id from datatype at dataport
				DataType dt = sdp.getPortDatatype();
				String dtId = dt.getId();
				
				if (dt instanceof IntegerType) {
					IntegerType it = (IntegerType)dt;
					IntegerTypeInstance iti = SofiaInstanceFactory.eINSTANCE.createIntegerTypeInstance();
					iti.setTypeId(it.getId());
					iti.setName(it.getName());
					iti.setInstanceId(it.getId()+"instance");
					iti.setInstancenumber(1);
					iti.setDataTypeType(dt);
					
					iti.setValue(666);
					
					inputData.put(dtId, iti);						
				}
			}	
		}
		
		System.out.println("Start instance");
		pec.startProcessInstance(instanceId, inputData);
	}
	
	private void testHumanTaskWithInputListMapping() {
		System.out.println("Upload");
		String processId = pec.uploadModelFile("processes/HumanTaskListMapping.diagram");
			
		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Id: "+instanceId);
		System.out.println("Start");
		
		//This one needs ingoing data
		
		//Needs a map of id of datatype at startport and instance of its datatype
		Map<String, DataTypeInstance> inputData = new HashMap<String, DataTypeInstance>();
		
		//Get process model from server
		Process p = pec.getProcessInfos(processId);
		
		for (Port port : p.getPorts()) {
			if (port instanceof StartDataPort) {
				StartDataPort sdp = (StartDataPort)port;
				//Get id from datatype at dataport
				DataType dt = sdp.getPortDatatype();
				String dtId = dt.getId();
				
				if (dt instanceof ListType) {
					ListType lt = (ListType)dt;
					ListTypeInstance lti = SofiaInstanceFactory.eINSTANCE.createListTypeInstance();
					lti.setCollectionItemType(lt.getCollectionItemType());
					lti.setTypeId(lt.getId());
					lti.setName(lt.getName());
					lti.setInstanceId(lt.getId()+"instance");
					lti.setInstancenumber(1);
					lti.setDataTypeType(dt);
					
					//Create list items
					
					for (int i=0; i<5; i++) {
						if (lt.getCollectionItemType() instanceof StringType) {
							StringTypeInstance strti = SofiaInstanceFactory.eINSTANCE.createStringTypeInstance();
							strti.setName("Name"+i);
							strti.setInstanceId("Nameinstance"+i);
							strti.setValue("NameValue"+i);
							strti.setDataTypeType(lt.getCollectionItemType());
							lti.getSubtypes().add(strti);
						}	
					}
					inputData.put(dtId, lti);						
				}
			}	
		}
		
		System.out.println("Start instance");
		pec.startProcessInstance(instanceId, inputData);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
//		System.out.println("Process "+pec.getProcessInfos(processId).getName());
		
		System.out.println("ProcessList "+pec.listProcessInstances().size());
		
		pec.getProcessInstanceInfos(instanceId);
		
		
	}
	
	private void testHumanTaskWithInputList() {
		System.out.println("Upload");
		String processId = pec.uploadModelFile("processes/HumanTaskLists.diagram");
			
		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Id: "+instanceId);
		System.out.println("Start");
		
		//This one needs ingoing data
		
		//Needs a map of id of datatype at startport and instance of its datatype
		Map<String, DataTypeInstance> inputData = new HashMap<String, DataTypeInstance>();
		
		//Get process model from server
		Process p = pec.getProcessInfos(processId);
		
		for (Port port : p.getPorts()) {
			if (port instanceof StartDataPort) {
				StartDataPort sdp = (StartDataPort)port;
				//Get id from datatype at dataport
				DataType dt = sdp.getPortDatatype();
				String dtId = dt.getId();
				
				if (dt instanceof ListType) {
					ListType lt = (ListType)dt;
					ListTypeInstance lti = SofiaInstanceFactory.eINSTANCE.createListTypeInstance();
					lti.setCollectionItemType(lt.getCollectionItemType());
					lti.setTypeId(lt.getId());
					lti.setName(lt.getName());
					lti.setInstanceId(lt.getId()+"instance");
					lti.setInstancenumber(1);
					lti.setDataTypeType(dt);
					
					//Create list items
					
					for (int i=0; i<5; i++) {
						if (lt.getCollectionItemType() instanceof StringType) {
							StringTypeInstance strti = SofiaInstanceFactory.eINSTANCE.createStringTypeInstance();
							strti.setName("Name"+i);
							strti.setInstanceId("Nameinstance"+i);
							strti.setValue("NameValue"+i);
							strti.setDataTypeType(lt.getCollectionItemType());
							lti.getSubtypes().add(strti);
						}	
					}
					inputData.put(dtId, lti);						
				}
			}	
		}
		
		System.out.println("Start instance");
		
		
	}
	
	private void testCoffee() {
		System.out.println("Upload");
		String processId = pec.uploadModelFile("processes/CoffeeProcess.diagram");
			
		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Id: "+instanceId);
		System.out.println("Start");
		pec.startProcessInstance(instanceId, null);
	}
	
	private void testSeMiWaInvoke() {
		System.out.println("Upload");
		String processId = pec.uploadModelFile("processes/exampleProcess.diagram");
			
		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Id: "+instanceId);
		System.out.println("Start");
		pec.startProcessInstance(instanceId, null);
	}
	
	private void testRosInvoke() {
		System.out.println("Upload");
		String processId = pec.uploadModelFile("processes/rosinvoke.diagram");
			
		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Id: "+instanceId);
		System.out.println("Start");
		pec.startProcessInstance(instanceId, null);
	}
	
	private void testHumanTask() {
		System.out.println("Upload");
		String processId = pec.uploadModelFile("processes/HumanTaskTest2.diagram");
			
		System.out.println("Deploy");
		pec.deployProcess(processId);
		System.out.println("DeployInstance");
		String instanceId = pec.deployProcessInstance(processId);
		
		System.out.println("Id: "+instanceId);
		System.out.println("Start");
		pec.startProcessInstance(instanceId, null);
	}
	
	private void uploadModel() {
		
		String text = "";
		
		File file = new File("processes/HumanTaskTest.diagram");
		
		try {
			   Scanner scanner = new Scanner(file);
			   scanner.useDelimiter("\\z");
			   text = scanner.next();
			   scanner.close();
			  } catch (FileNotFoundException e) {
			   e.printStackTrace();
		}
		
		boolean isDiagram = false;
				
		pec.uploadProcessDefinition("HumanTaskTest", text, isDiagram);
	}
	
	private void listModels() {

		List<String> processmodels = pec.listUploadedProcessDefinitions();
		
		System.out.println("Uploaded Models: ");
		
		for (String proc : processmodels) {
			System.out.println(proc);
		}
	}
	
	private void uploadModelFile() {
		pec.uploadModelFile("processes/HumanTaskTest.sofia");
	}

	private void deployModel() {
		String state = pec.deployProcess("HumanTaskTest");
	}

	private void listDeployedModels() {
		List<IProcessInfo> deployedmodels = pec.listDeployedProcesses();
		System.out.println("DeployedModels: ");
		for (IProcessInfo proc : deployedmodels) {
			System.out.println(proc.getProcessId());
			System.out.println(proc.getProcessName());
			System.out.println(proc.getProcessType());
			System.out.println(proc.getProcessDescription());
		}
	}
	
	private void getProcessDefinition() {
		System.out.println("MODEL:"+pec.getProcessDefinition("Pid1"));
	}
	
	private void getProcessInfos() {
		Process p = pec.getProcessInfos("Pid1");
		System.out.println(p.getDescription());
	}
	
}
