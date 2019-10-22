package cn.run.java.email.message;

import cn.run.java.commons.domain.email.EmailDTO;
import cn.run.java.commons.queue.EmailEnum;
import cn.run.java.email.domain.Mail;
import cn.run.java.email.mapper.MailMapper;
import cn.run.java.email.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 13:44
 */
@Slf4j
@Component
public class EmailMessageReceiver {

  @Autowired
  private MailService mailService;

  private final MailMapper emailMapper = Mappers.getMapper(MailMapper.class);

  @Bean
  public Queue queue() {
    return new Queue(EmailEnum.MessageEmailQueue);
  }

  @RabbitListener(queues = {EmailEnum.MessageEmailQueue})
  public void messageMail(EmailDTO emailDTO) {
    log.info("收到消息：{}", emailDTO);
    Mail mail = emailMapper.emailDToToMail(emailDTO);
    mailService.sendMessageEmail(mail);
  }

}
