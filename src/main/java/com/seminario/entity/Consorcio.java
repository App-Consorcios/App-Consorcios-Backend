package com.seminario.entity;

import javax.persistence.*;

@Entity
public class Consorcio {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_administrador_id")
    private Usuario administrador;

    public Consorcio() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Usuario administrador) {
        this.administrador = administrador;
    }
}
