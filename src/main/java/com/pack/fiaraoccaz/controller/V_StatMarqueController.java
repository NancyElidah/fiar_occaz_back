package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_StatMarqueDao;
import com.pack.fiaraoccaz.model.V_StatMarque;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/v_stat_marque")
public class V_StatMarqueController {
    private V_StatMarqueDao vsmDao;

    public V_StatMarqueController(V_StatMarqueDao vsmDao){
        this.vsmDao = vsmDao;
    }

    @GetMapping("/{status}")
    public List<V_StatMarque> findAllByStatus(@PathVariable int status){
        List<V_StatMarque> result = vsmDao.findAllByStatus(status);
        return result;
    }
}
