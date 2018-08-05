package com.shoes.api.controller;

import com.shoes.api.dto.UserDTO;
import com.shoes.api.enumeration.Role;
import com.shoes.api.service.UserService;
import com.shoes.api.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDTO> listUser() {
        return userService.findAll();
    }

    @RequestMapping(value = "/users/user/{id}", method = RequestMethod.GET)
    public UserDTO findById(@PathVariable(value = "id") Long id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/users/user", method = RequestMethod.POST)
    public UserDTO create(@RequestBody UserDTO dto) {
        return userService.save(dto);
    }

    @RequestMapping(value = "/users/user", method = RequestMethod.PUT)
    public UserDTO update(@RequestBody UserDTO dto) {
        return userService.save(dto);
    }

    @RequestMapping(value = "/users/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return Constants.SUCCESS_MSG;
    }

    @RequestMapping(value = "/users/roles", method = RequestMethod.GET)
    public List<String> getRoles() {
        List<String> list = new ArrayList<>();
        Role[] roles =  Role.values();
        for (Role role : roles) {
            list.add(role.name());
        }
        return list;
    }

}
