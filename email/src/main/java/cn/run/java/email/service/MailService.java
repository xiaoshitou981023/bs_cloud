package cn.run.java.email.service;

import cn.run.java.email.domain.Mail;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 11:12
 */
public interface MailService {

  /**
   * 发送自定义文字消息邮件
   *
   * @param mail
   */
  void sendMessageEmail(Mail mail);


  /**
   * 发送激活邮件
   *
   * @param mail
   */
  void sendActivationEmail(Mail mail);

  /**
   * 发送重置密码邮件
   *
   * @param mail
   */
  void sendPasswordResetMail(Mail mail);

}
