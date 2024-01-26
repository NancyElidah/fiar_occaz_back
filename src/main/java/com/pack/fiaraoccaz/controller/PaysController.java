package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Pays;
import com.pack.fiaraoccaz.service.PaysService;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://localhost:3000")
@RestController
@RequestMapping("/api/pays")
public class PaysController {

    @Autowired
    private PaysService paysService;
    @Autowired
    private TokenRepository tokenRe;
    @Autowired
    private UserService userService;

    @GetMapping("/{token}/getAll")
    public List<Pays> getAllPays(@PathVariable("token") String token, @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return paysService.getAllPays();
        }
        return null;  
    }

    @GetMapping("/{token}/getById/{id}")
    public Optional<Pays> getPaysById(@PathVariable Long id,
                                      @PathVariable("token") String token,
                                      @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return paysService.getPaysById(id);
        }
        return Optional.empty(); 
    }

    @PostMapping("/{token}/create")
    public Pays createPays(@RequestBody Pays pays,
                           @PathVariable("token") String token,
                           @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return paysService.createPays(pays);
        }
        return null;  
    }

    @PutMapping("/{token}/update/{id}")
    public Pays updatePays(@PathVariable Long id,
                           @RequestBody Pays pays,
                           @PathVariable("token") String token,
                           @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return paysService.updatePays(id, pays);
        }
        return null; 
    }

    @DeleteMapping("/{token}/delete/{id}")
    public void deletePays(@PathVariable Long id,
                           @PathVariable("token") String token,
                           @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            paysService.deletePays(id);
        }
       
    }
}
