package com.pack.fiaraoccaz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modele")
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmodele")
    private int idModele;
    @Column(name = "nom")
    private String nom;

    public int getIdModele() {
        return idModele;
    }
    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
