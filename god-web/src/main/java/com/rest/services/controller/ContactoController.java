package com.rest.services.controller;

import com.rest.services.god.persistence.hbm.TipoMovimientoEnum;
import com.rest.services.god.persistence.hbm.Usuario;
import com.rest.services.model.ErrorService;
import com.rest.services.service.ChangesetService;
import com.rest.services.service.EmailSendService;
import com.rest.services.service.UsuarioService;
import com.rest.services.util.UtilService;
import java.util.Date;
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
@RequestMapping("/contacto")
public class ContactoController {
    private final Logger log = Logger.getLogger(ContactoController.class);
    @RequestMapping(value="/sistema",method = RequestMethod.POST)
   public ResponseEntity<ErrorService> obtenerListaHimnario(Model model, HttpServletRequest request) throws Exception {
       HttpStatus status = HttpStatus.NOT_FOUND;
       
       String cifrar = request.getParameter("cifrar");
       String descifrado = UtilService.Desencriptar(cifrar);
       this.log.info(" -- Descifrado: "+descifrado);
       String[] data = descifrado.split(";");
       String userEmail = data[0];
       Usuario user = this.usuarioService.validaEmailSistema(userEmail);
       if(user!=null){
           this.changesetService.guardarChangeset(
                      TipoMovimientoEnum.ENVIO_CORREO_CONTACTO,
                      new Date(UtilService.getFechaTimeStamp().getTime()), 
                      user.getIdUsuario(), null);
       }

       String asunto = request.getParameter("asunto");
       String nombre = request.getParameter("nombre");
       String email = request.getParameter("emailContacto");
       String textarea = request.getParameter("textarea");
       
       this.log.info(" -- Asunto: "+asunto);
       this.log.info(" -- Nombre: "+nombre);
       this.log.info(" -- Email: "+email);
       this.log.info(" -- Textarea: "+textarea);

       ErrorService response = new ErrorService();
       response.setCodigo("404");
       response.setMensaje("Por el momento no se pudo enviar tus comentarios, intenta más tarde.");
       try{
           this.emailSendService.contactoSistema("gtrejo.armenta@gmail.com", asunto, nombre, email, textarea);
           this.log.info(" -- Comentarios enviados al sistema");
           response.setCodigo("200");
           response.setMensaje("Tus comentarios fueron enviados exitosamente");
           status = HttpStatus.OK;
       }catch(Exception ex){
           this.log.info(" -- Los comentarios no pudieron ser enviados al sistema");    
       }
       
      return new ResponseEntity<ErrorService>(response, status);
   }
   
   @Autowired
   EmailSendService emailSendService;
   
   @Autowired
   private UsuarioService usuarioService;
   
   @Autowired
   private ChangesetService changesetService;
}
