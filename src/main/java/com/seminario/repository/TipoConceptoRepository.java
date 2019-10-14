package com.seminario.repository;

import com.seminario.entity.TipoConcepto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoConceptoRepository extends JpaRepository<TipoConcepto, Long> {

    TipoConcepto findByNombre(String nombre);
}
