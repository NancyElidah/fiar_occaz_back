package com.pack.fiaraoccaz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "voiture")
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvoiture")
    int idvoiture;
    @Column(name = "type")
    int type;
    @Column(name = "marque")
    int marque;
    @Column(name = "modele")
    int modele;
    @Column(name = "energie")
    int energie;
    @Column(name = "boite_vitesse")
    int boite_vitesse;
    @Column(name = "annee")
    int annee;
    @Column(name = "kilometrage")
    double kilometrage;
    @Column(name = "prix")
    double prix;
    @Column(name = "couleur")
    int couleur;
    @Column(name = "provenance")
    int provenance;
    @Column(name = "nbplace")
    int nbplace;
    @Column(name = "nbporte")
    int nbporte;

    public int getIdvoiture() {
        return idvoiture;
    }
    public void setIdvoiture(int idvoiture) {
        this.idvoiture = idvoiture;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getMarque() {
        return marque;
    }
    public void setMarque(int marque) {
        this.marque = marque;
    }
    public int getModele() {
        return modele;
    }
    public void setModele(int modele) {
        this.modele = modele;
    }
    public int getEnergie() {
        return energie;
    }
    public void setEnergie(int energie) {
        this.energie = energie;
    }
    public int getBoite_vitesse() {
        return boite_vitesse;
    }
    public void setBoite_vitesse(int boite_vitesse) {
        this.boite_vitesse = boite_vitesse;
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
    public int getCouleur() {
        return couleur;
    }
    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
    public int getProvenance() {
        return provenance;
    }
    public void setProvenance(int provenance) {
        this.provenance = provenance;
    }
    public int getNbplace() {
        return nbplace;
    }
    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }
    public int getNbporte() {
        return nbporte;
    }
    public void setNbporte(int nbporte) {
        this.nbporte = nbporte;
    }
}
