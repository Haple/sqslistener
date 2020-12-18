package com.sample.sqslistener.interfaces.adapter.amqp.listener.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventDTO {

  @NotNull(message = "foo is mandatory")
  private final String foo;

  @NotNull(message = "bar is mandatory")
  private final String bar;

}
