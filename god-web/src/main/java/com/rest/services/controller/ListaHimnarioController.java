package com.rest.services.controller;

import com.rest.services.god.persistence.hbm.Coro;
import com.rest.services.god.persistence.hbm.Usuario;
import com.rest.services.service.CoroService;
import com.rest.services.service.UsuarioService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
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
    private final Logger log = Logger.getLogger(ListaHimnarioController.class);
    @RequestMapping(value="/obtener",method = RequestMethod.POST)
   public String obtenerListaHimnario(Model model, HttpServletRequest request) {
       String email = request.getParameter("idEmail");
       String pass = request.getParameter("idPassword");
       
       this.log.info(" -- email: "+email);
       this.log.info(" -- password: "+pass);
       
       Usuario user = this.usuarioService.validaUsuario(email, pass);
       
       try{
           List<Coro> corosActualizados = this.coroService.obtenerListaCoroActualizada();
           List<Coro> corosCompletos = this.coroService.obtenerListaCoroCompleta();
           if(corosActualizados!=null && corosActualizados.size()>0){
               model.addAttribute("coros", corosActualizados);
               model.addAttribute("corosCompletos", corosCompletos);
               model.addAttribute("usuario", user.getNombre());
               model.addAttribute("userEmail", user.getEmail());
               model.addAttribute("userPassword", user.getPassword());
           }
       }catch(Exception ex){
           ex.printStackTrace();
       }
      return "listaHimnario";
   }
   
   @RequestMapping(value="/obtener",method = RequestMethod.GET)
   public String ingresarGET(Model model, HttpServletRequest request) {
      return "forbidden";
   }
   
   @Autowired
   private CoroService coroService;
   
   @Autowired
   private UsuarioService usuarioService;
}
