package com.rest.services.controller;

import com.rest.services.service.CoroService;
import org.springframework.beans.factory.annotation.Autowired;
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
       
       try{
           this.coroService.obtenerListaCoro();
       }catch(Exception ex){
           ex.printStackTrace();
       }
      return "listaHimnario";
   }
   
   
   @Autowired
   private CoroService coroService;
}
