package eu.vicci.process.runtime;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.devices.util.OpenHabListener;
import eu.vicci.process.distribution.manager.DistributionManager;
import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.cep.EsperEngine;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.osgi.OSGiRuntime;
import eu.vicci.process.wampserver.Peer;
import eu.vicci.process.wampserver.SuperPeer;
import ws.wamp.jawampa.ApplicationError;

public class VicciRuntime {
	private static final Logger LOG = LoggerFactory.getLogger(VicciRuntime.class);
	private static final String PATH_MODEL = "processes/models/";
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VicciRuntime runtime = new VicciRuntime();
		LOG.info("starting vicci runtime...");
		boolean started = runtime.start();
		if(!started){
			LOG.error("failed to start vicci runtime");
			return;
		}
		
		LOG.info("vicci runtime started as {}", runtime.getRuntimeType());
		readLineTillStopIsEntered();
		
		LOG.info("stopping the runtime...");
		runtime.stop();
	}	

	private SuperPeer server;
	private IProcessManager processManagerPublic;
	
	public VicciRuntime(){	
		processManagerPublic = new ProcessManagerPublic();
	}
	
	public boolean start(){
		IConfigurationReader configReader = new ConfigurationReader("server.conf");
		ConfigurationManager.getInstance().updateFromConfigReader(configReader);
		
		if(!configReader.deployExistingProcessModels())
			deleteExistingModels();		
		
		initializeSofiaModel();
		registerListener(configReader);
		boolean isWebSocketServerStarted = startWebSocketServer(configReader);
		
		DistributionManager.getInstance().setPeerProfile(server.getPeerProfile());
		
		return isWebSocketServerStarted;
	}
	
	private String getRuntimeType(){
		return server.getClass().getSimpleName();
	}

	public void stop(){
		server.stop();
	}

	private static void initializeSofiaModel() {
		// Initialize the models
		SofiaPackage.eINSTANCE.eClass();
		SofiaInstancePackage.eINSTANCE.eClass();
		//PictogramsPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("diagram", new XMIResourceFactoryImpl());
		m.put("sofia", new XMIResourceFactoryImpl());
		m.put("sofiainstance", new SofiaInstanceFactoryImplCustom());
		m.put("sofiainstance", new XMIResourceFactoryImpl());
	}

	private void registerListener(IConfigurationReader configReader) {
		// Start OSGi Runtime
		if (configReader.startOsgiRuntime())
			OSGiRuntime.getInstance().start();

		// Start OpenHabListener
		if(configReader.startOpenHabListener())
			OpenHabListener.getInstance().start();

		// Start CEP Engine
		if(configReader.startCepEngine())
			EsperEngine.getInstance();

		// Deploy existing process models
		if(configReader.deployExistingProcessModels())
			processManagerPublic.loadExistingModels();
	}

	/**
	 * starts router and server client if this is a SuperPeer. otherwise only the server client is started, 
	 * which connects to the router on the SuperPeer.
	 * @param configReader
	 * @return
	 */
	private boolean startWebSocketServer(IConfigurationReader configReader) {
		try {
			if(configReader.getSuperPeerIp() == null)
				server = new SuperPeer(processManagerPublic, configReader);
			else
				server = new Peer(processManagerPublic, configReader, configReader.getSuperPeerIp());

			server.start();
			return true;
		} catch (ApplicationError e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void deleteExistingModels(){
		File file = new File(PATH_MODEL);
		if(!file.exists()) return;
		for (File tmpFile : file.listFiles()) {
			if(tmpFile.isFile())
				tmpFile.delete();
		}		
	}
	
	private static void readLineTillStopIsEntered() {
		boolean stop = false;
		Scanner scanner = new Scanner(System.in);
		while (!stop) {
			String input = scanner.nextLine();
			if(input != null)
				input = input.toLowerCase();
			stop = "stop".equals(input);
			if(!stop)
				printUsage();				
		}	
		scanner.close();
	}
	
	private static void printUsage(){
		println("######## VICCI RUNTIME ########");
		println("type 'stop' for stopping the runtime");
	}
	
	private static void println(Object txt){
		System.out.println(txt);
	}
}
