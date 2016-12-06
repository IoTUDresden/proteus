package eu.vicci.process.runtime;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.elasticsearch.metrics.ElasticsearchReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer.Context;

import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.devices.util.OpenHabListener;
import eu.vicci.process.devices.util.SeMiWaListener;
import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.cep.EsperEngine;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.model.util.logging.LoggingManager;
import eu.vicci.process.osgi.OSGiRuntime;
import eu.vicci.process.wampserver.RuntimeServer;
import ws.wamp.jawampa.ApplicationError;

public class VicciRuntime {

	private Logger LOG = LoggerFactory.getLogger(VicciRuntime.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VicciRuntime runtime = new VicciRuntime();
		println("starting vicci runtime...\n");
		boolean started = runtime.start();
		if(!started){
			printlnErr("\n\nfailed to start vicci runtime");
			return;
		}
		println("\n\nvicci runtime started");
		readLineTillStopIsEntered();
		
		println("\n\nstopping the runtime...");
		runtime.stop();
	}	

	private RuntimeServer server;
	private IProcessManager processManagerPublic;
	
	public VicciRuntime(){	
		processManagerPublic = new ProcessManagerPublic();
	}
	
	public boolean start(){
		IConfigurationReader configReader = new ConfigurationReader("server.conf");
		ConfigurationManager.getInstance().updateFromConfigReader(configReader);
		
		Optional<Context> timer = initReporting();		
		initializeSofiaModel();
		registerListener(configReader);
		boolean isWebSocketServerStarted = startWebSocketServer(configReader);
		
		timer.ifPresent(t -> t.stop());
		return isWebSocketServerStarted;
	}
	
	private Optional<Context> initReporting(){
		String host = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.ELASTICSEARCH_HOST);
		if(host == null)
			return Optional.empty();
		MetricRegistry registry = new MetricRegistry();			
		initializeElasticsearchReportingWith(registry, host);
		
		LoggingManager.getInstance().setMetricsReporter(registry);
		
		return Optional.ofNullable(registry.timer("startup").time());		
	}

	private void initializeElasticsearchReportingWith(MetricRegistry registry, String host) {
		try {
			ElasticsearchReporter reporter = ElasticsearchReporter
					.forRegistry(registry)
					.hosts(host)
					.index("mapek")
					.prefixedWith("proteus")
					.build();
			
			// reporter.start(10, TimeUnit.SECONDS);
			LOG.debug("Using Elasticsearch for metrics reporting");
			
		} catch (IOException e) {
			LOG.warn("Cannot connect to Elasticsearch due to {}", e.getMessage());
		}
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

		// Start SeMiWaListener
		if (configReader.startSemiwaListener())
			SeMiWaListener.getInstance().start();

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

	private boolean startWebSocketServer(IConfigurationReader configReader) {
		try {
			server = new RuntimeServer(processManagerPublic);
			server.start();
			return true;
		} catch (ApplicationError e) {
			e.printStackTrace();
		}
		return false;
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
	
	private static void printlnErr(Object txt){
		System.err.print(txt);
	}
	
	private static void println(Object txt){
		System.out.println(txt);
	}
}
