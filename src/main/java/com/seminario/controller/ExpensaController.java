package com.seminario.controller;

import com.seminario.dto.ExpensaGeneralDTO;
import com.seminario.service.ExpensaService;
import com.seminario.util.DateUtil;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensaController {

    @Autowired
    private ExpensaService expensaService;

    @PostMapping(value = "/expensa")
    public ExpensaGeneralDTO saveExpensaGeneral(@RequestBody ExpensaGeneralDTO expensaGeneralDTO) {
        return expensaService.saveExpensaGeneral(expensaGeneralDTO);
    }

    @GetMapping(value = "/expensas")
    public List<ExpensaGeneralDTO> getExpensasGenerales(@RequestParam(value="fromPeriodo", required=false) String strFromPeriod,
                                               @RequestParam(value="toPeriodo", required=false) String strToPeriod,
                                               @RequestParam(value="periodo", required=false) String strPeriod
    ) {
        LocalDate fromPeriod = DateUtil.getLocalDate(strFromPeriod);
        LocalDate toPeriod = DateUtil.getLocalDate(strToPeriod);
        LocalDate period = DateUtil.getLocalDate(strPeriod);
        return expensaService.getExpensas(fromPeriod, toPeriod, period);
    }
}
