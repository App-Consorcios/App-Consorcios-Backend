package com.seminario.service;

import com.seminario.dto.ExpensaGeneralDTO;
import com.seminario.entity.ExpensaGeneral;
import com.seminario.entity.ItemExpensa;
import com.seminario.repository.ConceptoRepository;
import com.seminario.repository.ExpensaGeneralRepository;
import com.seminario.util.DateUtil;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ExpensaService {

    @Autowired
    private ExpensaGeneralRepository expensaGeneralRepository;

    @Autowired
    private ConceptoRepository conceptoRepository;

    public ExpensaGeneralDTO saveExpensaGeneral(ExpensaGeneralDTO dto) {

        ExpensaGeneral expensaGeneral = new ExpensaGeneral();

        List<ItemExpensa> items = dto.getItems().stream().map(itemDTO -> {
            ItemExpensa itemExpensa = new ItemExpensa();
            itemExpensa.setConcepto(conceptoRepository.findByNombre(itemDTO.getConceptoNombre()));
            itemExpensa.setMonto(itemDTO.getMonto());
            itemExpensa.setExpensaGeneral(expensaGeneral);
            return itemExpensa;
        }).collect(Collectors.toList());

        expensaGeneral.setItems(items);
        expensaGeneral.setPeriodo(DateUtil.getLocalDate(dto.getPeriodo()));

        expensaGeneralRepository.save(expensaGeneral);

        return dto;
    }

    public List<ExpensaGeneralDTO> getExpensas(LocalDate fromPeriod, LocalDate toPeriod, LocalDate period) {

        List<ExpensaGeneral> expensasGenerales = new ArrayList<>();

        if (period != null) {
            expensasGenerales.add(expensaGeneralRepository.findByPeriodo(period));
        } else {
            expensasGenerales.addAll(expensaGeneralRepository.findAllByPeriodoBetween(fromPeriod, toPeriod));
        }

        return expensasGenerales.stream().filter(Objects::nonNull).map(ExpensaGeneralDTO::new).collect(Collectors.toList());
    }
}
