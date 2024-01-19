package com.pack.fiaraoccaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.Voiture;

public interface VoitureRepository extends JpaRepository<Voiture, Integer> {
    
}
