package cn.run.java.minio.config;

import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 16:00
 */
@Slf4j
@Data
@Accessors(chain = true)
@Configuration
@ConfigurationProperties("bs.minio")
public class MinIOConfig {

  private String endpoint;

  private String accessKey;

  private String secretKey;

  private String bucket;

  @Bean
  public MinioClient minioClient() throws InvalidPortException,
          InvalidEndpointException, IOException,
          InvalidKeyException, NoSuchAlgorithmException,
          InsufficientDataException, InternalException, NoResponseException,
          InvalidBucketNameException, XmlPullParserException, ErrorResponseException,
          RegionConflictException, InvalidObjectPrefixException, InvalidResponseException {
    MinioClient minioClient = new MinioClient(endpoint, accessKey, secretKey);
    boolean exists = minioClient.bucketExists(bucket);
    if (!exists) {
      log.info("初始化bucket:{}", bucket);
      minioClient.makeBucket(bucket);
      log.info("bucket 创建成功！");
    }
    return minioClient;
  }


}
