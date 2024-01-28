package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_AnnonceDao;
import com.pack.fiaraoccaz.model.V_Annonce;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
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
}
