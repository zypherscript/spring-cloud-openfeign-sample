package com.example.openfeignsample.config;

import feign.Logger;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

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
}
