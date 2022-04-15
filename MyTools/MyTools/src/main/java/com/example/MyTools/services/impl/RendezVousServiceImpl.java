package com.example.MyTools.services.impl;

import com.example.MyTools.model.*;
import com.example.MyTools.repository.*;
import com.example.MyTools.services.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
@Service
public class RendezVousServiceImpl implements RendezVousService {
    public RendezVousServiceImpl() {
        super();
    }

    @Autowired
    RendezVousRepository rendezVousRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    MessagesRepository messagesRepository;
    @Autowired
    AtelierRepository atelierRepository;
    @Autowired
    ProfessionnelRepository professionnelRepository;
    @Autowired
    ReparationRepository reparationRepository;
    @Autowired
    EmailServiceImpl emailService;

    @Transactional
    @Override
    public RendezVous ajouterRendezVous(RendezVous rendezVous, Integer id) {
        Atelier atelier =atelierRepository.findById(id).get();

        rendezVous.setAtelier(atelier);
        Messages messages = new Messages();
        messages.setRendezVous(rendezVous);
        messages.setEtat(Etat.ACTIVER);
        messagesRepository.save(messages);
        Reparation reparation = new Reparation();
        reparation.setDateCreation(LocalDate.now());
        reparation.setRendezVous(rendezVous);
        reparation.setEtat(Etat.ACTIVER);
        reparation.setAtelier(atelier);
        emailService.envoiEmail(rendezVous.getServices().getClient().getEmail(),
                "Date de votre Rendez-vous",
                "Bonjours "+rendezVous.getServices().getClient().getNom()+" "+rendezVous.getServices().getClient().getPrenom()+";\n"
                +"Suite à votre demande pour la réparation de votre "+rendezVous.getServices().getProduits()+" Vous avez Obtenu un Rendez-Vous avec l'atelier "+rendezVous.getAtelier().getNomAtelier()+"\n"
                +"Pour la date du "+rendezVous.getDateSaisi()+" à "+rendezVous.getHeureSaisi()+ "\n"
                +" le montant porposé par l'Altelier est de "+rendezVous.getMontant()+" FCFA"+"\n"
                +"MyTools vous souhaitez une bonne suite de journée.\n"
                +"Pour toutes recommandations ou plaintes pour vous pouvez nous contactes au numéros suivant:\n"+" 50 47 61 53 ");

        this.rendezVousRepository.save(rendezVous);
        this.reparationRepository.save(reparation);
        return null;
    }

    @Override
    public List<RendezVous> afficherRendezVous() {
        return this.rendezVousRepository.findAll();
    }

    @Override
    public String supprimer(Integer id) {
        this.rendezVousRepository.deleteById(id);
        return "Supprimer avec success";
    }

    @Override
    public void modifierRendezVous(RendezVous rendezVous, Integer id) {
        RendezVous rendezVousExistant = this.rendezVousRepository.findById(id).orElseThrow();
        rendezVousExistant.setDateSaisi(rendezVous.getDateSaisi());
        rendezVousExistant.setDateRendu(rendezVous.getDateRendu());
        rendezVousExistant.setMontant(rendezVous.getMontant());
    }

    @Override
    public RendezVous afficherRendezVousById(Integer id) {
        return this.rendezVousRepository.findById(id).get();
    }
}
