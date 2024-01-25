package com.pack.fiaraoccaz.dao;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.Favoris;
import com.pack.fiaraoccaz.repository.FavorisRepository;

@Service
public class FavorisDao {
    private final FavorisRepository favorisRepository;

    public FavorisDao(FavorisRepository favorisRepository){
        this.favorisRepository = favorisRepository;
    }

    public void save(Favoris favoris){
        favorisRepository.save(favoris);
    }
}
