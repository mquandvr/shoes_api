package com.shoes.api.mapper.impl;

import com.shoes.api.dao.StoreDao;
import com.shoes.api.dao.UserDao;
import com.shoes.api.dto.UserDTO;
import com.shoes.api.enumeration.Role;
import com.shoes.api.mapper.UserMapper;
import com.shoes.api.model.User;
import com.shoes.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private StoreDao storeDao;

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
        dto.setRole(user.getRole() != null ? user.getRole().name() : Role.NV_BAN_HANG.name());
        dto.setMobilePhone(user.getMobilePhone() != null ? user.getMobilePhone() : "");
        dto.setFullName(user.getFullName() != null ? user.getFullName() : "");
        dto.setStoreId(user.getStore() != null ? user.getStore().getId() : null);
        return dto;
    }

    @Override
    public User convertDto2Entity(UserDTO dto) {
        if (dto == null) return null;

        User user = new User();
        if (dto.getId() != null) {
            user = userDao.getOne(dto.getId());
        }

        user.setId(dto.getId());
        user.setActive(dto.getActive());
        user.setAddress(dto.getAddress());
        user.setBirthday(dto.getBirthday());
        user.setEmail(dto.getEmail());

        if (user.getId() == null) {
            user.setPassword(encoder.encode(dto.getPassword() != null ? dto.getPassword() :Constants.PASS_DEFAULT));
        }

        user.setUsername(dto.getUsername());
        user.setRemarks(dto.getRemarks());
        user.setRole(dto.getRole() != null ? Role.valueOf(dto.getRole()) : Role.NV_BAN_HANG);
        user.setMobilePhone(dto.getMobilePhone() != null ? dto.getMobilePhone() : "");
        user.setFullName(dto.getFullName() != null ? dto.getFullName() : "");
        user.setStore(dto.getStoreId() != null ? storeDao.getOne(dto.getStoreId()) : null);
        return user;
    }

}
