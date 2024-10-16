import javax.jms.*;

public class Consumer implements MessageListener {
    private String consumerName;
    public Consumer(String consumerName) {
        this.consumerName = consumerName;
    }

    public void onMessage(Message message) {
        if(message instanceof MapMessage) {
            MapMessage mapMessage = (MapMessage) message;
            try {
                String userName = mapMessage.getString("UserName");
                long time = mapMessage.getJMSTimestamp();
                String description = mapMessage.getString("Description");
                System.out.printf(String.format("Received: %s, %d, %s", userName, time, description));
            } catch (JMSException e) {
                e.printStackTrace();
            }
        } else if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;

            try {
                System.out.println(consumerName + " received " + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }

}