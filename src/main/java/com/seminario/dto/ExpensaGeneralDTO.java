package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.ExpensaGeneral;
import com.seminario.util.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpensaGeneralDTO {

    private String periodo;
    private List<ItemExpensaDTO> items;

    public ExpensaGeneralDTO() {
    }

    public ExpensaGeneralDTO(ExpensaGeneral expensaGeneral) {
        this.periodo = DateUtil.getStrDate(expensaGeneral.getPeriodo());
        this.items = expensaGeneral.getItems().stream().map(ItemExpensaDTO::new).collect(Collectors.toList());
    }

    public String getPeriodo() {
        return periodo;
    }

    public List<ItemExpensaDTO> getItems() {
        return items;
    }
}
