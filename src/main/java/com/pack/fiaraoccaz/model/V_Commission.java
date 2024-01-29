package com.pack.fiaraoccaz.model;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;

@Entity(name = "v_commission")
@Immutable
public class V_Commission {
    @Id
    @Column(name = "idtype")
    int idtype;
    @Column(name = "nom")
    String nom;
    @Column(name = "commission")
    double commission;

    public int getIdtype() {
        return idtype;
    }
    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getCommission() {
        return commission;
    }
    public void setCommission(double commission) {
        this.commission = commission;
    }
}
