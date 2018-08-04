package com.shoes.api.mapper.impl;

import com.shoes.api.dto.UserDTO;
import com.shoes.api.mapper.UserMapper;
import com.shoes.api.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO convertEntity2Dto(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setActive(user.getActive() != null ? user.getActive() : true);
        dto.setAddress(user.getAddress() != null ? user.getAddress() : "");
        dto.setBirthday(user.getBirthday());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setUsername(user.getUsername());
        dto.setRemarks(user.getRemarks());
        dto.setRole(user.getRole());
        return dto;
    }

    @Override
    public User convertDto2Entity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setActive(dto.getActive());
        user.setAddress(dto.getAddress());
        user.setBirthday(dto.getBirthday());
        user.setEmail(dto.getEmail());
        user.setId(dto.getId());
        user.setPassword(dto.getPassword());
        user.setUsername(dto.getUsername());
        user.setRemarks(dto.getRemarks());
        user.setRole(dto.getRole());
        return user;
    }

}
