package com.pack.fiaraoccaz.entity;
 
import jakarta.persistence.*;

@Entity
@Table(name = "annonce")
public class Annonce{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idannonce")
    private Long idannonce;

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User iduser;

    @ManyToOne
    @JoinColumn(name = "idvoiture")
    private Voiture idvoiture;

    @Column(name = "etat")
    private int etat;


    //constructeur par defaut

    public Annonce(){

    }
    //Constructeur avec parametres
    public Annonce(Long idannonce, User iduser, Voiture idvoiture, int etat){
        this.idannonce = idannonce;
        this.iduser = iduser;
        this.idvoiture = idvoiture;
        this.etat = etat; 

    }

    //getters et setters
    public Long getIdAnnonce(){
        return idannonce;
    }
    public void setIdAnnonce(int id){
        this.idannonce = idannonce;
    }

    public User getIdUser(){
        return iduser;
    }
    public void setIdUser(User iduser){
        this.iduser = iduser;
    }

    public Voiture getIdVoiture(){
        return idvoiture;
    }
    public void setIdVoiture(Voiture idvoiture){
        this.idvoiture = idvoiture;
    }

    public int getEtat(){
        return etat;
    }
    public void setEtat(int etat){
        this.etat = etat;
    }


}