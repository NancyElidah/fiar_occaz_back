package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_StatMarqueDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.V_StatMarque;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;

@RestController
@RequestMapping("/v_stat_marque")
public class V_StatMarqueController {
    private V_StatMarqueDao vsmDao;
    @Autowired
    private TokenRepository tokenRe ; 
    @Autowired
    private UserService userService;

    public V_StatMarqueController(V_StatMarqueDao vsmDao){
        this.vsmDao = vsmDao;
    }

    @GetMapping("/{token}/getstat/{idU}/{status}")
    public List<V_StatMarque> findAllByStatus(@PathVariable int status, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            List<V_StatMarque> result = vsmDao.findAllByStatus(status);
            return result;
        }
        return new ArrayList<>();
    }
}
