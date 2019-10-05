package com.seminario.repository;

import com.seminario.entity.Expense;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findAllByPeriodBetween(LocalDate fromPeriod, LocalDate toPeriod);

    Expense findByPeriod(LocalDate period);
}
