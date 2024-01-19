package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.Form;
import com.pack.fiaraoccaz.repository.FormRepository;

@Service
public class FormDao {
    private final FormRepository typerepository;

    @Autowired
    public FormDao(FormRepository typerepository){
        this.typerepository = typerepository;
    }

    public List<Form> findAll(){
        List<Form> typelist = typerepository.findAll();
        return typelist;
    }

    public void save(Form type){
        typerepository.save(type);
    }

    public void deleteById(int id) {
        typerepository.deleteById(id);
    }

    public Form findById(int id){
        Form result = typerepository.findById(id).orElse(null);
        return result; 
    }

}
