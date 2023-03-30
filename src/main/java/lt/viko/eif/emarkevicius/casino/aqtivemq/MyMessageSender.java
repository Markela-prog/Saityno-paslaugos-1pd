package lt.viko.eif.emarkevicius.casino.aqtivemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * The MyMessageSender class represents a message sender that sends
 * XML files to a specified queue using ActiveMQ message broker.
 *
 * @author Ernestas
 * @see MyMessageSender
 * @since 1.0
 */
public class MyMessageSender {
    private static final String QUEUE_NAME = "MY_QUEUE";

    private Connection connection;

    private MessageProducer producer;

    private Session session;
    /**
     * Constructor for MyMessageSender class that creates an instance of ConnectionFactory and establishes
     * a connection to the ActiveMQ broker.
     *
     * @throws JMSException if there is an error in creating the connection or session.
     */
    public MyMessageSender() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        this.connection = connectionFactory.createConnection();
        this.connection.start();
        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
    }

    /**
     * This method creates a message producer to send messages to the specified queue.
     *
     * @return A MessageProducer instance for sending messages to the queue.
     * @throws JMSException if there is an error in creating the message producer.
     */
    private MessageProducer getMessageProducer() throws JMSException {
        Destination destination = this.session.createQueue(QUEUE_NAME);
        return session.createProducer(destination);
    }

    /**
     * This method sends an XML file to the specified queue.
     *
     * @param xmlFile The XML file to be sent.
     * @throws JMSException if there is an error in sending the message.
     * @throws IOException if there is an error in reading the XML file.
     */

    public void sendMessage(File xmlFile) throws JMSException, IOException {
        try {
            MessageProducer producer = getMessageProducer();
            BytesMessage message = session.createBytesMessage();

            // Read the contents of the XML file into a byte array
            FileInputStream fileInputStream = new FileInputStream(xmlFile);
            byte[] xmlBytes = fileInputStream.readAllBytes();
            fileInputStream.close();

            // Set the byte array as the message payload
            message.writeBytes(xmlBytes);

            // Set additional properties if needed
            message.setStringProperty("test.xml", xmlFile.getName());

            producer.send(message);
            System.out.println("Sent XML file: " + xmlFile.getName());
        } finally {
            connection.close();
        }
    }
    /**
     * This method closes the connection to the ActiveMQ broker.
     *
     * @throws JMSException if there is an error in closing the connection.
     */
    public void close() throws JMSException{
        this.connection.close();
    }
}
