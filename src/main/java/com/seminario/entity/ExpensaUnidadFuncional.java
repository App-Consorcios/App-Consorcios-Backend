package com.seminario.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ExpensaUnidadFuncional {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "periodo", nullable = false)
    private Date periodo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="unidad_funcional_id", nullable=false)
    private UnidadFuncional unidadFuncional;

    @OneToMany(mappedBy = "expensaUnidadFuncional", cascade = CascadeType.ALL)
    private List<ItemExpensaUnidadFuncional> items;

    public ExpensaUnidadFuncional() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public UnidadFuncional getUnidadFuncional() {
        return unidadFuncional;
    }

    public void setUnidadFuncional(UnidadFuncional unidadFuncional) {
        this.unidadFuncional = unidadFuncional;
    }

    public List<ItemExpensaUnidadFuncional> getItems() {
        return items;
    }

    public void setItems(List<ItemExpensaUnidadFuncional> items) {
        this.items = items;
    }
}
