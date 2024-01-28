package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Marque;
import com.pack.fiaraoccaz.service.MarqueService;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/marques")
public class MarqueController {

    private final MarqueService marqueService;
    @Autowired
    private TokenRepository tokenRe;
    @Autowired
    private UserService userService;

    @Autowired
    public MarqueController(MarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @PostMapping("/{token}/create/{id}")
    public Marque createMarque(@RequestBody Marque marque,
                               @PathVariable("token") String token,
                               @PathVariable("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return marqueService.createMarque(marque);
        }
        return null;
    }

    @GetMapping("/{token}/getAll/{id}")
    public List<Marque> getAllMarques(@PathVariable("token") String token,
                                      @PathVariable("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return marqueService.getAllMarques();
        }
        return null; 
    }

    @GetMapping("/{token}/getById/{id}/{idU}")
    public Optional<Marque> getMarqueById(@PathVariable Long id,
                                          @PathVariable("token") String token,
                                          @PathVariable("idU") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return marqueService.getMarqueById(id);
        }
        return Optional.empty(); 
    }

    @PutMapping("/{token}/update/{id}/{idU}")
    public Marque updateMarque(@PathVariable Long id,
                               @RequestBody Marque newMarque,
                               @PathVariable("token") String token,
                               @PathVariable("idU") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return marqueService.updateMarque(id, newMarque);
        }
        return null;  
    }

    @DeleteMapping("/{token}/delete/{id}")
    public void deleteMarque(@PathVariable Long id,
                             @PathVariable("token") String token,
                             @RequestParam("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            marqueService.deleteMarque(id);
        }
        
    }
}
