package com.rest.services.service;

import com.rest.services.god.persistence.dao.ProductoDao;
import com.rest.services.god.persistence.hbm.Producto;
import com.rest.services.model.Empleado;
import com.rest.services.model.ErrorService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
@Component("listaEmpleadosService")
public class ListaEmpleadosServiceImpl implements ListaEmpleadosService{
private final Logger log = Logger.getLogger(ListaEmpleadosServiceImpl.class);
    
    @Transactional
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
        
        /*PROCESAR CONSULTA A LA BASE DE DATOS DE POSTGRESQL*/
        try{
            this.log.info(" -- Agrenado un nuevo producto:::: ");
            Producto item = new Producto();
            item.setIdProducto(0L);
            item.setDescripcion("PRODUCTO NUEVO CON FECHA: "+new Date());
            item.setPrecio(1234);
            Producto prod = this.productoDao.saveByEntity(item);
            this.log.info(" -- IdProducto: "+prod.getIdProducto()+" Descripcion: "+prod.getDescripcion()+" Precio: "+prod.getPrecio());
            this.log.info(" -- Producto Agregado:::: con idProducto: "+prod.getIdProducto());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        try{
            this.log.info(" -- Buscando en BASE DE DATOS MYSQL");
            List<Producto> list = this.productoDao.getAllProducts(1000);
            for(Producto p : list){
                this.log.info(" -- IdProducto: "+p.getIdProducto()+" Descripcion: "+p.getDescripcion()+" Precio: "+p.getPrecio());
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
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
    
@Autowired
private ProductoDao productoDao;
}
