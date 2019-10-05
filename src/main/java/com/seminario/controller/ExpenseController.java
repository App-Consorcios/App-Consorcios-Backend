package com.seminario.controller;

import com.seminario.dto.ExpenseDTO;
import com.seminario.service.ExpenseService;
import com.seminario.util.DateUtil;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping(value = "/expense")
    public ExpenseDTO saveUser(@RequestBody ExpenseDTO expense) {
        return expenseService.saveExpense(expense);
    }

    @GetMapping(value = "/expense")
    public List<ExpenseDTO> getExpenses(@RequestParam(value="fromPeriod", required=false) String strFromPeriod,
                                        @RequestParam(value="toPeriod", required=false) String strToPeriod,
                                        @RequestParam(value="period", required=false) String strPeriod
    ) {
        LocalDate fromPeriod = DateUtil.getLocalDate(strFromPeriod);
        LocalDate toPeriod = DateUtil.getLocalDate(strToPeriod);
        LocalDate period = DateUtil.getLocalDate(strPeriod);
        return expenseService.getExpense(fromPeriod, toPeriod, period);
    }
}
