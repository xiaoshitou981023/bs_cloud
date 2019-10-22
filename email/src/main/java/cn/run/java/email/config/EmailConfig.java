package cn.run.java.email.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 11:17
 */
@Configuration
public class EmailConfig {

  @Bean
  @ConditionalOnMissingBean
  @ConfigurationProperties(prefix = "spring.mail")
  public JavaMailSenderImpl javaMailSender() {
    return new JavaMailSenderImpl();
  }

}