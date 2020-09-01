/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.service;


import com.jelena.knjizara.domain.Knjiga;
import java.util.List;

/**
 *
 * @author Jelena
 */
public interface KnjigaService {
    List<Knjiga> findAll();
    Knjiga findById(int id);
    void save(Knjiga knjiga);
    void delete(int id);
}
