package com.rest.services.god.persistence.dao;

import com.rest.services.god.persistence.hbm.Producto;
import java.util.List;

/**
 *
 * @author emartinez
 */
public interface ProductoDao extends Dao<Producto, Long> {
    Producto buscar(Long llave);
    List<Producto> getAllProducts(int x);
}
