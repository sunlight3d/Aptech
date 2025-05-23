package org.ex002.question03;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JMSClient implements MessageListener {
    private String consumerName;
    public JMSClient(String consumerName) {
        this.consumerName = consumerName;
    }
    @Override
    public void onMessage(javax.jms.Message message) {
        try {
            if (message instanceof MapMessage) {
                handleMapMessage((MapMessage) message);
            } else if (message instanceof TextMessage) {
                handleTextMessage((TextMessage) message);
            } else {
                System.out.println("Unsupported message type received: " + message.getClass().getName());
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    private void handleMapMessage(MapMessage mapMessage) throws JMSException {
        String userName = mapMessage.getString("UserName");
        long time = mapMessage.getJMSTimestamp();
        String description = mapMessage.getString("Description");
        System.out.printf("Received: %s, %d, %s%n", userName, time, description);
    }

    private void handleTextMessage(TextMessage textMessage) throws JMSException {
        System.out.println(consumerName + " received " + textMessage.getText());
    }

}