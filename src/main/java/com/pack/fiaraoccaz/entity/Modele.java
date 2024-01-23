package com.pack.fiaraoccaz.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "modele")
public class Modele {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmodele")
    private Long idModele;

    @Column(name = "nom", length = 200)
    private String nom;

    // Constructeur par défaut
    public Modele() {
    }

    // Constructeur avec paramètres
    public Modele(String nom) {
        this.nom = nom;
    }

    // Getters and setters
    public Long getIdModele() {
        return idModele;
    }

    public void setIdModele(Long idModele) {
        this.idModele = idModele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
