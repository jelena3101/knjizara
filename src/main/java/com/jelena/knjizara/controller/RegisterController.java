/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.controller;

import com.jelena.knjizara.domain.Posetilac;
import com.jelena.knjizara.service.PosetilacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Jelena
 */
@Controller
public class RegisterController {
    
    @Autowired
    private PosetilacService posetilacService;
        
    public RegisterController() {
    }
    
    @ModelAttribute(name = "posetilac")
    public Posetilac posetilac() {
        return new Posetilac("", "", "", "", 0);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegister() {
        return "/register";
    }

}
