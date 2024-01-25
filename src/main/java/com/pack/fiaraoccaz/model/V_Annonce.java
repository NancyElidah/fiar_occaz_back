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
    @Column(name = "idtype")
    int idtype;
    @Column(name = "type")
    String type;
    @Column(name = "idmarque")
    int idmarque;
    @Column(name = "marque")
    String marque;
    @Column(name = "idmodele")
    int idmodele;
    @Column(name = "modele")
    String modele;
    @Column(name = "idenergie")
    int idenergie;
    @Column(name = "energie")
    String energie;
    @Column(name = "idbv")
    int idbv;
    @Column(name = "boite_vitesse")
    String boite_vitesse;
    @Column(name = "annee")
    int annee;
    @Column(name = "kilometrage")
    double kilometrage;
    @Column(name = "prix")
    double prix;
    @Column(name = "idcouleur")
    int idcouleur;
    @Column(name = "couleur")
    String couleur;
    @Column(name = "idpays")
    int idpays;
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
    public int getIdtype() {
        return idtype;
    }
    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getIdmarque() {
        return idmarque;
    }
    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public int getIdmodele() {
        return idmodele;
    }
    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
    }
    public int getIdenergie() {
        return idenergie;
    }
    public void setIdenergie(int idenergie) {
        this.idenergie = idenergie;
    }
    public String getEnergie() {
        return energie;
    }
    public void setEnergie(String energie) {
        this.energie = energie;
    }
    public int getIdbv() {
        return idbv;
    }
    public void setIdbv(int idbv) {
        this.idbv = idbv;
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
    public int getIdcouleur() {
        return idcouleur;
    }
    public void setIdcouleur(int idcouleur) {
        this.idcouleur = idcouleur;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public int getIdpays() {
        return idpays;
    }
    public void setIdpays(int idpays) {
        this.idpays = idpays;
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
