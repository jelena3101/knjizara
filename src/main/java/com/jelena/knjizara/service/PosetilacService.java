/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.service;


import com.jelena.knjizara.domain.Posetilac;
import java.util.List;

/**
 *
 * @author Jelena
 */
public interface PosetilacService {
    List<Posetilac> findAll();
    Posetilac findById(int id);
    void save(Posetilac posetilac);
    void register(Posetilac posetilac);
    void delete(int id);
    
    Posetilac validate(String korisnickoIme, String lozinka);
}
