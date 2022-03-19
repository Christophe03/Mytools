package com.example.MyTools.controller;

import com.example.MyTools.model.Vente;
import com.example.MyTools.services.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytools/vente")
@CrossOrigin("*")
public class VenteController {
    @Autowired
    VenteService venteService;

    @PostMapping("/ajouter")
    public String ajoutVente (@RequestBody Vente vente){
        this.venteService.ajouterVente(vente);
        return "Accessoire Ajouter avec success";
    }
    @GetMapping("/lister")
    public List<Vente> ListeVentes() {
        return  this.venteService.listerVente();
    }

    @GetMapping("/{id}")
    public Vente afficherVenteById(@PathVariable("id") Integer id){
        return  this.venteService.afficherVenteById(id);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerVente(@PathVariable("id") Integer id){
        this.venteService.supprimerVente(id);
        return "Effacer avec Success";
    }
}
