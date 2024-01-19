package com.pack.fiaraoccaz.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pack.fiaraoccaz.model.V_StatMarque;
import com.pack.fiaraoccaz.repository.V_StatMarqueRepository;

@Service
public class V_StatMarqueDao {
    private V_StatMarqueRepository vsmRepository;

    public V_StatMarqueDao(V_StatMarqueRepository vsmRepository){
        this.vsmRepository = vsmRepository;
    }

    public List<V_StatMarque> findAllByStatus(int status){
        return vsmRepository.findAllByStatus(status);
    }
}
