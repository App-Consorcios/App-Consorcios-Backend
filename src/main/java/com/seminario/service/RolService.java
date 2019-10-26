package com.seminario.service;

import com.seminario.dto.RolDTO;
import com.seminario.entity.Rol;
import com.seminario.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public RolDTO createRol(RolDTO dto) {
        Rol rol = new Rol(dto);
        rolRepository.save(rol);
        return dto;
    }

    public List<RolDTO> getRoles() {
        return rolRepository.findAll().stream().map(RolDTO::new).collect(Collectors.toList());
    }
}
