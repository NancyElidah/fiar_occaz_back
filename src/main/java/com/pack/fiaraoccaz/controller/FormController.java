package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.FormDao;
import com.pack.fiaraoccaz.model.Form;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/form")
public class FormController {
    private FormDao typedao;

    public FormController(FormDao typedao){
        this.typedao = typedao;
    }

    @PostMapping
    public void saveType(@RequestBody Form type){
        typedao.save(type);
    }

    @GetMapping
    public List<Form> findall(){
        return typedao.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        typedao.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Form> findById(@PathVariable int id){
        Form result = typedao.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public void deleteById(@PathVariable int id, @RequestBody Form type){
        Form f = typedao.findById(id);
        if (f != null) {
            type.setIdType(id);
            typedao.save(type);
        }
    }
}
