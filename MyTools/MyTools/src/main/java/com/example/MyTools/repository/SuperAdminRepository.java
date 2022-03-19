package com.example.MyTools.repository;

import com.example.MyTools.model.SuperAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuperAdminRepository extends JpaRepository<SuperAdmin, Integer> {
    Optional<SuperAdmin> findByEmailAndPassword(String email, String password);
}
