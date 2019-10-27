package com.seminario.entity;

import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ExpensaGeneral {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "periodo", nullable = false)
    private Date periodo;

    @OneToMany(mappedBy = "expensaGeneral", cascade = CascadeType.ALL)
    private List<ItemExpensaGeneral> items;

    public ExpensaGeneral() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getPeriodo() {
        return new LocalDate(this.periodo);
    }

    public void setPeriodo(LocalDate periodo) {
        this.periodo = periodo.toDate();
    }

    public List<ItemExpensaGeneral> getItems() {
        return items;
    }

    public void setItems(List<ItemExpensaGeneral> items) {
        this.items = items;
    }
}
