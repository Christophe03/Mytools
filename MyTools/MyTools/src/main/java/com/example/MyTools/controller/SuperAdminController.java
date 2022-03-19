package com.example.MyTools.controller;

import com.example.MyTools.model.SuperAdmin;
import com.example.MyTools.services.SuperAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytools/superAdmin")
@CrossOrigin("*")
public class SuperAdminController {
    @Autowired
    SuperAdminService superAdminService;

    @PostMapping("/ajouter")
    public String ajouterSuperAdmin(@RequestBody SuperAdmin superAdmin){
        this.superAdminService.ajouterSuperAdmin(superAdmin);
        return "Accessoire Ajouter avec success";
    }
    @GetMapping("/lister")
    public List<SuperAdmin> listerpersonne() {
        return  this.superAdminService.listerpersonne();
    }

    @GetMapping("/{id}")
    public SuperAdmin afficherSuperAdminById(@PathVariable("id") Integer id){
        return  this.superAdminService.afficherSuperAdminById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierSuperAdmin(@RequestBody SuperAdmin superAdmin, @PathVariable("id") Integer id){
        this.superAdminService.modifierSuperAdmin(superAdmin, id);
        return "Mise à Jours effectuer avec success";
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerSuperAdmin(@PathVariable("id") Integer id){
        this.superAdminService.supprimerSuperAdmin(id);
        return "Effacer avec Success";
    }
    @GetMapping("/connexion/{email}&{password}")
    public SuperAdmin connexion(@PathVariable("email") String email, @PathVariable("password") String password){
        return superAdminService.connexion(email,password);
    }
}
