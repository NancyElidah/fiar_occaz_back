package com.pack.fiaraoccaz.service;
import com.pack.fiaraoccaz.repository.MarqueRepository;
import com.pack.fiaraoccaz.entity.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueService {

    private final MarqueRepository marqueRepository;

    @Autowired
    public MarqueService(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    public Marque createMarque(Marque marque) {
        // Logique de création
        return marqueRepository.save(marque);
    }

    public List<Marque> getAllMarques() {
        // Logique de lecture (toutes les marques)
        return marqueRepository.findAll();
    }

    public Optional<Marque> getMarqueById(Long id) {
        // Logique de lecture (par ID)
        return marqueRepository.findById(id);
    }

    public Marque updateMarque(Long id, Marque newMarque) {
        // Logique de mise à jour
        return marqueRepository.findById(id)
                .map(existingMarque -> {
                    existingMarque.setNom(newMarque.getNom());
                    return marqueRepository.save(existingMarque);
                })
                .orElse(null);
    }

    public void deleteMarque(Long id) {
        // Logique de suppression
        marqueRepository.deleteById(id);
    }
}
