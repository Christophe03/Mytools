package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class RendezVous extends AbstractEntity{

    private LocalDate DateSaisi;
    private LocalTime HeureSaisi;
    private LocalDate DateRendu;
    private LocalTime HeureRendu;


    private BigDecimal montant;

    @ManyToOne
    private Professionnel professionnel;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Atelier atelier;

    @OneToOne
    private Services services;

    public RendezVous(LocalDate dateSaisi, LocalTime heureSaisi, LocalDate dateRendu, LocalTime heureRendu, BigDecimal montant) {
        DateSaisi = dateSaisi;
        HeureSaisi = heureSaisi;
        DateRendu = dateRendu;
        HeureRendu = heureRendu;
        this.montant = montant;
    }

    public LocalDate getDateSaisi() {
        return DateSaisi;
    }

    public void setDateSaisi(LocalDate dateSaisi) {
        DateSaisi = dateSaisi;
    }

    public LocalDate getDateRendu() {
        return DateRendu;
    }

    public void setDateRendu(LocalDate dateRendu) {
        DateRendu = dateRendu;
    }

    public LocalTime getHeureSaisi() {
        return HeureSaisi;
    }

    public void setHeureSaisi(LocalTime heureSaisi) {
        HeureSaisi = heureSaisi;
    }

    public LocalTime getHeureRendu() {
        return HeureRendu;
    }

    public void setHeureRendu(LocalTime heureRendu) {
        HeureRendu = heureRendu;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Professionnel getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnel professionnel) {
        this.professionnel = professionnel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
