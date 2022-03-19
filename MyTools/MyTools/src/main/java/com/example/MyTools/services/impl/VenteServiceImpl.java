package com.example.MyTools.services.impl;

import com.example.MyTools.model.Vente;
import com.example.MyTools.repository.VenteRepository;
import com.example.MyTools.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VenteServiceImpl implements VenteService {
    @Autowired
    VenteRepository venteRepository;

    @Override
    public Vente ajouterVente(Vente vente) {
        return this.venteRepository.save(vente);
    }

    @Override
    public List<Vente> listerVente() {
        return this.venteRepository.findAll();
    }

    @Override
    public String supprimerVente(Integer id) {
        this.venteRepository.deleteById(id);
        return "Supprimer avec success";
    }

    @Override
    public Vente afficherVenteById(Integer id) {
        return this.venteRepository.findById(id).get();
    }
}
