package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.ExpensaGeneral;
import com.seminario.util.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ExpensaGeneralDTO {

    private String periodo;
    private List<ItemExpensaDTO> itemsGenerales;

    public ExpensaGeneralDTO() {
    }

    public ExpensaGeneralDTO(ExpensaGeneral expensaGeneral) {
        this.periodo = DateUtil.getStrDate(expensaGeneral.getPeriodo());
        this.itemsGenerales = expensaGeneral.getItems().stream().map(ItemExpensaDTO::new).collect(Collectors.toList());
    }

    public String getPeriodo() {
        return periodo;
    }

    public List<ItemExpensaDTO> getItemsGenerales() {
        return itemsGenerales;
    }
}
