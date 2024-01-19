package com.pack.fiaraoccaz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "type")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtype")
    private int idType;
    @Column(name = "nom")
    private String nom;

    public int getIdType() {
        return idType;
    }
    public void setIdType(int idType) {
        this.idType = idType;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
}
