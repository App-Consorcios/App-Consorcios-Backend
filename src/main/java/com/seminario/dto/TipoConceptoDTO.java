package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.TipoConcepto;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class TipoConceptoDTO {

    private String nombre;
    private String color;

    public TipoConceptoDTO() {
    }

    public TipoConceptoDTO(TipoConcepto entity) {
        this.nombre = entity.getNombre();
        this.color = entity.getColor();
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }
}
