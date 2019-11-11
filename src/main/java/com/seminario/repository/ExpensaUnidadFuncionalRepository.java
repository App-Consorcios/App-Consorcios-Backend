package com.seminario.repository;

import com.seminario.entity.ExpensaUnidadFuncional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ExpensaUnidadFuncionalRepository extends JpaRepository<ExpensaUnidadFuncional, Long> {

    List<ExpensaUnidadFuncional> findAllByPeriodo(Date periodo);
}
