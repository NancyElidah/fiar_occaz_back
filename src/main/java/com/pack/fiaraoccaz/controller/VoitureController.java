package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Voiture;
import com.pack.fiaraoccaz.service.VoitureService;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;
    @Autowired
    private TokenRepository tokenRe;
    @Autowired
    private UserService userService;

    @GetMapping("/{token}/getAll/{id}")
    public List<Voiture> getAllVoitures(@PathVariable("token") String token, @PathVariable("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return voitureService.getAllVoitures();
        }
        return null; 
    }
}
