package com.seminario.repository;

import com.seminario.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombre(String nombre);
}
