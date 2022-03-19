package com.example.MyTools.services.impl;

import com.example.MyTools.model.Reparation;
import com.example.MyTools.repository.ReparationRepository;
import com.example.MyTools.services.ReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReparationServiceImpl implements ReparationService {
    @Autowired
    ReparationRepository reparationRepository;

    @Override
    public Reparation ajoutReparation(Reparation reparation) {
        return this.reparationRepository.save(reparation);
    }

    @Override
    public List<Reparation> afficherListReparation() {
        return this.reparationRepository.findAll();
    }

    @Override
    public void modifierReparation(Reparation reparation, Integer id) {
        Reparation reparationExistant = this.reparationRepository.findById(id).orElseThrow();
        reparationExistant.setNom(reparation.getNom());
        reparationExistant.setDateDepot(reparation.getDateDepot());
        reparationExistant.setDateRendu(reparation.getDateRendu());
        reparationExistant.setSolution(reparation.getSolution());
    }

    @Override
    public Reparation afficherById(Integer id) {
        return this.reparationRepository.findById(id).get();
    }

    @Override
    public String supprimer(Integer id) {
        this.reparationRepository.deleteById(id);
        return "Supprimer avec success";
    }
}
