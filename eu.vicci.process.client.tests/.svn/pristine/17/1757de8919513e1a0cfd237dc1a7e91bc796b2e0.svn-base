package eu.vicci.process.client.implementation.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import eu.vicci.process.client.handlers.AbstractClientHandler;
import eu.vicci.process.model.util.messages.StateChangeMessage;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import ws.wamp.jawampa.Reply;

public class AbstractClientHandlerTests {

	@Test
	public void stateMessageDeserializationTest() throws IOException {
		TestClientHandler handler = new TestClientHandler();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode stateMessageNode = mapper.readTree(stateMessage);
		ArrayNode stateChangeMessages = mapper.createArrayNode();
		stateChangeMessages.add(stateMessageNode);
		stateChangeMessages.add(stateMessageNode);
		stateChangeMessages.add(stateMessageNode);
		
		handler.testStateMessageDeserialization(stateMessageNode);
		handler.testRecentStateMessageDeserialization(stateChangeMessages);	
	}
	
	private static class TestClientHandler extends AbstractClientHandler{
		@Override
		public void onNext(Reply arg0) {}	
		
		public void testStateMessageDeserialization(JsonNode node){	
			IStateChangeMessage msg = convertFromJson(node, StateChangeMessage.class);
			assertNotNull("state change message deserialization failed", msg);
		}		
		
		public void testRecentStateMessageDeserialization(ArrayNode node){
			@SuppressWarnings("unchecked")
			List<IStateChangeMessage> msg = convertFromJsonToCollectionType(node, List.class, StateChangeMessage.class);
			assertNotNull("state change message deserialization failed", msg);
			assertEquals("list size does not match", 3, msg.size());
			assertEquals("deserialized message id does not match", "_UxWDsMAlEeWSlYT1nLYPsg", msg.get(2).getMessageId());
		}		
	}
	
	private static final String stateMessage = "{\"topic\":null,\"messageId\":\"_UxWDsMAlEeWSlYT1nLYPsg\",\"timeStamp\":1453370224491,\"instanceId\":\"_Fq5jsMi5EeSKccvjc0DMJA_Instance_2\",\"modelId\":\"_dv1Y0Mi4EeSKccvjc0DMJA\",\"processInstanceId\":\"_dv1Y0Mi4EeSKccvjc0DMJA_instance_2\",\"processModelId\":\"_dv1Y0Mi4EeSKccvjc0DMJA\",\"processId\":\"_Fq5jsMi5EeSKccvjc0DMJA\",\"processName\":\"ProcessBottom1\",\"state\":\"ACTIVE\",\"startDataPorts\":{},\"endDataPorts\":{},\"startControlPorts\":{\"_QFBjwMi6EeSKccvjc0DMJA\":{\"portType\":\"StartControlPort\",\"state\":\"DEACTIVATED\",\"portName\":\"start_0\"}},\"endControlPorts\":{\"_fE5R0Mi5EeSKccvjc0DMJA\":{\"portType\":\"EndControlPort\",\"state\":\"INACTIVE\",\"portName\":\"end_bottom1\"}}}";

}
