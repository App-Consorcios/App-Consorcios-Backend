package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String password;
    private String mail;
    private String imagen;
    private List<RolDTO> roles;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario entity) {
        this.id = entity.getId();
        this.nombre = entity.getNombre();
        this.apellido = entity.getApellido();
        this.mail = entity.getMail();
        entity.getImagen().ifPresent(imagen -> this.imagen = imagen);
        this.roles = entity.getRoles().stream().map(RolDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public Optional<String> getImagen() {
        return Optional.ofNullable(imagen);
    }

    public List<RolDTO> getRoles() {
        return roles;
    }
}


