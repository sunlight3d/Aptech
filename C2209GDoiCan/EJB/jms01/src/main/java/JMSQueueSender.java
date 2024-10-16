import javax.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSQueueSender {
    public static void main(String[] args) throws JMSException {
        // Tạo ConnectionFactory
        ActiveMQConnectionFactory connectionFactory = 
                new ActiveMQConnectionFactory("tcp://localhost:61616");

        // Tạo Connection
        Connection connection = connectionFactory.createConnection();
        connection.start();

        // Tạo Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Tạo Queue
        Queue queue = session.createQueue("DemoQueue");

        // Tạo Producer và gửi tin nhắn
        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage("Chao cac ban toi la nguoi gui!");
        producer.send(message);

        // Đóng kết nối
        session.close();
        connection.close();

        System.out.println("Message sent to DemoQueue.");
    }
}
