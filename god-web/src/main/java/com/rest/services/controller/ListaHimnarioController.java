package com.rest.services.controller;

import com.rest.services.god.persistence.hbm.Coro;
import com.rest.services.god.persistence.hbm.PropiedadSistema;
import com.rest.services.god.persistence.hbm.TipoMovimientoEnum;
import com.rest.services.god.persistence.hbm.Usuario;
import com.rest.services.service.ChangesetService;
import com.rest.services.service.CoroService;
import com.rest.services.service.PropiedadSistemaService;
import com.rest.services.service.UsuarioService;
import com.rest.services.util.UtilService;
import java.util.Date;
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
       
       String encriptarPassword = UtilService.Encriptar(pass);
       Usuario user = this.usuarioService.validaUsuario(email, encriptarPassword);
       
       if(user!=null){
            this.changesetService.guardarChangeset(
                TipoMovimientoEnum.CONSULTAR_HIMNARIO,
                new Date(UtilService.getFechaTimeStamp().getTime()), 
                user.getIdUsuario(), null);
        }
       
       try{
           List<Coro> corosActualizados = this.coroService.obtenerListaCoroActualizada();
           List<Coro> corosCompletos = this.coroService.obtenerListaCoroCompleta();
           if(corosActualizados!=null && corosActualizados.size()>0){
               model.addAttribute("coros", corosActualizados);
               model.addAttribute("corosCompletos", corosCompletos);
               model.addAttribute("usuario", user.getNombre());
               
               //model.addAttribute("userEmail", user.getEmail());
               //model.addAttribute("userPassword", pass);
               String cifrar = UtilService.Encriptar(user.getEmail()+";"+pass);
               model.addAttribute("cifrar",cifrar);
               
               //retornando los datos del perfil
               model.addAttribute("nombreUsuario", user.getNombre());
               model.addAttribute("falta", user.getFechaAlta());
               model.addAttribute("fconexion", user.getUltConexion());
               model.addAttribute("emailUsuario", user.getEmail());
               model.addAttribute("actividad", user.getActividad());
               model.addAttribute("sexo", user.getSexo()=='M'?"Masculino":"Femenino");
               model.addAttribute("fnacimiento", user.getFechaNacimiento());
               
               //retornando los aviso
               PropiedadSistema tituloAviso = this.propiedadSistemaService.obtenerValorPropiedad("titulo.aviso");
               PropiedadSistema detalleAviso = this.propiedadSistemaService.obtenerValorPropiedad("detalle.aviso");
               
               if(tituloAviso.getActive() == 1){
                model.addAttribute("titulo", tituloAviso.getValue());
                model.addAttribute("detalle", detalleAviso.getValue());
               }else{
                    model.addAttribute("titulo", "<p class=\"alert alert-warning\">Por el momento no hay avisos disponibles.</p>");
                    model.addAttribute("detalle", "");
               }
               
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
   
   @Autowired
   private PropiedadSistemaService propiedadSistemaService;
   
   @Autowired
   private ChangesetService changesetService;
}
