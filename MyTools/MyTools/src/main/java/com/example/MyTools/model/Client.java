package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Client extends AbstractEntity{

    private String nom;

    private String prenom;

    private String contacts;
    @Column
    private Adresse adresse;

    private String typeAppareil;

    private String serviceSollicite;
    @Column(unique = true)
    private String email;

    private String password;

    private String genre;

    @Enumerated (EnumType.STRING)
    private Profils profils = Profils.CLIENT;
    @Enumerated (EnumType.STRING)
    private etat Etat = etat.ACTIVER;

    @OneToMany
    private List<Appareil> appareil;

    @OneToMany
    private List<Services> services;

    @OneToMany
    private List<RendezVous> rendezVous;




    public Client(String nom, String prenom, String contacts, Adresse adresse, String typeAppareil, String serviceSollicite, String email, String password, String genre, Profils profils, etat etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.contacts = contacts;
        this.adresse = adresse;
        this.typeAppareil = typeAppareil;
        this.serviceSollicite = serviceSollicite;
        this.email = email;
        this.password = password;
        this.genre = genre;
        this.profils = profils;
        Etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getTypeAppareil() {
        return typeAppareil;
    }

    public void setTypeAppareil(String typeAppareil) {
        this.typeAppareil = typeAppareil;
    }

    public String getServiceSollicite() {
        return serviceSollicite;
    }

    public void setServiceSollicite(String serviceSollicite) {
        this.serviceSollicite = serviceSollicite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    public etat getEtat() {
        return Etat;
    }

    public void setEtat(etat etat) {
        Etat = etat;
    }

    public List<Appareil> getAppareil() {
        return appareil;
    }

    public void setAppareil(List<Appareil> appareil) {
        this.appareil = appareil;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public Profils getProfils() {
        return profils;
    }

    public void setProfils(Profils profils) {
        this.profils = profils;
    }
}
