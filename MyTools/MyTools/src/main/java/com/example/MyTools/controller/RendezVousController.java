package com.example.MyTools.controller;

import com.example.MyTools.model.Accessoires;
import com.example.MyTools.model.RendezVous;
import com.example.MyTools.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytools/rendezVous")
@CrossOrigin("*")
public class RendezVousController {

    @Autowired
    RendezVousService rendezVousService;

    @PostMapping("/ajouter")
    public String ajouterRendezVous(@RequestBody RendezVous rendezVous) {
        this.rendezVousService.ajouterRendezVous(rendezVous);
        return "Prise de rendez-vous effectuer";
    }

    @GetMapping("/lister")
    public List<RendezVous> afficherRendezVous() {
        return  this.rendezVousService.afficherRendezVous();
    }
    @GetMapping("/{id}")
    public RendezVous afficherAccrssoiresById(@PathVariable("id") Integer id){
        return  this.rendezVousService.afficherRendezVousById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierAccoires (@RequestBody RendezVous rendezVous, @PathVariable("id") Integer id){
        this.rendezVousService.modifierRendezVous(rendezVous, id);
        return "Mise à Jours effectuer avec success";
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable("id") Integer id){
        this.rendezVousService.supprimer(id);
        return "Effacer avec Success";
    }
}