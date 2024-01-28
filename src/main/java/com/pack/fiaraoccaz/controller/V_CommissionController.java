package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_CommissionDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.V_Commission;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/v_commission")
public class V_CommissionController {
    private V_CommissionDao vsmDao;
    @Autowired
    private TokenRepository tokenRe ; 
    @Autowired
    private UserService userService;

    public V_CommissionController(V_CommissionDao vsmDao){
        this.vsmDao = vsmDao;
    }

    @GetMapping("/{token}/getall/{idU}")
    public List<V_Commission> findAll(@PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            List<V_Commission> result = vsmDao.findAll();
            return result;
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/getone/{idU}/{id}")
    public ResponseEntity<V_Commission> findById(@PathVariable("id") String id, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long iduser =Long.valueOf(idU) ;

        User user = userService.findUser(iduser);
        if(tok!=null && tok.isValid(iduser) && user.getEtat()==10){
            int idm = Integer.valueOf(id);
            V_Commission result = vsmDao.findById(idm);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }
    
}