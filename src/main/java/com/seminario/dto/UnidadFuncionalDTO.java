package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.UnidadFuncional;

import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class UnidadFuncionalDTO {

    private long id;

    private String codigoDepartamento;

    private String descripcionDepartamento;

    private Integer metrosCuadrados;

    private Double prorrateo;

    private String codigoUbicacion;

    private String descripcionUbicacion;

    private ConsorcioDTO consorcio;

    private UsuarioDTO propietario;

    private UsuarioDTO inquilino;

    public UnidadFuncionalDTO() {
    }

    public UnidadFuncionalDTO(UnidadFuncional entity) {
        this.id = entity.getId();
        this.codigoDepartamento = entity.getCodigoDepartamento();
        this.descripcionDepartamento = entity.getDescripcionDepartamento();
        this.metrosCuadrados = entity.getMetrosCuadrados();
        this.prorrateo = entity.getProrrateo();
        this.codigoUbicacion = entity.getCodigoUbicacion();
        this.descripcionUbicacion = entity.getDescripcionUbicacion();
        entity.getPropietario().ifPresent(prop -> this.propietario = new UsuarioDTO(prop));
        entity.getInquilino().ifPresent(inq -> this.inquilino = new UsuarioDTO(inq));
    }

    public long getId() {
        return id;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public String getDescripcionDepartamento() {
        return descripcionDepartamento;
    }

    public Integer getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public Double getProrrateo() {
        return prorrateo;
    }

    public String getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public String getDescripcionUbicacion() {
        return descripcionUbicacion;
    }

    public ConsorcioDTO getConsorcio() {
        return consorcio;
    }

    public Optional<UsuarioDTO> getPropietario() {
        return Optional.ofNullable(propietario);
    }

    public Optional<UsuarioDTO> getInquilino() {
        return Optional.ofNullable(inquilino);
    }
}
