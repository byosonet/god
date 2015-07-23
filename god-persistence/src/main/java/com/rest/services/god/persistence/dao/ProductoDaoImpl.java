package com.rest.services.god.persistence.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.rest.services.god.persistence.hbm.Producto;


public class ProductoDaoImpl extends HibernateDaoSupport implements ProductoDao {
    	private final Logger log = Logger.getLogger(ProductoDaoImpl.class);

	public Producto buscar(Long llave) {
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
				.createQuery("FROM Producto p " + "ORDER BY p.idProducto DESC")
				.setMaxResults(x).list();
	}

    public Long guardar(Producto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Producto> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actualizar(Producto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminar(Long llave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void eliminarEntidad(Producto entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
