package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.V_StatModele;
import com.pack.fiaraoccaz.repository.V_StatModeleRepository;

@Service
public class V_StatModeleDao {
    private V_StatModeleRepository vsmRepository;

    public V_StatModeleDao(V_StatModeleRepository vsmRepository){
        this.vsmRepository = vsmRepository;
    }

    public List<V_StatModele> findAllByStatus(int status){
        return vsmRepository.findAllByStatus(status);
    }
}
