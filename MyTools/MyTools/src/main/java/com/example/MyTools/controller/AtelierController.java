package com.example.MyTools.controller;

import com.example.MyTools.model.Atelier;
import com.example.MyTools.services.AtelierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mytools/atelier")
@CrossOrigin("*")
public class AtelierController {

    @Autowired
    AtelierService atelierService;

    @PostMapping("/ajouter")
    public Atelier    ajouterAtelier(@RequestBody Atelier atelier){
        return this.atelierService.ajouterAtelier(atelier);
    }
    @PutMapping("/Ajoutphoto/{id}")
    @ResponseBody
    public Atelier ajoutePhoto(@PathVariable Integer id, @RequestParam("file") MultipartFile file)
            throws IOException {
        return this.atelierService.ajoutePhoto(id, file);
    }
    @GetMapping(value="/photo/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.ALL_VALUE})
    byte[] getPhoto(@PathVariable Integer id) throws IOException{
        return atelierService.recupPhoto(id);
    }
    @GetMapping("/lister")
    public List<Atelier> listeAtelier(){
        return this.atelierService.listeAtelier();
    }
    @GetMapping("/{id}")
    public Atelier afficherAtelierById(@PathVariable("id") Integer id){
        return this.atelierService.afficherAtelierById(id);
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerAtelier(@PathVariable("id") Integer id){
        return this.atelierService.supprimerAtelier(id);
    }
    @PutMapping("/modifier")
    public String modifierAtelier(@RequestBody Atelier atelier, @PathVariable("id") Integer id){
        this.atelierService.modifierAtelier(atelier, id);
        return "Modification effectuer";
    }
    @GetMapping("/connexion/{email}&{password}")
    public Atelier connexion(@PathVariable("email") String email, @PathVariable("password") String password){
        return atelierService.connexion(email, password);
    }
}
