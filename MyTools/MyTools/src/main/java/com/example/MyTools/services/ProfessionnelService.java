package com.example.MyTools.services;

import com.example.MyTools.model.Appareil;
import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Professionnel;

import java.util.List;

public interface ProfessionnelService {
    Professionnel ajouterPersonne(Professionnel professionnel, Integer id);
    List<Professionnel> afficherListPersonne();
    String supprimerPersonne(Integer id);
    void modifierPersonne(Professionnel professionnel, Integer id);
    Professionnel afficherPersonneById(Integer id);
    Professionnel connexion(String email, String password);
    List<Professionnel> professionnelAteler(Atelier app);
}
