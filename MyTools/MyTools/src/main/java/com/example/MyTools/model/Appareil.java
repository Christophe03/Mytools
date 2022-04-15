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

public class Appareil extends AbstractEntity{
    private String nom;
    private String photo;
    private BigDecimal prix;
    private String caracteristique;
    @Enumerated (EnumType.STRING)
    private ArticleType articleType = ArticleType.APPAREIL;
    @Enumerated (EnumType.STRING)
    private Etat etat = Etat.ACTIVER;
    private Produits produits;
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

    public Appareil(String nom, String photo, BigDecimal prix, String caracteristique, ArticleType articleType, Etat etat, Produits produits, Client client, List<Commandes> commandes, Atelier atelier, Professionnel professionnel) {
        this.nom = nom;
        this.photo = photo;
        this.prix = prix;
        this.caracteristique = caracteristique;
        this.articleType = articleType;
        this.etat = etat;
        this.produits = produits;
        this.client = client;
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

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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
