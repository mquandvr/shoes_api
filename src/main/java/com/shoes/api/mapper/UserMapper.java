package com.shoes.api.mapper;

import com.shoes.api.dto.UserDTO;
import com.shoes.api.model.User;

public interface UserMapper {

    UserDTO convertEntity2Dto(User user);

    User convertDto2Entity(UserDTO dto);
}
