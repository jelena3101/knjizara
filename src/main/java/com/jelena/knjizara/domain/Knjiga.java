/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jelena
 */

@Entity(name = "Knjiga")
@Table(name = "knjiga")
public class Knjiga implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int knjigaID;
    
    @NotNull
    private String naslov;
    
    @NotNull
    private int godina;
    
    @NotNull
    @Column(length = 2000)
    private String opis;
    
    @NotNull
    private String slika;
    
    @NotNull
    private String jezik;
    
    @ManyToOne
    @JoinColumn(name = "posetilacID")
    @NotNull
    private Posetilac posetilac;
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "autor_knjiga",
            joinColumns = @JoinColumn(name = "knjigaID"),
            inverseJoinColumns = @JoinColumn(name = "autorID")
    )
    private Set<Autor> autor = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "zanr_knjiga",
            joinColumns = @JoinColumn(name = "knjigaID"),
            inverseJoinColumns = @JoinColumn(name = "zanrID")
    )
    private Set<Zanr> zanr= new HashSet<>();

    public Knjiga() {
    }

    public Knjiga(String naslov, int godina, String opis, String slika, String jezik, Posetilac posetilac) {
        this.naslov = naslov;
        this.godina = godina;
        this.opis = opis;
        this.slika = slika;
        this.jezik = jezik;
        this.posetilac = posetilac;
    }

    public int getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(int knjigaID) {
        this.knjigaID = knjigaID;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getJezik() {
        return jezik;
    }

    public void setJezik(String jezik) {
        this.jezik = jezik;
    }

    public Posetilac getPosetilac() {
        return posetilac;
    }

    public void setPosetilac(Posetilac posetilac) {
        this.posetilac = posetilac;
    }

    public Set<Autor> getAutori() {
        return autor;
    }

    public void setAutori(Set<Autor> autor) {
        this.autor = autor;
    }

    public Set<Zanr> getZanrovi() {
        return zanr;
    }

    public void setZanrovi(Set<Zanr> zanr) {
        this.zanr = zanr;
    }
    @Override
    public String toString() {
        return new StringBuilder()
                .append(getNaslov()).append(", ")
                .append(getGodina()).append(", ")
                .append(getOpis()).toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.getKnjigaID();
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
        final Knjiga other = (Knjiga) obj;
        if (this.getKnjigaID() != other.getKnjigaID()) {
            return false;
        }
        return true;
    }
    
    
}
