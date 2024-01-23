package com.pack.fiaraoccaz.entity;
import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;
import jakarta.persistence.*;

@Entity
@Table(name = "energie")
public class Energie{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idenergie")
    private Long idenergie;

    @Column(name = "energie", nullable = false)
    private String energie;

    //constructeur par defaut
    public Energie(){

    }
    //constructeur avec parametres

    public Energie(String energie){
        this.energie = energie;
    }

    //Gettters and setters
    public Long getIdEnergie(){
        return idenergie;
    }
    public void setIdEnergie(Long idenergie){
        this.idenergie = idenergie;
    }

    public String getEnergie(){
        return energie;
    }
    public void setEnergie(String energie){
        this.energie = energie;
    }
}