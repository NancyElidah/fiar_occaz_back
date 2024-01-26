package com.pack.fiaraoccaz.controller;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.dto.UserLoginRequest;
import com.pack.fiaraoccaz.service.UserService;
import com.pack.fiaraoccaz.util.TokenG;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenRepository tokenRe ; 

    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody UserLoginRequest request) {
        User user = userService.loginUser(request.getEmail(), request.getPassword());
        String token = "vide";
        HashMap<String,Object> map = new HashMap<>();
        if (user != null) {
            Token tok = tokenRe.findTokenByUtilisateur(user.getIdUser());
            Date date = new Date(System.currentTimeMillis());
            if(tok!=null && tok.getDate_expiration().after(date)){
                System.out.println(tok.getToken());

                map.put("token",tok.getToken());
                map.put("user",user.getIdUser());
                map.put("name",user.getNom());
                map.put("status",user.getEtat());
            }else{
                token = TokenG.genererToken(user);
                LocalDate  localDate = LocalDate.now();
                LocalDate plusDays = localDate.plusDays(2);


                Token t = new Token();

                if (!token.equals("vide")) {
                    t.setToken(token);
                    t.setId_utilisateur(user.getIdUser());
                    t.setDate_expiration(java.sql.Date.valueOf(plusDays));
                    tokenRe.save(t);
                    System.out.println(t.getToken());
                    map.put("token",t.getToken());
                    map.put("user",user.getIdUser());
                    map.put("name",user.getNom());
                    map.put("status",user.getEtat());
                }
            }
        }
        return map ; 
    }


}
