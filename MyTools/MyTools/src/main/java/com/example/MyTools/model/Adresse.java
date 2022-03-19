package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Adresse {

    private String Quartier;

    private String Ville;

    private String Region;

    private String Pays;

    public Adresse(String quartier, String ville, String region, String pays) {
        Quartier = quartier;
        Ville = ville;
        Region = region;
        Pays = pays;
    }

    public String getQuartier() {
        return Quartier;
    }

    public void setQuartier(String quartier) {
        Quartier = quartier;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }
}
