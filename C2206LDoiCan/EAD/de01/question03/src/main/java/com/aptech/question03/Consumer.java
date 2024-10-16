package com.aptech.question03;

import javax.jms.*;

public class Consumer implements MessageListener {
    private String consumerName;

    public Consumer(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof MapMessage) {
                handleMapMessage((MapMessage) message);
            } else if (message instanceof TextMessage) {
                handleTextMessage((TextMessage) message);
            } else {
                System.out.println("Received unsupported message type.");
            }
        } catch (JMSException e) {
            System.err.println("Error processing message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void handleMapMessage(MapMessage mapMessage) throws JMSException {
        String userName = mapMessage.getString("UserName");
        //long time = mapMessage.getJMSTimestamp();
        String description = mapMessage.getString("Description");
        System.out.printf("Received MapMessage: UserName=%s, Time=%s, Description=%s%n",
                userName, mapMessage.getString("Time"), description);
    }

    private void handleTextMessage(TextMessage textMessage) throws JMSException {
        String text = textMessage.getText();
        System.out.println(consumerName + " received TextMessage: " + text);
    }
}
