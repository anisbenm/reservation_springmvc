/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import reservation.entity.Utilisateur;

/**
 *
 * @author formation
 */


public class InscriptionController {
    
    @RequestMapping(value="/inscription")
    public String inscriptionGet(Model model){
        
        Utilisateur utilisateur= new Utilisateur();
        
        model.addAttribute("utilisateur",utilisateur);
        
        return"/inscription/inscription.jsp";
       
    }
    
    public String InscriptionPost(){
        
        
        
        
        return"";
    }
    
}
