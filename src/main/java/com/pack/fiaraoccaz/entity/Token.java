package com.pack.fiaraoccaz.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "token")
public class Token {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column
	Long id_utilisateur;
	@Column
	String token;
	@Column
	Date date_expiration;
	
	
	public Token(int id, Long id_utilisateur,String token, Date date_expiration) {
		super();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.token = token;
		this.date_expiration = date_expiration;
	}
	public Token() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getId_utilisateur() {
		return id_utilisateur;
	}
	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDate_expiration() {
		return date_expiration;
	}
	public void setDate_expiration(Date date_expiration) {
		this.date_expiration = date_expiration;
	}

	public boolean isValid(Long id){
		Date date = new Date(System.currentTimeMillis());
		if(this.getDate_expiration().after(date) && id == this.getId_utilisateur()){
			return true ;
		}
		return false ; 
	}
	
}

