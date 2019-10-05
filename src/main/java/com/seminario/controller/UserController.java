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

    @PostMapping(value = "/user")
    public UserDTO saveUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @GetMapping(value = "/user")
    public List<UserDTO> getUsers() {
        //TODO: Add query string filters
        return userService.allUsers();
    }

    @GetMapping(value = "/login")
    public Boolean allUsers(@RequestParam("mail") String mail, @RequestParam("password") String password) {
        return userService.isValidCredential(mail, password);
    }

}
