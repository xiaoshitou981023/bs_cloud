package cn.run.java.email.mapper;

import cn.run.java.commons.domain.email.EmailDTO;
import cn.run.java.email.domain.Mail;
import org.mapstruct.Mapper;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 14:41
 */
@Mapper
public interface MailMapper {

  /**
   * Mail TO MailToEmailDTO
   *
   * @param mail
   * @return
   */
  EmailDTO mailToEmailDTO(Mail mail);

  /**
   * EmailD To ToMail
   *
   * @param emailDTO
   * @return
   */
  Mail emailDToToMail(EmailDTO emailDTO);
}
