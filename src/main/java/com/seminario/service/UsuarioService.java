package com.seminario.service;


import com.seminario.dto.LoginDTO;
import com.seminario.dto.RolDTO;
import com.seminario.dto.UsuarioDTO;
import com.seminario.entity.Rol;
import com.seminario.entity.Usuario;
import com.seminario.repository.RolRepository;
import com.seminario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;

    public UsuarioDTO saveUser(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto);

        List<Rol> roles = dto.getRoles().stream().map(rolDTO -> {
            Rol rol = rolRepository.findByNombre(rolDTO.getNombre());
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(usuario);
            rol.setUsuarios(usuarios);
            return rol;
        }).collect(Collectors.toList());

        usuario.setRoles(roles);

        Usuario saved = userRepository.save(usuario);
        return new UsuarioDTO(saved);
    }

    public List<UsuarioDTO> allUsers() {
        return userRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public LoginDTO isValidCredential(String mail, String password) {
        Usuario user = userRepository.findByMailAndPassword(mail, password);
        return new LoginDTO(user);
    }

    public UsuarioDTO updateUserRol(Long idUsuario, UsuarioDTO usuarioDTO) {
        Usuario userToUpdate = userRepository.findById(idUsuario).get();

        List<Rol> roles = usuarioDTO.getRoles().stream().map(rolDTO -> {
            Rol rol = rolRepository.findByNombre(rolDTO.getNombre());
            List<Usuario> usuarios = new ArrayList<>();
            usuarios.add(userToUpdate);
            rol.setUsuarios(usuarios);
            return rol;
        }).collect(Collectors.toList());

        userToUpdate.setRoles(roles);

        return new UsuarioDTO(userRepository.save(userToUpdate));
    }
}
