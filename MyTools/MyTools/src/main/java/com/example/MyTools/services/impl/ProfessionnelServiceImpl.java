package com.example.MyTools.services.impl;

import com.example.MyTools.model.Atelier;
import com.example.MyTools.model.Client;
import com.example.MyTools.model.Professionnel;
import com.example.MyTools.repository.AtelierRepository;
import com.example.MyTools.repository.ClientRepository;
import com.example.MyTools.repository.ProfessionnelRepository;
import com.example.MyTools.services.ProfessionnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessionnelServiceImpl implements ProfessionnelService {

    @Autowired
    ProfessionnelRepository professionnelRepository;
    @Autowired
    AtelierRepository atelierRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Professionnel ajouterPersonne(Professionnel professionnel, Integer id) {
        Atelier atelier1=atelierRepository.findById(id).get();
        professionnel.setAtelier(atelier1);
        Optional<Atelier> atelier = atelierRepository.findByEmail(professionnel.getEmail());
        Optional<Client> client = clientRepository.findByEmail(professionnel.getEmail());
        Optional<Professionnel> professionnel1 = professionnelRepository.findByEmail(professionnel.getEmail());

        if (client.isPresent()){
            return null;
        }
        if (atelier.isPresent()){
            return null;
        }
        if (professionnel1.isPresent()){
            return null;
        }
        return this.professionnelRepository.save(professionnel);
    }

    @Override
    public List<Professionnel> afficherListPersonne() {
        return this.professionnelRepository.findAll();
    }

    @Override
    public String supprimerPersonne(Integer id) {
        this.professionnelRepository.deleteById(id);
        return "Supprimer avec success";
    }

    @Override
    public void modifierPersonne(Professionnel professionnel, Integer id) {
        Professionnel professionnelExistant = this.professionnelRepository.findById(id).orElseThrow();
        professionnelExistant.setNom(professionnelExistant.getNom());
        professionnelExistant.setPrenom(professionnelExistant.getPrenom());
        professionnelExistant.setDomaineActivite(professionnelExistant.getDomaineActivite());
        professionnelExistant.setContact(professionnelExistant.getContact());
        professionnelExistant.setPassword(professionnelExistant.getPassword());
        professionnelExistant.setEmail(professionnelExistant.getEmail());
        professionnelExistant.setAdresse(professionnelExistant.getAdresse());
        professionnelExistant.setGenre(professionnelExistant.getGenre());
        professionnelExistant.setDateModification(LocalDate.now());
    }

    @Override
    public Professionnel afficherPersonneById(Integer id) {
        return this.professionnelRepository.findById(id).get();
    }

    @Override
    public Professionnel connexion(String email, String password) {
        Optional<Professionnel> personne = professionnelRepository.findByEmailAndPassword(email,password);
        if (personne.isEmpty()){
            return null;
        }
        return personne.get();
    }

    @Override
    public List<Professionnel> professionnelAteler(Atelier app) {
        return this.professionnelRepository.findAllByAtelier(app);
    }
}
