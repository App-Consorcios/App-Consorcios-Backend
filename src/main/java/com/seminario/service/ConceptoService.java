package com.seminario.service;

import com.seminario.dto.ConceptoDTO;
import com.seminario.dto.TipoConceptoDTO;
import com.seminario.entity.Concepto;
import com.seminario.entity.TipoConcepto;
import com.seminario.repository.ConceptoRepository;
import com.seminario.repository.TipoConceptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConceptoService {

    @Autowired
    private ConceptoRepository conceptoRepository;

    @Autowired
    private TipoConceptoRepository tipoConceptoRepository;

    public TipoConceptoDTO saveTipoConcepto(TipoConceptoDTO dto) {
        tipoConceptoRepository.save(new TipoConcepto(dto));
        return dto;
    }

    public List<TipoConceptoDTO> getAllConceptoTipos() {
        return tipoConceptoRepository.findAll().stream().map(TipoConceptoDTO::new).collect(Collectors.toList());
    }

    public ConceptoDTO saveConcepto(ConceptoDTO dto) {
        TipoConcepto tipoConcepto = tipoConceptoRepository.findByNombre(dto.getTipoConcepto().getNombre());
        conceptoRepository.save(new Concepto(dto.getNombre(), tipoConcepto));
        return dto;
    }

    public List<ConceptoDTO> getAllConceptos() {
        return conceptoRepository.findAll().stream().map(ConceptoDTO::new).collect(Collectors.toList());
    }
}
