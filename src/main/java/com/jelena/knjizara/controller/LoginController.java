/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.controller;

import com.jelena.knjizara.domain.Posetilac;
import com.jelena.knjizara.service.PosetilacService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Jelena
 */
@Controller
@SessionAttributes({"tip", "sessionPosetilac"})
public class LoginController {

    @Autowired
    private PosetilacService posetilacService;

    public LoginController() {
    }

    @ModelAttribute(name = "posetilac")
    public Posetilac posetilac() {
        return new Posetilac("", "", "", "", 0);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin() {
        return "/login";
    }

    @RequestMapping(value = {"/welcome", "/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/index");
        Posetilac p = (Posetilac) request.getSession().getAttribute("posetilac");
        System.out.println("Posetilac iz request-a: " + p);
        if (p == null) {
            modelAndView.addObject("tip", "gost");
        } else {
            Posetilac korisnik = p;

            switch (korisnik.getRole()) {
                case 1:
                    modelAndView.addObject("tip", "admin");
                    modelAndView.addObject("admin", korisnik);
                    System.out.println(korisnik);
                    break;
                case 2:
                    modelAndView.addObject("tip", "korisnik");
                    modelAndView.addObject("korisnik", korisnik);
                    System.out.println(korisnik);
                    break;
                default:
                    modelAndView.addObject("tip", "gost");
                    System.out.println(korisnik);
                    break;
            }
            
        }
        return modelAndView;
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute(name = "posetilac") Posetilac posetilac, HttpServletRequest request, final RedirectAttributes redirectAttributes) {
        Posetilac p = posetilacService.validate(posetilac.getUsername(), posetilac.getPassword());
        ModelAndView modelAndView = new ModelAndView("/index");
        if (p == null) {
            modelAndView.addObject("tip", "gost");
            redirectAttributes.addFlashAttribute("errorMessage", "Pogresan unos");
//            modelAndView.addObject("errorMessage", "Pogresan unos");
            modelAndView.setViewName("redirect:login");
            System.out.println("Nema korisnika");
        } else {
            request.getSession().setAttribute("posetilac", p);
            Posetilac korisnik = p;

            switch (korisnik.getRole()) {
                case 1:
                    modelAndView.addObject("tip", "admin");
                    modelAndView.addObject("admin", korisnik);
                    break;
                case 2:
                    modelAndView.addObject("tip", "korisnik");
                    modelAndView.addObject("korisnik", korisnik);
                    break;
                default:
                    System.out.println("Nema korisnika");
                    break;
            }
            request.getSession().setAttribute("sessionPosetilac", korisnik);
        }
        return modelAndView;
    }
}
