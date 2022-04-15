package com.example.MyTools.controller;

import com.example.MyTools.model.Client;
import com.example.MyTools.model.Commandes;
import com.example.MyTools.services.CommandesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytools/commande")
@CrossOrigin("*")

public class CommandeController {

    @Autowired
    CommandesServices commandesServices;

    @PostMapping("/ajouter")
    public Commandes ajouterCommande(@RequestBody Commandes commandes){
        return this.commandesServices.ajouterCommandes(commandes);
    }

    @GetMapping("/lister")
    public List<Commandes> listeCommande(){
        return this.commandesServices.ListCommandes();
    }

    @GetMapping("/commandeClient/{id}")
    public List<Commandes>CommandeClient(@PathVariable("id")Client app){
        return this.commandesServices.commandeClient(app);
    }
    @GetMapping("/{id}")
    public Commandes afficherCommandeById(@PathVariable("id") Integer id){
        return this.commandesServices.afficherCommandeById(id);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerCommande(@PathVariable("id") Integer id){
        return this.commandesServices.supprimerCommande(id);
    }

}
