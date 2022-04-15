package com.example.MyTools.services.impl;

import com.example.MyTools.model.*;
import com.example.MyTools.repository.AccessoiresRepository;
import com.example.MyTools.repository.AtelierRepository;
import com.example.MyTools.repository.ProfessionnelRepository;
import com.example.MyTools.services.AccessoiresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AccessoiresServiceImpl implements AccessoiresService {
    @Autowired
    AccessoiresRepository accessoiresRepository;
    @Autowired
    AtelierRepository atelierRepository;

    @Autowired
    ProfessionnelRepository professionnelRepository;

    @Override
    public Accessoires AjoutAccessoires(Accessoires accessoires, Profils profils, Integer id) {
        if (profils ==Profils.GERANT){
            Atelier atelier=atelierRepository.findById(id).get();
            accessoires.setAtelier(atelier);
        }
        if(profils ==Profils.TECHNICIEN){
            Professionnel professionnel=professionnelRepository.findById(id).get();
            accessoires.setProfessionnel(professionnel);
        }
        return this.accessoiresRepository.save(accessoires);
    }

    @Override
    public Accessoires ajoutePhoto(Integer id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Accessoires accessoires= accessoiresRepository.findById(id).get();
        accessoires.setPhoto(fileName);

        String uploadDir = "src/main/resources/images/accessoires/"+accessoires.getId();
        Photo.saveFile(uploadDir, fileName, file);
        this.accessoiresRepository.save(accessoires);
        return accessoires;
    }

    @Override
    public List<Accessoires> ListeAccessoires() {
        return this.accessoiresRepository.findAll();
    }

    @Override
    @Transactional
    public void modifierAccoires(Accessoires accessoires, Integer idAccessoires) {
        Accessoires accessoireExistant = this.accessoiresRepository.findById(idAccessoires).orElseThrow();
        accessoireExistant.setNom(accessoires.getNom());
        accessoireExistant.setEtat(accessoires.getEtat());
        accessoireExistant.setPhoto(accessoires.getPhoto());
        accessoireExistant.setPrix(accessoires.getPrix());
    }

    @Override
    public String supprimerAccessoires(Integer id) {
        this.accessoiresRepository.deleteById(id);
        return "Supprimer avec success";
    }

    @Override
    public Accessoires afficherAccrssoiresById(Integer id) {
        return this.accessoiresRepository.findById(id).get();
    }

    @Override
    public byte[] recupPhoto(Integer id) throws IllegalStateException,IOException {
        Accessoires artcl = accessoiresRepository.findById(id).get();
        String AccessoiresPhoto =artcl.getPhoto();
        File file = new File("src/main/resources/images/accessoires/"+artcl.getId()+"/"+AccessoiresPhoto);
        Path path = Paths.get(file.toURI());
        return  Files.readAllBytes(path);
    }

    @Override
    public List<Accessoires> accessoiresType(String acce) {
        return this.accessoiresRepository.findByProduits(acce);
    }

    @Override
    public List<Accessoires> accessoireAteler(Atelier app) {
        return this.accessoiresRepository.findAllByAtelier(app);
    }

    @Override
    public List<Accessoires> listeCobeille() {
        return this.accessoiresRepository.findByEtat(Etat.DESACTIVER);
    }

    @Override
    public void supprimer(Integer id) {
        Accessoires accessoires = accessoiresRepository.findById(id).get();
        accessoires.setEtat(Etat.DESACTIVER);
        accessoiresRepository.save(accessoires);

    }

    @Override
    public void restore(Integer id) {
        Accessoires accessoires = accessoiresRepository.findById(id).get();
        accessoires.setEtat(Etat.ACTIVER);
        accessoiresRepository.save(accessoires);
    }
}
