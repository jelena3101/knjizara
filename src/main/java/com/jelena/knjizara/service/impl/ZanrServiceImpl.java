/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.service.impl;


import com.jelena.knjizara.domain.Zanr;
import com.jelena.knjizara.repository.ZanrRepository;
import com.jelena.knjizara.service.ZanrService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
@Transactional
public class ZanrServiceImpl implements ZanrService {
    
    @Autowired
    private ZanrRepository zanrRepository;

    public ZanrServiceImpl() {
    }

    @Override
    public List<Zanr> findAll() {
        return zanrRepository.findAll();
    }

    @Override
    public Zanr findById(int id) {
        Optional<Zanr> optionalZanr = zanrRepository.findById(id);
        if (optionalZanr.isPresent())
            return optionalZanr.get();
        return null;
    }

    @Override
    public void save(Zanr zanr) {
        zanrRepository.save(zanr);
    }
    
}
