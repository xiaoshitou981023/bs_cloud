package cn.run.java.minio.web.rest;

import cn.run.java.commons.domain.minio.BucketDTO;
import cn.run.java.minio.config.MinIOClientUtil;
import io.minio.messages.Bucket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 区块 Controller
 *
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 16:58
 */
@RestController
@RequestMapping("/minio/bucket")
public class BucketController {

  @GetMapping
  public List<BucketDTO> findAll() {
    // 查询所有的Bucket
    List<Bucket> buckets = MinIOClientUtil.listBuckets();
    List<BucketDTO> bucketDTOS = new ArrayList<>();
    buckets.forEach(bucket -> bucketDTOS.add(new BucketDTO().setName(bucket.name()).setCreationDate(bucket.creationDate().toString())));
    return bucketDTOS;
  }

}
