package com.example.MyTools.services;

import com.example.MyTools.model.Reparation;

import java.util.List;

public interface ReparationService {
    Reparation ajoutReparation(Reparation reparation);
    List<Reparation> afficherListReparation();
    void modifierReparation(Reparation reparation, Integer id);
    Reparation afficherById(Integer id);
    String supprimer(Integer id);
}
