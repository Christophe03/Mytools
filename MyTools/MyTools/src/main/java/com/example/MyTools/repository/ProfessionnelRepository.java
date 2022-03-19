package com.example.MyTools.repository;

import com.example.MyTools.model.Professionnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionnelRepository extends JpaRepository<Professionnel, Integer> {
    Optional<Professionnel> findByEmailAndPassword(String email, String password);
    Professionnel findPersonnesByEmail(String email);
    Optional<Professionnel> findByContact(String contact);
    Optional<Professionnel> findByEmail(String email);
}
