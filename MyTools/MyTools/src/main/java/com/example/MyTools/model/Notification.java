package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Notification{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date = LocalDate.now();

    private String vue;

    @Enumerated(EnumType.STRING)
    private vueService vueService;

    @OneToOne
    private Services services;

    @OneToOne
    private Atelier atelier;

    @OneToOne
    private Client client;

    @Enumerated(EnumType.STRING)
    private etat Etat = etat.ACTIVER;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Notification(LocalDate date, String vue, com.example.MyTools.model.vueService vueService, etat etat) {
        this.date = date;
        this.vue = vue;
        this.vueService = vueService;
        Etat = etat;
    }

    public String getVue() {
        return vue;
    }

    public void setVue(String vue) {
        this.vue = vue;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
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

    public etat getEtat() {
        return Etat;
    }

    public void setEtat(etat etat) {
        Etat = etat;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public com.example.MyTools.model.vueService getVueService() {
        return vueService;
    }

    public void setVueService(com.example.MyTools.model.vueService vueService) {
        this.vueService = vueService;
    }
}
