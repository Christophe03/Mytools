package com.example.MyTools.services;

import com.example.MyTools.model.Appareil;
import com.example.MyTools.model.Services;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ServicesService {
    Services ajoutServices(Services services, Integer id);
    Services ajoutePhoto(Integer id, MultipartFile file) throws IOException;
    List<Services> afficherListServices();
    void modifierServices(Services services, Integer id);
    Services afficherById(Integer id);
    String supprimerById(Integer id);
    byte[] recupPhoto(Integer id) throws IOException;
}
