import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSQueueReceiver {
    public static void main(String[] args) throws JMSException {
        // Tạo ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Tạo Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Tạo Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Tạo Queue và Consumer
        Queue queue = session.createQueue("DemoQueue");
        MessageConsumer consumer = session.createConsumer(queue);

        // Nhận tin nhắn
        TextMessage message = (TextMessage) consumer.receive();
        System.out.println("Received: " + message.getText());

        // Đóng kết nối
        session.close();
        connection.close();
    }
}
