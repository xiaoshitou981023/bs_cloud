package cn.run.java.email.repository;

import cn.run.java.email.domain.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 14:28
 */
public interface MailRepository extends JpaRepository<Mail, Long> {
}
