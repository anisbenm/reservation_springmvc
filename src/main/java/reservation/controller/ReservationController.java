/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Hotel;
import reservation.entity.Reservation;
import reservation.service.ClientCrudService;
import reservation.service.HotelCrudService;
import reservation.service.ReservationCrudService;

/**
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/reservation")
public class ReservationController {
     
    @Autowired
    private ReservationCrudService service;
    @Autowired
    private ClientCrudService clientService;
            
     @RequestMapping(value = "/ajouter")
    public String ajouterGet( Model model) {
        Reservation r=new Reservation();
         // passer cet hotel à la vue
        model.addAttribute("reservation", r);
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("etats", Reservation.EtatReservation.values());
        return "/reservation/ajouter.jsp";
    }  

    @RequestMapping(value = "/ajouter", method = RequestMethod.POST)//par defaut get
    public String ajouter(@ModelAttribute("reservation") Reservation r) {
        //persister
        service.save(r);
        return "redirect:/reservation/lister";
    }

    @RequestMapping(value = "/modifier", method = RequestMethod.POST)
    public String modifier(@ModelAttribute("reservation") Reservation r) {
        //persister
        service.save(r);
        return "redirect:/reservation/lister";
    }

    @RequestMapping(value = "/modifier/{id}")
    public String afficheModif(@PathVariable("id") long id, Model model) {
        //recuperer l'hotel à modifier
        Reservation r = service.findOne(id);

        // passer cet hotel à la vue
        model.addAttribute("reservation", r);
        return "/reservation/modifier.jsp";
    }

    @RequestMapping(value = "/lister")
    public String lister(Model model) {
        List<Reservation> reservations = (List<Reservation>) service.findAll();
        model.addAttribute("reservations", reservations);
        return "/reservation/lister.jsp";
    }

    @RequestMapping(value = "/supprimer/{resId}")
    public String supprimer(@PathVariable("resId") long id) {
        service.delete(id);
        return "redirect:/reservation/lister";//envoi une repense au client pour qu il emmet une requete get
    }

}
