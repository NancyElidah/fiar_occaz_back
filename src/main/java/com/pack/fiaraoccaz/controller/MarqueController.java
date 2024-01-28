package com.pack.fiaraoccaz.controller;
import com.pack.fiaraoccaz.service.MarqueService;
import com.pack.fiaraoccaz.entity.Marque;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("api/marques")
public class MarqueController {

    private final MarqueService marqueService;

    @Autowired
    public MarqueController(MarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @PostMapping
    public Marque createMarque(@RequestBody Marque marque) {
        return marqueService.createMarque(marque);
    }

    @GetMapping
    public List<Marque> getAllMarques() {
        return marqueService.getAllMarques();
    }

    @GetMapping("/{id}")
    public Optional<Marque> getMarqueById(@PathVariable Long id) {
        return marqueService.getMarqueById(id);
    }

    @PutMapping("/{id}")
    public Marque updateMarque(@PathVariable Long id, @RequestBody Marque newMarque) {
        return marqueService.updateMarque(id, newMarque);
    }

    @DeleteMapping("/{id}")
    public void deleteMarque(@PathVariable Long id) {
        marqueService.deleteMarque(id);
    }
}
