package com.pack.fiaraoccaz.dao;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.repository.AnnonceRepository;

@Service
public class AnnonceDao {
    private AnnonceRepository annonceRepository;

    public AnnonceDao(AnnonceRepository annonceRepository){
        this.annonceRepository = annonceRepository;
    }

    
}
