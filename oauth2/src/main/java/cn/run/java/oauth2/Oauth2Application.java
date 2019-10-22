package cn.run.java.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Oauth 认证中心
 *
 * @author stone
 * @date 2019年10月17日15:56:26
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2Application {

  public static void main(String[] args) {
    SpringApplication.run(Oauth2Application.class, args);
  }

}