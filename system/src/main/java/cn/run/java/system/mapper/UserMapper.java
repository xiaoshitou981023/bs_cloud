package cn.run.java.system.mapper;

import cn.run.java.commons.domain.system.UserDTO;
import cn.run.java.system.domain.User;
import org.mapstruct.Mapper;

/**
 * @author <a href="mailto:stone981023@gmail.com">郑查磊</a>
 * @date 2019/10/18: 11:45
 */
@Mapper
public interface UserMapper {

  /**
   * user to userDTO
   *
   * @param user
   * @return
   */
  UserDTO userToUserDTO(User user);

  /**
   * UserDTO to User
   *
   * @param userDTO
   * @return
   */
  User UserDTOToUser(UserDTO userDTO);
}
