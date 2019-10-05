package com.seminario.repository;

import com.seminario.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByMailAndPassword(String mail, String password);
}
