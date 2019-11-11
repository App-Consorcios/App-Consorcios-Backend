package com.seminario.service;

import com.seminario.dto.ExpensasUnidadesFuncionalesWrapperDTO;
import com.seminario.dto.ExpensaUnidadFuncionalDTO;
import com.seminario.dto.ExpensaGeneralDTO;
import com.seminario.dto.ItemExpensaDTO;
import com.seminario.entity.*;
import com.seminario.repository.ConceptoRepository;
import com.seminario.repository.ExpensaGeneralRepository;
import com.seminario.repository.ExpensaUnidadFuncionalRepository;
import com.seminario.repository.UnidadFuncionalRepository;
import com.seminario.util.DateUtil;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ExpensaService {

    @Autowired
    private ExpensaGeneralRepository expensaGeneralRepository;

    @Autowired
    private ConceptoRepository conceptoRepository;

    @Autowired
    private UnidadFuncionalRepository unidadFuncionalRepository;

    @Autowired
    private ExpensaUnidadFuncionalRepository expensaUnidadFuncionalRepository;

    public ExpensaGeneralDTO saveExpensaGeneral(ExpensaGeneralDTO dto) {

        ExpensaGeneral expensaGeneral = new ExpensaGeneral();

        List<ItemExpensaGeneral> items = dto.getItemsGenerales().stream().map(itemDTO -> {
            Concepto concepto = conceptoRepository.findByNombre(itemDTO.getConceptoNombre());
            return new ItemExpensaGeneral(itemDTO, concepto, expensaGeneral);
        }).collect(Collectors.toList());

        expensaGeneral.setItems(items);
        expensaGeneral.setPeriodo(DateUtil.getLocalDate(dto.getPeriodo()));

        expensaGeneralRepository.save(expensaGeneral);

        return dto;
    }

    public List<ExpensaGeneralDTO> getExpensas(Optional<Date> fromPeriod, Optional<Date> toPeriod, Optional<Date> period) {

        List<ExpensaGeneral> expensasGenerales = new ArrayList<>();

        if (period.isPresent()) {
            expensasGenerales.add(expensaGeneralRepository.findByPeriodo(period.get()));
        } else if (fromPeriod.isPresent() && toPeriod.isPresent()) {
            expensasGenerales.addAll(expensaGeneralRepository.findAllByPeriodoBetween(fromPeriod.get(), toPeriod.get()));
        }

        return expensasGenerales.stream().filter(Objects::nonNull).map(ExpensaGeneralDTO::new).collect(Collectors.toList());
    }

    public ExpensasUnidadesFuncionalesWrapperDTO calcularExpensasUnidadesFuncionales() {
        LocalDate localDate = new LocalDate().withDayOfMonth(1);
        ExpensaGeneral expensaGeneralCurrentMonth = expensaGeneralRepository.findByPeriodo(localDate.toDate());

        List<ExpensaUnidadFuncionalDTO> items = unidadFuncionalRepository.findAll().stream().map(unidadFuncional -> {;
            List<ItemExpensaDTO> conceptos = expensaGeneralCurrentMonth.getItems().stream().map(itemExpensaGeneral -> {
                BigDecimal montoConcepto = BigDecimal.valueOf(itemExpensaGeneral.getMonto());
                BigDecimal prorrateo = BigDecimal.valueOf(unidadFuncional.getProrrateo());
                String conceptoNombre = itemExpensaGeneral.getConcepto().getNombre();
                return new ItemExpensaDTO(conceptoNombre, montoConcepto.multiply(prorrateo).doubleValue());
            }).collect(Collectors.toList());
            return new ExpensaUnidadFuncionalDTO(unidadFuncional.getCodigoDepartamento(), conceptos);
        }).collect(Collectors.toList());

        return new ExpensasUnidadesFuncionalesWrapperDTO(DateUtil.getStrDate(localDate), items);
    }

    public ExpensasUnidadesFuncionalesWrapperDTO saveExpensasUnidadesFuncionales() {

        ExpensasUnidadesFuncionalesWrapperDTO expensasUnidadesFuncionalesWrapperDTO = calcularExpensasUnidadesFuncionales();
        List<ExpensaUnidadFuncionalDTO> expensasUnidadesFuncionalesDTO = expensasUnidadesFuncionalesWrapperDTO.getExpensasUnidadesFuncionales();
        String periodo = expensasUnidadesFuncionalesWrapperDTO.getPeriodo();

        for (ExpensaUnidadFuncionalDTO expensaUnidadFuncionalDTO : expensasUnidadesFuncionalesDTO) {

            ExpensaUnidadFuncional expensaUnidadFuncional = new ExpensaUnidadFuncional();

            List<ItemExpensaUnidadFuncional> items = expensaUnidadFuncionalDTO.getItems().stream().map(itemExpensaDTO -> {
                Concepto concepto = conceptoRepository.findByNombre(itemExpensaDTO.getConceptoNombre());
                return new ItemExpensaUnidadFuncional(itemExpensaDTO.getMonto(), concepto, expensaUnidadFuncional);
            }).collect(Collectors.toList());

            UnidadFuncional unidadFuncional = unidadFuncionalRepository.findByCodigoDepartamento(expensaUnidadFuncionalDTO.getCodigoDepartamento());
            expensaUnidadFuncional.setUnidadFuncional(unidadFuncional);
            expensaUnidadFuncional.setPeriodo(DateUtil.getDate(periodo));
            expensaUnidadFuncional.setItems(items);

            expensaUnidadFuncionalRepository.save(expensaUnidadFuncional);
        }

        return expensasUnidadesFuncionalesWrapperDTO;
    }

    public ExpensasUnidadesFuncionalesWrapperDTO obtenerExpensasUnidadesFuncionales(Date period) {

        List<ExpensaUnidadFuncionalDTO> expensasUnidadesFuncionales = expensaUnidadFuncionalRepository.findAllByPeriodo(period).stream().map(expensaUnidadFuncional -> {
            List<ItemExpensaDTO> items = expensaUnidadFuncional.getItems().stream().map(ItemExpensaDTO::new).collect(Collectors.toList());
            String codigoDepartamento = expensaUnidadFuncional.getUnidadFuncional().getCodigoDepartamento();
            return new ExpensaUnidadFuncionalDTO(codigoDepartamento, items);
        }).collect(Collectors.toList());

        return new ExpensasUnidadesFuncionalesWrapperDTO(DateUtil.getStrDate(period), expensasUnidadesFuncionales);
    }
}
