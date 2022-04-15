package com.example.MyTools.services.impl;

import com.example.MyTools.model.*;
import com.example.MyTools.repository.AtelierRepository;
import com.example.MyTools.repository.ClientRepository;
import com.example.MyTools.repository.MessagesRepository;
import com.example.MyTools.services.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class MessagesServiceImpl implements MessagesService {
    @Autowired
    MessagesRepository messagesRepository;

    @Autowired
    AtelierRepository atelierRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Messages ajouteM(Messages messages) {
        return null;
    }

    @Override
    public List<Messages> ListeM() {
        return this.messagesRepository.findAll();
    }

    @Override
    public Messages afficherparId(Integer id) {
        return this.messagesRepository.findById(id).get();
    }

    @Override
    public String supprimerM(Integer id) {
        this.messagesRepository.deleteById(id);
        return "Supprimer avec Success";
    }

    @Override
    public Messages modifierM(Integer id, Integer idNote) {
        Client client = clientRepository.findById(id).get();
        Messages messages = messagesRepository.findById(idNote).get();
        messages.setClient(client);
        messages.setDate(LocalDate.now());
        return this.messagesRepository.save(messages);
    }
}
