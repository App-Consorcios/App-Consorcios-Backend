package com.seminario.service;

import com.seminario.dto.ExpenseDTO;
import com.seminario.entity.Expense;
import com.seminario.repository.ExpenseRepository;
import com.seminario.util.DateUtil;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public ExpenseDTO saveExpense(ExpenseDTO expenseDTO) {

        Expense expense = new Expense();

        expense.setPeriod(DateUtil.getLocalDate(expenseDTO.getPeriodo()));
        expense.setAbonosServicios(expenseDTO.getAbonosServicios());
        expense.setCargasSociales(expenseDTO.getCargasSociales());
        expense.setGastosAdministrativos(expenseDTO.getGastosAdministrativos());
        expense.setGastosMantenimiento(expenseDTO.getGastosMantenimiento());
        expense.setReparacionesEdificio(expenseDTO.getReparacionesEdificio());
        expense.setServiciosPublicos(expenseDTO.getServiciosPublicos());

        Expense expenseSaved = expenseRepository.save(expense);

        expenseDTO.setId(expenseSaved.getId());

        return expenseDTO;
    }

    public List<ExpenseDTO> getExpense(LocalDate fromPeriod, LocalDate toPeriod, LocalDate period) {

        List<Expense> expenses = new ArrayList<>();

        if (period != null) {
            expenses.add(expenseRepository.findByPeriod(period));
        } else {
            expenses.addAll(expenseRepository.findAllByPeriodBetween(fromPeriod, toPeriod));
        }

        return expenses.stream().filter(Objects::nonNull).map(expense -> {

            ExpenseDTO expenseDTO = new ExpenseDTO();

            expenseDTO.setId(expense.getId());
            expenseDTO.setPeriodo(DateUtil.getStrDate(expense.getPeriod()));
            expenseDTO.setAbonosServicios(expense.getAbonosServicios());
            expenseDTO.setCargasSociales(expense.getCargasSociales());
            expenseDTO.setGastosAdministrativos(expense.getGastosAdministrativos());
            expenseDTO.setGastosMantenimiento(expense.getGastosMantenimiento());
            expenseDTO.setReparacionesEdificio(expense.getReparacionesEdificio());
            expenseDTO.setServiciosPublicos(expense.getServiciosPublicos());

            return expenseDTO;
        }).collect(Collectors.toList());
    }
}
