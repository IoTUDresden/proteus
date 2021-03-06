package eu.vicci.process.server.http;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.server.events.StateChangesSse;
import eu.vicci.process.server.exception.BadRequestException;
import eu.vicci.process.server.rest.ProcessManagerRest;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

/**
 * Encapsulates jetty http server for REST and HTTP services.
 * 
 * @author andre
 */
public class ProteusHttpServer implements Runnable {
	private static final Logger LOG = LoggerFactory.getLogger(ProteusHttpServer.class);
	
	public static final String REST_BASE_PATH = "/rest";
	private static final String REST_PATH = REST_BASE_PATH + "/*";
	private static final String SSE_PATH = "/events/*";
	private static final String HTTP_CTX_PATH = "/";
	private static final String SWAGGER_PATH = "/api/*";

	private final int httpPort;
	private final Server server;

	public ProteusHttpServer(int httpPort) {
		server = new Server(httpPort);
		this.httpPort = httpPort;

		Handler http = getHttpHandler();
		Handler servlets = getServletsHandler();

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { http, servlets });

		server.setHandler(handlers);
	}

	private Handler getServletsHandler() {
		ServletContextHandler restHandler = new ServletContextHandler(server, HTTP_CTX_PATH);
		restHandler.addServlet(getRestServlet(), REST_PATH);
		restHandler.addServlet(getSseServlet(), SSE_PATH);
		restHandler.addServlet(getSwaggerServlet(), SWAGGER_PATH);
		return restHandler;
	}

	private ServletHolder getRestServlet() {
		ResourceConfig restConfig = new ResourceConfig();
		restConfig.register(JacksonJsonProvider.class);
		restConfig.register(JacksonFeature.class);
		restConfig.packages(ProcessManagerRest.class.getPackage().getName());
		restConfig.packages(BadRequestException.class.getPackage().getName());
		ServletHolder restServlet = new ServletHolder(new ServletContainer(restConfig));
		return restServlet;
	}

	private ServletHolder getSseServlet() {
		ResourceConfig sseConfig = new ResourceConfig();
//		sseConfig.register(JacksonFeature.class);
		sseConfig.packages(StateChangesSse.class.getPackage().getName());
		sseConfig.packages(BadRequestException.class.getPackage().getName());
		ServletHolder sseServlet = new ServletHolder(new ServletContainer(sseConfig));
		return sseServlet;
	}

	private Handler getHttpHandler() {
		ResourceHandler httpHandler = new ResourceHandler();
		httpHandler.setBaseResource(Resource.newClassPathResource("web"));
		httpHandler.setWelcomeFiles(new String[] { "index.html" });
		httpHandler.setRedirectWelcome(true);
		return httpHandler;
	}

	private ServletHolder getSwaggerServlet() {
		ResourceConfig resConfig = new ResourceConfig();
//		resConfig.register(MOXyJsonProvider.class);
		resConfig.register(JacksonJsonProvider.class);
		resConfig.register(JacksonFeature.class);
		resConfig.packages(ProcessManagerRest.class.getPackage().getName());
		resConfig.packages(ApiListingResource.class.getPackage().getName());
		resConfig.packages(SwaggerSerializers.class.getPackage().getName());
		return new ServletHolder(new ServletContainer(resConfig));
	}

	private void start() {
		LOG.debug("starting proteus http server on port '{}'...", httpPort);
		try {
			server.start();
			server.join();
		} catch (Exception ex) {
			LOG.error(ex.getMessage());
		} finally {
			server.destroy();
		}
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			server.destroy();
		}
	}

	@Override
	public void run() {
		start();
	}

}
