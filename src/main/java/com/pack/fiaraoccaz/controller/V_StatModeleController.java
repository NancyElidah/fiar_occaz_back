package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_StatModeleDao;
import com.pack.fiaraoccaz.model.V_StatModele;

@RestController
@RequestMapping("/v_stat_modele")
public class V_StatModeleController {
    private V_StatModeleDao vsmDao;

    public V_StatModeleController(V_StatModeleDao vsmDao){
        this.vsmDao = vsmDao;
    }

    @GetMapping("/{status}")
    public List<V_StatModele> findAllByStatus(@PathVariable int status){
        List<V_StatModele> result = vsmDao.findAllByStatus(status);
        return result;
    }
}
