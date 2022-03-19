package com.example.MyTools.services.impl;

import com.example.MyTools.model.RendezVous;
import com.example.MyTools.repository.RendezVousRepository;
import com.example.MyTools.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RendezVousServiceImpl implements RendezVousService {
    public RendezVousServiceImpl() {
        super();
    }

    @Autowired
    RendezVousRepository rendezVousRepository;

    @Override
    public RendezVous ajouterRendezVous(RendezVous rendezVous) {
        return this.rendezVousRepository.save(rendezVous);
    }

    @Override
    public List<RendezVous> afficherRendezVous() {
        return this.rendezVousRepository.findAll();
    }

    @Override
    public String supprimer(Integer id) {
        this.rendezVousRepository.deleteById(id);
        return "Supprimer avec success";
    }

    @Override
    public void modifierRendezVous(RendezVous rendezVous, Integer id) {
        RendezVous rendezVousExistant = this.rendezVousRepository.findById(id).orElseThrow();
        rendezVousExistant.setDateSaisi(rendezVous.getDateSaisi());
        rendezVousExistant.setDateRendu(rendezVous.getDateRendu());
        rendezVousExistant.setMontant(rendezVous.getMontant());
    }

    @Override
    public RendezVous afficherRendezVousById(Integer id) {
        return this.rendezVousRepository.findById(id).get();
    }
}
