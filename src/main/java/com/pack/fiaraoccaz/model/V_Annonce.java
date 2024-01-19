package com.pack.fiaraoccaz.model;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.*;

@Entity(name = "v_annonce")
@Immutable
public class V_Annonce {
    @Id
    @Column(name = "idannonce")
    int idannonce;
    @Column(name = "iduser")
    int iduser;
    @Column(name = "idvoiture")
    int idvoiture;
    @Column(name = "type")
    String type;
    @Column(name = "marque")
    String marque;
    @Column(name = "modele")
    String modele;
    @Column(name = "energie")
    String energie;
    @Column(name = "boite_vitesse")
    String boite_vitesse;
    @Column(name = "annee")
    int annee;
    @Column(name = "kilometrage")
    double kilometrage;
    @Column(name = "prix")
    double prix;
    @Column(name = "couleur")
    String couleur;
    @Column(name = "provenance")
    String provenance;
    @Column(name = "nbplace")
    int nbplace;
    @Column(name = "nbporte")
    int nbporte;
    @Column(name = "etat")
    int etat;

    public int getIdannonce() {
        return idannonce;
    }
    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public int getIdvoiture() {
        return idvoiture;
    }
    public void setIdvoiture(int idvoiture) {
        this.idvoiture = idvoiture;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public String getEnergie() {
        return energie;
    }
    public void setEnergie(String energie) {
        this.energie = energie;
    }
    public String getBoite_vitesse() {
        return boite_vitesse;
    }
    public void setBoite_vitesse(String boite_vitesse) {
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
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public String getProvenance() {
        return provenance;
    }
    public void setProvenance(String provenance) {
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
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
}
