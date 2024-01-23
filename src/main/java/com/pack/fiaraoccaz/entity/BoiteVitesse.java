package com.pack.fiaraoccaz.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "boite_vitesse")
public class BoiteVitesse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbv")
    private Long idbv;

    @Column(name = "nom", length = 200)
    private String nom;

    // Constructeur par défaut
    public BoiteVitesse() {
    }

    // Constructeur avec paramètres
    public BoiteVitesse(String nom) {
        this.nom = nom;
    }

    // Getters and setters
    public Long getIdbv() {
        return idbv;
    }

    public void setIdbv(Long idbv) {
        this.idbv = idbv;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
