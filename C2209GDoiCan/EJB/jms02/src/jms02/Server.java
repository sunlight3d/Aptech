/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jms02;

import javax.jms.*;
import javax.jms.Connection;
import java.net.URI;
import org.apache.activemq.*;
import org.apache.activemq.broker.*;

public final class Server {    
    public static final String url = "tcp://localhost:61616";
    public static void main(String[] args) throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI(
                String.format("broker:(%s)", url)));
        broker.start();
        Connection connection = null;
        try {
            // Producer
            int i = 0;
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                        url);
                connection = connectionFactory.createConnection();
                Session session = connection.createSession(false,
                        Session.AUTO_ACKNOWLEDGE);
                //Queue queue = session.createQueue("customerQueue");
                Topic topic = session.createTopic("customerTopic");
                String payload = "Hello, how are you ?";
                var textMessage = session.createTextMessage(payload);

                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("UserName", "Nguyen Van A");
                mapMessage.setString("Description", "Test sending an object");

                MessageProducer producer = session.createProducer(topic);
                System.out.println("Sending text '" + payload + "'");
                producer.send(textMessage);
                System.out.println("Sending an object");
                producer.send(mapMessage);

                // Consumer
                MessageConsumer consumer = session.createConsumer(topic);
                consumer.setMessageListener(new JMSClient(
                        String.format("Consumer %d", i)));
                connection.start();
                Thread.sleep(10000);
                session.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
            broker.stop();
        }
    }
}
