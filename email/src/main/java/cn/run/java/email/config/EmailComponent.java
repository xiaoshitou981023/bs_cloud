package cn.run.java.email.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Data
@Slf4j
@Component
public class EmailComponent {

  @Autowired
  private JavaMailSenderImpl javaMailSender;

  public void sendEmail(String to, String subject, String content, String sender) {
    log.debug("Send email to '{}' with subject '{}' and content={}",
            to, subject, content);
    // Prepare message using a Spring helper
    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    try {
      MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
      message.setTo(to);
      message.setFrom(sender);
      message.setSubject(subject);
      message.setText(content);
      javaMailSender.send(mimeMessage);
      log.debug("Sent email to User '{}'", to);
    } catch (MailException | MessagingException | javax.mail.MessagingException e) {
      log.warn("Email could not be sent to user '{}'", to, e);
    }
  }

  public void send(MimeMessage... mimeMessages) throws MailException {
    log.info("发送邮件中。。。{}", mimeMessages);
    javaMailSender.send(mimeMessages);
  }

  public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
    log.info("发送邮件中。。。{}", mimeMessagePreparator);
    javaMailSender.send(mimeMessagePreparator);
  }

  public void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {
    log.info("发送邮件中。。。{}", mimeMessagePreparators);
    javaMailSender.send(mimeMessagePreparators);
  }

}
