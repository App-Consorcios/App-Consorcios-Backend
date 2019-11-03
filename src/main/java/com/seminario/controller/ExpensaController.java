package com.seminario.controller;

import com.seminario.dto.ExpensaGeneralDTO;
import com.seminario.service.ExpensaService;
import com.seminario.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
        Optional<Date> fromPeriod = DateUtil.getOptionalDate(strFromPeriod);
        Optional<Date> toPeriod = DateUtil.getOptionalDate(strToPeriod);
        Optional<Date> period = DateUtil.getOptionalDate(strPeriod);

        return expensaService.getExpensas(fromPeriod, toPeriod, period);
    }
}
