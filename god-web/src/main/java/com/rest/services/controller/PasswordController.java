package com.rest.services.controller;

import com.rest.services.god.persistence.hbm.Usuario;
import com.rest.services.model.ErrorService;
import com.rest.services.service.EmailSendService;
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
@RequestMapping("/password")
public class PasswordController {
    private final Logger log = Logger.getLogger(PasswordController.class);
 
    @RequestMapping(value="/recuperar", method = RequestMethod.GET)
    public String recuperarPassword(){
        return "password";
    }
    
    @RequestMapping(value="/enviar/email", method = RequestMethod.POST)
    public ResponseEntity<ErrorService> enviarPasswordEmail(Model model, HttpServletRequest request){
        String email = request.getParameter("email");
        String confEmail = request.getParameter("confEmail");
        HttpStatus status = HttpStatus.NOT_FOUND;
        this.log.info(" -- Request recibido emai: "+email);
        this.log.info(" -- Request recibido emai: "+confEmail);
        
        ErrorService response = new ErrorService();
        Usuario user = this.usuarioService.validaEmailSistema(email);
        if(user!=null){
            this.log.info(" -- Enviar email de password a usuario: "+user.getNombre());
            response.setCodigo("202");
            response.setMensaje("Hola "+user.getNombre()+", tu password ha sido enviado a: "+user.getEmail());
            status = HttpStatus.OK;
            
            this.emailSendService.recuperarPassword(email, user.getPassword(),"gtrejo.armenta@gmail.com");
            this.log.info(" -- El correo fue enviado con tu password a: " + email);
            
        }else{
            this.log.info(" -- Este email no esta registrado en el sistema");
            response.setCodigo("404");
            response.setMensaje("Este email "+email+" no ha sido registrado en el sistema.");
        }
        return new ResponseEntity<ErrorService>(response,status);
    }
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private EmailSendService emailSendService;
    
}
