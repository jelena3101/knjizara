/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jelena.knjizara.controller;

import com.jelena.knjizara.domain.Autor;
import com.jelena.knjizara.domain.Knjiga;
import com.jelena.knjizara.domain.Posetilac;
import com.jelena.knjizara.domain.Zanr;
import com.jelena.knjizara.service.*;
//import com.jelena.knjizara.service.ZanrService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
@SessionAttributes(names = {"saveKnjiga", "listaAutora", "tip", "admin"})
@RequestMapping(value = "/knjiga/*")
public class KnjigaController {

    @Autowired
    private KnjigaService knjigaService;

    @Autowired
    private ZanrService zanrService;

    @Autowired
    private AutorService autorService;

    @ModelAttribute(name = "knjiga")
    public Knjiga knjiga() {
        return new Knjiga("", 1900, "", "", "", null);
    }

    @ModelAttribute(name = "autor")
    public Autor autor() {
        return new Autor();
    }

    @ModelAttribute(name = "autori")
    public Set<Autor> autori() {
        return new HashSet<>();
    }

    @ModelAttribute(name = "sviAutori")
    public Set<Autor> sviAutori() {
        Set<Autor> autori = new HashSet<>();
        autori.addAll(autorService.findAll());
        return autori;
    }

    @ModelAttribute(name = "sviZanrovi")
    public List<Zanr> sviZanrovi() {
        List<Zanr> zanrovi = zanrService.findAll();
        return zanrovi;
    }

