/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question03;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.Message;


public class JMSConsumer {
    public static void main(String[] args) {
        // URL của ActiveMQ (thay đổi nếu cần)
        String brokerURL = "tcp://localhost:61616";
        String queueName = "UserQueue";

        try {
            // Kết nối đến ActiveMQ
            ConnectionFactory factory = new ActiveMQConnectionFactory(brokerURL);
            Connection connection = factory.createConnection();
            connection.start();

            // Tạo session không dùng giao dịch (transacted=false) và chế độ xác nhận AUTO_ACKNOWLEDGE
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Lấy Queue
            Destination destination = session.createQueue(queueName);

            // Tạo Consumer
            MessageConsumer consumer = session.createConsumer(destination);
            System.out.println("Đang đợi tin nhắn...");

            // Lắng nghe tin nhắn
            while (true) {
                javax.jms.Message message = consumer.receive();
                if (message instanceof MapMessage) {
                    MapMessage mapMessage = (MapMessage) message;
                    System.out.println("📩 Tin nhắn nhận được:");
                    System.out.println("UserName: " + mapMessage.getString("UserName"));
                    System.out.println("Time: " + mapMessage.getString("Time"));
                    System.out.println("Description: " + mapMessage.getString("Description"));
                    System.out.println("-----------------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
