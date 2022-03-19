package com.example.MyTools.services;

import com.example.MyTools.model.Vente;

import java.util.List;

public interface VenteService {

    Vente ajouterVente(Vente vente);
    List<Vente> listerVente();
    String supprimerVente(Integer id);
    Vente afficherVenteById(Integer id);
}
