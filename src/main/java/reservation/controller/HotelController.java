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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reservation.entity.Hotel;
import reservation.service.HotelCrudService;

/**
 *
 * @author Administrateur
 */
@Controller
public class HotelController {
    @Autowired
    private HotelCrudService service;
    @RequestMapping(value = "/hotel/lister",method = RequestMethod.GET)
    public String lister(Model model){
        List<Hotel> hotels=(List<Hotel>) service.findAll();
        model.addAttribute("hotels", hotels);
        return "hotel/lister.jsp";
    }
    
}
