package com.pack.fiaraoccaz.service;
import com.pack.fiaraoccaz.repository.CouleurRepository;
import com.pack.fiaraoccaz.entity.Couleur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouleurService {

    private final CouleurRepository couleurRepository;

    @Autowired
    public CouleurService(CouleurRepository couleurRepository){
        this.couleurRepository = couleurRepository;
    }

    public Couleur createCouleur(Couleur couleur){
        return couleurRepository.save(couleur);
    }

    public List<Couleur> getAllCouleurs(){
        return couleurRepository.findAll();
    }

    public Optional<Couleur> getCouleurById(Long id){
        return couleurRepository.findById(id);
    }
    
    public Couleur updateCouleur(Long id, Couleur newCouleur){
        return couleurRepository.findById(id)
            .map(existingCouleur  ->{
                existingCouleur.setNom(newCouleur.getNom());
                return couleurRepository.save(existingCouleur);
            })
            .orElse(null);
    }

    public void deleteCouleur(Long id){
        couleurRepository.deleteById(id);
    }
}
