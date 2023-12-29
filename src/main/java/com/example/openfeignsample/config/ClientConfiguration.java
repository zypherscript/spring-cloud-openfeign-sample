package com.example.openfeignsample.config;

import feign.Logger;
import feign.RetryableException;
import feign.Retryer;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

  @Bean
  public OkHttpClient client() {
    return new OkHttpClient();
  }

  @Bean
  public Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  //more example[error handling]: https://github.com/eugenp/tutorials/blob/master/spring-cloud-modules/spring-cloud-openfeign-2/src/main/java/com/baeldung/cloud/openfeign/config/CustomErrorDecoder.java
  //[auth interceptors] https://www.baeldung.com/spring-cloud-openfeign#interceptors

  @Bean
  public Retryer retryer() {
    return new MyRetryer();
  }
}

class MyRetryer implements Retryer {

  private final long backoff;
  private final int maxAttempts;
  int attempt;

  public MyRetryer() {
    this(2000, 3);
  }

  public MyRetryer(long backoff, int maxAttempts) {
    this.backoff = backoff;
    this.maxAttempts = maxAttempts;
    this.attempt = 1;
  }

  public void continueOrPropagate(RetryableException e) {
    if (attempt++ >= maxAttempts) {
      throw e;
    }

    try {
      Thread.sleep(backoff);
    } catch (InterruptedException ignored) {
      Thread.currentThread().interrupt();
    }
  }

  @Override
  public Retryer clone() {
    return new MyRetryer(backoff, maxAttempts);
  }
}
