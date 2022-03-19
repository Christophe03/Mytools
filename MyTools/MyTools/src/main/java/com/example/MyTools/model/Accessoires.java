package com.example.MyTools.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Accessoires extends AbstractEntity{

    private String nom;

    private BigDecimal Prix;

    private String caracteristique;
    @Enumerated (EnumType.STRING)
    private ArticleType articleType = ArticleType.ACCESSOIRES;

    @Enumerated (EnumType.STRING)
    private etat Etat = etat.ACTIVER;

    private String photo;
    
    private Produits produits;
    @OneToMany
    private List<Commandes> commandes;
    @ManyToOne
    private Appareil appareils;
    @OneToOne
    private Atelier atelier;
    @OneToOne
    private Professionnel professionnel;

    public Accessoires(String nom, BigDecimal prix, String caracteristique, ArticleType articleType, etat etat, String photo, Produits produits) {
        this.nom = nom;
        Prix = prix;
        this.caracteristique = caracteristique;
        this.articleType = articleType;
        Etat = etat;
        this.photo = photo;
        this.produits = produits;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getPrix() {
        return Prix;
    }

    public void setPrix(BigDecimal prix) {
        Prix = prix;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Appareil getAppareils() {
        return appareils;
    }

    public void setAppareils(Appareil appareils) {
        this.appareils = appareils;
    }

    public etat getEtat() {
        return Etat;
    }

    public void setEtat(etat etat) {
        Etat = etat;
    }

    public List<Commandes> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commandes> commandes) {
        this.commandes = commandes;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public Professionnel getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnel professionnel) {
        this.professionnel = professionnel;
    }
}
