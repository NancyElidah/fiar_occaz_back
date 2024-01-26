package com.pack.fiaraoccaz.model;

import com.pack.fiaraoccaz.entity.*;

import jakarta.persistence.*;

@Entity
@Table(name = "favoris")
public class Favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfavoris")
    int idfavoris;
    @Column(name = "iduser")
    int iduser;
    @Column(name = "idannonce")
    int idannonce;

    public int getIdfavoris() {
        return idfavoris;
    }
    public void setIdfavoris(int idfavoris) {
        this.idfavoris = idfavoris;
    }
    public int getIduser() {
        return iduser;
    }
    public void setIduser(int iduser) {
        this.iduser = iduser;
    }
    public int getIdannonce() {
        return idannonce;
    }
    public void setIdannonce(int idannonce) {
        this.idannonce = idannonce;
    }
}
