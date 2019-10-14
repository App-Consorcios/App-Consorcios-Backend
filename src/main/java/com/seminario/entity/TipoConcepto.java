package com.seminario.entity;

import com.seminario.dto.TipoConceptoDTO;

import javax.persistence.*;

@Entity
public class TipoConcepto {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "color", nullable = false)
    private String color;

    public TipoConcepto() {
    }

    public TipoConcepto(TipoConceptoDTO dto) {
        this.nombre = dto.getNombre();
        this.color = dto.getColor();
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
