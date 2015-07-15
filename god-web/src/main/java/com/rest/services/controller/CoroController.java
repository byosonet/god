/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
public class CoroController {
    private final Logger log = Logger.getLogger(CoroController.class);
   @RequestMapping(value="/coro/{id}",method = RequestMethod.GET)
   public String obtenerListaHimnario(Model model, @PathVariable("id") String id) {
       this.log.info(" -- IdCoro recibido:::: "+id);
       if(id.equals("520"))
           return "520";
    return "notfoundCoro";
   }
    
}
