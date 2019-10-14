package com.seminario.entity;

import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExpensaGeneral {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "periodo", nullable = false)
    private LocalDate periodo;

    @OneToMany(mappedBy = "expensaGeneral", cascade = CascadeType.ALL)
    private List<ItemExpensa> items;

    public ExpensaGeneral() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPeriodo() {
        return periodo;
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo;
    }

    public List<ItemExpensa> getItems() {
        return items;
    }

    public void setItems(List<ItemExpensa> items) {
        this.items = items;
    }
}
