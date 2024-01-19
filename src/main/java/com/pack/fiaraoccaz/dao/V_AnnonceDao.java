package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.V_Annonce;
import com.pack.fiaraoccaz.repository.V_AnnonceRepository;

@Service
public class V_AnnonceDao {
    private V_AnnonceRepository vaRepository;

    public V_AnnonceDao(V_AnnonceRepository vaRepository){
        this.vaRepository = vaRepository;
    }

    public List<V_Annonce> findAllByEtat(int etat){
        List<V_Annonce> result = vaRepository.findAllByEtat(etat);
        return result; 
    }
}
