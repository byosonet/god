package com.rest.services.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
public class LoginController {
   private final Logger log = Logger.getLogger(LoginController.class);
   @RequestMapping(value="/ingresar",method = RequestMethod.POST)
   public String ingresar(Model model, HttpServletRequest request) {
      this.log.info(" -- Ingresando al sistema");
      this.log.info(" -- Request: "+request);
      this.log.info(" -- User: "+request.getParameter("user"));
      this.log.info(" -- Password: "+request.getParameter("password"));
      
      if(request.getParameter("user")!=null && request.getParameter("password")!=null){
          String user = request.getParameter("user");
          String password = request.getParameter("password");
          
          if(user.equals("gtrejo") && password.equals("gtrejo")){
              this.log.info(" -- Usuario correcto");
              return "ingresar";
          }else{
              this.log.info(" -- Usuario incorrecto");
          }
          
      }
   return "invalido";
   }
   
   
   @RequestMapping(value="/validar/usuario",method = RequestMethod.POST)
   public ResponseEntity<Data> validar(Model model, HttpServletRequest request) {
      this.log.info(" -- Ingresando al sistema");
      this.log.info(" -- Request: "+request);
      this.log.info(" -- User: "+request.getParameter("user"));
      this.log.info(" -- Password: "+request.getParameter("password"));
      
      if(request.getParameter("user")!=null && request.getParameter("password")!=null){
          String user = request.getParameter("user");
          String password = request.getParameter("password");
          
          if(user.equals("gtrejo") && password.equals("gtrejo")){
              this.log.info(" -- Usuario correcto");
              Data data = new Data();
              data.setStatus("200");
              return new ResponseEntity<Data>(data, HttpStatus.OK);
              
          }
      }
    this.log.info(" -- Usuario incorrecto");
    Data data = new Data();
    data.setStatus("404");
    return new ResponseEntity<Data>(data, HttpStatus.NOT_FOUND);
   }
   
   public static class Data{
       private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
       
   }
    
    
}
