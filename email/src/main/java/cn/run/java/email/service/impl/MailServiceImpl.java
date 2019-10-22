package cn.run.java.email.service.impl;

import cn.run.java.email.config.EmailComponent;
import cn.run.java.email.domain.Mail;
import cn.run.java.email.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 14:30
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MailServiceImpl implements MailService {

  @Autowired
  private EmailComponent emailComponent;

  @Autowired
  private JavaMailSenderImpl javaMailSender;

  /**
   * 发送自定义文字消息邮件
   *
   * @param mail
   */
  @Override
  public void sendMessageEmail(Mail mail) {
    send(mail);
  }

  /**
   * 发送激活邮件
   *
   * @param mail
   */
  @Override
  public void sendActivationEmail(Mail mail) {
    send(mail);
  }

  /**
   * 发送重置密码邮件
   *
   * @param mail
   */
  @Override
  public void sendPasswordResetMail(Mail mail) {
    send(mail);
  }

  private void send(Mail mail) {
    // 初始化发件人
    mail.setSender(javaMailSender.getUsername());
    emailComponent.sendEmail(mail.getAddressee(), mail.getSubject(), mail.getContext(), mail.getSender());
  }
}
