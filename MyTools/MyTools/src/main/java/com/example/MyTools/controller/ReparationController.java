package com.example.MyTools.controller;

import com.example.MyTools.model.Accessoires;
import com.example.MyTools.model.Reparation;
import com.example.MyTools.services.ReparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytools/reparation")
@CrossOrigin("*")
public class ReparationController {
    @Autowired
    ReparationService reparationService;
    @PostMapping("/ajouter")
    public String ajoutAccessoires (@RequestBody Reparation reparation){
        this.reparationService.ajoutReparation(reparation);
        return "Accessoire Ajouter avec success";
    }
    @GetMapping("/lister")
    public List<Reparation> ListeAccessoires() {
        return  this.reparationService.afficherListReparation();
    }
    @GetMapping("/{id}")
    public Reparation afficherById(@PathVariable("id") Integer id){
        return  this.reparationService.afficherById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierAccoires (@RequestBody Reparation reparation, @PathVariable("id") Integer id){
        this.reparationService.modifierReparation(reparation, id);
        return "Mise à Jours effectuer avec success";
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable("id") Integer id){
        this.reparationService.supprimer(id);
        return "Effacer avec Success";
    }

}
