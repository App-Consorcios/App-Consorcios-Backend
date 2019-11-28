package com.seminario.service;

import com.seminario.dto.UnidadFuncionalDTO;
import com.seminario.dto.UsuarioDTO;
import com.seminario.entity.UnidadFuncional;
import com.seminario.entity.Usuario;
import com.seminario.repository.UnidadFuncionalRepository;
import com.seminario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UnidadFuncionalService {

    @Autowired
    private UnidadFuncionalRepository unidadFuncionalRepository;

    @Autowired
    private UserRepository userRepository;

    public UnidadFuncionalDTO saveUnidadFuncional(UnidadFuncionalDTO dto) {
        UnidadFuncional saved = unidadFuncionalRepository.save(new UnidadFuncional(dto));
        return new UnidadFuncionalDTO(saved);
    }

    public List<UnidadFuncionalDTO> getUnidadesFuncionales() {
        return unidadFuncionalRepository.findAll().stream().map(UnidadFuncionalDTO::new).collect(Collectors.toList());
    }

    public UnidadFuncionalDTO updateUnidadFuncional(Long idUnidadFuncional, UnidadFuncionalDTO unidadFuncionalDTO) {
        UnidadFuncional unidadFuncional = unidadFuncionalRepository.findById(idUnidadFuncional).get();

        Optional<Usuario> inquilino = unidadFuncionalDTO.getInquilino().map(user -> userRepository.findByMail(user.getMail()));
        unidadFuncional.setInquilino(inquilino.orElse(null));

        Optional<Usuario> propietario = unidadFuncionalDTO.getPropietario().map(user -> userRepository.findByMail(user.getMail()));
        unidadFuncional.setPropietario(propietario.orElse(null));

        UnidadFuncional saved = unidadFuncionalRepository.save(unidadFuncional);
        return new UnidadFuncionalDTO(saved);
    }
}
