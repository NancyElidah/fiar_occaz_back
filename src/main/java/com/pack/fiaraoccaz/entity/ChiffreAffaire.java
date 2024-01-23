package com.pack.fiaraoccaz.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "chiffre_affaire")
public class ChiffreAffaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chiffre_affaire")
    private Long idChiffreAffaire;

    @Column(name = "prix_vente")
    private double prixVente;

    @Column(name = "etat_annonce")
    private int etatAnnonce;

    @Column(name = "commission")
    private double commission;

    @Column(name = "chiffre_affaire_net")
    private double chiffreAffaireNet;

    // constructeur par defaut
    public ChiffreAffaire(){

    }

    //constructeur avec parametres
    public ChiffreAffaire(Long idChiffreAffaire, double prixVente, int etatAnnonce, double commission, double chiffreAffaireNet){
        this.idChiffreAffaire = idChiffreAffaire;
        this.prixVente = prixVente;
        this.etatAnnonce = etatAnnonce;
        this.commission = commission;
        this.chiffreAffaireNet = chiffreAffaireNet;
    }

    //Getters et Setters
    public Long getidChiffreAffaire(){
        return idChiffreAffaire;
    }
    public void setIdChiffreAffaire(Long idChiffreAffaire){
        this.idChiffreAffaire = idChiffreAffaire;
    }

    public double getPrixVente(){
        return prixVente;
    }
    public void setPrixVente(double prixVente){
        this.prixVente = prixVente;
    }

    public int getEtatAnnonce(){
        return etatAnnonce;
    }
    public void setEtatAnnonce(int etatAnnonce){
        this.etatAnnonce = etatAnnonce;
    }

    public double getCommission(){
        return commission;
    }
    public void setCommission(double commission){
        this.commission = commission;
    }

    public double getChiffreAffaireNet(){
        return chiffreAffaireNet;
    }
    public void setChiffreAffaireNet(double chiffreAffaireNet){
        this.chiffreAffaireNet = chiffreAffaireNet;
    }

}
