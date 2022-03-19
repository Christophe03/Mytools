package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor

public class Reparation extends AbstractEntity{

    private String nom;

    private LocalDate dateDepot;

    private Date dateRendu;

    @OneToMany
    private List<Solution> solution;

    public Reparation(String nom, LocalDate dateDepot, Date dateRendu) {
        this.nom = nom;
        this.dateDepot = dateDepot;
        this.dateRendu = dateRendu;
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

    public Date getDateRendu() {
        return dateRendu;
    }

    public void setDateRendu(Date dateRendu) {
        this.dateRendu = dateRendu;
    }

    public List<Solution> getSolution() {
        return solution;
    }

    public void setSolution(List<Solution> solution) {
        this.solution = solution;
    }
}
