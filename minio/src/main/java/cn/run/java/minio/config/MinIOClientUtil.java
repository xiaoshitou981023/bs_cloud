package cn.run.java.minio.config;

import cn.run.java.commons.exception.BusinessException;
import io.minio.MinioClient;
import io.minio.errors.*;
import io.minio.messages.Bucket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 21:43
 */
@Slf4j
@Component
public class MinIOClientUtil {

  /**
   * 操作Util
   */
  private static MinioClient minioClient;

  /**
   * 桶名称
   */
  private static String bucket;

  @Autowired
  public void initField(MinIOConfig minIOConfig, MinioClient minioClient) {
    MinIOClientUtil.bucket = minIOConfig.getBucket();
    MinIOClientUtil.minioClient = minioClient;
  }

  /**
   * 获取所有的 桶 Bucket
   *
   * @return
   */
  public static List<Bucket> listBuckets() {
    try {
      return minioClient.listBuckets();
    } catch (InvalidBucketNameException | NoSuchAlgorithmException | InsufficientDataException | IOException | InvalidKeyException | NoResponseException | XmlPullParserException | ErrorResponseException | InternalException | InvalidResponseException e) {
      log.error("获取所有Bucket异常", e);
    }
    throw new BusinessException("文件服务器开小差了！");
  }

  private static String putObject(InputStream stream, String fileName) {
    // .*（ 二进制流，不知道下载文件类型）
    String contentType = "application/octet-stream";

    fileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
    try {
      minioClient.putObject(bucket, fileName, stream, null, null, null, contentType);
      return fileName;
    } catch (InvalidBucketNameException | NoSuchAlgorithmException | IOException | InvalidKeyException | NoResponseException | XmlPullParserException | ErrorResponseException | InternalException | InvalidArgumentException | InsufficientDataException | InvalidResponseException e) {
      log.error("获取所有Bucket异常", e);
      throw new BusinessException("文件服务器开小差了！");
    }
  }

  /**
   * 上传文件
   *
   * @param file
   * @return
   */
  public static String putObject(MultipartFile file) {
    if (file == null) {
      throw new BusinessException("文件不存在！");
    }
    try {
      InputStream inputStream = file.getInputStream();
      return putObject(inputStream, file.getOriginalFilename());
    } catch (IOException e) {
      log.error("上传文件异常", e);
      throw new BusinessException("文件不存在！");
    }
  }

  /**
   * 获取文件地址
   *
   * @param name
   * @return
   */
  public static String presignedGetObject(String name) {
    try {
      return minioClient.presignedGetObject(bucket, name, 7 * 24 * 3600);
    } catch (InvalidBucketNameException | NoSuchAlgorithmException | InsufficientDataException | IOException | InvalidKeyException | NoResponseException | XmlPullParserException | ErrorResponseException | InternalException | InvalidExpiresRangeException | InvalidResponseException e) {
      log.error("获取文件地址异常", e);
      throw new BusinessException("文件不存在！");
    }
  }


}
