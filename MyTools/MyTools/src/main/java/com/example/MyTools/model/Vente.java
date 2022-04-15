package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

public class Vente extends AbstractEntity{

    private BigDecimal MontantPaye;
    private BigDecimal MontantRestant;
    private BigDecimal total;
    private BigDecimal benefice;
    @OneToOne
    private Solution solution;
    @OneToOne
    private Commandes commandes;

    public Vente(BigDecimal montantPaye, BigDecimal montantRestant, BigDecimal total, BigDecimal benefice, Solution solution, Commandes commandes) {
        MontantPaye = montantPaye;
        MontantRestant = montantRestant;
        this.total = total;
        this.benefice = benefice;
        this.solution = solution;
        this.commandes = commandes;
    }

    public BigDecimal getMontantPaye() {
        return MontantPaye;
    }

    public void setMontantPaye(BigDecimal montantPaye) {
        MontantPaye = montantPaye;
    }

    public BigDecimal getMontantRestant() {
        return MontantRestant;
    }

    public void setMontantRestant(BigDecimal montantRestant) {
        MontantRestant = montantRestant;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getBenefice() {
        return benefice;
    }

    public void setBenefice(BigDecimal benefice) {
        this.benefice = benefice;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public Commandes getCommandes() {
        return commandes;
    }

    public void setCommandes(Commandes commandes) {
        this.commandes = commandes;
    }
}
