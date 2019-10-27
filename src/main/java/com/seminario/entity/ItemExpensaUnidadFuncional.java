package com.seminario.entity;

import javax.persistence.*;

@Entity
public class ItemExpensaUnidadFuncional {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "monto", nullable = false)
    private Double monto;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="concepto_id", nullable=false)
    private Concepto concepto;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="expensa_unidad_funcional_id", nullable=false)
    private ExpensaUnidadFuncional expensaUnidadFuncional;

    public ItemExpensaUnidadFuncional() {
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

    public ExpensaUnidadFuncional getExpensaUnidadFuncional() {
        return expensaUnidadFuncional;
    }

    public void setExpensaUnidadFuncional(ExpensaUnidadFuncional expensaUnidadFuncional) {
        this.expensaUnidadFuncional = expensaUnidadFuncional;
    }
}
