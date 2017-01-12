package eu.vicci.process.distribution.endpoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import eu.vicci.process.distribution.logging.DistributionCommand;
import eu.vicci.process.distribution.logging.LogEntry;
import eu.vicci.process.distribution.manager.DistributionManagerOLD;
 
public class Client implements MessageListener {
    private static int ackMode;
    private static String clientQueueName;
    private static String serverQueueName;

 
    private boolean transacted = false;
    private MessageProducer producer;
	private Destination tempDest;
	private Session session;
	private Destination adminQueue;
 
    static {
        clientQueueName = "client.messages";
        serverQueueName = "server.messages";
        ackMode = Session.AUTO_ACKNOWLEDGE;
    }
 
    @SuppressWarnings("unchecked")
	public Client() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connectionFactory.setTrustedPackages(new ArrayList(Arrays.asList("eu.vicci.process.distribution.logging")));
        Connection connection;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(transacted, ackMode);
            adminQueue = session.createTopic(clientQueueName);
 
            //Setup a message producer to send message to the queue the server is consuming from
            this.producer = session.createProducer(adminQueue);
            this.producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
 
            tempDest = session.createTopic(serverQueueName);
            MessageConsumer responseConsumer = session.createConsumer(tempDest);
            
            //This class will handle the messages to the temp queue as well
            responseConsumer.setMessageListener(this);
 
            //Now create the actual message you want to send
//            TextMessage txtMessage = session.createTextMessage();
//            txtMessage.setText("MyProtocolMessage");
// 
//            //Set the reply to field to the temp queue you created above, this is the queue the server
//            //will respond to
//            txtMessage.setJMSReplyTo(tempDest);
// 
//            //Set a correlation ID so when you get a response you know which sent message the response is for
//            //If there is never more than one outstanding message to the server then the
//            //same correlation ID can be used for all the messages...if there is more than one outstanding
//            //message to the server you would presumably want to associate the correlation ID with this
//            //message somehow...a Map works good
//            String correlationId = this.createRandomString();
//            txtMessage.setJMSCorrelationID(correlationId);
//            this.producer.send(txtMessage);
        } catch (JMSException e) {
            //Handle the exception appropriately
        }
    }
 
    private String createRandomString() {
        Random random = new Random(System.currentTimeMillis());
        long randomLong = random.nextLong();
        return Long.toHexString(randomLong);
    }
    @Override
    public void onMessage(Message message) {
    	//System.out.println("Client Received Message");
        String messageText = null;
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                messageText = textMessage.getText();
                //System.out.println("messageText = " + messageText);
            } else if (message instanceof ObjectMessage){
            	ObjectMessage objMessage = (ObjectMessage) message;
            	if (objMessage.getObject() instanceof DistributionCommand){
            		DistributionCommand cmd = (DistributionCommand) objMessage.getObject(); 
            		System.out.println("Command received: "+cmd);
            		DistributionManagerOLD mng = DistributionManagerOLD.getInstance();
            		mng.switchPeerCommand(cmd.getPeerIp(), cmd.getPeerName(), cmd.getProcessName());
            	}
            }
            
        } catch (JMSException e) {
           System.err.println("Error with message decoding: "+ e);
           e.printStackTrace();
        }
    }
    public void sendMessage(LogEntry entry){
    	try {
        String correlationId = this.createRandomString();
        ObjectMessage message = session.createObjectMessage(entry);
        message.setJMSCorrelationID(correlationId);
        	//System.out.println("Sending Log Message");
			this.producer.send(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args) {
        new Client();
    }
}