/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.domain;

import com.jelena.knjizara.domain.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "zanr")
public class Zanr implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int zanrID;
    
    @NotNull
    private String nazivZanra;
    
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "zanr")
    private Set<Knjiga> knjiga = new HashSet<>();

    public Zanr() {
    }

    public Zanr(String nazivZanra) {
        this.nazivZanra = nazivZanra;
    }

    /**
     * @return the zanrID
     */
    public int getZanrID() {
        return zanrID;
    }

    /**
     * @param zanrID the zanrID to set
     */
    public void setZanrID(int zanrID) {
        this.zanrID = zanrID;
    }

    /**
     * @return the nazivZanra
     */
    public String getNazivZanra() {
        return nazivZanra;
    }

    /**
     * @param nazivZanra the nazivZanra to set
     */
    public void setNazivZanra(String nazivZanra) {
        this.nazivZanra = nazivZanra;
    }

   public Set<Knjiga> getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Set<Knjiga> knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String toString() {
        return getNazivZanra();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.zanrID;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Zanr other = (Zanr) obj;
        if (this.zanrID != other.zanrID) {
            return false;
        }
        if (!Objects.equals(this.nazivZanra, other.nazivZanra)) {
            return false;
        }
        return true;
    }
}
