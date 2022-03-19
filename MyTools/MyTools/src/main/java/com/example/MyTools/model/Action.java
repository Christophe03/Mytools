package com.example.MyTools.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class Action extends AbstractEntity{
    @ManyToOne
    private Professionnel professionnel;

    public Professionnel getProfessionnel() {
        return professionnel;
    }

    public void setProfessionnel(Professionnel professionnel) {
        this.professionnel = professionnel;
    }
}
