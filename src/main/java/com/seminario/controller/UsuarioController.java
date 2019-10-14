package com.seminario.controller;

import com.seminario.dto.LoginDTO;
import com.seminario.dto.UsuarioDTO;
import com.seminario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/usuario")
    public UsuarioDTO saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @GetMapping(value = "/usuarios")
    public List<UsuarioDTO> getUsers() {
        return usuarioService.allUsers();
    }

    @GetMapping(value = "/login")
    public LoginDTO allUsers(@RequestParam("mail") String mail, @RequestParam("password") String password) {
        return usuarioService.isValidCredential(mail, password);
    }
}