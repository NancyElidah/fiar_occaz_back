package com.pack.fiaraoccaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.V_Annonce;

public interface V_AnnonceRepository extends JpaRepository<V_Annonce, Integer> {
    List<V_Annonce> findAllByEtat(int etat);
    List<V_Annonce> findAllByIdtype(int idtype);
    List<V_Annonce> findAllByIdmarque(int idmarque);
    List<V_Annonce> findAllByIdmodele(int idmodele);
    List<V_Annonce> findAllByIdenergie(int idenergie);
    List<V_Annonce> findAllByIdcouleur(int idcouleur);
    List<V_Annonce> findAllByIdpays(int idpays);
    List<V_Annonce> findAllByIdbv(int idbv);
    List<V_Annonce> findAllByPrixBetween(double prixMin, double prixMax);
    List<V_Annonce> findAllByAnneeBetween(double anneeMin, double anneeMax);
}
