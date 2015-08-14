package com.rest.services.controller;

import com.rest.services.god.persistence.hbm.Coro;
import com.rest.services.god.persistence.hbm.Usuario;
import com.rest.services.model.ErrorService;
import com.rest.services.service.CoroService;
import com.rest.services.service.EmailSendService;
import com.rest.services.service.UsuarioService;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpStatusCodeException;

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
              try {
                  List<Coro> corosActualizados = this.coroService.obtenerListaCoroActualizada();
                  List<Coro> corosCompletos = this.coroService.obtenerListaCoroCompleta();
                  if (corosActualizados != null && corosActualizados.size() > 0) {
                      model.addAttribute("coros", corosActualizados);
                      model.addAttribute("corosCompletos", corosCompletos);
                      model.addAttribute("usuario", usuario.getNombre());
                      model.addAttribute("userEmail", usuario.getEmail());
                      model.addAttribute("userPassword", usuario.getPassword());
                  }
              } catch (Exception ex) {
                  ex.printStackTrace();
              }
              return "listaHimnario";
          }
      }
   return "invalido";
   }
   
   @RequestMapping(value="/ingresar",method = RequestMethod.GET)
   public String ingresarGET(Model model, HttpServletRequest request) {
      return "forbidden";
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
              try {
                  this.usuarioService.actulizarConexionUsuario(usuario);
              } catch (Exception ex) {
                  ex.printStackTrace();
              }
              return new ResponseEntity<ErrorService>(data, HttpStatus.OK);
          }
      }
      
    this.log.info(" -- Usuario incorrecto");
    ErrorService data = new ErrorService();
    data.setCodigo("404");
    data.setMensaje("Esta email y password no ha sido registrado: "+request.getParameter("user"));
    return new ResponseEntity<ErrorService>(data, HttpStatus.NOT_FOUND);
   }
   
    @RequestMapping(value="/registrar/usuario", method = RequestMethod.GET)
    public String registrarUsuario(){
        return "registrar";
    }
    
    
    @RequestMapping(value="/usuario/nuevo", method = RequestMethod.POST)
    public ResponseEntity<ErrorService> registrarUsuarionNuevo(HttpServletRequest request, Model model){
        
        String notificar = request.getParameter("notificar")!=null?request.getParameter("notificar"):"NO";
        String nombre = request.getParameter("nombre").toUpperCase();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        char sexo = request.getParameter("sexo").toCharArray()[0];
        Usuario user = this.usuarioService.validaEmailSistema(email);
        if(user == null){
            this.log.info(" -- Agregand nuevo usuario:");
            this.log.info(" -- Nombre: "+nombre);
            this.log.info(" -- Email: "+email);
            this.log.info(" -- Password: "+password);
            this.log.info(" -- Sexo: "+sexo);
            this.log.info(" -- Notificar: "+notificar);

            Timestamp stamp = new Timestamp(System.currentTimeMillis());
            this.log.info("-- Fecha de Alta::: "+stamp);
            Date fechaAlta = new Date(stamp.getTime());

            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setSexo(sexo);
            usuario.setPassword(password);
            usuario.setFechaAlta(fechaAlta);
            usuario.setUltConexion(fechaAlta);
            usuario.setNotificaciones(notificar);

            int id = this.usuarioService.agregaUsuarioNuevo(usuario);
            this.log.info(" -- El usuario se agrego correctamente con el id: "+id);
           try {
               this.emailSendService.sendEmailRegister(usuario.getEmail(), "gtrejo.armenta@gmail.com", usuario.getNombre(), null);
               this.log.info(" -- Enviado");
               
                this.log.info(" -- Usuario correcto");
                ErrorService data = new ErrorService();
                data.setCodigo("200");
                data.setMensaje("El email: "+usuario.getEmail()+" ha sido registrado.");
                return new ResponseEntity<ErrorService>(data, HttpStatus.OK);
               
           } catch (Exception ex) {
               this.log.info(" -- No se puedo enviar el correo: "+ex);
               ex.printStackTrace();
           }
        }
        this.log.info(" -- Usuario ya se encuentra en sistema registrado");
        ErrorService data = new ErrorService();
        data.setCodigo("404");
        data.setMensaje("Este email ya ha sido registrado con anterioridad: "+email);
        return new ResponseEntity<ErrorService>(data, HttpStatus.NOT_FOUND);
    }
    
    
    @RequestMapping(value = "/localizar/email", method = RequestMethod.POST)
    public ResponseEntity<ErrorService> localizarPorEmail(HttpServletRequest request) throws IOException, JSONException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str;
        while( (str = br.readLine()) != null ){
            sb.append(str);
        }    
        JSONObject jObj = new JSONObject(sb.toString());
        this.log.info(" -- JSON: "+jObj.toString());
        
        ErrorService response = new ErrorService();
        String email = jObj.getString("email");
        Usuario user = this.usuarioService.validaEmailSistema(email);
        if(user!=null){
            this.log.info(" -- Usuario encontrado: "+user.getEmail());
            response.setMensaje(user.getNombre());
        }else{
            response.setMensaje("NO LOCALIZADO");
        }
        return new ResponseEntity<ErrorService>(response, HttpStatus.OK);
    }

    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    EmailSendService emailSendService;
    
    @Autowired
    private CoroService coroService;
    
}
