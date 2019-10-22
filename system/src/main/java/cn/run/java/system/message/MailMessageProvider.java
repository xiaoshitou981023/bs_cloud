package cn.run.java.system.message;

import cn.run.java.commons.domain.email.EmailDTO;
import cn.run.java.commons.queue.EmailEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 13:51
 */
@Slf4j
@Component
public class MailMessageProvider {

  @Autowired
  private AmqpTemplate amqpTemplate;

  @Async
  public void sendMessageMail(EmailDTO mail) {
    log.info("发送邮件：{}", mail);
    amqpTemplate.convertSendAndReceive(EmailEnum.MessageEmailQueue, mail);
  }

}
