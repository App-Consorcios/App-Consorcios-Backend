package com.seminario.controller;

import com.seminario.dto.UserDTO;
import com.seminario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public List<UserDTO> allUsers() {
        return userService.allUsers();
    }

    @PostMapping(value = "/user")
    public UserDTO saveUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }

}
