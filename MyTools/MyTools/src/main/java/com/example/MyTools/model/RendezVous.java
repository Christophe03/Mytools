package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class RendezVous extends AbstractEntity{

    private Date DateSaisi;
    private Date DateRendu;

    private BigDecimal montant;

    @ManyToOne
    private Professionnel professionnel;

    @ManyToOne
    private Client client;

    public RendezVous(Date dateSaisi, Date dateRendu, BigDecimal montant) {
        this.DateSaisi = dateSaisi;
        this.DateRendu = dateRendu;
        this.montant = montant;
    }

    public Date getDateSaisi() {
        return DateSaisi;
    }

    public void setDateSaisi(Date dateSaisi) {
        DateSaisi = dateSaisi;
    }

    public Date getDateRendu() {
        return DateRendu;
    }

    public void setDateRendu(Date dateRendu) {
        DateRendu = dateRendu;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Professionnel getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnel professionnel) {
        this.professionnel = professionnel;
    }
}
