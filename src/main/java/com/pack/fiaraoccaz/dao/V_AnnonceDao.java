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

    public List<V_Annonce> findAllByIdtype(int idtype){
        List<V_Annonce> result = vaRepository.findAllByIdtype(idtype);
        return result;
    }

    public List<V_Annonce> findAllByIdmarque(int idmarque){
        List<V_Annonce> result = vaRepository.findAllByIdmarque(idmarque);
        return result;
    }

    public List<V_Annonce> findAllByIdmodele(int idmodele){
        List<V_Annonce> result = vaRepository.findAllByIdmodele(idmodele);
        return result;
    }

    public List<V_Annonce> findAllByIdenergie(int idenergie){
        List<V_Annonce> result = vaRepository.findAllByIdenergie(idenergie);
        return result;
    }

    public List<V_Annonce> findAllByIdcouleur(int idcouleur){
        List<V_Annonce> result = vaRepository.findAllByIdcouleur(idcouleur);
        return result;
    }

    public List<V_Annonce> findAllByIdpays(int idpays){
        List<V_Annonce> result = vaRepository.findAllByIdpays(idpays);
        return result;
    }

    public List<V_Annonce> findAllByIdbv(int idbv){
        List<V_Annonce> result = vaRepository.findAllByIdbv(idbv);
        return result;
    }

    public List<V_Annonce> findAllByPrixBetween(double prixMin, double prixMax){
        List<V_Annonce> result = vaRepository.findAllByPrixBetween(prixMin, prixMax);
        return result;
    }

    public List<V_Annonce> findAllByAnneeBetween(double anneeMin, double anneeMax){
        List<V_Annonce> result = vaRepository.findAllByAnneeBetween(anneeMin, anneeMax);
        return result;
    }
}
