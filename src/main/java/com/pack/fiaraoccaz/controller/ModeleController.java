package com.pack.fiaraoccaz.controller;

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
    public String saveType(@RequestBody Modele type , @PathVariable("token") String token ,@PathVariable("id") String idU )throws Exception{
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null&&tok.isValid(id)&&user.getEtat()==10){
            modeleDao.save(type);
            return "Réussie";
        }
        return "Vous ne pouvez pas faire ce requête";
    }

    @GetMapping
    public List<Modele> findall(){
        return modeleDao.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        modeleDao.deleteById(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modele> findById(@PathVariable int id){
        Modele result = modeleDao.findById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public void deleteById(@PathVariable int id, @RequestBody Modele modele){
        Modele f = modeleDao.findById(id);
        if (f != null) {
            modele.setIdModele(id);
            modeleDao.save(modele);
        }
    }
}
