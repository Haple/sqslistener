package com.sample.sqslistener.interfaces.adapter.amqp.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"test", "local"})
@Configuration
public class SQSClientConfigLocal {

  @Value("${aws.sqs.endpoint}")
  private String url;

  @Bean
  AmazonSQSAsync amazonSqsAsync() {
    final AWSCredentials credentials = new BasicAWSCredentials("accessKey", "secretKey");
    AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(credentials);
    return AmazonSQSAsyncClientBuilder.standard()
        .withEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration(url, Regions.US_EAST_2.name()))
        .withCredentials(awsCredentialsProvider)
        .build();
  }
}
