package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.Tema;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class TemaDTO {

    private Long id;
    private String descripcion;
    private Integer positivo;
    private Integer negativo;

    public TemaDTO() {
    }

    public TemaDTO(Tema entity) {
        this.id = entity.getId();
        this.descripcion = entity.getDescripcion();
        this.positivo = entity.getPositivo();
        this.negativo = entity.getNegativo();
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPositivo() {
        return positivo;
    }

    public Integer getNegativo() {
        return negativo;
    }
}
