package com.example.MyTools.services;

import com.example.MyTools.model.Appareil;
import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Client;
import com.example.MyTools.model.Commandes;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommandesServices {
    Commandes ajouterCommandes(Commandes commandes);
    List<Commandes> ListCommandes();
    String supprimerCommande(Integer id);
    Commandes afficherCommandeById(Integer id);
    List<Commandes> commandeClient(Client app);
}
