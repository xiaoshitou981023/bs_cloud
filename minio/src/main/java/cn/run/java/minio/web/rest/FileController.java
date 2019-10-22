package cn.run.java.minio.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static cn.run.java.minio.config.MinIOClientUtil.presignedGetObject;
import static cn.run.java.minio.config.MinIOClientUtil.putObject;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 21:37
 */
@Controller
@RequestMapping("/minio/file")
public class FileController {

  /**
   * 上传文件返回文件名
   *
   * @param file
   * @return
   */
  @ResponseBody
  @PostMapping
  public String uploadFile(MultipartFile file) {
    return putObject(file);
  }

  @GetMapping("{name}")
  public String redirectFilePath(@PathVariable String name) {
    String path = presignedGetObject(name);
//    return "redirect:" + path;
    return "redirect:" + path;
  }

  /**
   * 获取文件路径
   *
   * @param name
   * @return
   */
  @ResponseBody
  @GetMapping("/path/{name}")
  public String getPath(@PathVariable String name) {
    return presignedGetObject(name);
  }

}
