/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.repository;

import com.jelena.knjizara.domain.Knjiga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jelena
 */
@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Integer>{
    
}
