package com.demo.kafka.demo.components;

import com.demo.kafka.demo.models.Product;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@KafkaListener(id = "multiGroup", topics = { "product" })
public class MyKafkaListener {
    private final TaskExecutor exec = new SimpleAsyncTaskExecutor();

    private void terminateMessage() {
        this.exec.execute(() -> System.out.println("Hit Enter to terminate..."));
    }
    /*
    @KafkaHandler
    public void foo(Object something ) {
        System.out.println("Received: " + something);
        terminateMessage();
    }
    */
    @KafkaHandler
    public void listenProduct(Product product ) {
        System.out.println("Received: " + product);
        terminateMessage();
    }
    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("Received unknown: " + object);
        terminateMessage();
    }
    /*
    @KafkaHandler
    public void listenXX(Object product ) {
        System.out.println("Received: " + product);
        terminateMessage();
    }
    */
    /*
    @KafkaHandler
    public void listenListOfString(ArrayList<String> strings) {
        System.out.println("Received: " + strings);
        terminateMessage();
    }
    */
}
