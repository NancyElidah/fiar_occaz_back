package com.pack.fiaraoccaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pack.fiaraoccaz.model.V_Annonce;

public interface V_AnnonceRepository extends JpaRepository<V_Annonce, Integer> {
    List<V_Annonce> findAllByEtat(int etat);
}
