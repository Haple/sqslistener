package com.sample.sqslistener.interfaces.adapter.amqp.configuration;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import java.util.Collections;
import org.springframework.cloud.aws.messaging.config.QueueMessageHandlerFactory;
import org.springframework.cloud.aws.messaging.listener.QueueMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.support.PayloadMethodArgumentResolver;
import org.springframework.validation.Validator;

@Configuration
public class MessageHandler {
  @Bean
  QueueMessageHandler queueMessageHandler(final AmazonSQSAsync amazonSQSAsync,
      final MessageConverter messageConverter,
      final Validator validator) {
    final QueueMessageHandlerFactory queueMessageHandlerFactory = new QueueMessageHandlerFactory();
    final PayloadMethodArgumentResolver payloadMethodArgumentResolver = new PayloadMethodArgumentResolver(messageConverter, validator);
    queueMessageHandlerFactory.setArgumentResolvers(Collections.singletonList(payloadMethodArgumentResolver));
    queueMessageHandlerFactory.setAmazonSqs(amazonSQSAsync);
    queueMessageHandlerFactory.setMessageConverters(Collections.singletonList(messageConverter));
    return queueMessageHandlerFactory.createQueueMessageHandler();
  }
}
