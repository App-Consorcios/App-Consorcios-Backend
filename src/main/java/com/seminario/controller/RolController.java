package com.seminario.controller;

import com.seminario.dto.RolDTO;
import com.seminario.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping(value = "/rol")
    public RolDTO saveRol(@RequestBody RolDTO rolDTO) {
        return rolService.createRol(rolDTO);
    }

    @GetMapping(value = "/roles")
    public List<RolDTO> getRoles() {
        return rolService.getRoles();
    }
}
