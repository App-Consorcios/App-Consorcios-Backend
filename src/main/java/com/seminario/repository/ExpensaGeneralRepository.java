package com.seminario.repository;

import com.seminario.entity.ExpensaGeneral;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpensaGeneralRepository extends JpaRepository<ExpensaGeneral, Long> {

    List<ExpensaGeneral> findAllByPeriodoBetween(LocalDate fromPeriod, LocalDate toPeriod);

    ExpensaGeneral findByPeriodo(LocalDate period);
}
