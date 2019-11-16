package com.seminario.entity;

import com.seminario.dto.TemaDTO;

import javax.persistence.*;

@Entity
public class Tema {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "positivo")
    private Integer positivo;

    @Column(name = "negativo")
    private Integer negativo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="reunion_id", nullable = false)
    private Reunion reunion;

    public Tema() {
    }

    public Tema(TemaDTO dto, Reunion reunion) {
        this.descripcion = dto.getDescripcion();
        this.reunion = reunion;
    }

    public long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPositivo() {
        return positivo;
    }

    public void setPositivo(Integer positivo) {
        this.positivo = positivo;
    }

    public Integer getNegativo() {
        return negativo;
    }

    public void setNegativo(Integer negativo) {
        this.negativo = negativo;
    }

    public Reunion getReunion() {
        return reunion;
    }
}
