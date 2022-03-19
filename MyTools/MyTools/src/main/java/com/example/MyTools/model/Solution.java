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
public class Solution extends AbstractEntity{


    private String Etat;

    @OneToOne
    private Reparation reparation;

    @OneToOne
    private Services services;

    @OneToMany
    private List<Vente> ventes;

    public Solution(String etat) {
        Etat = etat;
    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public Reparation getReparation() {
        return reparation;
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }
}
