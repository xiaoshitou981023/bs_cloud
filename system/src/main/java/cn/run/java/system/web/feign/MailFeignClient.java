package cn.run.java.system.web.feign;

import cn.run.java.commons.domain.email.EmailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 12:29
 */
@FeignClient("mail")
public interface MailFeignClient {

  /**
   * 发送邮件
   *
   * @param mail
   */
  @Async
  @PostMapping("/mail/send")
  void sendMessageMail(EmailDTO mail);

}
