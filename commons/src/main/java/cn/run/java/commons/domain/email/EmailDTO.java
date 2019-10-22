package cn.run.java.commons.domain.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 12:31
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmailDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  /**
   * 发送给谁
   */
  private String addressee;

  /**
   * 发件人邮箱
   */
  private String sender;

  /**
   * 标题
   */
  private String subject;

  /**
   * 消息内容
   */
  private String context;
}
