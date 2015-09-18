package com.rest.services.controller;

import com.rest.services.god.drools.DroolRuleAge;
import com.rest.services.god.drools.vo.UserTemp;
import com.rest.services.god.persistence.dto.ConsultaCoro;
import com.rest.services.god.persistence.hbm.Changeset;
import com.rest.services.god.persistence.hbm.Coro;
import com.rest.services.god.persistence.hbm.PropiedadSistema;
import com.rest.services.god.persistence.hbm.TipoMovimientoEnum;
import com.rest.services.god.persistence.hbm.Usuario;
import com.rest.services.model.ErrorService;
import com.rest.services.service.ChangesetService;
import com.rest.services.service.CoroService;
import com.rest.services.service.EmailSendService;
import com.rest.services.service.PropiedadSistemaService;
import com.rest.services.service.UsuarioService;
import com.rest.services.util.UtilService;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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
   public String ingresar(Model model, HttpServletRequest request) throws Exception {
       
      String requestEmail="";
      String requestPassword="";
               
      String cifrarEnviado = request.getParameter("cifrar");
      if(cifrarEnviado!=null){
          this.log.info(" -- El cifrado es enviado: "+cifrarEnviado);
          String descifrar = UtilService.Desencriptar(cifrarEnviado);
          String[] dataEnviada = descifrar.split(";");
          requestEmail = dataEnviada[0];
          requestPassword = dataEnviada[1];          
      }else{
          this.log.info(" -- El cifrado no es enviado: ");
          requestEmail = request.getParameter("user");
          requestPassword = request.getParameter("password");  
      }

      this.log.info(" -- Ingresando al sistema");
      this.log.info(" -- Request: "+request);
      this.log.info(" -- User: "+requestEmail);
      this.log.info(" -- Password: "+requestPassword);
      
      if(requestEmail!=null && requestPassword!=null){
          String user = requestEmail;
          String password = requestPassword;
          String encriptarPassword = UtilService.Encriptar(password);
          Usuario usuario = this.usuarioService.validaUsuario(user, encriptarPassword);
          if(usuario!=null){
              this.log.info(" -- Ingresando al sistema como: "+usuario.getNombre());
              
              this.changesetService.guardarChangeset(
                      TipoMovimientoEnum.ACCESO_AL_SISTEMA,
                      new Date(UtilService.getFechaTimeStamp().getTime()), 
                      usuario.getIdUsuario(), null);
              
              try {
                  List<Coro> corosActualizados = this.coroService.obtenerListaCoroActualizada();
                  List<Coro> corosCompletos = this.coroService.obtenerListaCoroCompleta();
                  if (corosActualizados != null && corosActualizados.size() > 0) {
                        model.addAttribute("coros", corosActualizados);
                        model.addAttribute("corosCompletos", corosCompletos);
                        model.addAttribute("usuario", usuario.getNombre());

                        //model.addAttribute("userEmail", usuario.getEmail());
                        //model.addAttribute("userPassword", password);
                        String cifrar = UtilService.Encriptar(usuario.getEmail()+";"+password);
                        model.addAttribute("cifrar",cifrar);
                        
                        //activar menu
                        model.addAttribute("menu",true);

                        //retornando los datos del perfil
                        model.addAttribute("nombreUsuario", usuario.getNombre());
                        model.addAttribute("falta", usuario.getFechaAlta());
                        model.addAttribute("fconexion", usuario.getUltConexion());
                        model.addAttribute("emailUsuario", usuario.getEmail());
                        model.addAttribute("actividad", usuario.getActividad());
                        model.addAttribute("sexo", usuario.getSexo()=='M'?"Masculino":"Femenino");
                        model.addAttribute("fnacimiento", usuario.getFechaNacimiento());

                        //Dial
                        model.addAttribute("accesoSistema", 
                                this.changesetService.totalMovement(TipoMovimientoEnum.ACCESO_AL_SISTEMA, String.valueOf(usuario.getIdUsuario())));
                        model.addAttribute("registroCoro", 
                                this.changesetService.totalMovement(TipoMovimientoEnum.REGISTRO_DE_CORO, String.valueOf(usuario.getIdUsuario())));
                        model.addAttribute("consultarPerfil", 
                                this.changesetService.totalMovement(TipoMovimientoEnum.VALIDAR_USUARIO, String.valueOf(usuario.getIdUsuario())));
                        model.addAttribute("consultarCoro", 
                                this.changesetService.totalMovement(TipoMovimientoEnum.CONSULTAR_CORO, String.valueOf(usuario.getIdUsuario())));
                        model.addAttribute("emailContacto", 
                                this.changesetService.totalMovement(TipoMovimientoEnum.ENVIO_CORREO_CONTACTO, String.valueOf(usuario.getIdUsuario())));
                        model.addAttribute("actUsuario", 
                                this.changesetService.totalMovement(TipoMovimientoEnum.ACTUALIZAR_PERFIL, String.valueOf(usuario.getIdUsuario())));

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
                        
                        //Retornando Lista de movimientos de usuario
                        List<Changeset> listCh = 
                                this.changesetService.listaChangeset(String.valueOf(usuario.getIdUsuario()));
                        if(listCh != null){
                            model.addAttribute("changesetUser", listCh);
                        } 
                  }
                  this.changesetService.guardarChangeset(
                      TipoMovimientoEnum.CONSULTAR_HIMNARIO,
                      new Date(UtilService.getFechaTimeStamp().getTime()), 
                      usuario.getIdUsuario(), null);
                  
                  //RECUPERANDO INFORMACION DE CONSULTA DE COROS
                  int rows=0;
                  PropiedadSistema ps =
                          this.propiedadSistemaService.obtenerValorPropiedad("rows.query.choir");
                  if(ps!=null)
                     rows = Integer.valueOf(ps.getValue());
                  List<ConsultaCoro> cc = this.changesetService.getListaCoros(rows);
                  if(cc!=null){
                      for(int i=0; i<cc.size();i++){
                           model.addAttribute("fecha"+i, cc.get(i).getFecha());
                           model.addAttribute("total"+i, cc.get(i).getTotal());
                      }
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
          
          String encriptarPassword = UtilService.Encriptar(password);
          Usuario usuario = this.usuarioService.validaUsuario(user, encriptarPassword);
          if(usuario!=null){
              this.changesetService.guardarChangeset(
                      TipoMovimientoEnum.VALIDAR_USUARIO,
                      new Date(UtilService.getFechaTimeStamp().getTime()), 
                      usuario.getIdUsuario(), null);
              
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
    public String registrarUsuario(Model model){
         //activar menu
         model.addAttribute("menu","smenu");
        return "registrar";
    }
    
    
    @RequestMapping(value="/usuario/nuevo", method = RequestMethod.POST)
    public ResponseEntity<ErrorService> registrarUsuarionNuevo(HttpServletRequest request, Model model){
        
        String notificar = request.getParameter("notificar")!=null?request.getParameter("notificar"):"NO";
        String nombre = request.getParameter("nombre").toUpperCase();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        char sexo = request.getParameter("sexo").toCharArray()[0];
        
        String dia = request.getParameter("dia");
        String mes = request.getParameter("mes");
        String anio = request.getParameter("anio");
        String actividad = request.getParameter("actividad");
        
        
        
        Usuario user = this.usuarioService.validaEmailSistema(email);
        if(user == null){
            this.log.info(" -- Agregand nuevo usuario:");
            this.log.info(" -- Nombre: "+nombre);
            this.log.info(" -- Email: "+email);
            this.log.info(" -- Password: "+password);
            this.log.info(" -- Sexo: "+sexo);
            this.log.info(" -- Notificar: "+notificar);
            
            this.log.info(" -- Dia: "+dia);
            this.log.info(" -- Mes: "+mes);
            this.log.info(" -- Anio: "+anio);
            this.log.info(" -- Actividad: "+actividad);

            Timestamp stamp = new Timestamp(System.currentTimeMillis());
            this.log.info(" -- Fecha de Alta::: "+stamp);
            Date fechaAlta = new Date(stamp.getTime());

            Usuario usuario = new Usuario();
            usuario.setNombre(nombre);
            usuario.setEmail(email);
            usuario.setSexo(sexo);
            String encriptado = UtilService.Encriptar(password);
            usuario.setPassword(encriptado);
            usuario.setFechaAlta(fechaAlta);
            usuario.setUltConexion(fechaAlta);
            usuario.setNotificaciones(notificar);
            usuario.setActividad(actividad);
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateInString = dia+"/"+mes+"/"+anio;
            try {
                Date date = formatter.parse(dateInString);
                this.log.info(" -- Año de Nacimiento: " + date);
                if (LoginController.validaFecha(dateInString)) {
                    this.log.info(" -- Fecha es Valida: " + date);
                    usuario.setFechaNacimiento(date);
                } else {
                    this.log.info(" -- Fecha Invalida: " + dateInString);
                    ErrorService data = new ErrorService();
                    data.setCodigo("404");
                    data.setMensaje("La fecha de nacimiento es inválida: "+dateInString);
                    return new ResponseEntity<ErrorService>(data, HttpStatus.NOT_FOUND);
                }
            } catch (ParseException e) {
                this.log.error(" -- Error al crear la fecha de nacimiento: " + e.getMessage());
            }
            
            int edad = UtilService.calcularEdad(dateInString);
            this.log.info(" -- La edad del usuario a registrar es de: "+edad);
            
            this.log.info(" -- Disparando las reglas con Drools");
            UserTemp userTemp = new UserTemp();
            userTemp.setEdad(edad);
            userTemp.setEmail(email);
            userTemp.setNombre(nombre);
            userTemp = this.droolRuleAgeAdapter.validarReglasAge(userTemp);
            if(userTemp.isValidado()){
                this.log.info(" -- El usuario ha validado todas las reglas");
            }else{
                this.log.info(" -- El usuario no ha cumplido las reglas del sistema");
                ErrorService data = new ErrorService();
                data.setCodigo("404");
                data.setMensaje(userTemp.getMensaje());
                return new ResponseEntity<ErrorService>(data, HttpStatus.NOT_FOUND);
            }
            
            

            int id = this.usuarioService.agregaUsuarioNuevo(usuario);
            this.log.info(" -- El usuario se agrego correctamente con el id: "+id);
            
            this.changesetService.guardarChangeset(
                      TipoMovimientoEnum.REGISTRO_DE_USUARIO,
                      new Date(UtilService.getFechaTimeStamp().getTime()), 
                      id, null);
           try {
               this.emailSendService.sendEmailRegister(usuario.getEmail(), "gtrejo.armenta@gmail.com", usuario.getNombre(), null);
               this.log.info(" -- Enviado");
               
                this.log.info(" -- Usuario correcto");
                ErrorService data = new ErrorService();
                data.setCodigo("200");
                data.setMensaje("El email: "+usuario.getEmail()+" ha sido registrado.");
                return new ResponseEntity<ErrorService>(data, HttpStatus.OK);
               
           } catch (Exception ex) {
               this.log.info(" -- No se puedo llevar a cabo el registro del usuario en el sistema.");    
               
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
            
            this.changesetService.guardarChangeset(
                      TipoMovimientoEnum.VALIDAR_EMAIL,
                      new Date(UtilService.getFechaTimeStamp().getTime()), 
                      user.getIdUsuario(), null);
            
            this.log.info(" -- Usuario encontrado: "+user.getEmail());
            response.setMensaje(user.getNombre());
        }else{
            response.setMensaje("NO LOCALIZADO");
        }
        return new ResponseEntity<ErrorService>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/actualizar/usuario", method = RequestMethod.POST)
    public ResponseEntity<ErrorService> actualizarDatosUsuario(HttpServletRequest request) throws IOException, JSONException {
        HttpStatus status = HttpStatus.NOT_FOUND;
        
        String emailUsuario = request.getParameter("emailUsuario");
        String passwordUsuario = request.getParameter("passwordUsuario");
        
        String nombreUsuario = request.getParameter("nombreUsuario");
        String falta = request.getParameter("falta");
        String fconexion = request.getParameter("fconexion");
        String actividad = request.getParameter("actividad");
        String fnacimiento = request.getParameter("fnacimiento");
        String sexo = request.getParameter("sexo");
        
        
        this.log.info(" -- Email Usuario: "+emailUsuario);
        this.log.info(" -- Password Usuario: "+passwordUsuario);
        
        this.log.info(" -- Nombre Usuario: "+nombreUsuario);
        this.log.info(" -- Fecha Alta Usuario: "+falta);
        this.log.info(" -- Fecha Ultima Conexion Usuario: "+fconexion);
        this.log.info(" -- Actividad Usuario: "+actividad);
        this.log.info(" -- Fecha Nacimiento Usuario: "+fnacimiento);
        this.log.info(" -- Sexo Usuario: "+sexo);
        
        ErrorService response = new ErrorService();
        response.setCodigo("404");
        response.setMensaje("Los datos del usuario no se pudieron actualizar, intente más tarde.");
        
        Usuario user = this.usuarioService.validaEmailSistema(emailUsuario);
        if(user!=null){
            this.changesetService.guardarChangeset(
                      TipoMovimientoEnum.ACTUALIZAR_PERFIL,
                      new Date(UtilService.getFechaTimeStamp().getTime()), 
                      user.getIdUsuario(), null);
            
            this.log.info(" -- Usuario encontrado: "+user.toString());
            String encriptarPassword = UtilService.Encriptar(passwordUsuario);
            user.setPassword(encriptarPassword);
            this.usuarioService.actualizarDatosUsuario(user);
            this.log.info(" -- El password fue actualizado");
            response.setCodigo("200");
            response.setMensaje("La información fue actualizada con éxito, "
                    + "para continuar tendrá que reingresar al sistema con su nuevo password.");
            status = HttpStatus.OK;
        }
        return new ResponseEntity<ErrorService>(response, status);
    }

    public static boolean validaFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            System.out.println(" -- Fecha Invalida: "+fecha);
            return false;
        }
        return true;
    }
    
    @RequestMapping(value = "/sistema/salir", method = RequestMethod.POST)
    public ResponseEntity<ErrorService> exitSistema(HttpServletRequest request) throws IOException, JSONException, Exception {
       
       this.log.info(" -- Registrando salida en sistema."); 
       String cifrar = request.getParameter("cifrar");
       this.log.info(" -- Cifrado enviado: "+cifrar);
       
       String descifrado = UtilService.Desencriptar(cifrar);
       this.log.info(" -- Descifrado: "+descifrado);
       String[] data = descifrado.split(";");
       String userEmail = data[0];
       Usuario user = this.usuarioService.validaEmailSistema(userEmail);
       if(user!=null){
           this.changesetService.guardarChangeset(
                      TipoMovimientoEnum.SALIR_DEL_SISTEMA,
                      new Date(UtilService.getFechaTimeStamp().getTime()), 
                      user.getIdUsuario(), null);
       }
       ErrorService response = new ErrorService();
       response.setCodigo("200");
       response.setMensaje("Registro de mensaje de sálida. "+TipoMovimientoEnum.SALIR_DEL_SISTEMA.toString());
       
       return new ResponseEntity<ErrorService>(response, HttpStatus.OK);
    }
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    EmailSendService emailSendService;
    
    @Autowired
    private CoroService coroService;
    
    @Autowired
    private DroolRuleAge droolRuleAgeAdapter;
    
    @Autowired
    private PropiedadSistemaService propiedadSistemaService;
    
    @Autowired
    ChangesetService changesetService;
    
}
