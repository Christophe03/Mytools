package com.example.MyTools.services;

import com.example.MyTools.model.RendezVous;

import java.util.List;

public interface RendezVousService {
    RendezVous ajouterRendezVous(RendezVous rendezVous);
    List<RendezVous> afficherRendezVous();
    String supprimer(Integer id);
    void modifierRendezVous(RendezVous rendezVous, Integer id);
    RendezVous afficherRendezVousById(Integer id);
}
