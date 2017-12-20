package eu.vicci.process.server.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.client.core.UploadAndDeployRequest;
import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.server.util.RuntimeContext;

//TODO use swagger.io for api description
@Path("processes")
public class ProcessManagerRest {
	private static final Logger LOG = LoggerFactory.getLogger(ProcessManagerRest.class);
	private final IProcessManager processManager;

	public ProcessManagerRest() {
		registerResourceFactories(); // maybe this is not needed
		processManager = RuntimeContext.getInstance().getProcessManager();
	}

	public IProcessManager getProcessManager() {
		return processManager;
	}

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "ready? " + (processManager != null);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<IProcessInfo> deployedProcesses() {
		return processManager.listDeployedProcesses();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response uploadAndDeploy(UploadAndDeployRequest request) {
		if (request == null || isNullOrEmpty(request.getProcessdocument()))
			return Response.status(Status.BAD_REQUEST).build();

		Process process = null;

		try {
			process = getProcessFromString(request.getProcessdocument());
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage());
			return Response.serverError().build();
		}

		if (process == null)
			return Response.serverError().build();
		
		processManager.uploadAndDeploy(process);
		return Response.ok(process.getId(), MediaType.TEXT_PLAIN).build();
	}

	private static boolean isNullOrEmpty(String value) {
		if (value == null)
			return true;
		return value.isEmpty();
	}

	private static void registerResourceFactories() {
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("diagram", new XMIResourceFactoryImpl());
		m.put("sofia", new XMIResourceFactoryImpl());
		m.put("sofiainstance", new XMIResourceFactoryImpl());
	}

	/**
	 * @throws Exception
	 *             Thrown if something is wrong with the document or the document
	 *             failed to load to resource.
	 */
	private Process getProcessFromString(String input) throws Exception {
		ResourceSet resSet = getConfiguredResourceSet();
		Resource resource = resSet.createResource(URI.createURI("*.sofia"));
		resource.load(new URIConverter.ReadableInputStream(input), resSet.getLoadOptions());

		EObject p = resource.getContents().get(0);
		if (p instanceof Process)
			return (Process) p;
		p = resource.getContents().get(1);
		return (Process) p;
	}

	private ResourceSet getConfiguredResourceSet() {
		ResourceSet resSet = new ResourceSetImpl();

		resSet.getPackageRegistry().put(SofiaPackage.eINSTANCE.getNsURI(), SofiaPackage.eINSTANCE);
		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());

		// this option let us load a diagram file without to have graphiti stuff
		// in the classpath
		// otherwise an exception is thrown if the graphiti.mm package is not
		// found
		resSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		return resSet;
	}

}
