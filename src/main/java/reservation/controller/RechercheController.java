/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.dto.rechercheDTO;

/**
 *
 * @author Administrateur
 */
@Controller
public class RechercheController {
    
    @RequestMapping(value = "/recherche", method = RequestMethod.GET)
    public String rechercherGet(Model model){
        rechercheDTO rec=new rechercheDTO();
        model.addAttribute("rec", rec);
    return "/rechercher/chambres.jsp";
    }
}
