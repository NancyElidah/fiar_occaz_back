package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_StatModeleDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.V_StatModele;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/v_stat_modele")
public class V_StatModeleController {
    private V_StatModeleDao vsmDao;
    @Autowired
    private TokenRepository tokenRe ; 
    @Autowired
    private UserService userService;

    public V_StatModeleController(V_StatModeleDao vsmDao){
        this.vsmDao = vsmDao;
    }

    @GetMapping("/{token}/getstat/{idU}/{status}")
    public List<V_StatModele> findAllByStatus(@PathVariable("status") int status, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            List<V_StatModele> result = vsmDao.findAllByStatus(status);
            return result;
        }
        return new ArrayList<>();
    }
}
