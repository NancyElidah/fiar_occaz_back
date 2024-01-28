package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.FormDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.Form;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/form")
public class FormController {
    private FormDao typedao;
    @Autowired
    private TokenRepository tokenRe ; 
    @Autowired
    private UserService userService;

    public FormController(FormDao typedao){
        this.typedao = typedao;
    }

    @PostMapping("/{token}/add/{id}")
    public String save(@RequestBody Form type,  @PathVariable("token") String token ,@PathVariable("id") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            typedao.save(type);
            return "Réussie";
        }
        return "Vous ne pouvez pas faire ce requête";
    }

    @GetMapping("/{token}/getall/{id}")
    public List<Form> findall(@PathVariable("token") String token ,@PathVariable("id") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return typedao.findAll();
        }
        return new ArrayList<>();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        typedao.deleteById(id);
    }

    @GetMapping("/{token}/getone/{idU}/{id}")
    public ResponseEntity<Form> findById(@PathVariable("id") String id, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long iduser =Long.valueOf(idU) ;

        User user = userService.findUser(iduser);
        if(tok!=null && tok.isValid(iduser) && user.getEtat()==10){
            int idt = Integer.valueOf(id);
            Form result = typedao.findById(idt);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{token}/update/{id}/{idU}")
    public void updateById(@PathVariable int id, @PathVariable("token") String token ,@PathVariable("idU") String idU, @RequestBody Form type){
        Form f = typedao.findById(id);
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long iduser =Long.valueOf(idU) ;

        User user = userService.findUser(iduser);
        if(tok!=null && tok.isValid(iduser) && user.getEtat()==10){
            if (f != null) {
                type.setIdType(id);
                typedao.save(type);
            }
        }
    }
}
