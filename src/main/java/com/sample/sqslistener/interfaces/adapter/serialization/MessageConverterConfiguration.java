package com.sample.sqslistener.interfaces.adapter.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;

@Configuration
public class MessageConverterConfiguration {

  @Bean
  public MessageConverter mappingJackson2MessageConverter(final ObjectMapper objectMapper) {
    final MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
    mappingJackson2MessageConverter.setSerializedPayloadClass(String.class);
    mappingJackson2MessageConverter.setObjectMapper(objectMapper);
    return mappingJackson2MessageConverter;
  }
}

