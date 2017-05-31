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
import reservation.entity.Client;
import reservation.service.ClientCrudService;

/**
 *
 * @author Administrateur
 */
@Controller
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    ClientCrudService clService;

    @RequestMapping(value = "/ajouter", method = RequestMethod.GET)
    public String ajouter(Model model) {
        model.addAttribute("client", new Client());
        return "/client/ajouter.jsp";
    }
}
