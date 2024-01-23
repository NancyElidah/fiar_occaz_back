package com.pack.fiaraoccaz.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "couleur")
public class Couleur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcouleur")
    private Long idcouleur;

    @Column(name = "couleur", length = 200)
    private String nom;

    // Constructeur par défaut
    public Couleur() {
    }

    // Constructeur avec paramètres
    public Couleur(String nom) {
        this.nom = nom;
    }

    // Getters and setters
    public Long getIdcouleur() {
        return idcouleur;
    }

    public void setIdcouleur(Long idcouleur) {
        this.idcouleur = idcouleur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
