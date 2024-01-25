package com.pack.fiaraoccaz.controller;

import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.FavorisDao;
import com.pack.fiaraoccaz.model.Favoris;

@RestController
@RequestMapping("/favoris")
public class FavorisController {
    private FavorisDao favorisDao;

    public FavorisController(FavorisDao favorisDao){
        this.favorisDao = favorisDao;
    }

    @PostMapping
    public void save(@RequestBody Favoris fav){
        favorisDao.save(fav);
    }
}