    @GetMapping("/all")
    public ModelAndView all() {
        List<Knjiga> knjige = knjigaService.findAll();
        ModelAndView modelAndView = new ModelAndView("/knjiga/all");
        modelAndView.addObject("knjige", knjige);
        return modelAndView;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ModelAndView get(@PathVariable("id") int id, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("/knjiga/view");
        Knjiga knjiga = knjigaService.findById(id);
        modelAndView.addObject("viewKnjiga", knjiga);
        return modelAndView;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {

        ModelAndView modelAndView = new ModelAndView("redirect:/knjiga/all");
        Knjiga knjiga = knjigaService.findById(id);

        knjiga.getAutori().clear();
        knjiga.getZanrovi().clear();

        knjigaService.save(knjiga);
        knjigaService.delete(id);
        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(HttpServletRequest request) {
        ModelAndView mav;
        Posetilac p = (Posetilac) request.getSession().getAttribute("posetilac");
        if (p == null) {
            mav = new ModelAndView("/unauthorized");
            mav.addObject("tip", "gost");
        } else {
            Posetilac korisnik = p;
            switch (korisnik.getRole()) {
                case 1:
                    mav = new ModelAndView("/knjiga/add-1");
                    mav.addObject("tip", "admin");
                    mav.addObject("admin", korisnik);
                    request.getSession().setAttribute("tip", "admin");
                    mav.addObject("knjiga", new Knjiga());
                    break;
                case 2:
                    mav = new ModelAndView("/unauthorized");
                    request.getSession().setAttribute("tip", "korisnik");
                    mav.addObject("tip", "korisnik");
                    break;
                default:
                    mav = new ModelAndView("/unauthorized");
                    request.getSession().setAttribute("tip", "gost");
                    mav.addObject("tip", "gost");
                    break;
            }
        }
        return mav;
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id, HttpServletRequest request) {
        ModelAndView mav;
        Posetilac p = (Posetilac) request.getSession().getAttribute("posetilac");
        if (p == null) {
            mav = new ModelAndView("/unauthorized");
            mav.addObject("tip", "gost");
        } else {
            Posetilac korisnik = p;
            switch (korisnik.getRole()) {
                case 1:
                    Knjiga knjiga = knjigaService.findById(id);
                    mav = new ModelAndView("/knjiga/edit");
                    mav.addObject("tip", "admin");
                    mav.addObject("admin", korisnik);

                    mav.addObject("saveKnjiga", knjiga);

                    Set<Autor> listaAutora = knjiga.getAutori();

                    mav.addObject("listaAutora", listaAutora);
                    break;
                case 2:
                    mav = new ModelAndView("/unauthorized");
                    mav.addObject("tip", "korisnik");
                    break;
                default:
                    mav = new ModelAndView("/unauthorized");
                    mav.addObject("tip", "gost");
                    break;
            }
        }
        return mav;
    }

    @RequestMapping(value = "edit/saveEdit", method = RequestMethod.POST)
    public String saveEditBook(HttpServletRequest request, @ModelAttribute("saveKnjiga") Knjiga stareInfo, @ModelAttribute("knjiga") Knjiga knjiga, @ModelAttribute("admin") Posetilac admin, final RedirectAttributes redirectAttributes) {

        Set<Zanr> zanrovi = new HashSet<>();
        for (Zanr zanr : knjiga.getZanrovi()) {
            Zanr novi = zanrService.findById(Integer.parseInt(zanr.toString()));
            zanrovi.add(novi);
        }

        redirectAttributes.addFlashAttribute("posetilac", admin);

        stareInfo.setNaslov(knjiga.getNaslov());
        stareInfo.setOpis(knjiga.getOpis());
        stareInfo.setSlika(knjiga.getSlika());
        stareInfo.setZanrovi(zanrovi);
        stareInfo.setGodina(knjiga.getGodina());
        stareInfo.setJezik(knjiga.getJezik());
        stareInfo.setPosetilac(admin);

        redirectAttributes.addFlashAttribute("saveKnjiga", stareInfo);

        return "redirect:/knjiga/add-2";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String saveBook(HttpServletRequest request, @ModelAttribute("knjiga") Knjiga knjiga, @ModelAttribute("admin") Posetilac admin, final RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("naslov", knjiga.getNaslov());
        redirectAttributes.addFlashAttribute("opis", knjiga.getOpis());
        Set<Zanr> zanrovi = new HashSet<>();
        for (Zanr zanr : knjiga.getZanrovi()) {
            Zanr novi = zanrService.findById(Integer.parseInt(zanr.toString()));
            zanrovi.add(novi);
        }
        knjiga.setZanrovi(zanrovi);
        redirectAttributes.addFlashAttribute("zanrovi", zanrovi);
        redirectAttributes.addFlashAttribute("godina", knjiga.getGodina());
        redirectAttributes.addFlashAttribute("jezik", knjiga.getJezik());
        System.out.println("Posetilac: " + admin);
        redirectAttributes.addFlashAttribute("posetilac", admin);
        knjiga.setPosetilac(admin);
        redirectAttributes.addFlashAttribute("saveKnjiga", knjiga);
        redirectAttributes.addFlashAttribute("listaAutora", new HashSet<Autor>());
        return "redirect:/knjiga/add-2";
    }

    @RequestMapping(value = "add-2", method = RequestMethod.GET)
    public ModelAndView showAutor(HttpServletRequest request, @ModelAttribute("saveKnjiga") Knjiga knjiga) {
        ModelAndView mav = new ModelAndView("/knjiga/add-2");
        return mav;
    }

    @RequestMapping(value = "success", method = RequestMethod.GET)
    public ModelAndView showSuccess(HttpServletRequest request, @ModelAttribute("saveKnjiga") Knjiga knjiga) {

        ModelAndView mav = new ModelAndView("/knjiga/success");
        mav.addObject("viewKnjiga", knjiga);
        request.getSession().removeAttribute("saveKnjiga");
        request.getSession().removeAttribute("listaAutora");
        return mav;
    }

    @RequestMapping(value = "autori/save", method = RequestMethod.POST)
    public String saveAutori(@ModelAttribute("saveKnjiga") Knjiga knjiga, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "redirect:/knjiga/all";
        }

        knjigaService.save(knjiga);     

        return "redirect:/knjiga/success";
    }
    
    @RequestMapping(value = "autor/save", method = RequestMethod.POST)
    public String saveAutor(@ModelAttribute("autor") Autor autor,
                            @ModelAttribute("saveKnjiga") Knjiga knjiga,
                            @ModelAttribute("listaAutora") Set<Autor> listaAutora,
                             final RedirectAttributes redirectAttributes) {
        
        if (autor != null) {
            autorService.save(autor);

            if (!listaAutora.contains(autor)) {
                listaAutora.add(autor);
                knjiga.getAutori().add(autor);
            }
        }
        System.out.println("Sacuvani autor: " + autor);
        return "redirect:/knjiga/add-2";
    }
    
    @RequestMapping(value = "autori/get/{id}", method = RequestMethod.GET)
    public String addAutor(HttpServletRequest request,
                            @PathVariable("id") int id,
                            @ModelAttribute("saveKnjiga") Knjiga knjiga,
                            @ModelAttribute("listaAutora") Set<Autor> listaAutora,
                            final RedirectAttributes redirectAttributes) {

        Autor autorZaUbacivanje = autorService.findById(id);
                
        if (autorZaUbacivanje != null && !listaAutora.contains(autorZaUbacivanje)) {
            listaAutora.add(autorZaUbacivanje);
        }
        
        knjiga.setAutori(listaAutora);
        System.out.println("Lista autora iz 'autor/get/id':");
        for (Autor autor : listaAutora) {
            System.out.println(autor);
        }
        redirectAttributes.addFlashAttribute("saveKnjiga", knjiga);                    
        return "redirect:/knjiga/add-2";
    }
    
    @RequestMapping(value = "autori/delete/{id}", method = RequestMethod.GET)
    public String removeAutor(HttpServletRequest request,
                                @PathVariable("id") int id,
                                @ModelAttribute("saveKnjiga") Knjiga knjiga,
                                @ModelAttribute("listaAutora") Set<Autor> listaAutora,
                                final RedirectAttributes redirectAttributes) {

        Autor autorZaIzbacivanje = autorService.findById(id);
        
        if (autorZaIzbacivanje != null && listaAutora.contains(autorZaIzbacivanje)) {
            listaAutora.remove(autorZaIzbacivanje);
        }
        
        knjiga.setAutori(listaAutora);
        redirectAttributes.addFlashAttribute("saveKnjiga", knjiga);  
        return "redirect:/knjiga/add-2";
    }
}
