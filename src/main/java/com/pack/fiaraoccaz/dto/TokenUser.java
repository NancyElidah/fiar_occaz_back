package com.pack.fiaraoccaz.dto;

public class TokenUser {
    private Long idUser ;
    private String token ;
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public TokenUser(Long idUser, String token) {
        this.idUser = idUser;
        this.token = token;
    }
    public TokenUser(){}

    
}
