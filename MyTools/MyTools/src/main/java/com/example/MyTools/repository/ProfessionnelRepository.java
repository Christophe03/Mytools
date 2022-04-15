package com.example.MyTools.repository;

import com.example.MyTools.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessionnelRepository extends JpaRepository<Professionnel, Integer> {
    Optional<Professionnel> findByEmailAndPassword(String email, String password);
    Professionnel findPersonnesByEmail(String email);
    Optional<Professionnel> findByContact(String contact);
    Optional<Professionnel> findByEmail(String email);
    @Query(value = "SELECT ap FROM Professionnel ap WHERE ap.atelier=:app ORDER BY ap.atelier.id")
    List<Professionnel> findAllByAtelier(@Param("app") Atelier app);
}
