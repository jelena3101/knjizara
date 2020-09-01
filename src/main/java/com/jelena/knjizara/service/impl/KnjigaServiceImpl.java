/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.service.impl;

import com.jelena.knjizara.domain.Knjiga;
import com.jelena.knjizara.repository.KnjigaRepository;
import com.jelena.knjizara.service.KnjigaService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jelena
 */
@Service
@Transactional
public class KnjigaServiceImpl implements KnjigaService{
    
     @Autowired
    private KnjigaRepository knjigaRepository;

    public KnjigaServiceImpl() {
    }

    
    @Override
    public List<Knjiga> findAll() {
        return knjigaRepository.findAll();
    }

    @Override
    public Knjiga findById(int id) {
        Optional<Knjiga> optionalKnjiga = knjigaRepository.findById(id);
        if (optionalKnjiga.isPresent())
            return optionalKnjiga.get();
        return null;
    }

    @Override
    public void save(Knjiga knjiga) {
        knjigaRepository.save(knjiga);
    }

    @Override
    public void delete(int id) {
        knjigaRepository.deleteById(id);
    }
}
