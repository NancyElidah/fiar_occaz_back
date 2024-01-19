package com.pack.fiaraoccaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
    
}
