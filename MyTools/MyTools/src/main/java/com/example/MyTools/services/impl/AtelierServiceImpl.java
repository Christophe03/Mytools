package com.example.MyTools.services.impl;

import com.example.MyTools.model.*;
import com.example.MyTools.repository.AtelierRepository;
import com.example.MyTools.repository.ClientRepository;
import com.example.MyTools.repository.ProfessionnelRepository;
import com.example.MyTools.services.AtelierService;
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
import java.util.Optional;

@Service
public class AtelierServiceImpl implements AtelierService {
    public AtelierServiceImpl() {
        super();
    }

    @Autowired
    AtelierRepository atelierRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ProfessionnelRepository professionnelRepository;

    @Override
    public Atelier ajouterAtelier(Atelier atelier) {
        Optional<Atelier> atelier1= atelierRepository.findByEmail(atelier.getEmail());
        Optional<Client> client= clientRepository.findByEmail(atelier.getEmail());
        Optional<Professionnel> professionnel= professionnelRepository.findByEmail(atelier.getEmail());

        if (atelier1.isPresent()) {
            return null;
        }
        if (client.isPresent()){
            return null;
        }
        if (professionnel.isPresent()) {
            return null;
        }

        this.atelierRepository.save(atelier);
        return this.atelierRepository.save(atelier);
    }

    @Override
    public Atelier ajoutePhoto(Integer id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Atelier atelier= atelierRepository.findById(id).get();
        atelier.setPhoto(fileName);

        String uploadDir = "src/main/resources/images/atelier/"+atelier.getId();
        Photo.saveFile(uploadDir, fileName, file);
        this.atelierRepository.save(atelier);
        return atelier;
    }

    @Override
    public List<Atelier> listeAtelier() {
        return this.atelierRepository.findAll();
    }

    @Override
    public String supprimerAtelier(Integer id) {
        this.atelierRepository.deleteById(id);
        return "Atelier Supprimer";
    }
    @Override
    public void modifierAtelier(Atelier atelier, Integer id) {
        Atelier atelierExiste = this.atelierRepository.findById(id).orElseThrow();
        atelierExiste.setNom(atelier.getNom());
        atelierExiste.setAdresse(atelier.getAdresse());
        atelierExiste.setNomAtelier(atelier.getNomAtelier());
        atelierExiste.setContacts(atelier.getContacts());
        atelierExiste.setDomaineActivite(atelier.getDomaineActivite());
        atelierExiste.setGenre(atelier.getGenre());
        atelierExiste.setEtat(atelier.getEtat());
        atelierExiste.setDateModification(atelier.getDateModification());
        atelierExiste.setPassword(atelier.getPassword());
        atelierExiste.setPrenom(atelier.getPrenom());
    }

    @Override
    public Atelier afficherAtelierById(Integer id) {
        return atelierRepository.findById(id).get();
    }

    @Override
    public Atelier connexion(String email, String password) {
        Optional<Atelier> atelier = atelierRepository.findByEmailAndPassword(email, password);
        if (atelier.isEmpty()){
            return null;
        }
        return atelier.get();
    }

    @Override
    public byte[] recupPhoto(Integer id) throws IOException {
        Atelier artcl = atelierRepository.findById(id).get();
        String AtelierPhoto =artcl.getPhoto();
        File file = new File("src/main/resources/images/atelier/"+artcl.getId()+"/"+AtelierPhoto);
        Path path = Paths.get(file.toURI());
        return  Files.readAllBytes(path);
    }
}
