package eu.vicci.process.runtime;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.distribution.manager.DistributionManager;
import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.cep.EsperEngine;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.osgi.OSGiRuntime;
import eu.vicci.process.server.http.ProteusHttpServer;
import eu.vicci.process.server.util.RuntimeContext;
import eu.vicci.process.server.util.Util;
import eu.vicci.process.wampserver.Peer;
import eu.vicci.process.wampserver.SuperPeer;
import ws.wamp.jawampa.ApplicationError;

public class VicciRuntime {
	private static final Logger LOG = LoggerFactory.getLogger(VicciRuntime.class);
	private static final String PATH_MODEL = "processes/models/";
	private static final String OPENHAB_MDNS_TYPE = "_openhab-server._tcp.local.";
	private static final String PROTEUS_MDNS_TYPE = "_proteus._tcp.local.";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// https://commons.apache.org/proper/commons-cli/usage.html
		Options options = prepareOptions();
		CommandLine cmd = parseArguments(args, options);
		if (cmd == null)
			return;

		if (cmd.hasOption("help")) {
			HelpFormatter help = new HelpFormatter();
			help.printHelp("vicci-runtime", options);
			return;
		}

		LOG.info("starting vicci runtime...");
		VicciRuntime runtime = new VicciRuntime();

		if (cmd.hasOption("container")) {
			runtime.readConfigFromEnv = true;
		}

		boolean started = runtime.start();
		if (!started) {
			LOG.error("failed to start vicci runtime");
			return;
		}

		ObjectMapper m = new ObjectMapper();
		ObjectReader reader = m.reader();
		Version version = reader.version();
		LOG.info("Jackson Version:\n{}", version.toString());

