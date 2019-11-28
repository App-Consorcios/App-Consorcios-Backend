package com.seminario.entity;

import com.seminario.dto.ReunionDTO;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Reunion {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm-ss.zzz")
    @Column(name = "fecha")
    private Date fecha;

    @OneToMany(mappedBy = "reunion", cascade = CascadeType.ALL)
    private List<Tema> temas = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="consorcio_id")
    private Consorcio consorcio;

    public Reunion() {
    }

    public Reunion(ReunionDTO dto) {
        this.color = dto.getColor();
        this.descripcion = dto.getDescripcion();
        this.fecha = dto.getFecha();
    }

    public long getId() {
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Tema> getTemas() {
        return temas;
    }
}
