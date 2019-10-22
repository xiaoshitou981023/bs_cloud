package cn.run.java.system.web.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/22: 10:01
 */
@FeignClient("minio")
public interface FileFeignClient {

//  /**
//   * 上传文件 返回文件名称
//   *
//   * @param file
//   * @return
//   */
//  @PostMapping("/minio/file")
//  String uploadFile(MultipartFile file);
//
//  /**
//   * 上传文件  返回文件下载地址
//   *
//   * @param file
//   * @return
//   */
//  @PostMapping("/minio/file/path")
//  String uploadFileAndGetFilePath(MultipartFile file);
//
//  /**
//   * 通过文件名称获取文件的下载地址
//   *
//   * @param name
//   * @return
//   */
//  @GetMapping("/minio/file")
//  String getPath(String name);

}
