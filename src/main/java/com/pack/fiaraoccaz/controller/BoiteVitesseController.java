package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.BoiteVitesseDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.BoiteVitesse;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/bv")
public class BoiteVitesseController {
    private BoiteVitesseDao bvDao;
    @Autowired
    private TokenRepository tokenRe ; 
    @Autowired
    private UserService userService;

    public BoiteVitesseController(BoiteVitesseDao bvDao){
        this.bvDao = bvDao;
    }

    @PostMapping("/{token}/add/{id}")
    public String save(@RequestBody BoiteVitesse bv, @PathVariable("token") String token ,@PathVariable("id") String idU) throws Exception{
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            bvDao.save(bv);
            return "Réussie";
        }
        return "Vous ne pouvez pas faire ce requête";
    }

    @GetMapping("/{token}/getall/{id}")
    public List<BoiteVitesse> findall(@PathVariable("token") String token ,@PathVariable("id") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU) ;

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return bvDao.findAll();
        }
        return new ArrayList<>();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        bvDao.deleteById(id);
    }

    @GetMapping("/{token}/getone/{idU}/{id}")
    public ResponseEntity<BoiteVitesse> findById(@PathVariable("id") String id, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long iduser =Long.valueOf(idU) ;

        User user = userService.findUser(iduser);
        if(tok!=null && tok.isValid(iduser) && user.getEtat()==10){
            int idBV = Integer.valueOf(id);
            BoiteVitesse result = bvDao.findById(idBV);
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{token}/update/{idU}/{id}")
    public void updateteById(@PathVariable("token") String token , @PathVariable("idU") String idU ,@PathVariable int id, @RequestBody BoiteVitesse bv){
        BoiteVitesse f = bvDao.findById(id);
        if (f != null) {
            bv.setIdBV(id);
            bvDao.save(bv);
        }
    }
}
