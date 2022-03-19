package com.example.MyTools.controller;

import com.example.MyTools.model.Accessoires;
import com.example.MyTools.model.Appareil;
import com.example.MyTools.model.Services;
import com.example.MyTools.services.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mytools/service")
@CrossOrigin("*")
public class ServicesController {
    @Autowired
    ServicesService servicesService;

    @PostMapping("/ajouter/{id}")
    public Services ajoutServices (@RequestBody Services services, @PathVariable Integer id){
        return this.servicesService.ajoutServices(services, id);
    }
    @PutMapping("/Ajoutphoto/{id}")
    @ResponseBody
    public Services ajoutePhoto(@PathVariable Integer id, @RequestParam("file") MultipartFile file)
            throws IOException {
        return this.servicesService.ajoutePhoto(id, file);
    }
    @GetMapping("/lister")
    public List<Services> afficherListServices() {
        return  this.servicesService.afficherListServices();
    }
    @GetMapping("/{id}")
    public Services afficherById(@PathVariable("id") Integer id){
        return  this.servicesService.afficherById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierServices (@RequestBody Services services, @PathVariable("id") Integer id){
        this.servicesService.modifierServices(services, id);
        return "Mise à Jours effectuer avec success";
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerById(@PathVariable("id") Integer id){
        this.servicesService.supprimerById(id);
        return "Supprimer avec Success";
    }

}
