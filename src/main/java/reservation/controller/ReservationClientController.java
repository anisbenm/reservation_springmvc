/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.dto.ReservationDTO;
import reservation.entity.Client;
import reservation.entity.Reservation;
import reservation.service.ReservationClientServiceCrud;
import reservation.service.ReservationCrudService;

/**
 *
 * @author formation
 */

@Controller
public class ReservationClientController {
    
     @Autowired
     ReservationClientServiceCrud serviceReservationClient;
    
    @RequestMapping(value = "/reservationClient", method = RequestMethod.GET)
    public String ReservationClientGet(Model model){
       
        long id_client =1;
        String etat="PAYE";
        //une nouvelle reservation 
       Reservation reservations = (Reservation) serviceReservationClient.reservationClient(id_client, etat);
        
        
        model.addAttribute("reservations",  reservations);
        return "/reservationClient/liste.jsp";
       
        //calcule de prix
       
        
        // Enregistrer reservation 
     
       
       
      
        
    }
    
}
