package com.seminario.repository;

import com.seminario.entity.Concepto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConceptoRepository extends JpaRepository<Concepto, Long> {

    Concepto findByNombre(String nombre);
}
