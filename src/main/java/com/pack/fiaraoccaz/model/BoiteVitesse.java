package com.pack.fiaraoccaz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "boite_vitesse")
public class BoiteVitesse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbv")
    private int idBV;
    @Column(name = "nom")
    private String nom;

    public int getIdBV() {
        return idBV;
    }
    public void setIdBV(int idBV) {
        this.idBV = idBV;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
