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
    private Voiture voiture;

    @Column(name = "etat")
    private int etat;

    // Constructeur par défaut
    public Annonce() {
    }


    //Constructeur avec parametres
    public Annonce(Long idannonce, User iduser, Voiture voiture, int etat){
        this.idannonce = idannonce;
        this.iduser = iduser;
        this.voiture = voiture;
        this.etat = etat; 

    }

    //getters et setters
    public Long getIdAnnonce(){
        return idannonce;
    }
    public void setIdAnnonce(Long id){
        this.idannonce = idannonce;
    }

    public User getIdUser(){
        return iduser;
    }
    public void setIdUser(User iduser){
        this.iduser = iduser;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public int getEtat(){
        return etat;
    }
    public void setEtat(int etat){
        this.etat = etat;
    }
}