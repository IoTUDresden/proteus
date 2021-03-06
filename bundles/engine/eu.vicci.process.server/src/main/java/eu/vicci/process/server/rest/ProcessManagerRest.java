package eu.vicci.process.server.rest;

import static eu.vicci.process.server.rest.Messages.ERR_COULD_NOT_DEPLOY_INSTANCE_FOR_ID;
import static eu.vicci.process.server.rest.Messages.ERR_COULD_NOT_DEPLOY_PROCESS;
import static eu.vicci.process.server.rest.Messages.ERR_EXISTING_PROCESS_NO_OVERRIDE;
import static eu.vicci.process.server.rest.Messages.ERR_MISSING_PROCESS_DOC;
import static eu.vicci.process.server.rest.Messages.ERR_MISSING_PROCESS_ID;
import static eu.vicci.process.server.rest.Messages.ERR_PROCESS_NOT_CREATED;
import static eu.vicci.process.server.rest.Messages.ERR_PROCESS_WITH_ID_NOT_FOUND;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
import eu.vicci.process.server.exception.BadRequestException;
import eu.vicci.process.server.exception.NotFoundErrorException;
import eu.vicci.process.server.exception.ServerErrorException;
import eu.vicci.process.server.util.RuntimeContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Rest resource for processes.
 * 
 * Api operations are described by the 
 * <a href="https://github.com/swagger-api/swagger-core/wiki/Annotations-2.X">Swagger Annotations</a>
 * 
 * @author andre
 *
 */
@Path("processes")
@Api(tags = {"processes"})
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
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Lists all deployed process instances, "
			+ "which available for deploying a process instance.",
			response = IProcessInfo.class,
			responseContainer = "List")
	public List<IProcessInfo> deployedProcesses() {
		return processManager.listDeployedProcesses();
	}

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "Uploads a process definition, which is saved to file on server. "
			+ "The process is then deployed to the engine and available for deploying as process instance.",
			notes = "Returns the process id as string for the deployed process",
			response = String.class) 
	@ApiResponses(value = { 
		@ApiResponse(code = 200, message = "Process updaded."),
		@ApiResponse(code = 201, message = "Process uploaded and deployed."),
		@ApiResponse(code = 400, message = "Request contains errors or missing values."),
		@ApiResponse(code = 500, message = "Upload and deployment failed on server. Be sure the model is consistent.")
	})
	public Response uploadAndDeploy(
			@ApiParam(value = "The request for uploading and deploying processes. "
					+ "The setting 'overrideExisting' will not update the model on the server properly at the moment. "
					+ "Set it to 'true' "
					+ "Restart the engine if you want to update the model. "
					+ "'processdocument' should contain the process model (*.diagram file) as string. "
					+ "Restart the engine if you want to update the model.", required = true) 
			UploadAndDeployRequest request) 
			throws BadRequestException, ServerErrorException 
	{
		if (request == null || isNullOrEmpty(request.getProcessdocument()))
			throw new BadRequestException(ERR_MISSING_PROCESS_DOC);
		Process process = null;
		
		try {
			process = getProcessFromString(request.getProcessdocument());
		} catch (Exception e) {
			LOG.error(e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		
		if (process == null)
			throw new ServerErrorException(ERR_PROCESS_NOT_CREATED);
		
		Process tmpProcess = processManager.getProcessInfos(process.getId());
		if(tmpProcess != null && !request.isOverrideExisting())
			throw new BadRequestException(ERR_EXISTING_PROCESS_NO_OVERRIDE, process.getId());
		
		String processId = processManager.uploadAndDeploy(process);
		if (processId == null)
			throw new ServerErrorException(ERR_COULD_NOT_DEPLOY_PROCESS);
		
		return Response
				.status(request.isOverrideExisting() ? Status.OK : Status.CREATED)
				.entity(processId)
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

	@POST
	@Path("{processId}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "Deploys a process instance for the given process id. "
			+ "This instance can then be used for execution.",
			notes = "Returns the instance id as string of the deployed process",
			response = String.class)
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Process instance was created."),
			@ApiResponse(code = 400, message = "Request contains errors or missing values."),
			@ApiResponse(code = 404, message = "The process with the given process id does not exist on the server."),
			@ApiResponse(code = 500, message = "Upload and deployment failed on server. Be sure the model is consistent.")
		})
	public String deployProcessInstance(
			@ApiParam(value = "The process id for the process which should be deployed as instance.", required = true)
			@PathParam("processId") String processId) 
			throws BadRequestException, NotFoundErrorException, ServerErrorException 
	{
		if (isNullOrEmpty(processId))
			throw new BadRequestException(ERR_MISSING_PROCESS_ID);
		
		Process process = processManager.getProcessInfos(processId);
		if (process == null)
			throw new NotFoundErrorException(ERR_PROCESS_WITH_ID_NOT_FOUND, processId);
		
		String instanceId = processManager.deployProcessInstance(processId);
		if(instanceId == null)
			throw new ServerErrorException(ERR_COULD_NOT_DEPLOY_INSTANCE_FOR_ID, processId);
		
		return instanceId;
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
	 *             Thrown if something is wrong with the document or the
	 *             document failed to load to resource.
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
		resSet.getResourceFactoryRegistry()
		.getExtensionToFactoryMap()
		.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// this option let us load a diagram file without to have graphiti stuff
		// in the classpath
		// otherwise an exception is thrown if the graphiti.mm package is not
		// found
		resSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		return resSet;
	}

}
