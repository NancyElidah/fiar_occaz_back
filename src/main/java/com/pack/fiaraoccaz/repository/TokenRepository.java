package com.pack.fiaraoccaz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pack.fiaraoccaz.entity.Token;

public interface TokenRepository extends JpaRepository<Token,Integer>  {
    @Query(
			  value = "SELECT * FROM token where token = ?1", 
			  nativeQuery = true)
	public Token findIdUtilsateurFromToken(String token);

    @Query(
			  value = "SELECT * FROM token where id_utilisateur = ?1", 
			  nativeQuery = true)
	public Token findTokenByUtilisateur(Long id);
}
