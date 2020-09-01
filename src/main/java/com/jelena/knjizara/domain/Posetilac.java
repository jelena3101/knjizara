/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "posetilac")
public class Posetilac implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int posetilacID;
    
    private String ime;
    private String prezime;
    
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private int role;

    public Posetilac() {
    }

    public Posetilac(String ime, String prezime, String username, String password, int role) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * @return the posetilacID
     */
    public int getPosetilacID() {
        return posetilacID;
    }

    /**
     * @param posetilacID the posetilacID to set
     */
    public void setPosetilacID(int posetilacID) {
        this.posetilacID = posetilacID;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder()
                .append(getIme()).append(" ")
                .append(getPrezime()).append(", ");
        if (getRole() == 1) {
            str.append("administrator");
        } else if (getRole() == 2) {
            str.append("korisnik");
        }
        return str.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.getPosetilacID();
        hash = 17 * hash + Objects.hashCode(this.getPassword());
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
        final Posetilac other = (Posetilac) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }
    
    
}
