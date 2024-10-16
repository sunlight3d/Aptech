package com.aptech;

import java.net.URI;
 
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
 
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public final class Server {    
    private static String urlString = "broker:(tcp://localhost:61616)";
    public static void main(String[] args) {              
        try {
            BrokerService broker = BrokerFactory.createBroker(new URI(
                urlString));
            broker.start();
            Connection connection = null;
            // Producer
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    "tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("customerQueue");
            String payload = "Hello JMS";
            Message msg = session.createTextMessage(payload);
            MessageProducer producer = session.createProducer(queue);
            System.out.println("Published: '" + payload + "'");
            producer.send(msg);
 
            // Consumer
            MessageConsumer consumer = session.createConsumer(queue);
            consumer.setMessageListener(new Client("Consumer"));
            connection.start();
            Thread.sleep(1000);
            session.close();
        } catch(Exception e) {
            
        }
    }
}
