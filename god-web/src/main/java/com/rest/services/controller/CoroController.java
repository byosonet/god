package com.rest.services.controller;


import com.rest.services.god.persistence.hbm.Coro;
import com.rest.services.model.ErrorService;
import com.rest.services.service.CoroService;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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
public class CoroController {
    private final Logger log = Logger.getLogger(CoroController.class);
   @RequestMapping(value="/coro",method = RequestMethod.POST)
   public String obtenerListaHimnario(Model model, HttpServletRequest request) throws SQLException, IOException {
       String id = request.getParameter("idCoro");
       String userEmail = request.getParameter("userEmail");
       String userPassword = request.getParameter("userPassword");
       this.log.info(" -- IdCoro recibido:::: "+id);
       this.log.info(" -- userEmail recibido:::: "+userEmail);
       this.log.info(" -- userPassword recibido:::: "+userPassword);
       
       Coro coro = this.coroService.obtenerCoro(id);
       if(coro!=null){
           if(String.valueOf(coro.getIdCoro()).equals(id)){
               model.addAttribute("idCoro", id);
               model.addAttribute("nombre", coro.getNombre());
               
               if(coro.getActivo() == 2){
               model.addAttribute("coro", coro.getDescripcion()!=null?coro.getDataClob(coro.getDescripcion()):"El detalle de este coro no está disponible por el momento.");
               }else if(coro.getActivo() == 1){
                  coro.setDescripcion(null);
                  model.addAttribute("status", "1");
                  model.addAttribute("coro", "El detalle de este coro está en proceso de: VALIDACIÓN.");
               }else{
                  coro.setDescripcion(null);
                  model.addAttribute("status", "0");
                  model.addAttribute("coro", "El detalle de este coro está en proceso de: PENDIENTE.");
               }
               model.addAttribute("numCoro", coro.getNumCoro());
               model.addAttribute("userEmail", userEmail);
               model.addAttribute("userPassword", userPassword);
               model.addAttribute("statusDescripcion", true);

               if(coro.getDescripcion()==null){
                   model.addAttribute("statusDescripcion", false);
               }else if(coro.getDataClob(coro.getDescripcion()).trim().equals("")){
                   model.addAttribute("statusDescripcion", false);
                   model.addAttribute("coro", "El detalle de este coro no está disponible por el momento.");
                   model.addAttribute("status", "1");
               }
               return "detalle";
           }
       }
        
    return "notfoundCoro";
   }
   
   @RequestMapping(value="/agregar/coro",method = RequestMethod.POST)
   public ResponseEntity<ErrorService> agregarCoro(Model model, HttpServletRequest request) throws SQLException {
       HttpStatus status = HttpStatus.NOT_FOUND;
       
       String nombreCoro = request.getParameter("nombreCoro");
       String autor = request.getParameter("autor");
       String numCoro = request.getParameter("numCoro");
       String desccoro = request.getParameter("desccoro");
       
       this.log.info(" -- Nombre del Coro: "+nombreCoro);
       this.log.info(" -- Autor del Coro: "+autor);
       this.log.info(" -- # del Coro: "+numCoro);
       this.log.info(" -- Descripción del Coro: "+desccoro);
       
       ErrorService response = new ErrorService();
       response.setCodigo("404");
       response.setMensaje("Por el momento no es posible agregar el coro al sistema, intente más tarde.");
       
       Timestamp stamp = new Timestamp(System.currentTimeMillis());
       this.log.info(" -- Fecha de Alta::: "+stamp);
       Date fechaAlta = new Date(stamp.getTime());

       Coro coro = new Coro();
       coro.setActivo(0);
       coro.setAutor(autor);
       coro.setNumCoro(numCoro);
       coro.setFechaAct(fechaAlta);
       coro.setDescripcion(coro.covertirStringToClob(desccoro));
       coro.setNombre(nombreCoro.toUpperCase());

       int longNombre = coro.getNombre().length();
       if (longNombre > 99) {
           this.log.info(" -- Longitud del nombre del coro: "+longNombre);
           response.setMensaje("La longitud del nombre del coro es demasiado larga.");
           response.setCodigo("404");
           return new ResponseEntity<ErrorService>(response, status);
       }
       this.log.info(" -- Longitud del nombre del coro: "+longNombre);
           
       //VALIDANDO CORO EN BASE DE DATOS
       boolean nCoro = this.coroService.validarNumCoro(coro.getNumCoro());
       boolean nomCoro = this.coroService.validarNombreCoro(coro.getNombre());
       if (nCoro && nomCoro) {
           try {
               int idCoro = this.coroService.agregarCoro(coro);
               this.log.info(" -- Coro Agregado con el id: " + idCoro);
               response.setCodigo("200");
               response.setMensaje("El coro ha sido agregado exitosamente al sistema.");
               status = HttpStatus.OK;
           } catch (Exception ex) {
               this.log.error(" -- No se pudo agregar el coro al sistema: " + ex.getMessage());
           }
       } else {
           if (nCoro == false) 
               response.setMensaje("Este número de coro "+coro.getNumCoro()+" ya existe en sistema.");
            else if (nomCoro == false) 
               response.setMensaje("Este nombre de coro ya se encuentra registrado en sistema: "+coro.getNombre());
           response.setCodigo("404");
       }
    return new ResponseEntity<ErrorService>(response, status);
   }
   
   @Autowired
   private CoroService coroService;
    
}
