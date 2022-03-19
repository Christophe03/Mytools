package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class SuperAdmin extends AbstractEntity{

    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String genre;
    @Column(nullable = false, unique = true)
    private Integer contact;

    @ManyToOne
    @JoinColumn(name = "idAtilier")
    private Atelier atelier;

    @ManyToOne
    @JoinColumn(name = "idPersonne")
    private Professionnel professionnel;

    public SuperAdmin(String nom, String prenom, String email, String password, String genre, Integer contact) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.genre = genre;
        this.contact = contact;
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

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public Professionnel getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnel professionnel) {
        this.professionnel = professionnel;
    }
}
