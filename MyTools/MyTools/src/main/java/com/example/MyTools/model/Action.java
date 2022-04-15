package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Action extends AbstractEntity{
    @ManyToOne
    private Professionnel professionnel;

    @ManyToOne
    private Atelier atelier;

    @ManyToOne
    private Client client;

    private  String action;


    private LocalTime heure = LocalTime.now();

    public Action(Professionnel professionnel, Atelier atelier, Client client, String action, LocalDate date, LocalTime heure) {
        this.professionnel = professionnel;
        this.atelier = atelier;
        this.client = client;
        this.action = action;

        this.heure = heure;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public Professionnel getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnel professionnel) {
        this.professionnel = professionnel;
    }
}
