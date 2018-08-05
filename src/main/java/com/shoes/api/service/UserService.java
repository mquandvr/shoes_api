package com.shoes.api.service;

import java.util.List;
import com.shoes.api.dto.UserDTO;

public interface UserService {

    UserDTO save(UserDTO dto);

    List<UserDTO> findAll();

    void delete(Long id);

    UserDTO findById(Long id);
    
}
