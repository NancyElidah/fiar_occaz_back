package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_StatTypeDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.V_StatType;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/v_stat_type")
public class V_StatTypeController {
    private V_StatTypeDao vstDao;
    @Autowired
    private TokenRepository tokenRe ; 
    @Autowired
    private UserService userService;

    public V_StatTypeController(V_StatTypeDao vstDao){
        this.vstDao = vstDao;
    }

    @GetMapping("/{token}/getstat/{idU}/{status}")
    public List<V_StatType> findAllByStatus(@PathVariable("status") int status, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            List<V_StatType> result = vstDao.findAllByStatus(status);
            return result;
        }
        return new ArrayList<>();
    }
}
