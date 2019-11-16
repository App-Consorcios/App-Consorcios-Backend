package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.Reunion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ReunionDTO {

    private Long id;
    private String color;
    private String descripcion;
    private Date fecha;
    private List<TemaDTO> temas = new ArrayList<>();

    public ReunionDTO() {
    }

    public ReunionDTO(Reunion entity) {
        this.id = entity.getId();
        this.color = entity.getColor();
        this.descripcion = entity.getDescripcion();
        this.fecha = entity.getFecha();
        this.temas = entity.getTemas().stream().map(TemaDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public List<TemaDTO> getTemas() {
        return temas;
    }
}
