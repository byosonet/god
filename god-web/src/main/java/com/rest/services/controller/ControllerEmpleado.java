package com.rest.services.controller;

import com.rest.services.model.Empleado;
import com.rest.services.model.ErrorService;
import com.rest.services.service.DemoService;
import com.rest.services.service.ListaEmpleadosService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ControllerEmpleado {
    private final Logger log = Logger.getLogger(ControllerEmpleado.class);
    
    @RequestMapping(value = "/empleados")
    public ResponseEntity<List<Empleado>> getAllEmployeesJSON(Model model) {
        this.log.info(" -- Controller /empleados Method: GET");
        List<Empleado> response = this.listaEmpleadosService.getEmpleados();
        return new ResponseEntity<List<Empleado>>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/empleado/{id}")
    public ResponseEntity<Empleado> getEmployeeById(@PathVariable("id") String id) {
        this.log.info(" -- Controller /empleados/{id} Method: GET");
        Empleado response = this.listaEmpleadosService.getEmpleadoById(id);
        return new ResponseEntity<Empleado>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value="/error", method = RequestMethod.GET)
    public ResponseEntity<ErrorService> getError(){
        this.log.info(" -- Controller /error Method: GET");
        ErrorService response = this.demoService.getError();
        return new ResponseEntity<ErrorService>(response, HttpStatus.OK);
    }
    
    @Autowired
    private ListaEmpleadosService listaEmpleadosService;
    
    @Autowired
    private DemoService demoService;
}
