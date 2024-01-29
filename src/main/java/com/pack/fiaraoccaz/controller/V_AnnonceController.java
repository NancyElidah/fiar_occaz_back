package com.pack.fiaraoccaz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pack.fiaraoccaz.dao.V_AnnonceDao;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.model.V_Annonce;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/v_annonce")
public class V_AnnonceController {
    private V_AnnonceDao vaDao;
    @Autowired
    private TokenRepository tokenRe ; 
    @Autowired
    private UserService userService;

    public V_AnnonceController(V_AnnonceDao vaDao){
        this.vaDao = vaDao;
    }

    @GetMapping("/{token}/getstat/{idU}/{etat}")
    public List<V_Annonce> findAllByEtat(@PathVariable("etat") int etat, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByEtat(etat);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/type/{idtype}")
    public List<V_Annonce> findAllByIdtype(@PathVariable("idtype") int idtype, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){ 
            return vaDao.findAllByIdtype(idtype);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/marque/{idmarque}")
    public List<V_Annonce> findAllByIdmarque(@PathVariable("idmarque") int idmarque, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByIdmarque(idmarque);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/modele/{idmodele}")
    public List<V_Annonce> findAllByIdmodele(@PathVariable("idmodele") int idmodele, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByIdmodele(idmodele);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/energie/{idenergie}")
    public List<V_Annonce> findAllByIdenergie(@PathVariable("idenergie") int idenergie, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByIdenergie(idenergie);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/couleur/{idcouleur}")
    public List<V_Annonce> findAllByIdcouleur(@PathVariable("idcouleur") int idcouleur, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByIdcouleur(idcouleur);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/pays/{idpays}")
    public List<V_Annonce> findAllByIdpays(@PathVariable("idpays") int idpays, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByIdpays(idpays);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/boite_vitesse/{idbv}")
    public List<V_Annonce> findAllByIdbv(@PathVariable("idbv") int idbv, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByIdbv(idbv);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/prix/{prixmin}/{prixmax}")
    public List<V_Annonce> findAllByPrixBetween(@PathVariable("prixmin") double prixMin, @PathVariable("prixmax") double prixMax, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByPrixBetween(prixMin, prixMax);
        }
        return new ArrayList<>();
    }

    @GetMapping("/{token}/{idU}/annee/{anneemin}/{anneemax}")
    public List<V_Annonce> findAllByAnneeBetween(@PathVariable("anneemin") double anneeMin, @PathVariable("anneemax") double anneeMax, @PathVariable("token") String token ,@PathVariable("idU") String idU){
        Token tok = tokenRe.findIdUtilsateurFromToken(token); 
        Long id =Long.valueOf(idU);

        User user = userService.findUser(id);
        if(tok!=null && tok.isValid(id) && user.getEtat()==10){
            return vaDao.findAllByAnneeBetween(anneeMin, anneeMax);
        }
        return new ArrayList<>();
    }
}
