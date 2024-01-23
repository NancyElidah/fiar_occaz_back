package com.pack.fiaraoccaz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vente_mensuelle")
public class VenteMensuelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvente")
    private Long idVente;

    @Column(name = "mois")
    private int mois;

    @Column(name = "annee")
    private int annee;

    @ManyToOne
    @JoinColumn(name = "idtype")
    private Type type;

    @Column(name = "chiffre_affaire")
    private double chiffreAffaire;

    // Constructeur, getters, setters

    public VenteMensuelle(){

    }
    public VenteMensuelle(Long idVente, int mois, int annee, Type type, double chiffreAffaire){
        this.idVente = idVente;
        this.mois = mois;
        this.annee = annee;
        this.type = type;
        this.chiffreAffaire = chiffreAffaire;
    }

    public Long getIdVente(){
        return idVente;
    }
    public void setIdVente(Long idVente){
        this.idVente = idVente;
    }

    public int getMois(){
        return mois;
    }
    public void setMois(int mois){
        this.mois = mois;
    }

    public int getAnnee(){
        return annee;
    }
    public void setAnnee(int annee){
        this.annee = annee;
    }

    public Type getType(){
        return type;
    }
    public void setType(Type type){
        this.type = type;
    }

    public double getChiffreAffaire(){
        return chiffreAffaire;
    }
    public void setChiffreAffaire(double chiffreAffaire){
        this.chiffreAffaire = chiffreAffaire;
    }
}
