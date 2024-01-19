package com.pack.fiaraoccaz.model;

import org.springframework.data.annotation.Immutable;

import jakarta.persistence.*;

@Entity(name = "v_stat_type")
@Immutable
public class V_StatType {
    @Id
    @Column(name = "idtype")
    int idtype;
    @Column(name = "type")
    String type;
    @Column(name = "nombre")
    int nombre;
    @Column(name = "status")
    int status;

    public int getIdtype() {
        return idtype;
    }
    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
