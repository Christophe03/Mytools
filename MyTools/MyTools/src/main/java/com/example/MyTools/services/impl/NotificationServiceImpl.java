package com.example.MyTools.services.impl;

import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Notification;
import com.example.MyTools.repository.AtelierRepository;
import com.example.MyTools.repository.NotificationRepository;
import com.example.MyTools.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    AtelierRepository atelierRepository;

    @Override
    public Notification ajouterNotification(Notification notification) {
        return null;
    }

    @Override
    public List<Notification> ListNotification() {
        return this.notificationRepository.findAll();
    }

    @Override
    public Notification afficherparId(Integer id) {
        return this.notificationRepository.findById(id).get();
    }

    @Override
    public String supprimerNotification(Integer id) {
        this.notificationRepository.deleteById(id);
        return "Supprimer avec Success";
    }

    @Override
    public Notification modifierNotification(Integer idNote, Integer id) {
        Atelier atelier = atelierRepository.findById(id).get();
        Notification notification1= notificationRepository.findById(idNote).get();
        notification1.setAtelier(atelier);
        notification1.setDate(LocalDate.now());
        return this.notificationRepository.save(notification1);

    }
}
