package com.aptech.springrestapi.restservice;

import com.aptech.springrestapi.restservice.controllers.storage.StorageProperties;
import org.slf4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.listener.PatternTopic;
//import org.springframework.data.redis.listener.RedisMessageListenerContainer;
//import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@EnableScheduling //time interval, timer
public class Main {
	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = SpringApplication.run(Main.class, args);
//		StringRedisTemplate template = context.getBean(StringRedisTemplate.class);
//		RedisReceiver receiver = context.getBean(RedisReceiver.class);
//		while (receiver.getCount()  < 10) {
//
//			LOGGER.info("Sending message...");
//			template.convertAndSend("chat", "Hello from Redis!");
//			Thread.sleep(500L);
//		}
//
//		System.exit(0);
	}
//	@Bean
//	RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
//											MessageListenerAdapter listenerAdapter) {
//
//		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.addMessageListener(listenerAdapter, new PatternTopic("chat"));
//		return container;
//	}
//	@Bean
//	MessageListenerAdapter listenerAdapter(RedisReceiver receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessage");
//	}
//
//	@Bean
//	RedisReceiver receiver() {
//		return new RedisReceiver();
//	}
//	@Bean
//	StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
//		return new StringRedisTemplate(connectionFactory);
//	}

}
