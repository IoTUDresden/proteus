package eu.vicci.process.model.sofiainstance.util;

import static java.lang.String.format;
import static javax.ws.rs.core.UriBuilder.fromPath;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.UriBuilder;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.glassfish.jersey.media.sse.EventInput;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import eu.vicci.process.model.sofiainstance.util.processstepclasses.Compensation;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;

/**
 * Add a {@link CompensationListener} to get the final state of the compensation.
 * 
 */
public class CompensationWorker implements Runnable {
    private static final Logger LOG = LoggerFactory.getLogger(Compensation.class);
    
    public static final String GOAL = "Goal";
    public static final String CONTEXT_URI = "ContextUri";
    public static final String SERVICE_URI = "FeedbackServiceUri";
    public static final String WORKFLOW_NAME = "WorkflowName";
    public static final String HAS_BEEN_SATISFIED = "HasBeenSatisfied";
    public static final String HAS_BEEN_FINISHED = "HasBeenFinished";    
   
    private final Gson parser = new Gson();
    private CloseableHttpClient httpClient;
    
    private Client sseClient;
    private String workflowUri;
    private String serviceUri;
    
	private CompensationListener listener;	
    private CountDownLatch waitForEvent;
	
    private ExecutionFlags flags = new ExecutionFlags();
    
    private String workflowName;    
    private String contextUri;    
    private Collection<String> goals = new HashSet<>();
    private Map<String, Object> parameters = new HashMap<>();
    private String instanceId;
    
    private Object lock = new Object();


	@Override
	public void run() {
		addDefaultParameters();
		
    	waitForEvent = new CountDownLatch(1);
    	
        prepare();
		checkSettings();
        LOG.info("Start compensating feedback loop");

        createWorkflow();
        LOG.info(format("Workflow %s created", workflowUri));
        
        waitForEvent();
        createGoals();
        LOG.info("Goals created. Waiting for feedback loop");
        
        try {
			waitForEvent.await();
		    LOG.info(format("Workflow done. Satisfaction is %s", flags.hasBeenSatisfied));
		} catch (InterruptedException e) {
			LOG.error("I'm interrupted...", e);
		} finally {
	        deleteWorkflow();
	        finish();			
		}				
	}
	
	public void setListener(CompensationListener listener){
		synchronized(lock){
			this.listener = listener;		
		}
	}
	
	public void setWorkflowName(String workflowName){
		this.workflowName = workflowName;
	}
	
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
	public void addGoal(String goal){
		goals.add(goal);
	}
	
	public void addParameter(String name, Object value){
		parameters.put(name, value);
	}
	
	public ExecutionFlags getExecutionFlags(){
		return flags;
	}
	
    private void prepare() {
        httpClient = HttpClients.createDefault();
        sseClient = ClientBuilder.newBuilder().register(SseFeature.class).build();
        serviceUri = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.FEEDBACK_SERVICE_URI);
        contextUri = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.FEEDBACK_CONTEXT_URI);
    }
    
    private void addDefaultParameters(){
    	addParameter("piid", instanceId);
    }
    
    private void waitForEvent() {
		new Thread(() -> {
			try {
				UriBuilder target = fromPath(serviceUri).path("events").path(fromPath(workflowUri).build().getPath());
				EventInput eventInput = sseClient.target(target).request().get(EventInput.class);

				while (!eventInput.isClosed()) {
					final InboundEvent event = eventInput.read();
					if (workflowHasBeenDone(event.readData()))
						break;
				}
			} catch (Exception e) {
				LOG.error("Error while waiting for the result of the Workflow '{}'", workflowUri);
				e.printStackTrace();
				flags = new ExecutionFlags();
				flags.hasBeenFinished = false;
				flags.hasBeenSatisfied = false;
			} finally {
				waitForEvent.countDown();
			}
		}).start(); 	
    }
    
    private boolean workflowHasBeenDone(String json) {
        JsonObject workflow = parser.fromJson(json, JsonObject.class);
        flags.hasBeenSatisfied = workflow.get("hasBeenSatisfied").getAsBoolean();
        flags.hasBeenFinished = workflow.get("hasBeenFinished").getAsBoolean();
        return flags.hasBeenFinished || flags.hasBeenSatisfied;
    }
    
    private void createGoals() {
    	JsonElement params = parser.toJsonTree(parameters);
    	
        goals.stream()
                .map(it -> parser.fromJson(it, JsonObject.class))
                .forEach(it -> {
                    it.addProperty("workflow", fromPath(workflowUri).build().toString());
                    it.add("parameters", params);
                    String goalUri = post("goals", it.toString())
                            .get("_links").getAsJsonObject()
                            .get("self").getAsJsonObject()
                            .get("href").getAsString();

                    LOG.info(format("Goal %s created", goalUri));
                });
    }
    
    private void createWorkflow() {
        JsonObject workflow = new JsonObject();
        workflow.addProperty("name", workflowName + "." + instanceId);
        workflow.addProperty("context", contextUri);

        workflowUri = post("workflows", workflow.toString())
            .get("_links").getAsJsonObject()
            .get("self").getAsJsonObject()
            .get("href").getAsString();
    }
    
    private void deleteWorkflow() {
        try {
            httpClient.execute(new HttpDelete(fromPath(workflowUri).build()));
        } catch (IOException exception) {
            LOG.error("cant delete workflow from fbs: {}", workflowUri);
        }
    }
    
    private void finish() {
        try {
            httpClient.close();
            sseClient.close();
        } catch (IOException exception) {
        	LOG.error("error closing connection to fbs");
        } finally{
        	synchronized(lock){
        		if(listener != null)
        			listener.compensationFinished(flags);    
        	}
        }
    }
    
    private JsonObject post(String path, String json) {
        URI uri = fromPath(serviceUri).path(path).build();
        StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
        HttpPost post = new HttpPost(uri);
        post.setEntity(entity);

        try {
            CloseableHttpResponse response = httpClient.execute(post);
            return new Gson().fromJson(EntityUtils.toString(response.getEntity()), JsonObject.class);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
    
    private void checkSettings(){
		if(listener == null) LOG.warn("No CompensationListener listener set. Final state of compensation will be lost");
		if(workflowName == null || workflowName.isEmpty()) throw new RuntimeException("WorkflowName not set");
		if(contextUri == null || contextUri.isEmpty()) throw new RuntimeException("ContextUri not set");
		if(serviceUri == null || serviceUri.isEmpty()) throw new RuntimeException("Service URI not set");
		if(instanceId == null || instanceId.isEmpty()) throw new RuntimeException("Instance ID not set");
    }	
	
    ////////////////////////////////////////////////////
    //////////////////// Helper Classes
    ////////////////////////////////////////////////////
    
	public static interface CompensationListener{
		void compensationFinished(ExecutionFlags flags);
	}
	
	public static class ExecutionFlags{
		public boolean hasBeenSatisfied;
		public boolean hasBeenFinished;		
	}

}
