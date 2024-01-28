package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Type;
import com.pack.fiaraoccaz.entity.VenteMensuelle;
import com.pack.fiaraoccaz.entity.ChiffreAffaire;
import com.pack.fiaraoccaz.dto.ChiffreAffaireRequest;
import com.pack.fiaraoccaz.service.ChiffreAffaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/api/chiffre-affaire")
public class ChiffreAffaireController {

    @Autowired
    private ChiffreAffaireService chiffreAffaireService;

      // Endpoint pour enregistrer un nouveau chiffre d'affaire
      @PostMapping("/nouveau-chiffre-affaire")
      public ChiffreAffaire enregistrerChiffreAffaire(@RequestBody ChiffreAffaireRequest request) {
          return chiffreAffaireService.enregistrerChiffreAffaire(
                  request.getPrixVente(),
                  request.getEtatAnnonce(),
                  request.getCommission()
          );
      }
  
      // Endpoint pour récupérer tous les chiffres d'affaires enregistrés
      @GetMapping("/chiffres-affaires")
      public List<ChiffreAffaire> getAllChiffresAffaires() {
          return chiffreAffaireService.getAllChiffresAffaires();
      }
  
      // Endpoint pour calculer le chiffre d'affaire net
      @GetMapping("/calcul-chiffre-affaire-net")
      public double calculerChiffreAffaireNet(@RequestParam double prixVente, @RequestParam int etatAnnonce, @RequestParam double commission) {
          return chiffreAffaireService.calculerChiffreAffaireNet(prixVente, etatAnnonce, commission);
      }

    // Endpoint pour enregistrer une nouvelle vente mensuelle
    @PostMapping("/vente-mensuelle")
    public VenteMensuelle enregistrerVenteMensuelle(@RequestBody VenteMensuelle venteMensuelle) {
        return chiffreAffaireService.enregistrerVenteMensuelle(
                venteMensuelle.getChiffreAffaire(),
                venteMensuelle.getMois(),
                venteMensuelle.getAnnee(),
                venteMensuelle.getType()
        );
    }

    // Endpoint pour récupérer les chiffres d'affaires mensuels par type
    @GetMapping("/ventes-mensuelles/{typeId}")
    public List<VenteMensuelle> getChiffresAffairesMensuelsParType(@PathVariable Long typeId) {
        Type type = new Type();
        type.setIdType(typeId);
        return chiffreAffaireService.getChiffresAffairesMensuelsParType(type);
    }
}
