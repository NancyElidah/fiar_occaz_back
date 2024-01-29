package com.pack.fiaraoccaz.controller;

import com.pack.fiaraoccaz.entity.Annonce;
import com.pack.fiaraoccaz.service.AnnonceService;
import com.pack.fiaraoccaz.service.UserService;
import com.pack.fiaraoccaz.repository.TokenRepository;
import com.pack.fiaraoccaz.entity.Token;
import com.pack.fiaraoccaz.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "https://earnest-gumption-0c0eac.netlify.app")
@RestController
@RequestMapping("/api/annonces")
public class AnnonceController {

    private final AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @Autowired
    private TokenRepository tokenRe ; 

    @Autowired
    private UserService userService;


    @PostMapping("/{token}/valider/{idAnnonce}/{idU}")
    public ResponseEntity<?> validerAnnonce(
            @PathVariable Long idAnnonce,
            @PathVariable("token") String token,
            @PathVariable("idU") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);
        User user = userService.findUser(id);
    
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            Annonce annonce = annonceService.validerAnnonce(idAnnonce);
            return ResponseEntity.ok(annonce);
        } else {
            return ResponseEntity.badRequest().body("Vous ne pouvez pas valider l'annonce");
        }
    }
    


    @GetMapping("/recherche")
    public List<Annonce> rechercheAvancee(
            @RequestParam(required = false) String motCle,
            @RequestParam(required = false) Long type,
            @RequestParam(required = false) Long marque,
            @RequestParam(required = false) Long modele,
            @RequestParam(required = false) Long energie,
            @RequestParam(required = false) Long boite_vitesse,
            @RequestParam(required = false) int annee,
            @RequestParam(required = false) double kilometrage,
            @RequestParam(required = false) double prix,
            @RequestParam(required = false) Long couleur,
            @RequestParam(required = false) Long pays,
            @RequestParam(required = false) int nbplace,
            @RequestParam(required = false) int nbporte,
            @RequestParam(required = false) int status ) {
        return annonceService.rechercheAvancee(motCle, type, marque, modele, energie, boite_vitesse, annee, kilometrage, prix, couleur, pays, nbplace, nbporte, status );
    }


    @PostMapping("/{token}/add/{id}")
    public String save(@RequestBody Annonce comm, @PathVariable("token") String token, @PathVariable("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);
    
        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            
            try {
                annonceService.save(comm, comm.getVoiture());
                return "Réussie";
            } catch (VoitureCreationException e) {
                return "Échec de la création ou de la mise à jour de la voiture.";
            }
        }
        return "Vous ne pouvez pas faire cette requête";
    }

    public class VoitureCreationException extends RuntimeException {

        public VoitureCreationException(String message) {
            super(message);
        }
    }
    

    @GetMapping("/{token}/getAll/{id}")
    public ResponseEntity<List<Annonce>> findAll(
            @PathVariable("token") String token,
            @PathVariable("id") String idU) throws Exception {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long id = Long.valueOf(idU);
    
        User user = userService.findUser(id);
        if (tok != null && tok.isValid(id) && user.getEtat() == 10) {
            List<Annonce> annonces = annonceService.findAll();
            return ResponseEntity.ok(annonces);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id, @RequestHeader("token") String token, @RequestHeader("id") String idU) {
        try {
            Token tok = tokenRe.findIdUtilsateurFromToken(token);
            Long userId = Long.valueOf(idU);
    
            User user = userService.findUser(userId);
    
            if (tok != null && tok.isValid(userId) && user.getEtat() == 10) {
                annonceService.deleteById(id);
                return new ResponseEntity<>("Annonce supprimée avec succès", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Vous n'êtes pas autorisé à supprimer cette annonce", HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Une erreur s'est produite lors de la suppression de l'annonce", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{token}/getOne/{idU}/{id}")
public ResponseEntity<Annonce> findById(@PathVariable int id, @PathVariable("token") String token, @PathVariable("idU") String idU) {
    try {
        Token tok = tokenRe.findIdUtilsateurFromToken(token);
        Long userId = Long.valueOf(idU);

        User user = userService.findUser(userId);

        if (tok != null && tok.isValid(userId) && user.getEtat() == 10) {
            Annonce result = annonceService.findById(id);
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}


        @PutMapping("/{id}")
        public ResponseEntity<Annonce> updateById(@PathVariable Long id, @RequestBody Annonce updatedAnnonce, @RequestHeader("token") String token, @RequestHeader("id") String idU) {
            try {
                Token tok = tokenRe.findIdUtilsateurFromToken(token);
                Long userId = Long.valueOf(idU);
        
                User user = userService.findUser(userId);
        
                if (tok != null && tok.isValid(userId) && user.getEtat() == 10) {
                    Annonce updatedAnnonceResult = annonceService.updateById(id, updatedAnnonce);
        
                    if (updatedAnnonceResult != null) {
                        return ResponseEntity.ok(updatedAnnonceResult);
                    } else {
                        return ResponseEntity.notFound().build();
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            }
    }
}
