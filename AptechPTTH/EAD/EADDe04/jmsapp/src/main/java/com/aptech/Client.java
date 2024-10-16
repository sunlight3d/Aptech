package com.aptech;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
 
public class Client implements MessageListener {
    private String consumerName;
    public Client(String consumerName) {
        this.consumerName = consumerName;
    }
 
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println("Received " + textMessage.getText());
        } catch (JMSException e) {          
            e.printStackTrace();
        }
    }
 
}
