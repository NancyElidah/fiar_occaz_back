package com.pack.fiaraoccaz.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_StatTypeDao;
import com.pack.fiaraoccaz.model.V_StatType;

@RestController
@RequestMapping("/v_stat_type")
public class V_StatTypeController {
    private V_StatTypeDao vstDao;

    public V_StatTypeController(V_StatTypeDao vstDao){
        this.vstDao = vstDao;
    }

    @GetMapping("/{status}")
    public List<V_StatType> findAllByStatus(@PathVariable int status){
        List<V_StatType> result = vstDao.findAllByStatus(status);
        return result;
    }
}
