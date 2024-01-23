package com.pack.fiaraoccaz.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "pays")
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpays")
    private Long idpays;

    @Column(name = "nom", length = 200)
    private String nom;

    // Constructeur par défaut
    public Pays() {
    }

    // Constructeur avec paramètres
    public Pays(String nom) {
        this.nom = nom;
    }

    // Getters and setters
    public Long getIdPays() {
        return idpays;
    }

    public void setIdPays(Long idpays) {
        this.idpays = idpays;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
