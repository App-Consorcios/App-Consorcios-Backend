package com.seminario.entity;

import com.seminario.dto.ConceptoDTO;

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

    public Concepto(ConceptoDTO dto, TipoConcepto tipoConcepto) {
        this.nombre = dto.getNombre();
        this.tipoConcepto = tipoConcepto;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoConcepto getTipoConcepto() {
        return tipoConcepto;
    }

}
