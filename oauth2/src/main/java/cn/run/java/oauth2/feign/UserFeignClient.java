package cn.run.java.oauth2.feign;

import cn.run.java.commons.domain.system.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 16:49
 */
@FeignClient("system")
public interface UserFeignClient {

  /**
   * 根据用户名查询用户信息
   *
   * @param username
   * @return
   */
  @GetMapping("/oauth/findUserByUsername")
  UserDTO findUserByUsername(@RequestParam("username") String username);

}
