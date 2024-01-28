package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Energie;
import com.pack.fiaraoccaz.service.EnergieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/api/energies")
public class EnergieController {

    private final EnergieService energieService;

    @Autowired
    public EnergieController(EnergieService energieService) {
        this.energieService = energieService;
    }

    @GetMapping
    public List<Energie> getAllEnergies() {
        return energieService.getAllEnergies();
    }

    @GetMapping("/{id}")
    public Optional<Energie> getEnergieById(@PathVariable Long id) {
        return energieService.getEnergieById(id);
    }

    @PostMapping
    public Energie saveEnergie(@RequestBody Energie energie) {
        return energieService.saveEnergie(energie);
    }

    @DeleteMapping("/{id}")
    public void deleteEnergie(@PathVariable Long id) {
        energieService.deleteEnergie(id);
    }
}
