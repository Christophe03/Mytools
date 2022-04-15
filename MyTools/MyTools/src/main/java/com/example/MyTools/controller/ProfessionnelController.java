package com.example.MyTools.controller;

import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Professionnel;
import com.example.MyTools.services.ProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytools/professionnel")
@CrossOrigin("*")
public class ProfessionnelController {
    @Autowired
    ProfessionnelService professionnelService;
    @PostMapping("/ajouter/{id}")
    public String ajouterPersonne (@RequestBody Professionnel professionnel, @PathVariable Integer id){
        this.professionnelService.ajouterPersonne(professionnel, id);
        return "Ajouter avec success";
    }

    @GetMapping("/professionnel/{id}")
    public List<Professionnel>professionnelAtelier(@PathVariable("id")Atelier app){
        return this.professionnelService.professionnelAteler(app);
    }
    @GetMapping("/lister")
    public List<Professionnel> afficherListPersonne() {
        return  this.professionnelService.afficherListPersonne();
    }
    @GetMapping("/{id}")
    public Professionnel afficherPersonneById(@PathVariable("id") Integer id){
        return  this.professionnelService.afficherPersonneById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierPersonne (@RequestBody Professionnel professionnel, @PathVariable("id") Integer id){
        this.professionnelService.modifierPersonne(professionnel,id);
        return "Mise à Jours effectuer avec success";
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerAccessoires(@PathVariable("id") Integer id){
        this.professionnelService.supprimerPersonne(id);
        return "Supprimer avec Success";
    }

    @GetMapping("/connexion/{email}&{password}")
    public Professionnel connexion(@PathVariable("email") String email, @PathVariable("password") String password){
        return professionnelService.connexion(email,password);
    }

}
