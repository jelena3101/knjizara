/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.controller;

import com.jelena.knjizara.domain.Posetilac;
import com.jelena.knjizara.service.PosetilacService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Jelena
 */
@Controller
@RequestMapping(value = "/korisnik/*")
public class KorisnikController {
    
    @Autowired
    private PosetilacService posetilacService;
    
    @ModelAttribute(name = "posetilac")
    public Posetilac posetilac() {
        return new Posetilac();
    }
    
    @GetMapping("/all")
    public ModelAndView all() {
        List<Posetilac> korisnici = posetilacService.findAll();
        ModelAndView modelAndView = new ModelAndView("/korisnik/all");
        modelAndView.addObject("korisnici", korisnici);
        return modelAndView;
    }
    
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public ModelAndView registerProcess(@ModelAttribute(name = "posetilac") Posetilac posetilac, HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        if (posetilac == null) {
            modelAndView.addObject("tip", "gost");
            modelAndView.setViewName("redirect:/errorPage");
        } else {
            posetilac.setRole(2);
            posetilacService.register(posetilac);
        }
        return modelAndView;
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute(name = "posetilac") Posetilac posetilac,
                                    @ModelAttribute(name = "editPosetilac") Posetilac editPosetilac,
                                    HttpServletRequest request) {

        editPosetilac.setIme(posetilac.getIme());
        editPosetilac.setPrezime(posetilac.getPrezime());
        editPosetilac.setUsername(posetilac.getUsername());
        editPosetilac.setPassword(posetilac.getPassword());
        editPosetilac.setRole(posetilac.getRole());
        posetilacService.save(editPosetilac);
        ModelAndView modelAndView = new ModelAndView("/korisnik/success");
        modelAndView.addObject("editPosetilac", editPosetilac);
        return modelAndView;
    }
    
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        
        ModelAndView modelAndView = new ModelAndView("/korisnik/edit");
        Posetilac editPosetilac = posetilacService.findById(id);
        System.out.println("Uzeo posetioca");
        System.out.println(editPosetilac);
        modelAndView.addObject("editPosetilac", editPosetilac);
//        redirectAttributes.addFlashAttribute("editPosetilac", editPosetilac);
        System.out.println(editPosetilac);
        return modelAndView;
    }
    
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(HttpServletRequest request,
                                @PathVariable("id") int id,
                                @ModelAttribute(name = "posetilac") Posetilac posetilac) {

        ModelAndView modelAndView = new ModelAndView("/korisnik/view");
        Posetilac viewPosetilac = posetilacService.findById(id);
        modelAndView.addObject("viewPosetilac", viewPosetilac);
        return modelAndView;
    }
    
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        
        ModelAndView modelAndView = new ModelAndView("redirect:/korisnik/all");
        posetilacService.delete(id);
        return modelAndView;
    }
    
}
