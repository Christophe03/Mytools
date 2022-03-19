package com.example.MyTools.controller;

import com.example.MyTools.model.Client;
import com.example.MyTools.model.Professionnel;
import com.example.MyTools.services.ClientService;
import com.example.MyTools.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/mytools/client")
@CrossOrigin("*")
public class ClientController {
    @Autowired
    ClientService clientService;


    @PostMapping("/ajouter")
    public String ajouterClient (@RequestBody Client client){
        return this.clientService.ajouterClient(client);
    }
    @GetMapping("/lister")
    public List<Client> listeClient() {
        return  this.clientService.listeClient();
    }

    @GetMapping("/{id}")
    public Client afficherClientById(@PathVariable("id") Integer id){
        return  this.clientService.afficherClientById(id);
    }
    @PutMapping("/modifier/{id}")
    public String modifierClient(@RequestBody Client client, @PathVariable("id") Integer id){
        this.clientService.modifierClient(client, id);
        return "Mise à Jours effectuer avec success";
    }
    @DeleteMapping("/supprimer/{id}")
    public String supprimerClient(@PathVariable("id") Integer id){
       return this.clientService.supprimerClient(id);
    }

    @GetMapping("/connexion/{email}&{password}")
    public Client connexion(@PathVariable("email") String email, @PathVariable("password") String password){
        return clientService.connexion(email,password);
    }

}
