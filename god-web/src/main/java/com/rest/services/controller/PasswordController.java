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
@RequestMapping("/password")
public class PasswordController {
    
    @RequestMapping(value="/recuperar", method = RequestMethod.GET)
    public String recuperarPassword(){
        return "password";
    }
    
}
