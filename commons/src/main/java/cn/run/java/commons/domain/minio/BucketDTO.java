package cn.run.java.commons.domain.minio;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 17:00
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BucketDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String name;

  private String creationDate;

}
