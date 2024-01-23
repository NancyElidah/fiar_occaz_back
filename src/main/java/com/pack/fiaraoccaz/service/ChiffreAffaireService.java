package com.pack.fiaraoccaz.service;

import com.pack.fiaraoccaz.entity.ChiffreAffaire;
import com.pack.fiaraoccaz.entity.Type;
import com.pack.fiaraoccaz.entity.VenteMensuelle;
import com.pack.fiaraoccaz.repository.ChiffreAffaireRepository;
import com.pack.fiaraoccaz.repository.VenteMensuelleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiffreAffaireService {

    @Autowired
    private ChiffreAffaireRepository chiffreAffaireRepository;

    @Autowired
    private VenteMensuelleRepository venteMensuelleRepository;

    // Méthode pour calculer le chiffre d'affaire net
    public double calculerChiffreAffaireNet(double prixVente, int etatAnnonce, double commission) {
        if (etatAnnonce == 1) {
            double chiffreAffaireNet = prixVente - commission;
            return chiffreAffaireNet;
        } else {
            // Annonce non valide
            return 0.0;
        }
    }

    // Méthode pour enregistrer un nouveau chiffre d'affaire
    public ChiffreAffaire enregistrerChiffreAffaire(double prixVente, int etatAnnonce, double commission) {
        double chiffreAffaireNet = calculerChiffreAffaireNet(prixVente, etatAnnonce, commission);

        ChiffreAffaire chiffreAffaire = new ChiffreAffaire();
        chiffreAffaire.setPrixVente(prixVente);
        chiffreAffaire.setEtatAnnonce(etatAnnonce);
        chiffreAffaire.setCommission(commission);
        chiffreAffaire.setChiffreAffaireNet(chiffreAffaireNet);

        return chiffreAffaireRepository.save(chiffreAffaire);
    }
  
    // Méthode pour récupérer tous les chiffres d'affaires enregistrés

    public List<ChiffreAffaire> getAllChiffresAffaires() {
        return (List<ChiffreAffaire>) chiffreAffaireRepository.findAll();
    }

    // Méthode pour enregistrer une nouvelle vente mensuelle
    public VenteMensuelle enregistrerVenteMensuelle(double chiffreAffaire, int mois, int annee, Type type) {
        VenteMensuelle venteMensuelle = new VenteMensuelle();
        venteMensuelle.setChiffreAffaire(chiffreAffaire);
        venteMensuelle.setMois(mois);
        venteMensuelle.setAnnee(annee);
        venteMensuelle.setType(type);

        return venteMensuelleRepository.save(venteMensuelle);
    }

    // Méthode pour récupérer les chiffres d'affaires mensuels par type
    public List<VenteMensuelle> getChiffresAffairesMensuelsParType(Type type) {
        return venteMensuelleRepository.findByType(type);
    }
}
