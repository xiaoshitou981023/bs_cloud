package cn.run.java.system.web.rest;

import cn.run.java.commons.domain.email.EmailDTO;
import cn.run.java.system.message.MailMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/21: 14:00
 */
@RestController
@RequestMapping("/system/mail")
public class MailController {

  @Autowired
  private MailMessageProvider mailMessageProvider;

  @PostMapping("/register/code")
  public void registerCode(@RequestBody EmailDTO emailDTO) {
    mailMessageProvider.sendMessageMail(emailDTO);
  }
}
