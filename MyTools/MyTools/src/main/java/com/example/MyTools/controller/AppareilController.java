package com.example.MyTools.controller;

import com.example.MyTools.model.Appareil;
import com.example.MyTools.model.Photo;
import com.example.MyTools.model.Produits;
import com.example.MyTools.model.Profils;
import com.example.MyTools.services.AppreilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mytools/appareil")
@CrossOrigin("*")
public class AppareilController {
    @Autowired
    AppreilService appreilService;

    @PostMapping("/ajoute/{profils}/{id}")
    public Appareil ajouteAppareil(@RequestBody Appareil appareil, @PathVariable("profils") Profils profils, @PathVariable("id") Integer id){
        return this.appreilService.ajouterAppareil(appareil, profils, id);
    }

    @PutMapping("/Ajoutphoto/{id}")
    @ResponseBody
    public Appareil ajoutePhoto(@PathVariable Integer id, @RequestParam("file") MultipartFile file)
            throws IOException{
        return this.appreilService.ajoutePhoto(id, file);
    }
    @GetMapping("/lister")
    public List<Appareil> listeAppareil(){
        return this.appreilService.listeAppareil();
    }

    @GetMapping("ListeType/{ord}")
    public List<Appareil>appareilType(@PathVariable("ord") Produits ord){
        return this.appreilService.appareilType(ord);
    }

    @GetMapping(value="/photo/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.ALL_VALUE})
    byte[] getPhoto(@PathVariable Integer id) throws IOException{
        return appreilService.recupPhoto(id);
    }
    @GetMapping("/{id}")
    public Appareil afficherAppareilById(@PathVariable("id") Integer id){
        return this.appreilService.afficherAppareilById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierAppareil(@RequestBody Appareil appareil, @PathVariable("id") Integer id){
        this.appreilService.modifierAppareil(appareil, id);
        return "Mise de l'appareil Valider";
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerAppareil(@PathVariable("id") Integer id){
        this.appreilService.supprimerAppareil(id);
        return "Appareil Supprimer avec Success";
    }
}
