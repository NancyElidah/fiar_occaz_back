package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Annonce;
import com.pack.fiaraoccaz.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
