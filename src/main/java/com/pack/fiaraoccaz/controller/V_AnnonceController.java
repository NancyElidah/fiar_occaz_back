package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_AnnonceDao;
import com.pack.fiaraoccaz.model.V_Annonce;

@RestController
@RequestMapping("/v_annonce")
public class V_AnnonceController {
    private V_AnnonceDao vaDao;

    public V_AnnonceController(V_AnnonceDao vaDao){
        this.vaDao = vaDao;
    }

    @GetMapping("/{etat}")
    public List<V_Annonce> findAllByEtat(@PathVariable int etat){
        return vaDao.findAllByEtat(etat);
    }

    @GetMapping("/type/{idtype}")
    public List<V_Annonce> findAllByIdtype(@PathVariable int idtype){
        return vaDao.findAllByIdtype(idtype);
    }

    @GetMapping("/marque/{idmarque}")
    public List<V_Annonce> findAllByIdmarque(@PathVariable int idmarque){
        return vaDao.findAllByIdmarque(idmarque);
    }

    @GetMapping("/modele/{idmodele}")
    public List<V_Annonce> findAllByIdmodele(@PathVariable int idmodele){
        return vaDao.findAllByIdmodele(idmodele);
    }

    @GetMapping("/energie/{idenergie}")
    public List<V_Annonce> findAllByIdenergie(@PathVariable int idenergie){
        return vaDao.findAllByIdenergie(idenergie);
    }

    @GetMapping("/couleur/{idcouleur}")
    public List<V_Annonce> findAllByIdcouleur(@PathVariable int idcouleur){
        return vaDao.findAllByIdcouleur(idcouleur);
    }

    @GetMapping("/pays/{idpays}")
    public List<V_Annonce> findAllByIdpays(@PathVariable int idpays){
        return vaDao.findAllByIdpays(idpays);
    }

    @GetMapping("/boite_vitesse/{idbv}")
    public List<V_Annonce> findAllByIdbv(@PathVariable int idbv){
        return vaDao.findAllByIdbv(idbv);
    }

    @GetMapping("/prix/{prixmin}/{prixmax}")
    public List<V_Annonce> findAllByPrixBetween(@PathVariable("prixmin") double prixMin, @PathVariable("prixmax") double prixMax){
        return vaDao.findAllByPrixBetween(prixMin, prixMax);
    }

    @GetMapping("/annee/{anneemin}/{anneemax}")
    public List<V_Annonce> findAllByAnneeBetween(@PathVariable("anneemin") double anneeMin, @PathVariable("anneemax") double anneeMax){
        return vaDao.findAllByAnneeBetween(anneeMin, anneeMax);
    }
}
