package cn.run.java.system.service.impl;

import cn.run.java.commons.domain.system.UserDTO;
import cn.run.java.commons.exception.BusinessException;
import cn.run.java.system.domain.User;
import cn.run.java.system.mapper.UserMapper;
import cn.run.java.system.repository.UserRepository;
import cn.run.java.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 13:57
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);


  /**
   * Save a user.
   *
   * @param userDTO the entity to save.
   * @return the persisted entity.
   */
  @Override
  public UserDTO save(UserDTO userDTO) {
    User save = userMapper.UserDTOToUser(userDTO);
    save.setActivated(false);
    boolean b = userRepository.existsUserByEmailEqualsAndUsernameEquals(save.getEmail(), save.getUsername());
    if (b) {
      throw new BusinessException("用户已存在！");
    }
    User result = userRepository.save(save);
    return userMapper.userToUserDTO(result);
  }

  /**
   * Get all the users.
   *
   * @param user     查询条件
   * @param pageable 分页
   * @return the list of entities.
   */
  @Override
  public Page<User> findAll(User user, Pageable pageable) {
    ExampleMatcher exampleMatcher = ExampleMatcher.matching()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
            .withIgnoreCase(true);
    Example<User> of = Example.of(user, exampleMatcher);
    return userRepository.findAll(of, pageable);
  }

  /**
   * Get the "id" user.
   *
   * @param id the id of the entity.
   * @return the entity.
   */
  @Override
  public UserDTO findOne(Long id) {
    User byId = userRepository.findById(id).orElseThrow(() -> new BusinessException("用户不存在！"));
    return userMapper.userToUserDTO(byId);
  }

  /**
   * Delete the "id" user.
   *
   * @param id the id of the entity.
   */
  @Override
  public void delete(Long id) {
    // org.springframework.data.jpa.repository.support.SimpleJpaRepository.deleteById
    // delete(findById(id).orElseThrow(() -> new EmptyResultDataAccessException(
    //				String.format("No %s entity with id %s exists!", entityInformation.getJavaType(), id), 1)));
    // 判断的为NULL 会抛出异常
    userRepository.deleteById(id);
  }

  /**
   * find user by username
   *
   * @param username username the id of the entity.
   * @return the entity.
   */
  @Override
  public UserDTO findUserByUsername(String username) {
    User user = this.userRepository.findUserByUsername(username).orElseThrow(() -> new IllegalArgumentException("用户信息不存在！"));
    return this.userMapper.userToUserDTO(user);
  }

  /**
   * 更新用户信息
   *
   * @param userDTO
   * @return
   */
  @Override
  public UserDTO updateUser(UserDTO userDTO) {
    User user = userMapper.UserDTOToUser(userDTO);
    UserDTO flush = findOne(user.getId());
    boolean b = userRepository.existsUserByEmailEqualsAndUsernameEquals(user.getEmail(), user.getUsername());
    if (b) {
      throw new BusinessException("用户已存在！");
    }
    flush.setEmail(user.getEmail());
    flush.setUsername(user.getUsername());
    flush.setActivated(user.getActivated());
    userRepository.flush();
    return userMapper.userToUserDTO(user);
  }
}
