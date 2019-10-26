package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.Concepto;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConceptoDTO {

    private String nombre;
    private String descripcion;
    private TipoConceptoDTO tipoConcepto;

    public ConceptoDTO() {
    }

    public ConceptoDTO(Concepto entity) {
        this.nombre = entity.getNombre();
        this.tipoConcepto = new TipoConceptoDTO(entity.getTipoConcepto());
        this.descripcion = entity.getDescripcion();
    }

    public String getNombre() {
        return nombre;
    }

    public TipoConceptoDTO getTipoConcepto() {
        return tipoConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
