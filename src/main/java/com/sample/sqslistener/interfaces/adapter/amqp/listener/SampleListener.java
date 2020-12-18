package com.sample.sqslistener.interfaces.adapter.amqp.listener;

import com.sample.sqslistener.interfaces.adapter.amqp.listener.dto.EventDTO;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class SampleListener {

  @SqsListener("test_queue")
  public void execute(final @Valid @Payload EventDTO event) {
    log.info("OK: {}", event);
  }

}
