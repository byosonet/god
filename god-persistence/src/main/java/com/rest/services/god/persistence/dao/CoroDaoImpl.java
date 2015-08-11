/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.cp.HibernateUtil;
import com.rest.services.god.persistence.hbm.Coro;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author User
 */
public class CoroDaoImpl extends HibernateDaoSupport implements CoroDao{
    private final Logger log = Logger.getLogger(CoroDaoImpl.class);
    public List<Coro> obtenerListaCoro() {
        this.log.info(" -- Buscando por lista de coros::");
        return (List<Coro>) this
                .getSession()
                .createQuery("FROM Coro c " + "ORDER BY c.idCoro ASC").list();
    }

    public Coro obtenerCoro(String idCoro) {
        this.log.info(" -- Buscando por coro por id ::"+idCoro);
        int coro = Integer.valueOf(idCoro);
        return (Coro) this
                .getSession()
                .createQuery("FROM Coro c WHERE c.idCoro = :id")
                .setParameter("id", coro)
                .uniqueResult();
    }
    
    public Object findByKey(Object llave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object saveByEntityReturnID(Object entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object saveByEntity(Object entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Object> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateByEntity(Object entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteByKey(Object llave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteByEntity(Object entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Session sesion;
    private Transaction tx;
    
    private void iniciaOperacion() throws HibernateException {
        sesion = HibernateUtil.getSessionFactory().openSession();
        tx = sesion.beginTransaction();
    }

    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he);
    }
    
}
