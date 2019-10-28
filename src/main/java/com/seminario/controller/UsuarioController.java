package com.seminario.controller;

import com.seminario.dto.LoginDTO;
import com.seminario.dto.UsuarioDTO;
import com.seminario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/usuario")
    public UsuarioDTO saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.saveUser(usuarioDTO);
    }

    @PutMapping(value = "/usuario")
    public UsuarioDTO saveUsuario(@RequestParam(value="id") Long idUsuario,
                                  @RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.updateUserRol(idUsuario, usuarioDTO);
    }

    @GetMapping(value = "/usuarios")
    public List<UsuarioDTO> getUsers() {
        return usuarioService.allUsers();
    }

    @GetMapping(value = "/login")
    public LoginDTO validateLogin(@RequestParam("mail") String mail, @RequestParam("password") String password) {
        return usuarioService.isValidCredential(mail, password);
    }
}
