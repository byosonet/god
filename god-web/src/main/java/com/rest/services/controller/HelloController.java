/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
   

   @RequestMapping(value="/hola",method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "example";
   }
   
   @RequestMapping(value="/empleados",method = RequestMethod.GET)
   public String printEmpleados(ModelMap model) {
      return "empleados";
   }
   
    @RequestMapping(value="/test",method = RequestMethod.GET)
   public String printTest(ModelMap model) {
      return "test";
   }
   
}
