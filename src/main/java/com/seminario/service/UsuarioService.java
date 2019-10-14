package com.seminario.service;


import com.seminario.dto.LoginDTO;
import com.seminario.dto.UsuarioDTO;
import com.seminario.entity.Rol;
import com.seminario.entity.Usuario;
import com.seminario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    public UsuarioDTO save(UsuarioDTO dto) {
        Usuario usuario = new Usuario(dto);

        List<Rol> roles = dto.getRoles().stream().map(rolDTO -> {
           Rol rol = new Rol();
           rol.setNombre(rolDTO.getNombre());
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
}
