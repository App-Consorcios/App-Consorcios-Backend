package com.seminario.dto;

import com.seminario.entity.ExpensaUnidadFuncional;

import java.util.List;

public class ExpensaUnidadFuncionalDTO {
    private String codigoDepartamento;
    private List<ItemExpensaDTO> items;

    public ExpensaUnidadFuncionalDTO() {
    }

    public ExpensaUnidadFuncionalDTO(String codigoDepartamento, List<ItemExpensaDTO> items) {
        this.codigoDepartamento = codigoDepartamento;
        this.items = items;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public List<ItemExpensaDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemExpensaDTO> items) {
        this.items = items;
    }
}
