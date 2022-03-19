package com.example.MyTools.services;

import com.example.MyTools.model.Appareil;
import com.example.MyTools.model.Produits;
import com.example.MyTools.model.Profils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AppreilService {
    Appareil ajouterAppareil(Appareil appareil, Profils profils, Integer id);
    Appareil ajoutePhoto(Integer id, MultipartFile file) throws IOException;
    List<Appareil> listeAppareil();
    String supprimerAppareil(Integer id);
    void modifierAppareil(Appareil appareil, Integer idAppareil);
    Appareil afficherAppareilById(Integer id);
    byte[] recupPhoto(Integer id) throws IOException;
    List<Appareil> appareilType(Produits ord);
}
