package com.seminario.entity;

import com.seminario.dto.UnidadFuncionalDTO;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class UnidadFuncional {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo_departamento", nullable = false)
    private String codigoDepartamento;

    @Column(name = "descripcion_departamento", nullable = false)
    private String descripcionDepartamento;

    @Column(name = "metros_cuadrados", nullable = false)
    private Integer metrosCuadrados;

    @Column(name = "prorrateo", nullable = false)
    private Double prorrateo;

    @Column(name = "codigo_Ubicacion", nullable = false)
    private String codigoUbicacion;

    @Column(name = "descripcion_ubicacion", nullable = false)
    private String descripcionUbicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="consorcio_id")
    private Consorcio consorcio;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_propietario_id")
    private Usuario propietario;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_inquilino_id")
    private Usuario inquilino;

    public UnidadFuncional() {
    }

    public UnidadFuncional(UnidadFuncionalDTO dto) {
        this.codigoDepartamento = dto.getCodigoDepartamento();
        this.descripcionDepartamento = dto.getDescripcionDepartamento();
        this.metrosCuadrados = dto.getMetrosCuadrados();
        this.prorrateo = dto.getProrrateo();
        this.codigoUbicacion = dto.getCodigoUbicacion();
        this.descripcionUbicacion = dto.getDescripcionUbicacion();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getDescripcionDepartamento() {
        return descripcionDepartamento;
    }

    public void setDescripcionDepartamento(String descripcionDepartamento) {
        this.descripcionDepartamento = descripcionDepartamento;
    }

    public Integer getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(Integer metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public Double getProrrateo() {
        return prorrateo;
    }

    public void setProrrateo(Double prorrateo) {
        this.prorrateo = prorrateo;
    }

    public String getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setCodigoUbicacion(String codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public String getDescripcionUbicacion() {
        return descripcionUbicacion;
    }

    public void setDescripcionUbicacion(String descripcionUbicacion) {
        this.descripcionUbicacion = descripcionUbicacion;
    }

    public Optional<Consorcio> getConsorcio() {
        return Optional.ofNullable(consorcio);
    }

    public void setConsorcio(Consorcio consorcio) {
        this.consorcio = consorcio;
    }

    public Optional<Usuario> getPropietario() {
        return Optional.ofNullable(propietario);
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public Optional<Usuario> getInquilino() {
        return Optional.ofNullable(inquilino);
    }

    public void setInquilino(Usuario inquilino) {
        this.inquilino = inquilino;
    }
}
