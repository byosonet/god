package com.rest.services.service;

import com.rest.services.god.persistence.dao.CoroDao;
import com.rest.services.god.persistence.hbm.Coro;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author User
 */
public class CoroServiceImpl implements CoroService{
    private final Logger log = Logger.getLogger(CoroServiceImpl.class);

    @Transactional
    public List<Coro> obtenerListaCoroActualizada() {
       this.log.info(" -- Obteniendo Lista de Coros por fechas:::");
       
       List<Coro> coros = this.coroDao.obtenerListaCoroActualizada();
       if(coros!=null && coros.size()>0){
           for(Coro c : coros){
               try {
                   this.log.info(" -- idCoro: "+c.getIdCoro()+" Nombre: "+c.getNombre()+" Descripcion: "+c.getDataClob(c.getDescripcion()));
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
       }
       return coros;
    }

    @Transactional
    public List<Coro> obtenerListaCoroCompleta() {
       this.log.info(" -- Obteniendo Lista de Coros completa :::");
       
       List<Coro> coros = this.coroDao.obtenerListacCompletaCoro();
       if(coros!=null && coros.size()>0){
           for(Coro c : coros){
               try {
                   this.log.info(" -- idCoro: "+c.getIdCoro()+" Nombre del Coro: "+c.getNombre());
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
       }
       return coros;
    }
    
    

    @Transactional
    public Coro obtenerCoro(String idCoro) {
        this.log.info(" -- Obteniendo Coro");
        Coro coro = this.coroDao.obtenerCoro(idCoro);
        if(coro!=null){
            this.log.info(" -- Coro encontrado: "+coro.getNombre());
            return coro;
        }
        return coro;
    }

    @Transactional
    public int agregarCoro(Coro coro) {
        int idCoro = 0;
        this.log.info(" -- Agregando coro al sistema: " + coro.toString());
        try {
            idCoro = this.coroDao.agregarCoro(coro);
        } catch (Exception ex) {
            this.log.error(" -- El coro no se ha podido dar de alta en el sistema: " + ex.getMessage());
        }
        return idCoro;
    }
    
    @Autowired
    private CoroDao coroDao;
}
