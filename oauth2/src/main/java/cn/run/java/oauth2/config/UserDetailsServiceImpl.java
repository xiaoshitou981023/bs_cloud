package cn.run.java.oauth2.config;

import cn.run.java.commons.domain.system.UserDTO;
import cn.run.java.oauth2.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 16:26
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserFeignClient userFeignClient;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserDTO user = this.userFeignClient.findUserByUsername(username);
    return new User(username, user.getPassword(), new ArrayList<>());
  }

}
