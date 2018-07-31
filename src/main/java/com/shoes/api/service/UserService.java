package com.shoes.api.service;

import java.util.List;

import com.shoes.api.dto.UserDTO;
import com.shoes.api.model.User;

public interface UserService {

    UserDTO save(UserDTO dto);

    List<UserDTO> findAll();

    void delete(Long id);
    
}
