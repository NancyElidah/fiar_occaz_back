package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.CommissionDao;
import com.pack.fiaraoccaz.model.Commission;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/commission")
public class CommissionController {
    private CommissionDao cDao;

    public CommissionController(CommissionDao cDao){
        this.cDao = cDao;
    }

    @PostMapping
    public void save(@RequestBody Commission comm){
        cDao.save(comm);
    }

    @GetMapping
    public List<Commission> findAll(){
        return cDao.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        cDao.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commission> findById(@PathVariable int id){
        Commission result = cDao.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable int id, @RequestBody Commission comm){
        Commission c = cDao.findById(id);
        if (c != null) {
            comm.setIdtype(id);
            cDao.save(comm);
        }
    }
}
