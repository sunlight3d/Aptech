import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer {

    public static void main(String[] args) throws JMSException {
        // ConnectionFactory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Create connection and start
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Create session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Create Queue
        Queue queue = session.createQueue("myQueue");

        // Create MessageConsumer
        MessageConsumer consumer = session.createConsumer(queue);

        // Implement MessageListener
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                try {
                    if (message instanceof MapMessage) {
                        MapMessage mapMessage = (MapMessage) message;
                        String userName = mapMessage.getString("UserName");
                        long time = mapMessage.getLong("Time");
                        String description = mapMessage.getString("Description");

                        System.out.println("UserName: " + userName);
                        System.out.println("Time: " + time);
                        System.out.println("Description: " + description);
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        // Wait for messages
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Clean up
        session.close();
        connection.close();
    }
}
