package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Annonce;
import com.pack.fiaraoccaz.service.AnnonceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
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
    public void updateById(@PathVariable int id, @RequestBody Annonce comm){
        Annonce c = annonceService.findById(id);
        if (c != null) {
            comm.setIdAnnonce(id);
            annonceService.save(comm);
        }
    }

}
