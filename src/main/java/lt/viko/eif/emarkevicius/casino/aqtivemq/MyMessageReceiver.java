package lt.viko.eif.emarkevicius.casino.aqtivemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *  The MyMessageReceiver class represents a message receiver that
 *  receives messages from a specified queue using ActiveMQ message broker.
 *
 * @author Ernestas
 * @see MyMessageReceiver
 * @since 1.0
 */
public class MyMessageReceiver {
    private static final String QUEUE_NAME = "MY_QUEUE";

    private Connection connection;

    private MessageConsumer consumer;

    private Session session;

    /**
     *  Constructor for MyMessageReceiver class that creates an instance
     *  of ConnectionFactory and establishes a connection to the ActiveMQ broker.
     *  @throws JMSException if there is an error in creating the connection or session.
     */
    public MyMessageReceiver() throws JMSException {
        ConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        this.connection = connectionFactory.createConnection();
        this.connection.start();

        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);
        this.consumer = session.createConsumer(destination);
    }

    /**
     * Receives a message from the specified queue and prints the message
     * to the console if the message is a TextMessage.
     * @throws JMSException if there is an error in receiving the message.
     */
    public void receiveMessage() throws JMSException{

        Message message = consumer.receive();

        if(message instanceof TextMessage){
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received message "
                    +  textMessage.getText() + " from " + QUEUE_NAME);
        }
        close();
    }

    /**
     * Closes the connection to the ActiveMQ broker.
     * @throws JMSException if there is an error in closing the connection.
     */
    public void close() throws JMSException{
        this.connection.close();
    }
}
