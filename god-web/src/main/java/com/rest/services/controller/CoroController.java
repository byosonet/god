/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.controller;

import com.rest.services.god.persistence.dao.CoroDao;
import com.rest.services.god.persistence.hbm.Coro;
import com.rest.services.service.CoroService;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
   public String obtenerListaHimnario(Model model, @PathVariable("id") String id) throws SQLException, IOException {
       this.log.info(" -- IdCoro recibido:::: "+id);
       
       Coro coro = this.coroService.obtenerCoro(id);
       if(coro!=null){
           if(String.valueOf(coro.getIdCoro()).equals(id)){
               model.addAttribute("idCoro", id);
               model.addAttribute("coro", coro.getDataClob(coro.getDescripcion()));
               return "detalle";
           }
       }
        
    return "notfoundCoro";
   }
   
   @Autowired
   private CoroService coroService;
    
}
