package cn.run.java.system.service;

import cn.run.java.commons.domain.system.UserDTO;
import cn.run.java.system.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 13:57
 */
public interface UserService {

  /**
   * Save a user.
   *
   * @param userDTO the entity to save.
   * @return the persisted entity.
   */
  UserDTO save(UserDTO userDTO);

  /**
   * Get all the users.
   *
   * @param user     查询条件
   * @param pageable 分页
   * @return the list of entities.
   */
  Page<User> findAll(User user, Pageable pageable);

  /**
   * Get the "id" user.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  UserDTO findOne(Long id);

  /**
   * Delete the "id" user.
   *
   * @param id the id of the entity.
   */
  void delete(Long id);

  /**
   * find user by username
   *
   * @param username username the id of the entity.
   * @return the entity.
   */
  UserDTO findUserByUsername(String username);

  /**
   * 更新用户信息
   *
   * @param userDTO
   * @return
   */
  UserDTO updateUser(UserDTO userDTO);
}
