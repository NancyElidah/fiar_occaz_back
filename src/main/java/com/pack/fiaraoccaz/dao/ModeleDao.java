package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.Modele;
import com.pack.fiaraoccaz.repository.ModeleRepository;

@Service
public class ModeleDao {
    private final ModeleRepository modelerepository;

    public ModeleDao(ModeleRepository modelerepository){
        this.modelerepository = modelerepository;
    }

    public List<Modele> findAll(){
        List<Modele> modelelist = modelerepository.findAll();
        return modelelist;
    }

    public void save(Modele modele){
        modelerepository.save(modele);
    }

    public void deleteById(int id) {
        modelerepository.deleteById(id);
    }

    public Modele findById(int id){
        Modele result = modelerepository.findById(id).orElse(null);
        return result; 
    }
}
