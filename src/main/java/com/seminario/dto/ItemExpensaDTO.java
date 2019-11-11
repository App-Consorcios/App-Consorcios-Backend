package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.ItemExpensaGeneral;
import com.seminario.entity.ItemExpensaUnidadFuncional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ItemExpensaDTO {

    private String conceptoNombre;
    private String descripcion;
    private Double monto;

    public ItemExpensaDTO() {
    }

    public ItemExpensaDTO(ItemExpensaGeneral entity) {
        this.conceptoNombre = entity.getConcepto().getNombre();
        this.descripcion = entity.getDescripcion();
        this.monto = entity.getMonto();
    }

    public ItemExpensaDTO(ItemExpensaUnidadFuncional entity) {
        this.conceptoNombre = entity.getConcepto().getNombre();
        this.monto = entity.getMonto();
    }

    public ItemExpensaDTO(String conceptoNombre, Double monto) {
        this.conceptoNombre = conceptoNombre;
        this.monto = monto;
    }

    public String getConceptoNombre() {
        return conceptoNombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getMonto() {
        return monto;
    }

    public void setConceptoNombre(String conceptoNombre) {
        this.conceptoNombre = conceptoNombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }
}
