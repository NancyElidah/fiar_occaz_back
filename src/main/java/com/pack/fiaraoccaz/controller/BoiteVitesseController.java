package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.BoiteVitesseDao;
import com.pack.fiaraoccaz.model.BoiteVitesse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bv")
public class BoiteVitesseController {
    private BoiteVitesseDao bvDao;

    public BoiteVitesseController(BoiteVitesseDao bvDao){
        this.bvDao = bvDao;
    }

    @PostMapping
    public void save(@RequestBody BoiteVitesse bv){
    bvDao.save(bv);
    }

    @GetMapping
    public List<BoiteVitesse> findall(){
        return bvDao.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        bvDao.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoiteVitesse> findById(@PathVariable int id){
        BoiteVitesse result = bvDao.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public void deleteById(@PathVariable int id, @RequestBody BoiteVitesse bv){
        BoiteVitesse f = bvDao.findById(id);
        if (f != null) {
            bv.setIdBV(id);
            bvDao.save(bv);
        }
    }
}
