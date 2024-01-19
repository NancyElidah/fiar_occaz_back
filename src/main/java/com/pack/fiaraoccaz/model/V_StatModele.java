package com.pack.fiaraoccaz.model;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;

@Entity(name = "v_stat_modele")
@Immutable
public class V_StatModele {
    @Id
    @Column(name = "idmodele")
    int idmodele;
    @Column(name = "modele")
    String modele;
    @Column(name = "nombre")
    int nombre;
    @Column(name = "status")
    int status;

    public int getIdmodele() {
        return idmodele;
    }
    public void setIdmodele(int idmodele) {
        this.idmodele = idmodele;
    }
    public String getModele() {
        return modele;
    }
    public void setModele(String modele) {
        this.modele = modele;
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
