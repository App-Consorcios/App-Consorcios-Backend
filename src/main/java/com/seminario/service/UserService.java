package com.seminario.service;


import com.seminario.dto.UserDTO;
import com.seminario.entity.AppUser;
import com.seminario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> allUsers() {
        List<AppUser> appUsers = userRepository.findAll();

        return appUsers.stream().map(appUser -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(appUser.getId());
            userDTO.setName(appUser.getName());
            userDTO.setLastname(appUser.getLastname());
            userDTO.setPhone(appUser.getPhone());
            userDTO.setMail(appUser.getMail());
            return userDTO;
        }).collect(Collectors.toList());
    }

    public UserDTO save(UserDTO userDto) {

        AppUser appUser = new AppUser();
        appUser.setName(userDto.getName());
        appUser.setLastname(userDto.getLastname());
        appUser.setPhone(userDto.getPhone());
        appUser.setMail(userDto.getMail());
        appUser.setPassword(userDto.getPassword());

        AppUser appUserSave = userRepository.save(appUser);
        userDto.setId(appUserSave.getId());

        return userDto;
    }

    public boolean isValidCredential(String mail, String password) {
        AppUser user = userRepository.findByMailAndPassword(mail, password);
        return user != null;
    }
}
