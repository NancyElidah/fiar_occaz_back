package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.Commission;
import com.pack.fiaraoccaz.repository.CommissionRepository;

@Service
public class CommissionDao {
    private final CommissionRepository cRepository;

    public CommissionDao(CommissionRepository cRepository){
        this.cRepository = cRepository;
    }

    public List<Commission> findAll(){
        List<Commission> clist = cRepository.findAll();
        return clist;
    }

    public void save(Commission c){
        cRepository.save(c);
    }

    public void deleteById(int id) {
        cRepository.deleteById(id);
    }

    public Commission findById(int id){
        Commission result = cRepository.findById(id).orElse(null);
        return result; 
    }
}
