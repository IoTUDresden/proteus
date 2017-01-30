package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import eu.vicci.process.model.sofia.StringType;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.glassfish.jersey.media.sse.EventInput;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.concurrent.CountDownLatch;

import static java.lang.String.format;
import static java.util.stream.Collectors.toSet;
import static javax.ws.rs.core.UriBuilder.fromPath;

public class Compensation extends AbstractStep {

    private static final Logger LOG = Logger.getLogger(Compensation.class);

    private static final String GOAL = "Goal";

    private static final String CONTEXT_URI = "ContextUri";

    private static final String SERVICE_URI = "FeedbackServiceUri";

    private static final String WORKFLOW_NAME = "WorkflowName";

    private static final String HAS_BEEN_SATISFIED = "HasBeenSatisfied";

    private static final String HAS_BEEN_FINISHED = "HasBeenFinished";


    private final Gson parser = new Gson();

    private CloseableHttpClient httpClient;

    private Client sseClient;

    private String workflowUri;

    private String serviceUri;

    private boolean hasBeenSatisfied = false;

    private boolean hasBeenFinished = true;
    
    private CountDownLatch waitForEvent;


    @Override
    protected void work() {
    	waitForEvent = new CountDownLatch(1);
    	
        prepare();
        LOG.info("Start compensating feedback loop");

        createWorkflow();
        LOG.info(format("Workflow %s created", workflowUri));
        
        waitForEvent();
        createGoals();
        LOG.info("Goals created. Waiting for feedback loop");
        
        try {
			waitForEvent.await();
		    LOG.info(format("Workflow done. Satisfaction is %s", hasBeenSatisfied));
		} catch (InterruptedException e) {
			LOG.error("I'm interrupted...", e);
		} finally {
			publishExecutionFlags();
	        deleteWorkflow();
	        finish();			
		}
    }

    private void createWorkflow() {
        JsonObject workflow = new JsonObject();
        workflow.addProperty("name", stringParameter(WORKFLOW_NAME) + "." + instanceId);
        workflow.addProperty("context", stringParameter(CONTEXT_URI));

        workflowUri = post("workflows", workflow.toString())
            .get("_links").getAsJsonObject()
            .get("self").getAsJsonObject()
            .get("href").getAsString();
    }

    private void createGoals() {
        goals().stream()
                .map(it -> parser.fromJson(it, JsonObject.class))
                .forEach(it -> {
                    it.addProperty("workflow", fromPath(workflowUri).build().toString());
                    String goalUri = post("goals", it.toString())
                            .get("_links").getAsJsonObject()
                            .get("self").getAsJsonObject()
                            .get("href").getAsString();

                    LOG.info(format("Goal %s created", goalUri));
                });
    }

    private void waitForEvent() {
    	new Thread(() ->{
            EventInput eventInput = sseClient
                    .target(fromPath(serviceUri).path("events").path(fromPath(workflowUri).build().getPath()))
                    .request().get(EventInput.class);

            while (!eventInput.isClosed()) {
                final InboundEvent event = eventInput.read();
                if (workflowHasBeenDone(event.readData()))
                    break;
            }
            
            waitForEvent.countDown();    		
    	}).start();    	
    }

    private boolean workflowHasBeenDone(String json) {
        JsonObject workflow = parser.fromJson(json, JsonObject.class);
        hasBeenSatisfied = workflow.get("hasBeenSatisfied").getAsBoolean();
        hasBeenFinished = workflow.get("hasBeenFinished").getAsBoolean();
        return hasBeenFinished || hasBeenSatisfied;
    }

    private void publishExecutionFlags() {
        addOutgoing(booleanNamed(HAS_BEEN_SATISFIED, hasBeenSatisfied));
        addOutgoing(booleanNamed(HAS_BEEN_FINISHED, hasBeenFinished));
    }

    private void deleteWorkflow() {
        try {
            httpClient.execute(new HttpDelete(fromPath(workflowUri).build()));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
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

    private void prepare() {
        httpClient = HttpClients.createDefault();
        sseClient = ClientBuilder.newBuilder().register(SseFeature.class).build();
        serviceUri = stringParameter(SERVICE_URI);
    }

    private void finish() {
        try {
            httpClient.close();
            sseClient.close();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Collection<String> goals() {
        return parameters(GOAL, StringType.class)
                .map(it -> (String) it)
                .collect(toSet());
    }

}
