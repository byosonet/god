package com.rest.services.service;

import com.rest.services.model.Empleado;
import com.rest.services.model.ErrorService;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("listaEmpleadosService")
public class ListaEmpleadosServiceImpl implements ListaEmpleadosService{
private final Logger log = Logger.getLogger(ListaEmpleadosServiceImpl.class);
    
    public List<Empleado> getEmpleados() {
        /*Implementacion para obtener la lista*/
        this.log.info(" -- Accediendo al controller para obtener los empledos.");
        List<Empleado> response = new ArrayList<Empleado>();
        
        Empleado gustavo = new Empleado();
        gustavo.setId(1);
        gustavo.setEdad(31);
        gustavo.setNombre("Gustavo");
        gustavo.setApellido("Trejo");
        
        ErrorService error = new ErrorService();
            error.setCodigo("200");
            error.setMensaje("OK");
            gustavo.setStatus(error);
        
        Empleado eduardo = new Empleado();
        eduardo.setId(2);
        eduardo.setEdad(28);
        eduardo.setNombre("Eduardo");
        eduardo.setApellido("Trejo");
        
        eduardo.setStatus(error);

        response.add(gustavo);
        response.add(eduardo);
        
        
        this.log.info(" -- Regresa lista de empleados: "+response.toString());
        return response;
    }

    public Empleado getEmpleadoById(String id) {
        Empleado empleado = new Empleado();
        int idNum=0;
        try{
          idNum = Integer.valueOf(id);
        }catch(Exception ex){
            this.log.info(" -- Error al parsear el id"+ex.getMessage());
            ErrorService error = new ErrorService();
            error.setCodigo("500");
            error.setMensaje("Id con formato inválido");
            empleado.setStatus(error);
        }
        this.log.info(" -- Consultando por id de empleado: "+id);
        if (idNum == 1) {
            empleado.setId(1);
            empleado.setEdad(31);
            empleado.setNombre("Gustavo");
            empleado.setApellido("Armenta");
            ErrorService error = new ErrorService();
            error.setCodigo("200");
            error.setMensaje("OK");
            empleado.setStatus(error);
            
        }else if(idNum == 2){
            empleado.setId(2);
            empleado.setEdad(28);
            empleado.setNombre("Eduardo");
            empleado.setApellido("Trejo");
             ErrorService error = new ErrorService();
            error.setCodigo("200");
            error.setMensaje("OK");
            empleado.setStatus(error);
            
        }else{
            this.log.info(" -- Empleado No encontrado con id: "+id);
            ErrorService error = new ErrorService();
            error.setCodigo("404");
            error.setMensaje("Id no encontrado");
            empleado.setStatus(error);
        }
        
        return empleado;
    }
    
}
