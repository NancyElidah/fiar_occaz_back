package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Energie;
import com.pack.fiaraoccaz.service.EnergieService;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/api/energies")
public class EnergieController {

    private final EnergieService energieService;
    @Autowired
    private TokenRepository tokenRe;
    @Autowired
    private UserService userService;

    @Autowired
    public EnergieController(EnergieService energieService) {
        this.energieService = energieService;
    }

    @GetMapping("/{token}/getAll/{id}")
    public List<Energie> getAllEnergies(@PathVariable("token") String token,
                                        @PathVariable("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return energieService.getAllEnergies();
        }
        return null; 
    }

    @GetMapping("/{token}/getById/{id}/{idU}")
    public Optional<Energie> getEnergieById(@PathVariable Long id,
                                            @PathVariable("token") String token,
                                            @PathVariable("idU") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return energieService.getEnergieById(id);
        }
        return Optional.empty(); 
    }

    @PostMapping("/{token}/save/{id}")
    public Energie saveEnergie(@RequestBody Energie energie,
                                @PathVariable("token") String token,
                                @PathVariable("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            return energieService.saveEnergie(energie);
        }
        return null;
    }

    @DeleteMapping("/{token}/delete/{id}/idU")
    public void deleteEnergie(@PathVariable Long id,
                              @PathVariable("token") String token,
                              @RequestParam("idU") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        id = Long.valueOf(idU);

        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            energieService.deleteEnergie(id);
        }
        
    }
}
