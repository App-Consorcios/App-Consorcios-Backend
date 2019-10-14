package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.ItemExpensa;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemExpensaDTO {

    private String conceptoNombre;
    private Double monto;

    public ItemExpensaDTO() {
    }

    public ItemExpensaDTO(ItemExpensa entity) {
        this.conceptoNombre = entity.getConcepto().getNombre();
        this.monto = entity.getMonto();
    }

    public String getConceptoNombre() {
        return conceptoNombre;
    }

    public Double getMonto() {
        return monto;
    }
}
