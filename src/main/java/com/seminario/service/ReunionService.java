package com.seminario.service;

import com.seminario.dto.ReunionDTO;
import com.seminario.dto.TemaDTO;
import com.seminario.entity.Reunion;
import com.seminario.entity.Tema;
import com.seminario.repository.ReunionRepository;
import com.seminario.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ReunionService {

    @Autowired
    private ReunionRepository reunionRepository;

    @Autowired
    private TemaRepository temaRepository;

    public ReunionDTO saveReunion(ReunionDTO dto) {
        Reunion reunion = new Reunion(dto);
        List<Tema> temas = dto.getTemas().stream().map(temaDTO -> new Tema(temaDTO, reunion)).collect(Collectors.toList());
        reunion.getTemas().addAll(temas);
        return new ReunionDTO(reunionRepository.save(reunion));
    }

    public Boolean deleteReunion(Long id) {
        reunionRepository.deleteById(id);
        return true;
    }

    public List<ReunionDTO> getReuniones() {
        return reunionRepository.findAll().stream().map(ReunionDTO::new).collect(Collectors.toList());
    }

    public ReunionDTO updateReunion(Long id, ReunionDTO dto) {
        Reunion reunion = reunionRepository.findById(id).get();
        reunion.setFecha(dto.getFecha());
        return new ReunionDTO(reunionRepository.save(reunion));
    }

}
