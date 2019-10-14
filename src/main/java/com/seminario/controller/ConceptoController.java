package com.seminario.controller;

import com.seminario.dto.ConceptoDTO;
import com.seminario.dto.TipoConceptoDTO;
import com.seminario.service.ConceptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConceptoController {

    @Autowired
    private ConceptoService conceptoService;

    @PostMapping(value = "/conceptos/tipo")
    public TipoConceptoDTO saveTipoConcepto(@RequestBody TipoConceptoDTO tipoConceptoRequest) {
        return conceptoService.saveTipoConcepto(tipoConceptoRequest);
    }

    @GetMapping(value = "/conceptos/tipos")
    public List<TipoConceptoDTO> getTipoConcepto() {
        return conceptoService.getAllConceptoTipos();
    }

    @PostMapping(value = "/concepto")
    public ConceptoDTO saveConcepto(@RequestBody ConceptoDTO conceptoDTO) {
        return conceptoService.saveConcepto(conceptoDTO);
    }

    @GetMapping(value = "/conceptos")
    public List<ConceptoDTO> getConceptos() {
        return conceptoService.getAllConceptos();
    }
}
