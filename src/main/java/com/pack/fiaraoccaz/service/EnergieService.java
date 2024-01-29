package com.pack.fiaraoccaz.service;

import com.pack.fiaraoccaz.entity.Energie;
import com.pack.fiaraoccaz.repository.EnergieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnergieService {

    private final EnergieRepository energieRepository;

    @Autowired
    public EnergieService(EnergieRepository energieRepository) {
        this.energieRepository = energieRepository;
    }

    public List<Energie> getAllEnergies() {
        return energieRepository.findAll();
    }

    public Optional<Energie> getEnergieById(Long id) {
        return energieRepository.findById(id);
    }

    public Energie saveEnergie(Energie energie) {
        return energieRepository.save(energie);
    }

    public Energie updateEnergie(Long id, Energie newEnergie){
        return energieRepository.findById(id)
            .map(existingEnergie ->{
                existingEnergie.setEnergie(newEnergie.getEnergie());
                return energieRepository.save(existingEnergie);
            })
            .orElse(null);
    }

    public void deleteEnergie(Long id) {
        energieRepository.deleteById(id);
    }
}
