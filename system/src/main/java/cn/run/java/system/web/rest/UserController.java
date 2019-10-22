package cn.run.java.system.web.rest;

import cn.run.java.commons.domain.system.UserDTO;
import cn.run.java.system.domain.User;
import cn.run.java.system.mapper.UserMapper;
import cn.run.java.system.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 10:47
 */
@RestController
@RequestMapping("/system/users")
public class UserController {

  private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

  @Autowired
  private UserService userService;

  @GetMapping
  public List<UserDTO> getAllUsers(User user, @PageableDefault(sort = {"id"}) Pageable pageable) {
    Page<User> all = this.userService.findAll(user, pageable);
    return all.getContent().stream().map(userMapper::userToUserDTO).collect(Collectors.toList());
  }

  @PostMapping
  public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
    return this.userService.save(userDTO);
  }

  @PutMapping
  public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO) {
    return this.userService.updateUser(userDTO);
  }
}
