package com.example.MyTools.repository;

import com.example.MyTools.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommandesRepository extends JpaRepository<Commandes, Integer> {
    @Query(value = "SELECT ap FROM Commandes ap WHERE ap.client=:app ORDER BY ap.client.id")
    List<Commandes> findAllByClient(@Param("app") Client app);
}
