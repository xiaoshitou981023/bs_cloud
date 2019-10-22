package cn.run.java.system.repository;

import cn.run.java.system.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 10:43
 */
public interface UserRepository extends JpaRepository<User, Long> {

  /**
   * 根据用户名查询用户信息
   *
   * @param username
   * @return
   */
  Optional<User> findUserByUsername(String username);

  /**
   * 检查用户是否已存在
   *
   * @param email
   * @param username
   * @return
   */
  boolean existsUserByEmailEqualsAndUsernameEquals(String email, String username);
}
