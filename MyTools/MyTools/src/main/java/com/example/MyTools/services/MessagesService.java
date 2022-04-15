package com.example.MyTools.services;


import com.example.MyTools.model.Messages;

import java.util.List;

public interface MessagesService {
    Messages ajouteM(Messages messages);
    List<Messages> ListeM();
    Messages afficherparId(Integer id);
    String supprimerM(Integer id);
    Messages modifierM(Integer id, Integer idNote);
}
