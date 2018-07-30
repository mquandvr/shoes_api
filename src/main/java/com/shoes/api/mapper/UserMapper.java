package com.shoes.api.mapper;

import com.shoes.api.dto.UserDTO;
import com.shoes.api.model.User;

public interface UserMapper {

    public UserDTO convertEntity2Dto(User user);

    public User convertDto2Entity(UserDTO dto);
}
