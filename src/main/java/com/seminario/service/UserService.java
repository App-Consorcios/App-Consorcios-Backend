package com.seminario.service;


import com.seminario.dto.UserDTO;
import com.seminario.entity.SampleUser;
import com.seminario.repository.SampleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

    @Autowired
    private SampleUserRepository sampleUserRepository;

    public List<UserDTO> allUsers() {
        List<SampleUser> sampleUsers = sampleUserRepository.findAll();
        return sampleUsers.stream().map(sampleUser -> new UserDTO(sampleUser.getId(), sampleUser.getName(), 5))
                .collect(Collectors.toList());
    }

    public UserDTO save(UserDTO user) {
        SampleUser sampleUser = sampleUserRepository.save(new SampleUser(user.getName()));
        return new UserDTO(sampleUser.getId(), sampleUser.getName(), 5);
    }
}
