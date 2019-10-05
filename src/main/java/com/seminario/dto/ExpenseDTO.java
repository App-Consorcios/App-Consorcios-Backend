package com.seminario.dto;

import org.joda.time.LocalDate;

public class ExpenseDTO {

    private long id;
    private String periodo;
    private double cargasSociales;
    private double abonosServicios;
    private double reparacionesEdificio;
    private double serviciosPublicos;
    private double gastosAdministrativos;
    private double gastosMantenimiento;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
