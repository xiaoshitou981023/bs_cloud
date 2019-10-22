package cn.run.java.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@EnableConfigurationProperties
@EnableDiscoveryClient
@SpringBootApplication
public class EmailApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmailApplication.class, args);
  }

}
