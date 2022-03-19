package com.example.MyTools.controller;

import com.example.MyTools.model.Accessoires;
import com.example.MyTools.model.Appareil;
import com.example.MyTools.model.Profils;
import com.example.MyTools.services.AccessoiresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/mytools/accessoire")
@CrossOrigin("*")
public class AccessoiresController {
    @Autowired
    AccessoiresService accessoiresService;
    @PostMapping("/ajouter/{profils}/{id}")
    @ResponseBody
    public Accessoires ajoutAccessoires(@RequestBody Accessoires accessoires, @PathVariable("profils") Profils profils, @PathVariable Integer id){
        return this.accessoiresService.AjoutAccessoires(accessoires,profils, id);
    }
    @PutMapping("/Ajoutphoto/{id}")
    @ResponseBody
    public Accessoires ajoutePhoto(@PathVariable Integer id, @RequestParam("file") MultipartFile file)
            throws IOException {
        return this.accessoiresService.ajoutePhoto(id, file);
    }
    @GetMapping(value="/photo/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.ALL_VALUE})
    byte[] getPhoto(@PathVariable Integer id) throws IOException{
        return accessoiresService.recupPhoto(id);
    }

    @GetMapping("/lister")
    public List<Accessoires> ListeAccessoires() {
        return  this.accessoiresService.ListeAccessoires();
    }
    @GetMapping("AccessoireTYpe/{acce}")
    public List<Accessoires>accessoiresType(@PathVariable("acce") String acce){
        return this.accessoiresService.accessoiresType(acce);
    }

    @GetMapping("/{id}")
    public Accessoires afficherAccrssoiresById(@PathVariable("id") Integer id){
        return  this.accessoiresService.afficherAccrssoiresById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierAccoires (@RequestBody Accessoires accessoires, @PathVariable("id") Integer id){
        this.accessoiresService.modifierAccoires(accessoires, id);
        return "Mise à Jours effectuer avec success";
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerAccessoires(@PathVariable("id") Integer id){
        this.accessoiresService.supprimerAccessoires(id);
        return "Effacer avec Success";
    }

}
