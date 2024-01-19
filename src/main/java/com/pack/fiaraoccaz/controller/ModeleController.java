package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.ModeleDao;
import com.pack.fiaraoccaz.model.Modele;

@RestController
@RequestMapping("/modele")
public class ModeleController {
    private ModeleDao modeleDao;

    public ModeleController(ModeleDao modeleDao){
        this.modeleDao = modeleDao;
    }

    @PostMapping
    public void saveType(@RequestBody Modele type){
        modeleDao.save(type);
    }

    @GetMapping
    public List<Modele> findall(){
        return modeleDao.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        modeleDao.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modele> findById(@PathVariable int id){
        Modele result = modeleDao.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public void deleteById(@PathVariable int id, @RequestBody Modele modele){
        Modele f = modeleDao.findById(id);
        if (f != null) {
            modele.setIdModele(id);
            modeleDao.save(modele);
        }
    }
}
