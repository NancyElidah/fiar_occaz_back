package com.pack.fiaraoccaz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idannonce")
    private int idannonce;
    @Column(name = "iduser")
    private int iduser;
    @Column(name = "idvoiture")
    private int idvoiture;
    @Column(name = "etat")
    private int etat;

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
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
}
