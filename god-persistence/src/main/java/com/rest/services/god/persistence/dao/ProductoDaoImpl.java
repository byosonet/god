package com.rest.services.god.persistence.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rest.services.god.persistence.hbm.Producto;
import org.hibernate.HibernateException;


public class ProductoDaoImpl extends HibernateDaoSupport implements ProductoDao {
    private final Logger log = Logger.getLogger(ProductoDaoImpl.class);
    TransacctionMySQL mysql = new TransacctionMySQL();

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
            
            this.mysql.iniciarOperacion();
            Number maximo = (Number) this.getSession().createQuery(
                    "SELECT COUNT(*) "
                    + "FROM Producto")
                    .uniqueResult();

            long id = maximo == null ? 1 : maximo.longValue() + 1;
            producto.setIdProducto(id);
            this.mysql.getSesion().save(producto);
            this.mysql.getSesion().flush();

            this.mysql.getTx().commit();
        } catch (HibernateException he) {
            this.mysql.manejarException(he);
            throw he;
        } finally {
            this.mysql.getSesion().close();
        }
        return producto;

    }
      
}
