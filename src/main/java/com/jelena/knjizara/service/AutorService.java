/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.service;

import com.jelena.knjizara.domain.Autor;
import java.util.List;

/**
 *
 * @author Jelena
 */
public interface AutorService {
    
    List<Autor> findAll();
    Autor findById(int id);
    void save(Autor autor);
}
