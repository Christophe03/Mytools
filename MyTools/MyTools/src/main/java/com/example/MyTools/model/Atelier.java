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
public class Atelier extends AbstractEntity{

    private String nomAtelier;

    private String nom;

    private String prenom;
    @Column
    private Adresse adresse;
    @Column(unique = true)
    private String contacts;
    @Column(unique = true)
    private String email;

    private String domaineActivite;

    private String password;
    @Enumerated (EnumType.STRING)
    private Profils profils = Profils.GERANT;

    private String photo;

    private String genre;
    @Enumerated (EnumType.STRING)
    private etat Etat = etat.ACTIVER;
    @ManyToOne
    private Professionnel professionnel;
    @OneToOne
    private SuperAdmin superAdmin;
    @OneToMany
    private List<Appareil> appareils;
    @OneToMany
    private List<Accessoires> accessoires;

    @OneToMany
    private List<Notification> notifications;


    public Atelier(String nomAtelier, String nom, String prenom, Adresse adresse, String contacts, String email, String domaineActivite, String password, Profils profils, String photo, String genre, etat etat) {
        this.nomAtelier = nomAtelier;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.contacts = contacts;
        this.email = email;
        this.domaineActivite = domaineActivite;
        this.password = password;
        this.profils = profils;
        this.photo = photo;
        this.genre = genre;
        Etat = etat;
    }

    public String getNomAtelier() {
        return nomAtelier;
    }

    public void setNomAtelier(String nomAtelier) {
        this.nomAtelier = nomAtelier;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getDomaineActivite() {
        return domaineActivite;
    }

    public void setDomaineActivite(String domaineActivite) {
        this.domaineActivite = domaineActivite;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profils getProfils() {
        return profils;
    }

    public void setProfils(Profils profils) {
        this.profils = profils;
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

    public Professionnel getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnel professionnel) {
        this.professionnel = professionnel;
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Appareil> getAppareils() {
        return appareils;
    }

    public void setAppareils(List<Appareil> appareils) {
        this.appareils = appareils;
    }

    public List<Accessoires> getAccessoires() {
        return accessoires;
    }

    public void setAccessoires(List<Accessoires> accessoires) {
        this.accessoires = accessoires;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
