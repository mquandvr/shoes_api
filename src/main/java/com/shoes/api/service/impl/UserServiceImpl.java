package com.shoes.api.service.impl;

import com.shoes.api.dao.UserDao;
import com.shoes.api.dto.UserDTO;
import com.shoes.api.mapper.UserMapper;
import com.shoes.api.model.User;
import com.shoes.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userDao.findByUsername(userId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getId()), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

    public List<UserDTO> findAll() {
        List<UserDTO> list = new ArrayList<>();
        List<User> users = userDao.findAll();
        if (users != null && !users.isEmpty()) {
            users.forEach(item -> {
                list.add(userMapper.convertEntity2Dto(item));
            });
        }
        return list;
    }

    @Override
    public void delete(Long id) {
        User user = userDao.getOne(id);
        if (user != null && user.getId() != null) {
            user.setActive(false);
            userDao.save(user);
        }
    }

    @Override
    public UserDTO save(UserDTO dto) {
        User user = userMapper.convertDto2Entity(dto);
        user = userDao.save(user);
        return userMapper.convertEntity2Dto(user);
    }
    
}
