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


public class Appareil extends AbstractEntity{
    private String nom;
    private String photo;
    private BigDecimal prix;
    private String caracteristique;
    @Enumerated (EnumType.STRING)
    private ArticleType articleType = ArticleType.APPAREIL;
    @Enumerated (EnumType.STRING)
    private etat Etat = etat.ACTIVER;
    private Produits produits;
    @OneToMany
    @JsonIgnore
    private List<Accessoires> accessoires;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name="idclient", referencedColumnName = "id")
    private Client client;
    @OneToMany
    @JsonIgnore
    private List<Commandes> commandes;
    @OneToOne
    private Atelier atelier;
    @OneToOne
    private Professionnel professionnel;

    public Appareil(String nom, String photo, BigDecimal prix, String caracteristique, ArticleType articleType, etat etat, Produits produits) {
        this.nom = nom;
        this.photo = photo;
        this.prix = prix;
        this.caracteristique = caracteristique;
        this.articleType = articleType;
        Etat = etat;
        this.produits = produits;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
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

    public List<Accessoires> getAccessoires() {
        return accessoires;
    }

    public void setAccessoires(List<Accessoires> accessoires) {
        this.accessoires = accessoires;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
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
