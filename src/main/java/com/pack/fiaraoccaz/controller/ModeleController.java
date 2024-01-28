package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.ModeleDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.Modele;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;


@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/modele")
public class ModeleController {
    private ModeleDao modeleDao;

    @Autowired
    private TokenRepository tokenRe ; 

    @Autowired
    private UserService userService;

    public ModeleController(ModeleDao modeleDao){
        this.modeleDao = modeleDao;
    }

    @PostMapping("/{token}/add/{id}")
    public String save(@RequestBody Modele type , @PathVariable("token") String token ,@PathVariable("id") String idU )throws Exception{
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null&&tok.isValid(id)&&user.getEtat()==10){
            modeleDao.save(type);
            return "Réussie";
        }
        return "Vous ne pouvez pas faire ce requête";
    }

    @GetMapping("/{token}/getall/{id}")
    public List<Modele> findall(@PathVariable("token") String token ,@PathVariable("id") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return modeleDao.findAll();
        }
        return new ArrayList<>();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        modeleDao.deleteById(id);
    }

    @GetMapping("/{token}/getone/{idU}/{id}")
    public ResponseEntity<Modele> findById(@PathVariable("id") String id, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long iduser =Long.valueOf(idU) ;

        User user = userService.findUser(iduser);
        if(tok!=null && tok.isValid(iduser) && user.getEtat()==10){
            int idm = Integer.valueOf(id);
            Modele result = modeleDao.findById(idm);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{token}/update/{id}/{idU}")
    public void updateById(@PathVariable int id, @PathVariable("token") String token ,@PathVariable("idU") String idU, @RequestBody Modele modele){
        Modele f = modeleDao.findById(id);
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long iduser =Long.valueOf(idU) ;

        User user = userService.findUser(iduser);
        if(tok!=null && tok.isValid(iduser) && user.getEtat()==10){
        if (f != null) {
            modele.setIdModele(id);
            modeleDao.save(modele);
        }}
    }
}
