/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Chambre;
import reservation.service.ChambreCrudService;

/**
 *
 * @author anis
 */
@Controller
@RequestMapping(value = "/chambre")
public class ChambreController {
    @Autowired
    ChambreCrudService service;
    @RequestMapping(value = "/ajouter")
    public String ajouterGet(Model model) {
        Chambre chambre = new Chambre();
        model.addAttribute("chambre", chambre);
        return "chambre/ajouter.jsp";
    }

    @RequestMapping(value = "ajouter", method = RequestMethod.POST)
    public String ajouter(@ModelAttribute Chambre c) {
        service.save(c);
        return "cacahoute.jsp";
    }
}
