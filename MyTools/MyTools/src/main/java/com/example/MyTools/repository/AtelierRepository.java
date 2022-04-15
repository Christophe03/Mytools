package com.example.MyTools.repository;

import com.example.MyTools.model.Accessoires;
import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Etat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AtelierRepository extends JpaRepository<Atelier, Integer> {
    Optional<Atelier> findAtelierByContacts(String contact);
    Optional<Atelier> findByEmailAndPassword(String email, String password);
    Optional<Atelier> findByEmail(String email);
    public List<Atelier> findByEtat(Etat etat);
}
