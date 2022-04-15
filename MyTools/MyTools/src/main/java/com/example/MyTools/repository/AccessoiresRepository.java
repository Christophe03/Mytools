package com.example.MyTools.repository;

import com.example.MyTools.model.Accessoires;
import com.example.MyTools.model.Appareil;
import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Etat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccessoiresRepository extends JpaRepository<Accessoires, Integer> {

    @Query(value = "SELECT ap FROM Accessoires ap WHERE ap.produits =: acce")
    List<Accessoires> findByProduits(@Param("acce")String acce);

    @Query(value = "SELECT ap FROM Accessoires ap WHERE ap.atelier=:app ORDER BY ap.atelier.id")
    List<Accessoires> findAllByAtelier(@Param("app") Atelier app);

    public List<Accessoires> findByEtat(Etat etat);

}
