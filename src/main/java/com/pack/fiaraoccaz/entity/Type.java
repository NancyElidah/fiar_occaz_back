package com.pack.fiaraoccaz.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "type")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtype")
    private Long idtype;

    @Column(name = "nom", length = 200)
    private String nom;

    // Constructeur par défaut
    public Type() {
    }

    // Constructeur avec paramètres
    public Type(String nom) {
        this.nom = nom;
    }

    // Getters and setters
    public Long getIdType() {
        return idtype;
    }

    public void setIdType(Long idtype) {
        this.idtype = idtype;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
