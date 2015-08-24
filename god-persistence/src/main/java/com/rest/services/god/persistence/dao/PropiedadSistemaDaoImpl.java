package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.PropiedadSistema;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author User
 */
public class PropiedadSistemaDaoImpl extends HibernateDaoSupport implements PropiedadSistemaDao{
     private final Logger log = Logger.getLogger(PropiedadSistemaDaoImpl.class);
    TransacctionMySQL mysql = new TransacctionMySQL();
    public PropiedadSistema obtenerValorPropiedad(String key) {
        this.log.info(" -- Buscando Propiedad by key:: "+key);
        return (PropiedadSistema) this
                .getSession()
                .createQuery("FROM PropiedadSistema p WHERE p.key = :key")
                .setParameter("key", key)
                .uniqueResult();
    }
    
}
