package com.seminario.entity;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Expense {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "period", nullable = false)
    private LocalDate period;

    @Column(name = "cargas_sociales", nullable = false)
    private double cargasSociales;

    @Column(name = "abonos_servicios", nullable = false)
    private double abonosServicios;

    @Column(name = "reparaciones_edificio", nullable = false)
    private double reparacionesEdificio;

    @Column(name = "servicios_publicios", nullable = false)
    private double serviciosPublicos;

    @Column(name = "gastos_administrativos", nullable = false)
    private double gastosAdministrativos;

    @Column(name = "gastos_mantenimiento", nullable = false)
    private double gastosMantenimiento;

    public Expense() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPeriod() {
        return period;
    }

    public void setPeriod(LocalDate period) {
        this.period = period;
    }

    public double getCargasSociales() {
        return cargasSociales;
    }

    public void setCargasSociales(double cargasSociales) {
        this.cargasSociales = cargasSociales;
    }

    public double getAbonosServicios() {
        return abonosServicios;
    }

    public void setAbonosServicios(double abonosServicios) {
        this.abonosServicios = abonosServicios;
    }

    public double getReparacionesEdificio() {
        return reparacionesEdificio;
    }

    public void setReparacionesEdificio(double reparacionesEdificio) {
        this.reparacionesEdificio = reparacionesEdificio;
    }

    public double getServiciosPublicos() {
        return serviciosPublicos;
    }

    public void setServiciosPublicos(double serviciosPublicos) {
        this.serviciosPublicos = serviciosPublicos;
    }

    public double getGastosAdministrativos() {
        return gastosAdministrativos;
    }

    public void setGastosAdministrativos(double gastosAdministrativos) {
        this.gastosAdministrativos = gastosAdministrativos;
    }

    public double getGastosMantenimiento() {
        return gastosMantenimiento;
    }

    public void setGastosMantenimiento(double gastosMantenimiento) {
        this.gastosMantenimiento = gastosMantenimiento;
    }
}
