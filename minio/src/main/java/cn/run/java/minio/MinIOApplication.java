package cn.run.java.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * MinIO 文件服务器
 *
 * @author stone
 */
@EnableAsync
@EnableFeignClients
@EnableConfigurationProperties
@EnableDiscoveryClient
@SpringBootApplication
public class MinIOApplication {

  public static void main(String[] args) {
    SpringApplication.run(MinIOApplication.class, args);
  }

}
