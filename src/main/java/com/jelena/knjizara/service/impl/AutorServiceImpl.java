/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.service.impl;

import com.jelena.knjizara.domain.Autor;
import com.jelena.knjizara.repository.AutorRepository;
import com.jelena.knjizara.service.AutorService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jelena
 */
@Service
@Transactional
public class AutorServiceImpl implements AutorService{
    
    @Autowired
    private AutorRepository autorRepository;

    public AutorServiceImpl() {
    }
    
    @Override
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    @Override
    public Autor findById(int id) {
        Optional<Autor> optionalAutor = autorRepository.findById(id);
        if (optionalAutor.isPresent())
            return optionalAutor.get();
        return null;
    }

    @Override
    public void save(Autor autor) {
        autorRepository.save(autor);
    }
}
