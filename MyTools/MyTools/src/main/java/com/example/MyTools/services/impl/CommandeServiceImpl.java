package com.example.MyTools.services.impl;

import com.example.MyTools.model.Client;
import com.example.MyTools.model.Commandes;
import com.example.MyTools.repository.CommandesRepository;
import com.example.MyTools.services.CommandesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CommandeServiceImpl implements CommandesServices {
    @Autowired
    CommandesRepository commandesRepository;
    @Override
    public Commandes ajouterCommandes(Commandes commandes) {
        return this.commandesRepository.save(commandes);
    }

    @Override
    public List<Commandes> ListCommandes() {
        return this.commandesRepository.findAll();
    }

    @Override
    public String supprimerCommande(Integer id) {
        this.commandesRepository.deleteById(id);
        return "Commande Supprimer";
    }

    @Override
    public Commandes afficherCommandeById(Integer id) {
        return this.commandesRepository.findById(id).get();
    }

    @Override
    public List<Commandes> commandeClient(Client app) {
        return this.commandesRepository.findAllByClient(app);
    }
}
