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
public class Professionnel extends AbstractEntity{

    private String nom;

    private String prenom;
    @Column(unique = true)
    private String contact;
    @Column(unique = true)
    private String email;

    private String domaineActivite;

    private String password;
    @Column
    private Adresse adresse;

    private String genre;

    @Enumerated (EnumType.STRING)
    private Profils profils = Profils.TECHNICIEN;

    @Enumerated (EnumType.STRING)
    private etat Etat = etat.ACTIVER;


    @OneToMany
    private List <Action> action;

    @OneToOne
    private  Atelier atelier;

    @OneToOne
    private SuperAdmin superAdmin;

    @OneToMany
    private List<RendezVous> rendezVous;


    public Professionnel(String nom, String prenom, String contact, String email, String domaineActivite, String password, Adresse adresse, String genre, Profils profils, etat etat) {
        this.nom = nom;
        this.prenom = prenom;
        this.contact = contact;
        this.email = email;
        this.domaineActivite = domaineActivite;
        this.password = password;
        this.adresse = adresse;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Profils getProfils() {
        return profils;
    }

    public void setProfils(Profils profils) {
        this.profils = profils;
    }

    public etat getEtat() {
        return Etat;
    }

    public void setEtat(etat etat) {
        Etat = etat;
    }

    public List<Action> getAction() {
        return action;
    }

    public void setAction(List<Action> action) {
        this.action = action;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public SuperAdmin getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(SuperAdmin superAdmin) {
        this.superAdmin = superAdmin;
    }

    public List<RendezVous> getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(List<RendezVous> rendezVous) {
        this.rendezVous = rendezVous;
    }
}
