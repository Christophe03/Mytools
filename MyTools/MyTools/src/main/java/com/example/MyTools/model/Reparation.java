package com.example.MyTools.model;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Reparation extends AbstractEntity{

    private String nom;

    private LocalDate dateDepot;

    private LocalDate dateRendu;

    @OneToOne
    private Services services;

    @Enumerated(EnumType.STRING)
    private com.example.MyTools.model.Etat Etat = com.example.MyTools.model.Etat.ACTIVER;

    @OneToOne
    private RendezVous rendezVous;

    @OneToOne
    private  Atelier atelier;

    @OneToOne
    private Professionnel professionnel;

    public Reparation(String nom, LocalDate dateDepot, LocalDate dateRendu, Services services, RendezVous rendezVous, Atelier atelier, Professionnel professionnel) {
        this.nom = nom;
        this.dateDepot = dateDepot;
        this.dateRendu = dateRendu;
        this.services = services;
        this.rendezVous = rendezVous;
        this.atelier = atelier;
        this.professionnel = professionnel;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }

    public LocalDate getDateRendu() {
        return dateRendu;
    }

    public void setDateRendu(LocalDate dateRendu) {
        this.dateRendu = dateRendu;
    }

    public com.example.MyTools.model.Etat getEtat() {
        return Etat;
    }

    public void setEtat(com.example.MyTools.model.Etat etat) {
        Etat = etat;
    }
}
