package com.seminario.controller;

import com.seminario.dto.UnidadFuncionalDTO;
import com.seminario.service.UnidadFuncionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UnidadFuncionalController {

    @Autowired
    private UnidadFuncionalService unidadFuncionalService;

    @PostMapping(value = "/unidad-funcional")
    public UnidadFuncionalDTO saveUnidadFuncional(@RequestBody UnidadFuncionalDTO unidadFuncionalDTO) {
        return unidadFuncionalService.saveUnidadFuncional(unidadFuncionalDTO);
    }

    @GetMapping(value = "/unidades-funcionales")
    public List<UnidadFuncionalDTO> getUnidadesFuncionales() {
        return unidadFuncionalService.getUnidadesFuncionales();
    }

    @PutMapping(value = "/unidad-funcional")
    public UnidadFuncionalDTO updateUnidadFuncional(@RequestParam(value="id") Long idUnidadFuncional,
                                                    @RequestBody UnidadFuncionalDTO unidadFuncionalDTO) {
        return unidadFuncionalService.updateUnidadFuncional(idUnidadFuncional, unidadFuncionalDTO);
    }
}
