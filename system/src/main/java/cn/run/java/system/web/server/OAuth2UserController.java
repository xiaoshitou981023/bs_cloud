package cn.run.java.system.web.server;

import cn.run.java.commons.domain.system.UserDTO;
import cn.run.java.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供给Oauth认证系统使用
 *
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 16:51
 */
@RestController
public class OAuth2UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/oauth/findUserByUsername")
  public UserDTO findUserByUsername(String username) {
    return this.userService.findUserByUsername(username);
  }
}
