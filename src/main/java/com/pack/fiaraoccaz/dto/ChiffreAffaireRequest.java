package com.pack.fiaraoccaz.dto;
public class ChiffreAffaireRequest {

    private double prixVente;
    private int etatAnnonce;
    private double commission;

    // Constructeur par défaut
    public ChiffreAffaireRequest() {
    }

    // Constructeur avec paramètres
    public ChiffreAffaireRequest(double prixVente, int etatAnnonce, double commission) {
        this.prixVente = prixVente;
        this.etatAnnonce = etatAnnonce;
        this.commission = commission;
    }

    // Getters et setters
    public double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(double prixVente) {
        this.prixVente = prixVente;
    }

    public int getEtatAnnonce() {
        return etatAnnonce;
    }

    public void setEtatAnnonce(int etatAnnonce) {
        this.etatAnnonce = etatAnnonce;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }
}
