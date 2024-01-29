package com.pack.fiaraoccaz.service;

import com.pack.fiaraoccaz.entity.Annonce;
import com.pack.fiaraoccaz.entity.User;
import com.pack.fiaraoccaz.entity.Voiture;
import com.pack.fiaraoccaz.repository.AnnonceRepository;
import com.pack.fiaraoccaz.service.VoitureService;

import java.util.List;


import com.pack.fiaraoccaz.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;
import java.util.*;

@Service
public class AnnonceService {

    private final AnnonceRepository annonceRepository;
    private final VoitureService voitureService; 

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository, VoitureService voitureService) {
        this.annonceRepository = annonceRepository;
        this.voitureService = voitureService;
    }

    @Autowired
    private UserRepository userRepository; 



    public Annonce validerAnnonce(Long idAnnonce) {
        Annonce annonce = annonceRepository.findById(idAnnonce).orElse(null);

        if (annonce != null) {
            annonce.setEtat(1); // Mettez l'état à 1 pour valider l'annonce
            return annonceRepository.save(annonce);
        }

        return null; // L'annonce n'a pas été trouvée
    }



    public List<Annonce> rechercheAvancee(String motCle,Long type, Long marque, Long modele, Long energie, Long boite_vitesse, int annee, double kilometrage, double prix, Long couleur, Long pays,int nbplace, int nbporte,int status) {
        Specification<Annonce> specification = Specification.where(null);

        if (motCle != null && !motCle.isEmpty()) {
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("titre")), "%" + motCle.toLowerCase() + "%"));

            //des conditions pour les champs de l'entité Voiture
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("type").get("nom")), "%" + motCle.toLowerCase() + "%"));
            
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("marque").get("nom")), "%" + motCle.toLowerCase() + "%"));
            
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("modele").get("nom")), "%" + motCle.toLowerCase() + "%"));
            
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("energie").get("nom")), "%" + motCle.toLowerCase() + "%"));
                    
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("boite_vitesse").get("nom")), "%" + motCle.toLowerCase() + "%"));
            
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("annee").get("nom")), "%" + motCle.toLowerCase() + "%"));
            
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("kilometrage").get("nom")), "%" + motCle.toLowerCase() + "%"));
             

            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("prix").get("nom")), "%" + motCle.toLowerCase() + "%"));
             
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("couleur").get("nom")), "%" + motCle.toLowerCase() + "%"));
            
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("pays").get("nom")), "%" + motCle.toLowerCase() + "%"));
                
            
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("nbplace").get("nom")), "%" + motCle.toLowerCase() + "%"));
             
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("nbporte").get("nom")), "%" + motCle.toLowerCase() + "%"));
            
            specification = specification.or((root, query, builder) ->
                    builder.like(builder.lower(root.get("voiture").get("status").get("nom")), "%" + motCle.toLowerCase() + "%"));
                
                }

    

        return annonceRepository.findAll(specification);
    }


    public List<Annonce> getHistoriqueAnnoncesUtilisateur(Long idUtilisateur) {
        Optional<User> userOptional = userRepository.findById(idUtilisateur);
    
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user.getAnnonces();
        }
    
        return Collections.emptyList();
    }
    


  //annonce validee
public List<Annonce> findAll() {
    Specification<Annonce> specification = Specification.where((root, query, builder) ->
            builder.equal(root.get("etat"), 1));

    return annonceRepository.findAll(specification);
}


    public void save(Annonce c, Voiture voiture) {
        // Création ou mise à jour de la voiture
        Voiture savedVoiture = voitureService.createVoiture(voiture);

        if (savedVoiture != null) {
            // Associer la voiture créée ou mise à jour à l'annonce
            c.setVoiture(savedVoiture);

            // Sauvegarder l'annonce avec la voiture associée
            annonceRepository.save(c);
        } else {
            throw new VoitureCreationException("Impossible de créer ou mettre à jour la voiture.");
        }
    }

    public class VoitureCreationException extends RuntimeException {

        public VoitureCreationException(String message) {
            super(message);
        }
    }
    



    public void deleteById(int id) {
        annonceRepository.deleteById((long) id);
    }

    public Annonce findById(int id){
        Annonce result = annonceRepository.findById((long) id).orElse(null);
        return result; 
    }

    public Annonce updateById(Long id, Annonce updatedAnnonce) {
        
        if (annonceRepository.existsById(id)) {
            
            updatedAnnonce.setIdAnnonce(id);
            return annonceRepository.save(updatedAnnonce);
        } else {
           
            return null;
        }
    }
    

    

}
