package com.pack.fiaraoccaz.entity;

import com.pack.fiaraoccaz.model.BoiteVitesse;
import com.pack.fiaraoccaz.model.Modele;

import jakarta.persistence.*;

@Entity
@Table(name = "voiture")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvoiture")
    private Long idVoiture;

    @ManyToOne
    @JoinColumn(name = "type")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "marque")
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "modele")
    private Modele modele;

    @ManyToOne
    @JoinColumn(name = "energie")
    private Energie energie;

    @ManyToOne
    @JoinColumn(name = "boite_vitesse")
    private BoiteVitesse boiteVitesse;

    @Column(name = "annee")
    private int annee;

    @Column(name = "kilometrage")
    private double kilometrage;

    @Column(name = "prix")
    private double prix;

    @ManyToOne
    @JoinColumn(name = "couleur")
    private Couleur couleur;

    @ManyToOne
    @JoinColumn(name = "provenance")
    private Pays provenance;

    @Column(name = "nbplace")
    private int nbPlace;

    @Column(name = "nbporte")
    private int nbPorte;

    @Column(name = "status")
    private int status;

    // Constructeur par défaut
    public Voiture() {

    }

    // Constructeur avec des paramètres
    public Voiture(Long idVoiture, Type type, Marque marque, Modele modele, Energie energie, BoiteVitesse boiteVitesse,
            int annee, double kilometrage, double prix, Couleur couleur, Pays provenance, int nbPlace, int nbPorte,
            int status) {
        this.idVoiture = idVoiture;
        this.type = type;
        this.marque = marque;
        this.modele = modele;
        this.energie = energie;
        this.boiteVitesse = boiteVitesse;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.prix = prix;
        this.couleur = couleur;
        this.provenance = provenance;
        this.nbPlace = nbPlace;
        this.nbPorte = nbPorte;
        this.status = status;
    }

    // Getters and Setters

    public Long getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(Long idVoiture) {
        this.idVoiture = idVoiture;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Energie getEnergie() {
        return energie;
    }

    public void setEnergie(Energie energie) {
        this.energie = energie;
    }

    public BoiteVitesse getBoiteVitesse() {
        return boiteVitesse;
    }

    public void setBoiteVitesse(BoiteVitesse boiteVitesse) {
        this.boiteVitesse = boiteVitesse;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(double kilometrage) {
        this.kilometrage = kilometrage;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public Pays getProvenance() {
        return provenance;
    }

    public void setProvenance(Pays provenance) {
        this.provenance = provenance;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public int getNbPorte() {
        return nbPorte;
    }

    public void setNbPorte(int nbPorte) {
        this.nbPorte = nbPorte;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
