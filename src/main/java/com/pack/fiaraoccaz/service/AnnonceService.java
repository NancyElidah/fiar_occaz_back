package com.pack.fiaraoccaz.service;

import com.pack.fiaraoccaz.entity.Annonce;
import com.pack.fiaraoccaz.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {

    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    public Annonce validerAnnonce(Long idAnnonce) {
        Annonce annonce = annonceRepository.findById(idAnnonce).orElse(null);

        if (annonce != null) {
            annonce.setEtat(1); // Mettez l'état à 1 pour valider l'annonce
            return annonceRepository.save(annonce);
        }

        return null; // L'annonce n'a pas été trouvée
    }

  
}
