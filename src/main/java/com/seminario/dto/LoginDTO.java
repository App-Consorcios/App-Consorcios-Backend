package com.seminario.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.seminario.entity.Usuario;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class LoginDTO {

    private Boolean valido;
    private UsuarioDTO usuario;

    public LoginDTO() {
    }

    public LoginDTO(Usuario usuarioEntity) {
        boolean usuarioValido = usuarioEntity != null;

        this.valido = usuarioValido;

        if (usuarioValido) {
            this.usuario = new UsuarioDTO(usuarioEntity);
        }
    }

    public Boolean getValido() {
        return valido;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }
}
