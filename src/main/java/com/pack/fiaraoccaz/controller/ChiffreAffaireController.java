package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Type;
import com.pack.fiaraoccaz.entity.VenteMensuelle;
import com.pack.fiaraoccaz.entity.ChiffreAffaire;
import com.pack.fiaraoccaz.dto.ChiffreAffaireRequest;
import com.pack.fiaraoccaz.service.ChiffreAffaireService;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/api/chiffre-affaire")
public class ChiffreAffaireController {

    @Autowired
    private ChiffreAffaireService chiffreAffaireService;
    @Autowired
    private TokenRepository tokenRe;
    @Autowired
    private UserService userService;

    // Endpoint pour enregistrer un nouveau chiffre d'affaire
    @PostMapping("/nouveau-chiffre-affaire")
    public ChiffreAffaire enregistrerChiffreAffaire(@RequestBody ChiffreAffaireRequest request,
                                                    @RequestParam("token") String token,
                                                    @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return chiffreAffaireService.enregistrerChiffreAffaire(
                    request.getPrixVente(),
                    request.getEtatAnnonce(),
                    request.getCommission()
            );
        }
        return null; 
    }

    // Endpoint pour récupérer tous les chiffres d'affaires enregistrés
    @GetMapping("/chiffres-affaires")
    public List<ChiffreAffaire> getAllChiffresAffaires(@RequestParam("token") String token,
                                                       @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return chiffreAffaireService.getAllChiffresAffaires();
        }
        return null; 
    }

    // Endpoint pour calculer le chiffre d'affaire net
    @GetMapping("/calcul-chiffre-affaire-net")
    public double calculerChiffreAffaireNet(@RequestParam double prixVente,
                                            @RequestParam int etatAnnonce,
                                            @RequestParam double commission,
                                            @RequestParam("token") String token,
                                            @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return chiffreAffaireService.calculerChiffreAffaireNet(prixVente, etatAnnonce, commission);
        }
        return 0;
    }

    // Endpoint pour enregistrer une nouvelle vente mensuelle
    @PostMapping("/vente-mensuelle")
    public VenteMensuelle enregistrerVenteMensuelle(@RequestBody VenteMensuelle venteMensuelle,
                                                    @RequestParam("token") String token,
                                                    @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return chiffreAffaireService.enregistrerVenteMensuelle(
                    venteMensuelle.getChiffreAffaire(),
                    venteMensuelle.getMois(),
                    venteMensuelle.getAnnee(),
                    venteMensuelle.getType()
            );
        }
        return null; 
    }

    // Endpoint pour récupérer les chiffres d'affaires mensuels par type
    @GetMapping("/ventes-mensuelles/{typeId}")
    public List<VenteMensuelle> getChiffresAffairesMensuelsParType(@PathVariable Long typeId,
                                                                   @RequestParam("token") String token,
                                                                   @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            Type type = new Type();
            type.setIdType(typeId);
            return chiffreAffaireService.getChiffresAffairesMensuelsParType(type);
        }
        return null; 
    }

    @GetMapping("/ventes-mensuelles/annee")
  public List<VenteMensuelle> getVentesMensuellesParAnnee(@RequestParam Long typeId,
                                                         @RequestParam int annee,
                                                         @RequestParam String token,
                                                         @RequestParam String idU) throws Exception {
    Token tok = tokenRe.findIdUtilsateurFromToken(token);
    Long id = Long.valueOf(idU);

    User user = userService.findUser(id);
    if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
        Type type = new Type();
        type.setIdType(typeId);
        return chiffreAffaireService.getVentesMensuellesParAnnee(type, annee);
    }
    return null;
}

}
