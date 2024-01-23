package com.pack.fiaraoccaz.service;

import com.pack.fiaraoccaz.entity.Voiture;
import com.pack.fiaraoccaz.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }


}
