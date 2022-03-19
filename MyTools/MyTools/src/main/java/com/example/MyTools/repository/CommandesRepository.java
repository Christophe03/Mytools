package com.example.MyTools.repository;

import com.example.MyTools.model.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandesRepository extends JpaRepository<Commandes, Integer> {
}
