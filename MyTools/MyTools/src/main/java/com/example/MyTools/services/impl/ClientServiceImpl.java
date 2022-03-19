package com.example.MyTools.services.impl;

import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Client;
import com.example.MyTools.model.Professionnel;
import com.example.MyTools.repository.AtelierRepository;
import com.example.MyTools.repository.ClientRepository;
import com.example.MyTools.repository.ProfessionnelRepository;
import com.example.MyTools.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    public ClientServiceImpl() {
        super();
    }

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AtelierRepository atelierRepository;
    @Autowired
    ProfessionnelRepository professionnelRepository;

    @Override
    public String ajouterClient(Client client) {
        Optional<Atelier> atelier = atelierRepository.findByEmail(client.getEmail());
        Optional<Client> client1 = clientRepository.findByEmail(client.getEmail());
        Optional<Professionnel> professionnel = professionnelRepository.findByEmail(client.getEmail());
        if (client1.isPresent()){
            return null;
        }
        if (atelier.isPresent()){
            return null;
        }
        if (professionnel.isPresent()){
            return null;
        }
        this.clientRepository.save(client);
        return "Client Ajouter";
    }

    @Override
    public List<Client> listeClient() {
        return this.clientRepository.findAll();
    }

    @Override
    public void modifierClient(Client client, Integer id) {
        Client clientExistant = this.clientRepository.findById(id).orElseThrow();
        clientExistant.setNom(client.getNom());
        clientExistant.setEtat(client.getEtat());
        clientExistant.setAppareil(client.getAppareil());
        clientExistant.setAdresse(client.getAdresse());
        clientExistant.setContacts(client.getContacts());
        clientExistant.setEmail(client.getEmail());
        clientExistant.setGenre(client.getGenre());
        clientExistant.setPrenom(client.getPrenom());
        clientExistant.setServiceSollicite(client.getServiceSollicite());
        clientExistant.setTypeAppareil(client.getTypeAppareil());
    }

    @Override
    public Client afficherClientById(Integer id) {
        return this.clientRepository.findById(id).get();
    }

    @Override
    public Client connexion(String email, String password) {
        Optional<Client> client = clientRepository.findByEmailAndPassword(email, password);
        if (client.isEmpty()){
            return null;
        }
        return client.get();
    }

    @Override
    public String supprimerClient(Integer id) {
        this.clientRepository.deleteById(id);
        return "Supprimer avec success";
    }
}
