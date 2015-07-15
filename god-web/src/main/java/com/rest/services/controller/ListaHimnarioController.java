package com.rest.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/lista")
public class ListaHimnarioController {
    @RequestMapping(value="/obtener",method = RequestMethod.GET)
   public String obtenerListaHimnario(Model model) {
      return "listaHimnario";
   }
}
