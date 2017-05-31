/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.dto.UtilisateurDto;

/**
 *
 * @author Administrateur
 */
@Controller
public class UtilisateursController {

    @RequestMapping(value = "/deconnexion", method = RequestMethod.GET)
    public String deconnexion(HttpSession session) {
        session.invalidate();
        return "redirect:/identification";
    }

    @RequestMapping(value = "/identification", method = RequestMethod.GET)
    public String identificationGET(Model model) {
        model.addAttribute("utilDto", new UtilisateurDto());
        return "/identification.jsp";
    }

    @RequestMapping(value = "/identification", method = RequestMethod.POST)
    public String identificationPost(@ModelAttribute("utilDto") UtilisateurDto dto, HttpSession session) {
        //revoie vers la page d'identification si pas admin/admin
        if (!dto.getIdentifiant().equals("admin") || !dto.getMotDePasse().equals("admin")) {
            return "redirect:/identification";
        }
        // enregistrer en session que l'util est admin
        session.setAttribute("adminConnecte", true);
        // on choisi de rediriger vers la liste des hotels
        return "redirect:/hotel/lister";
    }
}
