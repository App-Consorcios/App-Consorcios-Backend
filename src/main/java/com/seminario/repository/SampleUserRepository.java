package com.seminario.repository;

import com.seminario.entity.SampleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleUserRepository extends JpaRepository<SampleUser, Long> {
}
