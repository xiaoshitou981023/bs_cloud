package cn.run.java.email.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 11:06
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "bs_email")
public class Mail implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 发送给谁
   */
  @NotNull
  private String addressee;

  /**
   * 发件人邮箱
   */
  private String sender;

  /**
   * 标题
   */
  @NotNull
  private String subject;

  /**
   * 消息内容
   */
  @NotNull
  private String context;

}
