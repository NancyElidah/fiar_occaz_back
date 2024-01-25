package com.pack.fiaraoccaz.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "utilisateur")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Long iduser;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "mdp", nullable = false)
    private String password;

    @Column(name = "etat", nullable = false)
    private int etat;

    @OneToMany(mappedBy = "user")
    private List<Annonce> annonces = new ArrayList<>();

    // Constructeur par défaut
    public User() {
    }

    // Constructeur avec paramètres
    public User(String nom, String email, String password, int etat) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.etat = etat;
    }

    // Getters and Setters

    public Long getIdUser() {
        return iduser;
    }

    public void setIdUser(Long iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public List<Annonce> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
