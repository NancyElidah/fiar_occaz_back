package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Pays;
import com.pack.fiaraoccaz.service.PaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/api/pays")
public class PaysController {

    @Autowired
    private PaysService paysService;

    @GetMapping
    public List<Pays> getAllPays() {
        return paysService.getAllPays();
    }

    @GetMapping("/{id}")
    public Optional<Pays> getPaysById(@PathVariable Long id) {
        return paysService.getPaysById(id);
    }

    @PostMapping
    public Pays createPays(@RequestBody Pays pays) {
        return paysService.createPays(pays);
    }

    @PutMapping("/{id}")
    public Pays updatePays(@PathVariable Long id, @RequestBody Pays pays) {
        return paysService.updatePays(id, pays);
    }

    @DeleteMapping("/{id}")
    public void deletePays(@PathVariable Long id) {
        paysService.deletePays(id);
    }
}
