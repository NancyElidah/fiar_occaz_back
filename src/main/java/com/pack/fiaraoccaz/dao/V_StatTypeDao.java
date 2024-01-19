package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.V_StatType;
import com.pack.fiaraoccaz.repository.V_StatTypeRepository;

@Service
public class V_StatTypeDao {
    private V_StatTypeRepository vstRepository;

    public V_StatTypeDao(V_StatTypeRepository vstRepository){
        this.vstRepository = vstRepository;
    }

    public List<V_StatType> findAllByStatus(int status){
        return vstRepository.findAllByStatus(status);
    }
    
}
