package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.service.CouleurService;
import com.pack.fiaraoccaz.entity.Couleur;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("api/couleurs")
public class CouleurController {

    private final CouleurService couleurService;
    @Autowired
    private TokenRepository tokenRe;
    @Autowired
    private UserService userService;

    @Autowired
    public CouleurController(CouleurService couleurService) {
        this.couleurService = couleurService;
    }

    @PostMapping("/{token}/create")
    public Couleur createCouleur(@RequestBody Couleur couleur,
                                 @PathVariable("token") String token,
                                 @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return couleurService.createCouleur(couleur);
        }
        return null; 
    }

    @GetMapping("/{token}/getAll")
    public List<Couleur> getAllCouleurs(@PathVariable("token") String token,
                                       @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return couleurService.getAllCouleurs();
        }
        return null; 
    }

    @GetMapping("/{token}/getById/{id}")
    public Optional<Couleur> getCouleurById(@PathVariable Long id,
                                            @PathVariable("token") String token,
                                            @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return couleurService.getCouleurById(id);
        }
        return Optional.empty(); 
    }

    @PutMapping("/{token}/update/{id}")
    public Couleur updateCouleur(@PathVariable Long id,
                                 @RequestBody Couleur newCouleur,
                                 @PathVariable("token") String token,
                                 @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return couleurService.updateCouleur(id, newCouleur);
        }
        return null; 
    }

    @DeleteMapping("/{token}/delete/{id}")
    public void deleteCouleur(@PathVariable Long id,
                              @PathVariable("token") String token,
                              @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            couleurService.deleteCouleur(id);
        }
        
    }
}
