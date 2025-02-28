/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package question03;
import java.util.*;
import javax.jms.*;
import org.apache.activemq.*;
public class JMSProducer {
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

            // Tạo Queue
            Destination destination = session.createQueue(queueName);

            // Tạo Producer
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Nhập dữ liệu từ bàn phím
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên người gửi: ");
            String userName = scanner.nextLine();
            System.out.print("Nhập mô tả: ");
            String description = scanner.nextLine();

            // Tạo MapMessage
            MapMessage message = session.createMapMessage();
            message.setString("UserName", userName);
            message.setString("Time", new java.util.Date().toString());
            message.setString("Description", description);

            // Gửi tin nhắn
            producer.send(message);
            System.out.println("Tin nhắn đã được gửi!");

            // Đóng kết nối
            session.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
