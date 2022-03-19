package com.example.MyTools.services;

import com.example.MyTools.model.Atelier;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AtelierService {
    Atelier ajouterAtelier(Atelier atelier);
    Atelier ajoutePhoto(Integer id, MultipartFile file) throws IOException;
    List<Atelier> listeAtelier();
    String supprimerAtelier(Integer id);
    void modifierAtelier(Atelier atelier, Integer id);
    Atelier afficherAtelierById(Integer id);
    Atelier connexion(String email, String password);
    byte[] recupPhoto(Integer id) throws IOException;

}
