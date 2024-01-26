package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.CommissionDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.Commission;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/commission")
public class CommissionController {
    private CommissionDao cDao;
    @Autowired
    private TokenRepository tokenRe ; 
    @Autowired
    private UserService userService;

    public CommissionController(CommissionDao cDao){
        this.cDao = cDao;
    }

    @PostMapping("/{token}/add/{id}")
    public String save(@RequestBody Commission comm, @PathVariable("token") String token ,@PathVariable("id") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            cDao.save(comm);
            return "Réussie";
        }
        return "Vous ne pouvez pas faire ce requête";
    }

    @GetMapping("/{token}/getall/{id}")
    public List<Commission> findAll(@PathVariable("token") String token ,@PathVariable("id") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return cDao.findAll();
        }
        return new ArrayList<>();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        cDao.deleteById(id);
    }

    @GetMapping("/{token}/getone/{idU}/{id}")
    public ResponseEntity<Commission> findById(@PathVariable("id") String id, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long iduser =Long.valueOf(idU) ;

        User user = userService.findUser(iduser);
        if(tok!=null && tok.isValid(iduser) && user.getEtat()==10){
            int idc = Integer.valueOf(id);
            Commission result = cDao.findById(idc);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable int id, @RequestBody Commission comm){
        Commission c = cDao.findById(id);
        if (c != null) {
            comm.setIdtype(id);
            cDao.save(comm);
        }
    }
}
