package com.example.MyTools.repository;

import com.example.MyTools.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppareilRepository extends JpaRepository<Appareil, Integer> {

    @Query(value = "SELECT ap FROM Appareil ap WHERE ap.produits =:ord ORDER BY ap.id DESC")
    List<Appareil> findByProduits(@Param("ord") Produits ord);

    @Query(value = "SELECT ap FROM Appareil ap WHERE ap.atelier=:app ORDER BY ap.atelier.id")
    List<Appareil> findAllByAtelier(@Param("app")Atelier app);
    public List<Appareil> findByEtat(Etat etat);
}
