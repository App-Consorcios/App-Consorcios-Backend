package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.Rol;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class RolDTO {

    private String nombre;

    public RolDTO() {
    }

    public RolDTO(Rol entity) {
        this.nombre = entity.getNombre();
    }

    public String getNombre() {
        return nombre;
    }
}
