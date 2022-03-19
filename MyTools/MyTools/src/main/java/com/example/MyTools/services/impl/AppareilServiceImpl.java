package com.example.MyTools.services.impl;

import com.example.MyTools.model.*;
import com.example.MyTools.repository.AppareilRepository;
import com.example.MyTools.repository.AtelierRepository;
import com.example.MyTools.repository.ProfessionnelRepository;
import com.example.MyTools.services.AppreilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AppareilServiceImpl implements AppreilService {

    @Autowired
    AppareilRepository appareilRepository;
    @Autowired
    AtelierRepository atelierRepository;
    @Autowired
    ProfessionnelRepository professionnelRepository;

    @Override
    public Appareil ajouterAppareil(Appareil appareil, Profils profils, Integer id) {

        if (profils == Profils.GERANT) {
            Atelier atelier=atelierRepository.findById(id).get();
            appareil.setAtelier(atelier);
        }

        if(profils == Profils.TECHNICIEN){
            Professionnel professionnel=professionnelRepository.findById(id).get();
            appareil.setProfessionnel(professionnel);
        }

        return this.appareilRepository.save(appareil);
    }

    @Override
    public Appareil ajoutePhoto(Integer id, MultipartFile file)
            throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Appareil appareil1= appareilRepository.findById(id).get();
        appareil1.setPhoto(fileName);

        String uploadDir = "src/main/resources/images/appareil/"+appareil1.getId();
        Photo.saveFile(uploadDir, fileName, file);
        this.appareilRepository.save(appareil1);
        return appareil1;
    }

    @Override
    public List<Appareil> listeAppareil() {
        return this.appareilRepository.findAll();
    }

    @Override
    public String supprimerAppareil(Integer id) {
        this.appareilRepository.deleteById(id);
        return "Appareil Supprimer avec success";
    }

    @Override
    public void modifierAppareil(Appareil appareil, Integer idAppareil) {
        Appareil appareilExistant = this.appareilRepository.findById(idAppareil).orElseThrow();
        appareilExistant.setNom(appareil.getNom());
        appareilExistant.setPrix(appareil.getPrix());
        appareilExistant.setCaracteristique(appareil.getCaracteristique());
        appareilExistant.setEtat(appareil.getEtat());
        appareilExistant.setPhoto(appareil.getPhoto());
        appareilExistant.setAccessoires(appareil.getAccessoires());
        appareilExistant.setProduits(appareil.getProduits());
    }

    @Override
    public Appareil afficherAppareilById(Integer id) {
        return this.appareilRepository.findById(id).get();
    }

    @Override
    public byte[] recupPhoto(Integer id) throws IllegalStateException, IOException{
        Appareil artcl = appareilRepository.findById(id).get();
        String AppareilPhoto =artcl.getPhoto();
        File file = new File("src/main/resources/images/appareil/"+artcl.getId()+"/"+AppareilPhoto);
        Path path = Paths.get(file.toURI());
        return  Files.readAllBytes(path);
    }

    @Override
    public List<Appareil> appareilType(Produits ord) {
        return this.appareilRepository.findByProduits(ord);
    }
}
