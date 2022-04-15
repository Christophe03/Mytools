package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Messages{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    private RendezVous rendezVous;

    @OneToOne
    private Professionnel professionnel;

    @Enumerated(EnumType.STRING)
    private com.example.MyTools.model.Etat Etat = com.example.MyTools.model.Etat.ACTIVER;

    public Messages(Integer id, LocalDate date, String vue, com.example.MyTools.model.vueService vueService, com.example.MyTools.model.Etat etat) {
        this.id = id;
        this.date = date;
        this.vue = vue;
        this.vueService = vueService;
        Etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVue() {
        return vue;
    }

    public void setVue(String vue) {
        this.vue = vue;
    }

    public com.example.MyTools.model.vueService getVueService() {
        return vueService;
    }

    public void setVueService(com.example.MyTools.model.vueService vueService) {
        this.vueService = vueService;
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

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }

    public Professionnel getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnel professionnel) {
        this.professionnel = professionnel;
    }

    public com.example.MyTools.model.Etat getEtat() {
        return Etat;
    }

    public void setEtat(com.example.MyTools.model.Etat etat) {
        Etat = etat;
    }
}
