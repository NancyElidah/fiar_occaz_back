package com.pack.fiaraoccaz.model;

import jakarta.persistence.*;

@Entity
@Table(name = "commission")
public class Commission {
    @Id
    @Column(name = "idtype")
    int idtype;
    @Column(name = "commission")
    double commission;

    public int getIdtype() {
        return idtype;
    }
    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }
    public double getCommission() {
        return commission;
    }
    public void setCommission(double commission) {
        this.commission = commission;
    }
}
