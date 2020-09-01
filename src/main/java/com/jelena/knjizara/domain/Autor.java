/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.domain;

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
@Table(name = "autor")
public class Autor implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int autorID;

    @NotNull
    private String ime;

    @NotNull
    private String prezime;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "autor")
    private Set<Knjiga> knjiga = new HashSet<>();

    public Autor() {
    }

    public Autor( String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getAutorID() {
        return autorID;
    }

    public void setAutorID(int autorID) {
        this.autorID = autorID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Set<Knjiga> getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Set<Knjiga> knjiga) {
        this.knjiga = knjiga;
    }


    @Override
    public String toString() {
        return new StringBuilder()
                .append(getIme()).append(" ")
                .append(getPrezime()).toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + this.autorID;
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
        final Autor other = (Autor) obj;
        if (this.autorID != other.autorID) {
            return false;
        }
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return true;
    }
    
}
