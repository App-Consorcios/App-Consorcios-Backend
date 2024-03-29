package com.seminario.entity;

import com.seminario.dto.ItemExpensaDTO;

import javax.persistence.*;

@Entity
public class ItemExpensaGeneral {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="concepto_id", nullable=false)
    private Concepto concepto;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="expensa_general_id", nullable=false)
    private ExpensaGeneral expensaGeneral;

    public ItemExpensaGeneral() {
    }

    public ItemExpensaGeneral(ItemExpensaDTO itemDTO, Concepto concepto, ExpensaGeneral expensaGeneral) {
        this.concepto = concepto;
        this.monto = itemDTO.getMonto();
        this.descripcion = itemDTO.getDescripcion();
        this.expensaGeneral = expensaGeneral;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public ExpensaGeneral getExpensaGeneral() {
        return expensaGeneral;
    }

    public void setExpensaGeneral(ExpensaGeneral expensaGeneral) {
        this.expensaGeneral = expensaGeneral;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
