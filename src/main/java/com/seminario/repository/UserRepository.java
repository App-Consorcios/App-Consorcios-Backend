package com.seminario.repository;

import com.seminario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    Usuario findByMailAndPassword(String mail, String password);

    Usuario findByMail(String mail);
}
