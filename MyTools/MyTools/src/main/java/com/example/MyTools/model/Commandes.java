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
@AllArgsConstructor
public class Commandes extends AbstractEntity{

    private String CodeCommande;

    private BigDecimal Quantite;

    private BigDecimal Montant;

    @ManyToOne
    private Appareil appareils;
    @ManyToOne
    private Accessoires accessoires;

    @ManyToOne
    private Client client;


    public Commandes(String codeCommande, BigDecimal quantite, BigDecimal montant) {

        CodeCommande = codeCommande;
        Quantite = quantite;
        Montant = montant;
    }

    public String getCodeCommande() {
        return CodeCommande;
    }

    public void setCodeCommande(String codeCommande) {
        CodeCommande = codeCommande;
    }

    public BigDecimal getQuantite() {
        return Quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        Quantite = quantite;
    }

    public BigDecimal getMontant() {
        return Montant;
    }

    public void setMontant(BigDecimal montant) {
        Montant = montant;
    }

    public Appareil getAppareils() {
        return appareils;
    }

    public void setAppareils(Appareil appareils) {
        this.appareils = appareils;
    }

    public Accessoires getAccessoires() {
        return accessoires;
    }

    public void setAccessoires(Accessoires accessoires) {
        this.accessoires = accessoires;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
