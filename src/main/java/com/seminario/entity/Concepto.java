package com.seminario.entity;

import javax.persistence.*;

@Entity
public class Concepto {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="tipo_concepto_id", nullable=false)
    private TipoConcepto tipoConcepto;

    public Concepto() {
    }

    public Concepto(String nombre, TipoConcepto tipoConcepto) {
        this.nombre = nombre;
        this.tipoConcepto = tipoConcepto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoConcepto getTipoConcepto() {
        return tipoConcepto;
    }

    public void setTipoConcepto(TipoConcepto tipoConcepto) {
        this.tipoConcepto = tipoConcepto;
    }
}
