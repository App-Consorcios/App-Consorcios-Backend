package com.seminario.entity;

import javax.persistence.*;

@Entity
public class Reunion {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Reunion() {
    }
}
