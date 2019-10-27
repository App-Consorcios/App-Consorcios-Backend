package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.ItemExpensaGeneral;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ItemExpensaDTO {

    private String conceptoNombre;
    private Double monto;

    public ItemExpensaDTO() {
    }

    public ItemExpensaDTO(ItemExpensaGeneral entity) {
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
