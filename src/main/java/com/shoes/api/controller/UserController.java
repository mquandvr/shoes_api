package com.shoes.api.controller;

import com.shoes.api.dto.UserDTO;
import com.shoes.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/users/user", method = RequestMethod.POST)
    public UserDTO create(@RequestBody UserDTO dto) {
        return userService.save(dto);
    }

    @RequestMapping(value = "/users/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "success";
    }

}
