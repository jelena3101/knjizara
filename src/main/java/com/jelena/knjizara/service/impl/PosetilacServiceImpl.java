/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.service.impl;


import com.jelena.knjizara.domain.Posetilac;
import com.jelena.knjizara.repository.PosetilacRepository;
import com.jelena.knjizara.service.PosetilacService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author User
 */
@Service
public class PosetilacServiceImpl implements PosetilacService {

    @Autowired
    private PosetilacRepository posetilacRepository;

    public PosetilacServiceImpl() {
    }
    
    @Override
    public List<Posetilac> findAll() {
        return posetilacRepository.findAll();
    }

    @Override
    public Posetilac findById(int id) {
        Optional<Posetilac> optionalUser = posetilacRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public void save(Posetilac user) {
        posetilacRepository.save(user);
    }

    @Override
    public void register(Posetilac user) {
        List<Posetilac> sviKorisnici = posetilacRepository.findAll();
        if (!sviKorisnici.contains(user)) {
            posetilacRepository.save(user);
        }
    }

    @Override
    public void delete(int id) {
        posetilacRepository.deleteById(id);
    }

    @Override
    public Posetilac validate(String korisnickoIme, String lozinka) {
        List<Posetilac> sviKorisnici = posetilacRepository.findAll();
        Posetilac requestPosetilac = new Posetilac("", "", korisnickoIme, lozinka, 2);
        for (Posetilac posetilac : sviKorisnici) {
            if (posetilac.equals(requestPosetilac))
                return posetilac;
        }
        return null;
    }
    
}
