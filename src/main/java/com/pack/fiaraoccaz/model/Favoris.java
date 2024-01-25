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
    @ManyToMany
    @JoinColumn(name = "iduser")
    User user;
    @ManyToMany
    @JoinColumn(name = "idannonce")
    Annonce annonce;

    public int getIdfavoris() {
        return idfavoris;
    }
    public void setIdfavoris(int idfavoris) {
        this.idfavoris = idfavoris;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Annonce getAnnonce() {
        return annonce;
    }
    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}
