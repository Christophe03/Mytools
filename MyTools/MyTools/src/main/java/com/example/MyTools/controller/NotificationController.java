package com.example.MyTools.controller;

import com.example.MyTools.model.Notification;
import com.example.MyTools.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/mytools/notification")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @PostMapping("/ajouter")
    public Notification ajoutNotification(@RequestBody Notification notification){
        return this.notificationService.ajouterNotification(notification);
    }

    @GetMapping("/liste")
    public List<Notification> listeNotification(){
    return this.notificationService.ListNotification();
    }

    @GetMapping("/{id}")
    public Notification afficherId(@PathVariable("id") Integer id){
        return this.notificationService.afficherparId(id);
    }
    @PutMapping("/notification/{idNote}&{id}")
    public String notification(@PathVariable("idNote") Integer idNote, @PathVariable("id") Integer id){
        this.notificationService.modifierNotification(id, idNote);
        return "mise à jour";
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimerNotification(@PathVariable("id") Integer id){
        this.notificationService.supprimerNotification(id);
        return "Supprimer avec success";
    }
}
