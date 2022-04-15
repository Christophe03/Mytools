package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Accessoires extends AbstractEntity{

    private String nom;

    private BigDecimal Prix;

    private String caracteristique;
    @Enumerated (EnumType.STRING)
    private ArticleType articleType = ArticleType.ACCESSOIRES;

    @Enumerated (EnumType.STRING)
    private Etat etat= Etat.ACTIVER;

    private String photo;
    
    private Produits produits;
    @OneToMany
    private List<Commandes> commandes;
    @OneToOne
    private Atelier atelier;
    @OneToOne
    private Professionnel professionnel;

    public Accessoires(String nom, BigDecimal prix, String caracteristique, ArticleType articleType, Etat etat, String photo, Produits produits, List<Commandes> commandes, Atelier atelier, Professionnel professionnel) {
        this.nom = nom;
        Prix = prix;
        this.caracteristique = caracteristique;
        this.articleType = articleType;
        this.etat = etat;
        this.photo = photo;
        this.produits = produits;
        this.commandes = commandes;
        this.atelier = atelier;
        this.professionnel = professionnel;
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

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    public List<Commandes> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commandes> commandes) {
        this.commandes = commandes;
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
