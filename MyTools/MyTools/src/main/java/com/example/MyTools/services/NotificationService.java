package com.example.MyTools.services;

import com.example.MyTools.model.Notification;

import java.time.LocalDate;
import java.util.List;

public interface NotificationService {
    Notification ajouterNotification(Notification notification);
    List<Notification> ListNotification();
    Notification afficherparId(Integer id);
    String supprimerNotification(Integer id);
    Notification modifierNotification(Integer id, Integer idNote);

}
