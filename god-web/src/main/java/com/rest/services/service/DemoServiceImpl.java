/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.service;

import com.rest.services.model.ErrorService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("demoService")
public class DemoServiceImpl implements DemoService{
private final Logger log = Logger.getLogger(DemoServiceImpl.class);
    public ErrorService getError() {
        this.log.info(" -- Accediendo al recurso error");
        ErrorService e = new ErrorService();
        e.setCodigo("1");
        e.setMensaje("Ninguno");
        
        return e;
    }
}
