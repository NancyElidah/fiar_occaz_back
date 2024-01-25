package com.pack.fiaraoccaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.Favoris;

public interface FavorisRepository extends JpaRepository<Favoris, Integer> {
    
}
