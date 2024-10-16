package com.aptech.question03;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.jms.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
public class Main {
    public static final String brokerURL = "tcp://localhost:61616";
    public static void main(String[] args) throws URISyntaxException, Exception {
        BrokerService broker = BrokerFactory.createBroker(new URI(
                String.format("broker:(%s)", brokerURL)));
        broker.start();
        Connection connection = null;
        try {
            // Producer
            int i = 0;
            while (true) {
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                        brokerURL);
                connection = connectionFactory.createConnection();
                Session session = connection.createSession(false,
                        Session.AUTO_ACKNOWLEDGE);
                Queue queue = session.createQueue("customerQueue");
                String payload = "Hello, how are you ?";
                Message textMessage = session.createTextMessage(payload);

                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("UserName", "Nguyen Van A");
                mapMessage.setString("Description", "Test sending an object");
                DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                String isoDate = isoFormatter.format(ZonedDateTime.now().withFixedOffsetZone());
                mapMessage.setString("Time", isoDate);

                MessageProducer producer = session.createProducer(queue);
                System.out.println("Sending text '" + payload + "'");
                producer.send(textMessage);
                System.out.println("Sending an object");
                producer.send(mapMessage);

                // Consumer
                MessageConsumer consumer = session.createConsumer(queue);
                consumer.setMessageListener(new Consumer(
                        String.format("Consumer %d", i)));
                connection.start();
                Thread.sleep(1000);
                session.close();
                i++;
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            broker.stop();
        }
    }
}