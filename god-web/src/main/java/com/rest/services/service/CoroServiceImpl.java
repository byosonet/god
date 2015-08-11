/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.service;

import com.rest.services.god.persistence.dao.CoroDao;
import com.rest.services.god.persistence.hbm.Coro;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
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
    public List<Coro> obtenerListaCoro() {
       this.log.info(" -- Obteniendo Lista de Coros:::");
       
       List<Coro> coros = this.coroDao.obtenerListaCoro();
       if(coros!=null && coros.size()>0){
           for(Coro c : coros){
               try {
                   this.log.info(" -- idCoro: "+c.getIdCoro()+" Nombre: "+c.getNombre()+" Descripcion: "+this.readClob(c.getDescripcion()));
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           }
       }
       
       return coros;
    }
    
    public String readClob(Clob clob) throws SQLException, IOException {
    StringBuilder sb = new StringBuilder((int) clob.length());
    Reader r = clob.getCharacterStream();
    char[] cbuf = new char[2048];
    int n;
    while ((n = r.read(cbuf, 0, cbuf.length)) != -1) {
        sb.append(cbuf, 0, n);
    }
    return sb.toString();
}
    
    @Autowired
    private CoroDao coroDao;
}
