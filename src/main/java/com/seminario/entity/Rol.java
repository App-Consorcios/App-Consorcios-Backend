package com.seminario.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Rol {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @ManyToMany(mappedBy = "roles")
    private List<AppUser> appUsers = new ArrayList<>();

    public Rol() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }
}
