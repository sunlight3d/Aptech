package org.ex002.question03;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;


import javax.jms.*;
import java.net.URI;

public final class Server {
    public static final String url = "tcp://localhost:9000";

    public static void main(String[] args) throws Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI(
                String.format("broker:(%s)", url)));
        broker.start();

        Connection connection = null;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
            connection = connectionFactory.createConnection();
            connection.setClientID("Client1"); // Set a unique client ID for durable subscription
            connection.start(); // Start the connection early

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("customerTopic");

            // Producer
            MessageProducer producer = session.createProducer(topic);
            String payload = "Hello, how are you ?";
            TextMessage textMessage = session.createTextMessage(payload);
            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("UserName", "Nguyen Van A");
            mapMessage.setString("Description", "Test sending an object");

            System.out.println("Sending text '" + payload + "'");
            producer.send(textMessage);
            System.out.println("Sending an object");
            producer.send(mapMessage);

            // Consumer
            TopicSubscriber subscriber = session.createDurableSubscriber(topic, "Sub1"); // Durable subscription
            subscriber.setMessageListener(new JMSClient("Consumer 1"));

            // Wait for the consumer to process messages
            Thread.sleep(5000); // Increase sleep time

            session.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
            broker.stop();
        }
    }
}