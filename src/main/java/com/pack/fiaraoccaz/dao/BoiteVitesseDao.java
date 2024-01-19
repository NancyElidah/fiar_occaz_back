package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.BoiteVitesse;
import com.pack.fiaraoccaz.repository.BoiteVitesseRepository;

@Service
public class BoiteVitesseDao {
    private final BoiteVitesseRepository boiteVitesseRepository;

    public BoiteVitesseDao(BoiteVitesseRepository boiteVitesseRepository){
        this.boiteVitesseRepository = boiteVitesseRepository;
    }

    public List<BoiteVitesse> findAll(){
        List<BoiteVitesse> boiteVitesselist = boiteVitesseRepository.findAll();
        return boiteVitesselist;
    }

    public void save(BoiteVitesse boiteVitesse){
        boiteVitesseRepository.save(boiteVitesse);
    }

    public void deleteById(int id) {
        boiteVitesseRepository.deleteById(id);
    }

    public BoiteVitesse findById(int id){
        BoiteVitesse result = boiteVitesseRepository.findById(id).orElse(null);
        return result; 
    }
}