		LOG.info("vicci runtime started as {}", runtime.getRuntimeType());
	}

	private static CommandLine parseArguments(String[] args, Options options) {
		CommandLineParser parser = new DefaultParser();
		try {
			return parser.parse(options, args);
		} catch (ParseException e) {
			LOG.error(e.getLocalizedMessage());
		}
		return null;
	}

	private static Options prepareOptions() {
		Option optionContainer = Option.builder("container").desc("To tell proteus, it is running in a container. "
				+ "PROtEUS will try to get all config values from the environment.").build();
		Option optionHelp = Option.builder("help").desc("Show this help.").build();
		Options options = new Options();
		options.addOption(optionHelp);
		options.addOption(optionContainer);
		return options;
	}

	private SuperPeer server;
	private IProcessManager processManagerPublic;
	private boolean readConfigFromEnv = false;
	private ProteusHttpServer httpServer;
	private CountDownLatch waitForOHAddress;

	public VicciRuntime() {
		processManagerPublic = new ProcessManagerPublic();
		RuntimeContext.getInstance().registerProcessManager(processManagerPublic);
	}

	public boolean start() throws IOException {
		IConfigurationReader configReader;
		if (readConfigFromEnv)
			configReader = new ConfigurationReader();
		else
			configReader = new ConfigurationReader("server.conf");

		ConfigurationManager.getInstance().updateFromConfigReader(configReader);
		waitForOHAddress = new CountDownLatch(1);

		if (!configReader.deployExistingProcessModels())
			deleteExistingModels();

		JmDNS jmdns = JmDNS.create(getAddressByFilter());
        ServiceInfo serviceInfo = ServiceInfo.create(PROTEUS_MDNS_TYPE, "proteus", 8082, "path=index.html");
		jmdns.registerService(serviceInfo);
		
		// this block will wait, till the openhab address was found if config
		// was set to auto
		try {
			autoResolveOpenHabIfEnabled(jmdns, configReader);
		} catch (Exception e) {
			LOG.error("failed autoresolving openhab, all steps using openhab will probably fail: {}", e.getMessage());
		}

		initializeSofiaModel();
		registerListener(configReader);
		boolean isWebSocketServerStarted = startWebSocketServer(configReader);
		startHttpServer(configReader);

		DistributionManager.getInstance().setPeerProfile(server.getPeerProfile());

		// init process execution system
		LifeCycleManager.INSTANCE.getClass();

		return isWebSocketServerStarted;
	}
	
	private InetAddress getAddressByFilter() throws IOException{
		String ip = Util.getLocalIpWithFilter();
		InetAddress out;
		if(ip == null){
			LOG.error("Failed to get ip via ip filter. Using first localhost ip");
			out = InetAddress.getLocalHost();
		}
		else{
			String[] split = ip.split("\\.");
			out = InetAddress.getByAddress(
					new byte[]{
							(byte)Integer.parseInt(split[0]),
							(byte)Integer.parseInt(split[1]),
							(byte)Integer.parseInt(split[2]),
							(byte)Integer.parseInt(split[3])});
		}
		LOG.info("using host ip for network discovery: '{}'", out.getHostAddress());
		return out;
	}

	private String getRuntimeType() {
		return server.getClass().getSimpleName();
	}

	public void stop() {
		server.stop();
	}

	private static void initializeSofiaModel() {
		// Initialize the models
		SofiaPackage.eINSTANCE.eClass();
		SofiaInstancePackage.eINSTANCE.eClass();
		// PictogramsPackage.eINSTANCE.eClass();

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

		// FIXME depending on the discovery mode
		// Start OpenHabListener
		// if(configReader.startOpenHabListener())
		// OpenHabListener.getInstance().start();

		// Start CEP Engine
		if (configReader.startCepEngine())
			EsperEngine.getInstance();

		// Deploy existing process models
		if (configReader.deployExistingProcessModels())
			processManagerPublic.loadExistingModels();
	}

	private void autoResolveOpenHabIfEnabled(JmDNS jmdns, IConfigurationReader configReader) throws Exception {
		if ("auto".equals(configReader.getOpenHabUri())) {
			LOG.info("searching for openhab...");
			jmdns.addServiceListener(OPENHAB_MDNS_TYPE, ohServiceListener);
			waitForOHAddress.await();
			//update this config reader with the new global setting
			//there is no longer the auto option set for oh uri
			configReader.updateOpenHabUri(ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.OPENHAB_URI));
		}
	}

	private ServiceListener ohServiceListener = new ServiceListener() {
		@Override
		public void serviceAdded(ServiceEvent serviceEvent) {
		}

		@Override
		public void serviceRemoved(ServiceEvent serviceEvent) {
		}

		@Override
		public void serviceResolved(ServiceEvent serviceEvent) {
			try {
				String completeAddress = "http://" + serviceEvent.getInfo().getHostAddresses()[0] + ":"
						+ serviceEvent.getInfo().getPort();
				ConfigurationManager.getInstance().OverrideConfig(ConfigProperties.OPENHAB_URI, completeAddress);
				LOG.info("openhab found on '{}'", completeAddress);
				waitForOHAddress.countDown();
			} catch (Exception e) {
				LOG.error("unable to resolve openhab address {}", e.getMessage());
				LOG.error("steps using openhab will probably fail");
				waitForOHAddress.countDown();
			}
		}
	};

	/**
	 * starts router and server client if this is a SuperPeer. otherwise only
	 * the server client is started, which connects to the router on the
	 * SuperPeer.
	 * 
	 * @param configReader
	 * @return
	 */
	private boolean startWebSocketServer(IConfigurationReader configReader) {
		try {
			if (configReader.getSuperPeerIp() == null)
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

	private void startHttpServer(IConfigurationReader configReader) {
		httpServer = new ProteusHttpServer(configReader.getHttpPort());
		Thread t = new Thread(httpServer);
		t.setName("ProteusHttpServerThread");
		t.setDaemon(true);
		t.start();
	}

	private void deleteExistingModels() {
		File file = new File(PATH_MODEL);
		if (!file.exists())
			return;
		for (File tmpFile : file.listFiles()) {
			if (tmpFile.isFile())
				tmpFile.delete();
		}
	}

}
