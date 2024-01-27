package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.V_Commission;
import com.pack.fiaraoccaz.repository.V_CommissionRepository;

@Service
public class V_CommissionDao {
    private final V_CommissionRepository vcRepository;

    public V_CommissionDao(V_CommissionRepository vcRepository){
        this.vcRepository = vcRepository;
    }

    public List<V_Commission> findAll(){
        List<V_Commission> vclist = vcRepository.findAll();
        return vclist;
    }

    public V_Commission findById(int id){
        V_Commission result = vcRepository.findById(id).orElse(null);
        return result; 
    }
}
