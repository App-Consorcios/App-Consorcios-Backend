package com.seminario.controller;

import com.seminario.model.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public UserDTO test() {
        return new UserDTO("nombre", "nickname");
    }

}
