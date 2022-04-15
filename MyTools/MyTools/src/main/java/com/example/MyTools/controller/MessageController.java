package com.example.MyTools.controller;

import com.example.MyTools.model.Messages;
import com.example.MyTools.model.Notification;
import com.example.MyTools.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mytools/messages")
@CrossOrigin("*")
public class MessageController {

    @Autowired
    MessagesService messagesService;

    @PostMapping("/ajouter")
    public Messages ajoutNotification(@RequestBody Messages messages){
        return this.messagesService.ajouteM(messages);
    }

    @GetMapping("/liste")
    public List<Messages> listeNotification(){
        return this.messagesService.ListeM();
    }

    @GetMapping("/{id}")
    public Messages afficherId(@PathVariable("id") Integer id){
        return this.messagesService.afficherparId(id);
    }
    @PutMapping("/notification/{idNote}&{id}")
    public String notification(@PathVariable("idNote") Integer idNote, @PathVariable("id") Integer id){
        this.messagesService.modifierM(id, idNote);
        return "mise à jour";
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimerNotification(@PathVariable("id") Integer id){
        this.messagesService.supprimerM(id);
        return "Supprimer avec success";
    }
}
