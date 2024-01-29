package com.pack.fiaraoccaz.service;

import com.pack.fiaraoccaz.entity.Voiture;
import com.pack.fiaraoccaz.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import java.util.List;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;


    public Voiture createVoiture(Voiture voiture){
        return voitureRepository.save(voiture);
    }
    
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    
    }

    public Optional<Voiture> getVoitureById(Long id){
        return voitureRepository.findById(id);
    }

    public Voiture updateVoiture(Long id, Voiture updatedVoiture) {
        Optional<Voiture> existingVoitureOptional = voitureRepository.findById(id);

        if (existingVoitureOptional.isPresent()) {
            Voiture existingVoiture = existingVoitureOptional.get();

           
            existingVoiture.setType(updatedVoiture.getType());
            existingVoiture.setMarque(updatedVoiture.getMarque());
            existingVoiture.setModele(updatedVoiture.getModele());
            existingVoiture.setEnergie(updatedVoiture.getEnergie());
            existingVoiture.setBoiteVitesse(updatedVoiture.getBoiteVitesse());
            existingVoiture.setAnnee(updatedVoiture.getAnnee());
            existingVoiture.setKilometrage(updatedVoiture.getKilometrage());
            existingVoiture.setPrix(updatedVoiture.getPrix());
            existingVoiture.setCouleur(updatedVoiture.getCouleur());
            existingVoiture.setProvenance(updatedVoiture.getProvenance());
            existingVoiture.setNbPlace(updatedVoiture.getNbPlace());
            existingVoiture.setNbPorte(updatedVoiture.getNbPorte());
            existingVoiture.setMatricule(updatedVoiture.getMatricule());
            existingVoiture.setStatus(updatedVoiture.getStatus());

            return voitureRepository.save(existingVoiture);
        } else {
            
            return null;
        }
    }
      
    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }
    
}



