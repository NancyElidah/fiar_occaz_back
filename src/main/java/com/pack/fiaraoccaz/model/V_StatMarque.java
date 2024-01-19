package com.pack.fiaraoccaz.model;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;

@Entity(name = "v_stat_marque")
@Immutable
public class V_StatMarque {
    @Id
    @Column(name = "idmarque")
    int idmarque;
    @Column(name = "marque")
    String marque;
    @Column(name = "nombre")
    int nombre;
    @Column(name = "status")
    int status;

    public int getIdmarque() {
        return idmarque;
    }
    public void setIdmarque(int idmarque) {
        this.idmarque = idmarque;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
