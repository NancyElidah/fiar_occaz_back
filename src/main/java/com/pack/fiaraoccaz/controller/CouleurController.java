package com.pack.fiaraoccaz.controller;
import com.pack.fiaraoccaz.service.CouleurService;
import com.pack.fiaraoccaz.entity.Couleur;
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
    public CouleurController(CouleurService couleurService) {
        this.couleurService = couleurService;
    }

    @PostMapping
    public Couleur createCouleur(@RequestBody Couleur couleur) {
        return couleurService.createCouleur(couleur);

    }

    @GetMapping
    public List<Couleur> getAllCouleurs() {
        return couleurService.getAllCouleurs();
    }

    @GetMapping("/{id}")
    public Optional<Couleur> getCouleurById(@PathVariable Long id) {
        return couleurService.getCouleurById(id);
    }

    @PutMapping("/{id}")
    public Couleur updateCouleur(@PathVariable Long id, @RequestBody Couleur newCouleur) {
        return couleurService.updateCouleur(id, newCouleur);
    }

    @DeleteMapping("/{id}")
    public void deleteCouleur(@PathVariable Long id) {
        couleurService.deleteCouleur(id);
    }
    
}
