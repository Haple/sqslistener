package com.sample.sqslistener.interfaces.adapter.amqp.configuration;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler;
import org.springframework.cloud.aws.messaging.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageListenerContainer {
  @Bean
  SimpleMessageListenerContainer simpleMessageListenerContainer(final AmazonSQSAsync amazonSQSAsync,
      final QueueMessageHandler queueMessageHandler) {
    final SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
    simpleMessageListenerContainer.setAmazonSqs(amazonSQSAsync);
    simpleMessageListenerContainer.setMessageHandler(queueMessageHandler);
    simpleMessageListenerContainer.setMaxNumberOfMessages(1);
    return simpleMessageListenerContainer;
  }
}
