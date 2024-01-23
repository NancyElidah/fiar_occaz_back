package com.pack.fiaraoccaz.entity;
import java.text.CollationElementIterator;
import jakarta.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "marque")
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmarque")
    private Long idmarque;

    @Column(name= "nom", nullable = false)
    private String nom;

    //constructeur par defaut
    public Marque(){

    }
    //Constructeur avec parametres
    public Marque(String nom){
        this.nom = nom;
    }

    // Getters and setters

    public Long getIdMarque(){
        return idmarque;
    }
    public void setIdMarque(Long idmarque){
        this.idmarque = idmarque;

    }
    public String getNom(){
        return nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
}

