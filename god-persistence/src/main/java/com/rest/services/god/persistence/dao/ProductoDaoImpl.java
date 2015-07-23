package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.cp.HibernateUtil;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rest.services.god.persistence.hbm.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProductoDaoImpl extends HibernateDaoSupport implements ProductoDao {
    	private final Logger log = Logger.getLogger(ProductoDaoImpl.class);

    public Producto findByKey(Long llave) {
        this.log.info(" -- Buscando por producto::");
        return (Producto) this
                .getSession()
                .createQuery("FROM Producto p " + "WHERE p.idProducto = :llave")
                .setParameter("llave", llave)
                .uniqueResult();
    }

    public List<Producto> getAllProducts(int x) {
        this.log.info(" -- Buscando por lista producto::");
        return (List<Producto>) this
                .getSession()
                .createQuery("FROM Producto p " + "ORDER BY p.idProducto ASC")
                .setMaxResults(x).list();
    }

    public Producto saveByEntity(Producto producto) {
        try {
            iniciaOperacion();
            Number maximo = (Number) this.getSession().createQuery(
                    "SELECT COUNT(*) "
                    + "FROM Producto")
                    .uniqueResult();

            long id = maximo == null ? 1 : maximo.longValue() + 1;
            producto.setIdProducto(id);
            this.sesion.save(producto);
            this.sesion.flush();

            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
            throw he;
        } finally {
            sesion.close();
        }
        return producto;

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

    public Long saveByEntityReturnID(Producto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Producto> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateByEntity(Producto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteByKey(Long llave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteByEntity(Producto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
