package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Annonce;
import com.pack.fiaraoccaz.service.AnnonceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {

    private final AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @PostMapping("/valider/{idAnnonce}")
    public Annonce validerAnnonce(@PathVariable Long idAnnonce) {
        return annonceService.validerAnnonce(idAnnonce);
    }


    @GetMapping("/recherche")
    public List<Annonce> rechercheAvancee(
            @RequestParam(required = false) String motCle,
            @RequestParam(required = false) Long type,
            @RequestParam(required = false) Long marque,
            @RequestParam(required = false) Long modele,
            @RequestParam(required = false) Long energie,
            @RequestParam(required = false) Long boite_vitesse,
            @RequestParam(required = false) int annee,
            @RequestParam(required = false) double kilometrage,
            @RequestParam(required = false) double prix,
            @RequestParam(required = false) Long couleur,
            @RequestParam(required = false) Long pays,
            @RequestParam(required = false) int nbplace,
            @RequestParam(required = false) int nbporte,
            @RequestParam(required = false) int status ) {
        return annonceService.rechercheAvancee(motCle, type, marque, modele, energie, boite_vitesse, annee, kilometrage, prix, couleur, pays, nbplace, nbporte, status );
    }

    @PostMapping
    public void save(@RequestBody Annonce comm){
        annonceService.save(comm);
    }

    @GetMapping
    public List<Annonce> findAll(){
        return annonceService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        annonceService.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Annonce> findById(@PathVariable int id){
        Annonce result = annonceService.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Annonce> updateById(@PathVariable Long id, @RequestBody Annonce updatedAnnonce) {
        Annonce updatedAnnonceResult = annonceService.updateById(id, updatedAnnonce);
    
        if (updatedAnnonceResult != null) {
            return ResponseEntity.ok(updatedAnnonceResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    


}
