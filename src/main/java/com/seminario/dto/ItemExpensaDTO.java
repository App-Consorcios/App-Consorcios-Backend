package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.Concepto;
import com.seminario.entity.ItemExpensaGeneral;
import com.seminario.entity.ItemExpensaUnidadFuncional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ItemExpensaDTO {

    private String conceptoNombre;
    private ConceptoDTO concepto;
    private String descripcion;
    private Double monto;

    public ItemExpensaDTO() {
    }

    public ItemExpensaDTO(ItemExpensaGeneral entity) {
        this.concepto = new ConceptoDTO(entity.getConcepto());
        this.conceptoNombre = entity.getConcepto().getNombre();
        this.descripcion = entity.getDescripcion();
        this.monto = entity.getMonto();
    }

    public ItemExpensaDTO(ItemExpensaUnidadFuncional entity) {
        this.concepto = new ConceptoDTO(entity.getConcepto());
        this.conceptoNombre = entity.getConcepto().getNombre();
        this.monto = entity.getMonto();
    }

    public ItemExpensaDTO(Concepto conceptoEntity, Double monto) {
        this.concepto = new ConceptoDTO(conceptoEntity);
        this.conceptoNombre = conceptoEntity.getNombre();
        this.monto = monto;
    }

    public ConceptoDTO getConcepto() {
        return concepto;
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
}
