package com.rest.services.controller;

import com.rest.services.god.persistence.hbm.Usuario;
import com.rest.services.model.ErrorService;
import com.rest.services.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
          Usuario usuario = this.usuarioService.validaUsuario(user, password);
          if(usuario!=null){
              this.log.info(" -- Ingresando al sistema como: "+usuario.getNombre());
              return "ingresar";
          }
      }
   return "invalido";
   }
   
   
   @RequestMapping(value="/validar/usuario",method = RequestMethod.POST)
   public ResponseEntity<ErrorService> validar(Model model, HttpServletRequest request) {
      this.log.info(" -- Ingresando al sistema");
      this.log.info(" -- Request: "+request.toString());
      this.log.info(" -- User: "+request.getParameter("user"));
      this.log.info(" -- Password: "+request.getParameter("password"));
      
      if(request.getParameter("user")!=null && request.getParameter("password")!=null){
          String user = request.getParameter("user");
          String password = request.getParameter("password");
          
          Usuario usuario = this.usuarioService.validaUsuario(user, password);
          if(usuario!=null){
              this.log.info(" -- Usuario correcto");
              ErrorService data = new ErrorService();
              data.setCodigo("200");
              data.setMensaje("Hola Bienvenido: "+usuario.getNombre());
              return new ResponseEntity<ErrorService>(data, HttpStatus.OK);
          }
      }
      
    this.log.info(" -- Usuario incorrecto");
    ErrorService data = new ErrorService();
    data.setCodigo("404");
    data.setMensaje("Usuario No Registrado");
    return new ResponseEntity<ErrorService>(data, HttpStatus.NOT_FOUND);
   }
   

    @Autowired
    UsuarioService usuarioService;
    
}
