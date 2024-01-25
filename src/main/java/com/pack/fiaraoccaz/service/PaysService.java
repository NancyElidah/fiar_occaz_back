package com.pack.fiaraoccaz.service;

import com.pack.fiaraoccaz.entity.Pays;
import com.pack.fiaraoccaz.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaysService {

    @Autowired
    private PaysRepository paysRepository;

    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }

    public Optional<Pays> getPaysById(Long id) {
        return paysRepository.findById(id);
    }

    public Pays createPays(Pays pays) {
        return paysRepository.save(pays);
    }

    public Pays updatePays(Long id, Pays pays) {
        pays.setIdPays(id);
        return paysRepository.save(pays);
    }

    public void deletePays(Long id) {
        paysRepository.deleteById(id);
    }
}
